package WK1;
//test Critter
public class T1 {
    public static void main(String[] args) {
        Critter c1 = new Critter();
        //功能1
        c1.poke();
        //功能2
        Critter c2 = new Critter("cow");
        c2.poke(c2.getName());
        //功能3
        c2.eat(c2.getName());



    }
}
