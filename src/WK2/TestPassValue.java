package WK2;
//Q3
//Java 的方法参数传递都是 pass-by-value。
//基本类型传递的是值的副本，所以方法内修改参数不会影响外部变量。
//引用类型传递的是引用的副本，因此可以通过该引用修改同一个对象的内容，但不能通过重新赋值参数来改变外部引用变量的指向。
public class TestPassValue {
    static void main(String[] args) {
        //外面的a时5 调用方法时把5变成传入参数x 方法里面的x变成10 外面的a依旧还是5
        int a = 5;
        PassValue.change(a);
        System.out.println(a);

        int x = 100;
        int y = 1;
        System.out.println(x+","+y);//100,1
        PassValue.swap(x,y);
        System.out.println(x+","+y);//100,1

    //引用类型
        Person p1 = new Person("Alice", 18);

        System.out.println("调用 changeObject 前：");
        p1.printInfo();

        PassValue.changeObject(p1);

        System.out.println("调用 changeObject 后：");
        p1.printInfo();

        System.out.println();

        System.out.println("调用 reassignObject 前：");
        p1.printInfo();

        PassValue.reassignObject(p1);

        System.out.println("调用 reassignObject 后：");
        p1.printInfo();

    }
}
