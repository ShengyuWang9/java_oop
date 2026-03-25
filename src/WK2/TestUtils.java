package WK2;

public class TestUtils {
    static void main(String[] args) {
//        Utility.assertEquals(3,1,"test1");

//        Utility.assertEquals(1,2,"Err!");
//        Utility.assertEquals("1","2","Err!");
//        Utility.assertEquals("1",null,"Err!");
//        Utility.assertEquals(1,"1","Err!");
//        Utility.assertEquals(null,null,"Err!");
    //b
        Utility.assertUniversalEquals(1,2,"Err!");
        Utility.assertUniversalEquals("1","2","Err!");
        Utility.assertUniversalEquals("1",null,"Err!");
        Utility.assertUniversalEquals(1,"1","Err!");
        Utility.assertUniversalEquals(null,null,"Err!");


        //一次性只会出来一个结果 用try-catch
        try{
            Utility.assertUniversalEquals(1,1, "err");
        }catch (AssertionError e){
            System.out.println(e.getMessage());
        }
        try{
            Utility.assertUniversalEquals("1",1, "err");
        }catch (AssertionError e){
            System.out.println(e.getMessage());
        }
    }
}
