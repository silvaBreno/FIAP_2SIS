package teste;
import tipoPilha.TipoPilhaString;

public class MainTesteString {
	public static void main(String[] args) {
		
		TipoPilhaString pilha = new TipoPilhaString();
		pilha.init();
		pilha.push("Azure Data Lake");
		pilha.push("Hadoop Framework");
		
		System.out.println(pilha.pop());
		
		pilha.push("Administração de Data Lakes");
		
		System.out.println(pilha.pop());
		
		pilha.push("Neo4J");	
		
		System.out.println(pilha.pop());
		System.out.println(pilha.pop());
		
		pilha.push("Deep Learning");
		
		System.out.println(pilha.pop());
	}
}
