package WK2;

public class TestErrorOrResut {
    public static void main(String[] args) {
        System.out.println(ErrorOrResult.parseIntOrFail("a"));
        System.out.println(ErrorOrResult.parseIntOrFail("1"));

//        ErrorOrResult e = ErrorOrResult.parseIntOrFail("1");
//        System.out.println(e.result()); //1
//        System.out.println(e.error()); //抛异常NoSuchElementException

//        ErrorOrResult a = ErrorOrResult.parseIntOrFail("e");
//        System.out.println(a.error());  //For input string: "e"
//        System.out.println(a.result()); //NoSuchElementException

    }
}
