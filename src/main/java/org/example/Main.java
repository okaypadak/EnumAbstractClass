package org.example;


interface Arayuz1 {
    void metot1();
}

interface Arayuz2 {
    void metot2();
}

abstract class AbstractSinif implements Arayuz1, Arayuz2 {
    // Arayüzlerde tanımlanan metotları burada uyguluyoruz
    @Override
    public void metot1() {
        System.out.println("Arayüz 1 metodu çalıştı");
    }

    @Override
    public void metot2() {
        System.out.println("Arayüz 2 metodu çalıştı");
    }

    abstract void metod3();
}

class Sinif1 extends AbstractSinif {

    @Override
    void metod3() {

    }
}

class Sinif2 extends AbstractSinif {

    @Override
    void metod3() {
        System.out.println("Metod 3 metodu çalıştı");
    }
}

enum Siniflar {
    SINIF1(Sinif1.class, "Class1"),
    SINIF2(Sinif2.class, "Class2");

    private Class<? extends AbstractSinif> sinif;
    private String sinifAdi;

    Siniflar(Class<? extends AbstractSinif> sinif, String sinifAdi) {
        this.sinif = sinif;
        this.sinifAdi = sinifAdi;
    }

    public static AbstractSinif getInstance(String sinifAdi) {
        for (Siniflar tek: Siniflar.values()) {
            if (tek.sinifAdi.equals(sinifAdi)) {
                try {
                    return tek.sinif.newInstance();
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {


        AbstractSinif class2 = Siniflar.getInstance("Class2");
        class2.metod3();

    }
}