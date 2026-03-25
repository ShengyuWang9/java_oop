package WK2;
//Q4
public class TestPassByValue {
    static void main(String[] args) {
    //1String一旦创建之后是不能被修改的
//        String s = "a";
//        System.out.println(s);
//        s += "b";// 看似被修改了 实际上创建了一个新的字符串让s指向新的“ab”
//        System.out.println(s);

        String s = "a";
        PassByValue.append1(s);//这里a和s指向同一个地址 都是"a"
        //a += "b";只是对a进行了修改不是外面的s
        System.out.println(s);//所以s依旧还是a
//        不可能，因为 String 是 immutable，且 Java 是 pass-by-value，参数重赋值不会影响调用者；同时 void 又不能返回新字符串。

    //2final 修饰参数，限制的是“变量不能重新赋值”
        //String append(final String a)//方法内就不能再写a= 。。。
        String x = "a";
        x = PassByValue.append2(x);
        System.out.println(x);

    //3 p是对象引用的副本
        //副本和外部变量指向同一个对象
        //修改对象内部字段，外面就能看到
        Person X = new Person("a",10);
        PassByValue.append3(X);
        System.out.println(X.name);

    }
}
