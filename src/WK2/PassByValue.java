package WK2;

public class PassByValue {
    static void append1(String a) {
        a += "b";
    }

    static String append2(final String a) {
        return a + "b";
    }

    static void append3(Person p){
        p.name += "b";
    }
}
