package singleton_aw;

interface IPolaczenie {
    char get(int indeks);
    void set(int indeks, char c);
    int length();
}

public class Baza {
	private char[] tab = new char[100];
	
	private static Baza instance = new Baza();
	private Baza() {};
	private static Baza getInstance(){
		return instance;
	}
	
    public static IPolaczenie getPolaczenie() {
        return Polaczenie.getInstance();
    }
    private static class Polaczenie implements IPolaczenie {
        private Baza baza = Baza.getInstance();
        
        private static int num = -1;
        private static Polaczenie[] ip = {new Polaczenie(), new Polaczenie(), new Polaczenie()};
        public static IPolaczenie getInstance() {
        	num = (num+1) % ip.length;
            return ip[num];
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
