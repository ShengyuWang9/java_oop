package WK1;

//为什么不要public
//不写public就是说只有在相同的包内才能看得到
class Vector2D {

    //    private double x;
//    private double y;
    private double x, y;

    public Vector2D() {
    }

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    //基于已有的向量 算距离
    public double distance(Vector2D v) {
//        double distance = Math.sqrt(Math.pow((this.x-v.x),2)+Math.pow((this.y-v.y),2));
//        return distance;
        return Math.sqrt(Math.pow((this.x - v.x), 2) + Math.pow((this.y - v.y), 2));

    }

//    //怎么一次性返回两个成员变量
    //不能一次返回两个变量 但是可以返回一个新的对象
//    public addVector(Vector2D v){
//        return this.x += v.x;
//        return this.y += v.y;
//
//    }

    Vector2D add(Vector2D v) {
//        double x = this.x + v.x;
//        double y = this.y + v.y;
//        return new Vector2D(x,y);
        return new Vector2D(x + v.x, y + v.y);
    }

    Vector2D scale(double f) {
//        double x = this.x * f;
//        double y = this.y * f;
//        return new Vector2D(x,y);
        return new Vector2D(x * f, y * f);
    }

    //如果想要直接打印Vector2D 打印出来的回是地址值 Sout就会像是Vector2D@4e25154f的地址值（类名@十六进制哈希值）
    //这里需要重写方法
    @Override
    public String toString() {
        return "Vector2D(" + x + " , " + y + ")";
    }
//Thefields in Vector2D should never be mutated after assignment in the constructor.
//By marking those fields private, we shield them from mutation from the users of the class,
//but you can still accidentally mutate them within the class. State how this can also be avoided
//这里的意思就是说加了private 只有类内部可以修改比如说setter 外部改不了
    //门外的人进不了门内 但是门内的人可以对里面进行修改
//private加了final setter就不能写了 只能用constructor写一次 就再也不能被赋值了
    //更强制 直接对里面的人说 里面的人也改不了
//如果写的是public final外部人可以直接访问它
    //暴露在外面了 没有封装的作用了


}
