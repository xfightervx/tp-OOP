package ensias;

public class comptecourant extends Compte{
	double decouverautorise;
	
	public comptecourant(double montant, String nom ,int decaut) {
		solde = montant;
		this.nom = nom;
		this.numero = tot;
		tot+=1;
		decouverautorise = decaut;
	}
	
	public void retirer(double montant) throws soldeinsuffisant{
		if(montant < decouverautorise) {
			solde-= montant;
			operations.add(new operation(0,montant));
			return ;
		}
		throw new soldeinsuffisant();
	}
	
	public void deposer(double montant) {
		solde += montant;
		operations.add(new operation(1,montant));
	}
	
	public void virer(double montant,comptecourant compte)  throws soldeinsuffisant{
		if(this.solde>=montant) {
			compte.deposer(montant);
			this.retirer(montant);
			operations.add(new operation(2,montant));
		}
		else {
			throw new soldeinsuffisant();
		}
	}
}
