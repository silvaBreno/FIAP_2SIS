import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;


public class Exemplo {

	public static void main(String[] args) {
		
		int x, y, resultado;
		
		try {
			x = parseInt(showInputDialog("Primeiro valor"));
			y = parseInt(showInputDialog("Segundo valor"));
			resultado = x /y;
			showMessageDialog(null, resultado);
		}
		catch(NumberFormatException e) {
			showMessageDialog(null, "Voce deve digitar um numero");
		}
		catch(ArithmeticException e) {
			showMessageDialog(null, "Nao existe divisao por zero");
		};
	}

}
