package ensias.banque;
import java.lang.Math;
public class Main {
	public static void main(String[] Args) throws SoldeInsuffisantException, InterruptedException {
		Compte a = new Compte("souhail", 5000.0);
		try {
		for(int i =0;i<5;i++) {
			double montant = Math.random()*5000;
			int operation = (int)(Math.random()*100)%2;
			a.add(operation, null, montant);
		}
		}
		catch{
			System.out.println("solde insuffisant");
		}
		System.out.println(a.releve());
		
	}
	
}