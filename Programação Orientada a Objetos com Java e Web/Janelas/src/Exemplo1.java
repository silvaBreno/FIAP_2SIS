import javax.swing.JOptionPane;

public class Exemplo1 {
	public static void main(String[] args) {
		
		//JOptionPane.showMessageDialog(null, "boa noite");
        //JOptionPane.showMessageDialog(null, "Boa Noite", "Caixa de Boa Noite", 0);
		
		//String nome = JOptionPane.showInputDialog("Qual é o seu nome?");
		//JOptionPane.showMessageDialog(null, nome);
		
		int valor1 = Integer.parseInt(JOptionPane.showInputDialog("Qual é o primeiro valor?"));
		int valor2 = Integer.parseInt(JOptionPane.showInputDialog("Qual é o segundo valor?"));
		int resultado = ((valor1+valor2)/2);
		JOptionPane.showMessageDialog(null, "o resultado é: " + resultado);
	}

}
