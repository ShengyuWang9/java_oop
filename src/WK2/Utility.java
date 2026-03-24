package WK2;
//知识点
//reference equality看的是两个变量是不是指向堆里的同一个对象    用==
//value equality    对象可能不是同一个示例 但是他们的内容有效值是不是一样 用equals（）

import java.util.Objects;

//构建工具类用来放工具方法 用static
//不同于普通类拿来建造对象的
//属于类本身 不是属于某个对象
//直接类名.方法名();调用
class Utility {
    //     私有化构造器
    private Utility() {
        throw new AssertionError();     //多加一条“这个类不应该被 new 出来。”
    }

    //不写static调用
//    A a = new A();
//    a.hello();

    //为什么这里的assertEquals要写成static
    //因为这里是工具类 而且static说明的就是这个方法属于类本身 不属于某个对象
    //所以不需要new一个对象 直接类名直接调用

    //    这里比较字符串的时候不能直接用==  这里等号比较的是是不是同一个对象
//    应该用a.equal(b)     这里expected.equals(actual)如果期望值是null会报错
//    或者Objects.equals(a,b)     可以处理null的情况
    static void assertEquals(String expected, String actual, String message) {
        if (!Objects.equals(expected, actual)) {     //java里不能写成not 得用！
            throw new AssertionError(message + ": expected " + expected + " but got " + actual); //断言错误
            //throw 扔 new AssertionError()创建了一个断言错误的对象 （）括号里提示错误文字
        }
    }

    static void assertEquals(int expected, int actual, String message) {
        if (expected != actual) {   //int是基本数据类型 不是对象 可以用==和！=
            throw new AssertionError(message + ": expected " + expected + " but got " + actual);
        }
    }
//    continue是给循环用的不是给这种普通方法用的 这里不需要写相等情况continue


//int是基本类型 ==比较的是数值是否相等 String是引用类型 ==比较的是两个引用类型是否指向的是同一个对象 不是比较字符串的内容
//如果两个string内容一样但是不是同一个对象 ==返回false；而equal比较的是对象的逻辑内容是否相等 对字符串来说内容一样equals返回true


//b对象里装的通常不是对象本身 而是引用
    //若是null的话则表明这个引用没有指向任何对象
//    String s = "1"; s不是字符串本体而是指向一个字符串对象的引用
//    右边等于null的话则引用（reference）说明没有指向任何对象

    //为什么这里参数写成了Object还能接受int
    //自动装箱 autoboxing
    //这里用Object 可以把所有类型包含进去 基本类型又能靠自动装箱进来

    //object就是可以把所有类型包含进去对吧 创建的对象不管是什么类型都可以 字符串 数字 或者null都可以？
    //答：Object 是大多数引用类型的共同父类，所以可以统一接收各种对象；而 int、double 这类基本类型会先自动装箱成对应包装类对象，再传入 Object 参数
    static void assertUniversalEquals(Object expected, Object actual, String message) {
        //Object是类型     java里所有类的父类
        //Objects是工具类
        if (!Objects.equals(expected, actual)) {
            //用传入的参数.getClass()调用方法查找类？
            //返回这个对象在运行时真正所属的类
                //eg 如果是Object a = 1;
                //这里a的类型就是 class java.lang.Integer

                //字符串的话就是class java.lang.String

            //注意 这里null根本不是对象 所以不能调用getClass null表示的是没有对象
            throw new AssertionError(
                    //判断对象是不是null值 用三元运算符
                    message + ": expected " + (expected == null ? "null" : expected + "(" + expected.getClass() + ")")
                            + " but got " +
                            (actual == null ? "null" : actual + "(" + actual.getClass() + ")")
            ); //断言错误
        }

        //Object 是类型，Objects 是工具类。
        //参数写成 Object，是为了统一接收不同类型的值。
        //基本类型传给 Object 参数时，会发生自动装箱。
        //Objects.equals(a, b) 能安全比较，包括 null。
        //?: 是三元运算符，不是正则表达式。
    }
}
