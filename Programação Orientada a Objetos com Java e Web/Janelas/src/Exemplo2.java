import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;

public class Exemplo2 {
	public static void main(String[] args) {
	
		int botao = showConfirmDialog(null, "Deseja sair?");
		
		if (botao == 0) {
			showMessageDialog(null, "Até logo");
		} else{
			showMessageDialog(null, "Que bom que você ficou");
		}
	}

}
