package WK2;

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
    static void assertEquals(String expected,String actual,String message){
        if (!Objects.equals(expected,actual)){     //java里不能写成not 得用！
            throw new AssertionError(message + ": expected " + expected + " but got " + actual); //断言错误
            //throw 扔 new AssertionError()创建了一个断言错误的对象 （）括号里提示错误文字
        }
    }

    static void assertEquals(int expected,int actual,String message){
        if(expected!=actual){   //int是基本数据类型 不是对象 可以用==和！=
            throw new AssertionError(message + ": expected " + expected + " but got " + actual);
        }
    }
//    continue是给循环用的不是给这种普通方法用的 这里不需要写相等情况continue


//int是基本类型 ==比较的是数值是否相等 String是引用类型 ==比较的是两个引用类型是否指向的是同一个对象 不是比较字符串的内容
//如果两个string内容一样但是不是同一个对象 ==返回false；而equal比较的是对象的逻辑内容是否相等 对字符串来说内容一样equals返回true
// 叫做reference 和value equality
}
