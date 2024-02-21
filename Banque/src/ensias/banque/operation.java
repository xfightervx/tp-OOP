package ensias.banque;

import java.time.LocalTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class operation {
	public static final int DEPOT=0,RETRAIT=1, VIREMENT=2;
	public int operation=0;
	public double montant=0;
	public String date;
	public String houre;
	public operation(int op,double mon) {
		this.operation = op;
		this.montant = mon;
		this.date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		this.houre = LocalTime.now().format(DateTimeFormatter.ofPattern("ss:mm:HH"));
	}
	public operation(int op , double mon,String time,String date) {
		this.operation = op;
		this.montant = mon;
		this.date = date;
		this.houre = time;
	}
}
