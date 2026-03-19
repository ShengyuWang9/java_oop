package WK1;

public class Vector2DTest {
    public static void main(String[] args) {
        Vector2D a = new Vector2D(10d,10d);
        //10d是什么意思 10d就是double 10的意思 加后缀让人知道类型
//        10      -> int
//        10L     -> long
//        10.0    -> double
//        10d     -> double
//        10f     -> float

//        System.out.println(对象) 遇到对象时，会自动调用这个对象的 toString()。
//        所以你已经重写了 toString() 的情况下，写 println(a) 和 println(a.toString()) 基本是一样的。
        System.out.println(a);
            //省略的.toString 不会把对象内部的字段一个一个打印出来 他要先想把这个对象变成字符串再输出
        System.out.println(a.toString());

        System.out.println(a.add(a).toString());
        System.out.println(a.toString());
        System.out.println(new Vector2D(10d,10d).add(new Vector2D(5d,5d)).scale(3d).scale(0.5d).distance(new Vector2D(1d,1d)));


    }
}
