package ensias.banque;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
public class ArrayList {
	public operation[] add(operation op[],int oper,double monta) {
		operation[] k = new operation[op.length+1];
		for(int i=0 ;i<op.length;i++) {
			k[i]= op[i];
		}
		operation s = new operation();
		s.montant= monta;
		s.operation=oper;
		s.date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		s.houre = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
		k[k.length-1]= s;
		return k;
	}
	public operation[] remove(operation op[]) {
		operation[] k = new operation[op.length-1];
		for(int i=0 ;i<k.length;i++) {
			k[i]= op[i];
		}
		return k;
	}
}