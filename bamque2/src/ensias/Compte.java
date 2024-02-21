package ensias;

import java.util.ArrayList;
import java.util.List;

public abstract class Compte {
	protected int numero;
	protected String nom;
	protected double solde;
	protected List<operation> operations  = new ArrayList<>();
	static int tot = 0;
	
}
