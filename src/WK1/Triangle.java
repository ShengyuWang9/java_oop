package WK1;

class Triangle {
    //    int a;
//    int b;
//    int c;
    private int a, b, c;  //成员属性私有化
    //通常写 private，因为边长属于对象内部状态，应该由类自己管理，这就是封装。

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    //根据三条边的关系，返回三角形类型的字符串
    //顺序很重要
    //flat三角形三点共线没有面积
    String triangleType() {
        if (a <= 0 || b <= 0 || c <= 0) return "Illegal";
        else if (a + b < c || a + c < b || b + c < a) {
            return "Impossible";
        } else if (a + b == c || a + c == b || b + c == a) {
            return "Flat";
        } else if (a == b && b == c) {
            return "Equilateral";
        }
            //这里用pow不够好 因为这里pow返回的是double 不是int
            //Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2) ||
            //                Math.pow(b, 2) + Math.pow(c, 2) == Math.pow(a, 2) ||
            //                Math.pow(a, 2) + Math.pow(c, 2) == Math.pow(b, 2)
         else if (a * a + b * b == c * c ||
                b * b + c * c == a * a ||
                a * a + c * c == b * b) {
            return "RightAngled";
        }  else if (a == b || a == c || b == c) {
            return "Isosceles";
        }  else {
            return "Scalene";
        }
    }

    @Override
    public String toString() {
        return triangleType() + "(" + a + "," + b + "," + c + ")";
    }

    //为什么这里是类
    //它不是三角形某个三角形的具体行为  而是三角形这个类提供的工具方法 不依赖abc只依赖输入的n
    //所以不属于某个三角形对象 应该属于类
    //在main函数里面用类调用 不是用创建的对象调用
    static void makeTriangles(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    System.out.println(new Triangle(i, j, k));
                }

            }

        }

    }
}
