package dev.lightdream.gtxcs;

public class Pond {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Frog peepo = new Frog("Peepo");
        Frog pepe = new Frog("Pepe", 10, 15);
        Frog peepaw = new Frog("Peepaw", 4.6, 5);
        Frog psd = new Frog("Muie PSD");

        Fly f1 = new Fly(1, 3);
        Fly f2 = new Fly(6);
        Fly f3 = new Fly(1, 3);

        Frog.setSpecies("1331 Frogs");
        System.out.println(peepo);

        peepo.eat(f2);

        System.out.println(f2);

        peepo.grow(8);
        peepo.eat(f2);

        System.out.println(f2);
        System.out.println(peepo);
        System.out.println(psd);

        peepaw.grow(4);

        System.out.println(peepaw);
        System.out.println(pepe);

    }
}
