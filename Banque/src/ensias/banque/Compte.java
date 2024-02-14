package ensias.banque;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Optional;
public class Compte extends ArrayList{
	private int numero;
	private String nom;
	private double solde;
	static int nbComptes;
	operation operations[];
	
	private void deposer(double montant) {
		solde += montant;
	}
	private void retirer(double montant)  throws SoldeInsuffisantException{
		if(solde<montant) {
			throw new SoldeInsuffisantException(this, montant);
		}
		else {
			solde -= montant;
		}
	}
	private void virer(double montant,Compte compte)  throws SoldeInsuffisantException{
		if(this.solde>=montant) {
			compte.deposer(montant);
			this.retirer(montant);
		}
		else {
			throw new SoldeInsuffisantException(this, montant);
		}
	}
	
	public Compte(String nom,double solde) {
		if(nom==null) {
			Scanner S=new Scanner(System.in);
			nom = S.next();
			S.close();
		}
		this.nom = nom;
		this.solde = solde;
		this.numero = nbComptes;
		this.operations = new operation[0];
		nbComptes+=1;
		
		
	}
	
	public Compte(){
		this.nom = null;
		nbComptes=0;
	}
	
	public Compte(Compte compte) {
		this.nom = compte.nom;
		this.solde = compte.solde;
		this.numero = nbComptes;
		this.operations = compte.operations;
		nbComptes++;
	}
	
	public String toString() {
		String a="le nom du propritaire :  "+ nom +"\nson solde             :  "+new DecimalFormat("0.00").format(solde)+"\nson numero est        :  "+ numero+"\n";
		return a;
	}
	
	public boolean equals(Compte compte){
		if(this.nom==compte.nom && this.solde==compte.solde && this.numero==compte.numero && this.operations==compte.operations) {return true;}
		return false;
	}
	public void getters(double solde){
		if(solde<0) {
			throw new IllegalArgumentException("le solde doit etre positive");
		}
		else {
			this.solde=solde;
		}
	}
	public String getSolde() {
		return Double.toString(this.solde);
	}
	public double getSoldeint() {
		return this.solde;
	}
	public void add(int op ,Optional<Compte> compte,double montant) throws SoldeInsuffisantException {
		if(op==0) {
			deposer(montant);
		}
		if(op==1) {
			retirer(montant);
		}
		if(op==2) {
			virer(montant, compte.orElse(null));
		}
		this.operations= add(this.operations, op, montant);
	}
	
	public void remove() {
		remove(this.operations);
		
	}
	public String releve() {
		String a= "Numero = "+numero+"    Nom = "+nom;
		a+="\n\n-----------------------------------------------\n";
		for(operation op :operations) {
			a+=op.date+" "+op.houre+" ";
			if(op.operation==0) {
				a+="DEPOT   ";
			}
			if(op.operation==1) {
				a+="RETRAIT ";
			}
			if(op.operation==2) {
				a+="VIERMENT";
			}
			a+=" "+new DecimalFormat("0.00").format(op.montant)+"\n";
		}
		a+="             Solde= "+new DecimalFormat("0.00").format(this.solde);
		return a;
	}
}
