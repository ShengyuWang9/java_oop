package WK1;

//不用写public 否则a.x可以对x的值进行修改
class IntBox {
    int x;

    IntBox(int x) {
        this.x = x;
    }

    //为什么这里要有这一步 复制构造器 copy constructor
    IntBox(IntBox that) {
        this.x = that.x;
    }
    //我把这里当作是一个有参构造器的重载
    //这里构造一个新构造器来复制的时候 可以复制已经构造过的对象时
    //这可以避免两个对象指向同一个值 下面的这个例子
    //两个变量可能保存同一个引用  这个引用指向堆里的同一个对象
    //如果没有这个构造器更改一个对象的值另一个值也会更改 因为他们保存的地址值都是一样的
//    IntBox a = new IntBox(10);
//    IntBox b = a;
    //但是如果有了这个方法 就可以定义一个新对象 对象的地址和之前的不一样 但是对象里面的x值时一样的
//    IntBox a = new IntBox(10);
//    IntBox b = new IntBox(a);


//    public int add(int a) {
//        return this.x + a;
//    }

    //为什么我写的类型值是int 他写的确实IntBox
        //这里不是要返回一个int类型的数字 而是对IntBox里已有的值修改
    IntBox add(int a) {
        x += a;
        //改当前对象里的x值
        return this;
    }
    //后面test文件 IntBox a = new IntBox(10);
    //创建了一个a对象  对象里有x = 10;
    //调用a.add(5);
    //this就是当前的对象 也是a指向的那个对象
    //执行加的方法 对对象a的x进行修改
    //最后返回this （this是这个对象；this.x才是这个对象里的字段值）
    //为什么这里不是返回this.x -> int
    //this -> IntBox    两者的类型不一样
    //这里题目要求返回IntBox类型

    //    public int substract(int a) {
//        return this.x - a;
//    }
    IntBox substract(int a) {
        x -= a;
        return this;
    }

    //    public int multiply(int a) {
//        return this.x * a;
//    }
    IntBox multiply(int a) {
        x *= a;
        return this;
    }

    @Override
    public String toString() {
        return "IntBox(" + x + ")";
    }

}
