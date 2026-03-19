package WK1;

public class WK1 {
    //public modifier on both the class and method means that these will be
    //visible to the world (i.e. every other class from any package).
    // 表示该类或方法对所有其他类都是可见的，即可以在任何包中访问。
    // 这是最常用的修饰符，用于创建可在整个应用程序中使用的类和方法。

   public static void main(String[] args) { //S传入一个字符串数组
    //static modifier on the method main means that it can be called without
    //creating an instance of the class.
    //static 修饰符（static modifier）：
    // 表示该方法可以在不创建类的实例的情况下调用。
    // 这是一种常用的方法，用于创建可以在整个应用程序中使用的方法。

    //In our case, the main method can be called
    //without an instance of the HelloWorld class.
    //main是主方法 程序运行的入口  可以不创建类的实例就可以调用
    System.out.println("hi");
    //system 是一个类  可以调用它的方法 println("hi");
    //out是system类的一个静态字段  可以调用它的方法 println("hi");
    }
}
//1explain all modifiers

//2Discuss why an entry point like main, in the context of an OOP language like Java, makes sense to be marked static.
//因为标记为静态是有意义的，因为该方法可以在没有封闭类实例的情况下被调用（call the method）。
// 如果没有这个修饰符，运行时（例如JVM）将在方法被调用之前必须实例化封闭类。
// 如果类有运行时无法满足的依赖关系，这是一个问题；类的构造函数可能有参数。
//换一个更好理解的方法：就是说 如果被标记了static就是静态的一个方法了 可以直接调用
// 而不需要创建类的实例。这里就像是静态和动态构建数组的区别一样。
// 静态方法可以在不创建类的实例的情况下调用，而动态方法必须在创建类的实例后调用。


//解释一下这里静态和动态的区别
//静态方法：可以在不创建类的实例的情况下调用。
//动态方法：必须在创建类的实例后调用。
//对应的英文是static method and dynamic method.

//3explain the class and the instance of class
//类是一个模板蓝图  实例是类的一个对象
//类是一个type 实例是只有在运行的时候存在的实例化类型

//4解释基本类型的用途并且结合类和实例进行比较
    //基本类型是用来存储简单数据的类型，例如整数、浮点数、字符和布尔值。
    // 它们是直接存储在内存中的简单数据类型，而不是对象。
    // 在声明时必须指定其类型，例如int、double、char和boolean等。
    // 在内存中占用固定的空间，例如int占用4个字节，double占用8个字节等。
    // 可以直接赋值和操作，例如int a = 10; a = a + 1;等。

    // 而类和实例则是用来存储复杂数据的类型，例如对象、数组和字符串等。
    // 它们是存储在堆内存中的对象，而不是直接存储在栈内存中的简单数据类型。
    // 在声明时必须指定其类型，例如Critter critter = new Critter();等。
    // 在内存中占用的空间是不固定的，因为它们是存储在堆内存中的对象。
    // 只能通过引用（reference）来访问和操作，例如critter.name = "kitty";等。

//5explain what null is give example of type where null is not valid value
//解释什么是null。给出一个null不是有效值的类型的例子
//null是一个特殊的值，它表示一个引用变量不引用任何对象。
// 例如，Critter critter = null;表示critter引用变量不引用任何Critter对象。
// 例子int a = null;是错误的，因为int是一个基本类型，不能赋值为null。

