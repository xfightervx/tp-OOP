package ensias;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class operation {
	int type;
	double montant;
	public String date;
	public String houre;
	
	public operation(int op, double montant) {
		type =  op;
		this.montant = montant;
		this.date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		this.houre = LocalTime.now().format(DateTimeFormatter.ofPattern("ss:mm:HH"));
	}
	
}
