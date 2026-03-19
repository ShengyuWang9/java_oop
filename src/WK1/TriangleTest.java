package WK1;

public class TriangleTest {
    public static void main(String[] args) {
        System.out.println(new Triangle(0,0,0));
        System.out.println(new Triangle(10,10,10));
        System.out.println(new Triangle(0,10,10));
        System.out.println(new Triangle(3,4,5));
        System.out.println("makeTriangle(2)");
        Triangle.makeTriangles(2);

    }
}
