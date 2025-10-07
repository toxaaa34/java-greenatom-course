package ru.aaa34.homework.module3;

public final class Skate extends TransportWithoutEngine{
    private boolean forStunt;

    public Skate(String name, boolean forStunt) {
        super(name, 1);
        this.forStunt = forStunt;
    }

    @Override
    public void displayInfo() {
        if (forStunt)
            System.out.println("Скейт трюковой " + name);
        else
            System.out.println("Скейт дорожный " + name);
    }

    @Override
    public void drive() {
        System.out.println("Вжух-вжух, скейт едет вперед!");
    }

    @Override
    public void pickUp() {
        System.out.println("Вы слезли со скейта");
    }

    public void makeStunt() {
        if (forStunt)
            System.out.println("Ты сделал трюк");
        else
            System.out.println("Ты упал \uD83D\uDE2D");
    }
}
