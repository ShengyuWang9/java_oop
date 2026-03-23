package WK2;

public class TestUtils {
    static void main(String[] args) {
        Utility.assertEquals(3,1,"test1");

        //b)
        Utility.assertEquals(1,2,"Err!");
        Utility.assertEquals("1","2","Err!");
        Utility.assertEquals("1",null,"Err!");
        Utility.assertEquals(1,"1","Err!");
        Utility.assertEquals(null,null,"Err!");


    }
}
