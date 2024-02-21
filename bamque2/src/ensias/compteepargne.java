package ensias;

public class compteepargne extends Compte{
	double taux;
	
	
	
	public compteepargne(double montant, String nom, double t) {
		this.solde = montant;
		this.nom = nom;
		this.numero = tot;
		taux = t;
		tot+=1;
	}
	public void deposer(double montant) {
		solde += montant*(1+ taux);
		operations.add(new operation(1,montant));
	}
	public void retirer(double montant) throws soldeinsuffisant{
		if(montant < solde) {
			solde-= montant;
			operations.add(new operation(0,montant));
			return ;
		}
		throw new soldeinsuffisant();
	}
	public void virer(double montant,compteepargne compte)  throws soldeinsuffisant{
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
