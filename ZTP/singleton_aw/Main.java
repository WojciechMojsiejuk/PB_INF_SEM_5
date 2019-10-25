package singleton_aw;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c = 'a';
		IPolaczenie[] ip = {Baza.getPolaczenie(), Baza.getPolaczenie(), 
				Baza.getPolaczenie(), Baza.getPolaczenie()};
		
		for(int i = 0; i < 4; i++)
		{
			ip[i].set(i, c);
			c++;
		}
		
		for(int i = 0; i<4;i++){
			for(int j = i+1; j<4;j++){
				System.out.println("Polaczenie " + i + " i " + "polaczenie " + j + " sa takieie same: " + (ip[i] == ip[j]));
			}
		}
	}
}
