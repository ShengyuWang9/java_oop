package WK1;

public class IntBoxTest {
    public static void main(String[] args) {
//        IntBox a = new IntBox(10);
//        System.out.println(a);
//        System.out.println(a.add(10));
//        IntBox b = new IntBox(a.add(10));
//        System.out.println(b.multiply(10));
        //这里我不能直接IntBox().add()的原因就是他们的类型不一样？

         IntBox a=new IntBox(10).add(10);
         System.out.println(a);
         System.out.println(a.multiply(10));
         System.out.println(a);
    }
}
