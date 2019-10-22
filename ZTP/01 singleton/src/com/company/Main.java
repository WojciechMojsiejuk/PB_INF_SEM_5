package com.company;

interface IPolaczenie {
    char get(int indeks);
    void set(int indeks, char c);
    int length();
}

final class Baza {
    private char[] tab = new char[100];
    private static Baza instance = new Baza();
    private Baza() {}
    private static Baza getInstance() {
        return instance;
    }
    public static IPolaczenie getPolaczenie() {
        return Polaczenie.getInstance();
    }
    private static class Polaczenie implements IPolaczenie {
        private Baza baza;
        private static Polaczenie[] connections = {  new Polaczenie(),
                new Polaczenie(), new Polaczenie() };
        private static int index = -1;
        private Polaczenie() {
            baza = Baza.getInstance();
        }
        public static IPolaczenie getInstance() {
            index = (index+1) % connections.length;
            return connections[index];
        }
        public char get(int indeks) {
            return baza.tab[indeks];
        }
        public void set(int indeks, char c) {
            baza.tab[indeks] = c;
        }
        public int length() {
            return baza.tab.length;
        }
    }
}

public class Main {

    public static void main(String[] args) {
        IPolaczenie[] connection_list = {  Baza.getPolaczenie(), Baza.getPolaczenie(), Baza.getPolaczenie(), Baza.getPolaczenie()  };

        connection_list[0].set(5, 'k');
        System.out.println("Do bazy wysłano znak k przy pomocy połącznia pierwszego");

        for (IPolaczenie connection : connection_list) {
            char character = connection.get(5);
            System.out.println("Znak pobrany z bazy " + character);
        }
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                if (connection_list[i] == connection_list[j]) {
                    System.out.println(String.format("Połączenie %d jest tym samym, co połączenie %d", i+1, j+1));
                } else {
                    System.out.println(String.format("Połączenie %d nie jest tym samym, co połączenie %d", i+1, j+1));
                }
            }
        }
    }
}
