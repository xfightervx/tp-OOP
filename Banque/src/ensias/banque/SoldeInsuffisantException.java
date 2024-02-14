package ensias.banque;

public class SoldeInsuffisantException extends Exception {

	private static final long serialVersionUID = 1L;

	public SoldeInsuffisantException(Compte compte, double montant) {
		System.out.println("Impossible de retirer le mentant : "+ montant
				+ "\nSolde ="+compte.getSolde());
	}
	
}
