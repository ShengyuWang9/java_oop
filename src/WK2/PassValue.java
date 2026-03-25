package WK2;

//Q3
//方法传参传的永远都是一个拷贝 不是本体
//方法参数是一个新的局部变量。调用方法时，外面实参的值会复制给这个局部变量。
//之后你在方法里改的，是这个局部变量，不是外面的变量
public class PassValue {
//基本类型
    static void change(int x) {
        x = 10;
    }


    static void swap(Object a, Object b) {
        Object temp = a;
        a = b;
        b = temp;
    }

//引用类型
    static void changeObject(Person p) {
        System.out.println("changeObject 方法内，修改前：");
        p.printInfo();

        p.age = 20;

        System.out.println("changeObject 方法内，修改后：");
        p.printInfo();
    }

    static void reassignObject(Person p) {
        System.out.println("reassignObject 方法内，重新指向新对象前：");
        p.printInfo();

        p = new Person("Bob", 30);

        System.out.println("reassignObject 方法内，重新指向新对象后：");
        p.printInfo();
    }

}
