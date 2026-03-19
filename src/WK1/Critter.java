package WK1;
//这里都不需要写public 默认同一个包里可见
public class Critter {
    //题目要求的是确保名字永远不能被改变 所以得添加final
    //必须在构造函数中赋值一次 且之后永远不能修改 如果写set去修改final变量会直接报错
    //后面的空参构造就没有必要写了 因为每一次构造对象必赋值
        //或者空参构造里面放一个默认值
    private String name;
    //这里加private的目的是让外界不能直接访问
    //真正预防改名字是final加上不写setter

    //不需要空参构造 这里有final 必须在构造函数中赋值一次
    public Critter() {
    }

    public Critter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void poke() {
        System.out.println("i was poke");
    }
    //方法重载的知识为什么这里不适用了 我想的是 如果没有传入参数 就用上面的poke
    //有参数传入就用下面的poke方法
    //为什么答案这里定义方法的时候没有加public

    //题目要求的是无参 把上面的修改成
    //名字应该存在对象内部不是每一次调用方法传进去
    public void poke(String name) {
        System.out.println(this.name + " was poked");
        //什么时候用this
        //this=表示当前这个对象自己   当前调用者本身


    }

    //这里是对象吃对象 不是对象吃字符串
    public void eat(String name) {
        System.out.println(name + " is eating");
    }

    //正确答案
//    private final String name;

//    public void poke() {
//        System.out.println("i was poked");}
//    public void poke() {
//        System.out.println(this.name + " was poked");//什么时候用this 当方法中需要使用对象的属性时
//    }
//    public void eat(Critter c) {
//        System.out.println(this.name + " is eating " + c.name);
//    }

}
