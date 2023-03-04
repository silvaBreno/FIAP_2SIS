package br.fiap.main;
import br.fiap.formas.*;
import br.fiap.volume.Volume;

public class Main {

	public static void main(String[] args) {
		
		FormaGeometrica[] forma = new FormaGeometrica[4]; 
		 

		forma[0] = new Circulo(2, 2, 2);
		forma[1] = new Cilindro(3, 3, 3.5, 4.25);
		forma[2] = new Circulo(4, 4, 4.5);
		forma[3] = new Cilindro(2, 3, 4, 5);
		
		//impressao dos dados
				// so posso utilizar ele se for pecorrer o vetor como um todo, se o tamanho do meu vetor fosse 10, e eu tivesse preenchido apenas
				// essas 4 posicoes do vetor, eu nao poderia utilizar esse for each
				// para esse for each eu preciso utilizar um variavel do mesmo tipo do vetor qualquer e referenciar no segundo termo o vetor 
				// que desejo percorrer
				// a minha variavel do tipo f esta referenciando o vetor forma do tipo forma geometrica
		for(FormaGeometrica f : forma) {
			System.out.println(f);
			
			//eu n preciso fazer f.tostring(); pq esse metodo ele foi sobrescrito e nao precisa ser chamado.
			//se n tivessemos sobrescrito o metodo, esse variavel iria retornar a posicao de memoria do objeto
		}
		
		//forma tradicional
//		for (int i = 0; i < forma.length; i++) {
//			System.out.println(forma[i].toString());
//		}
		
		//impressao do volume
	
		
		for (FormaGeometrica f : forma) {
			//se o f for uma instancia de Cilindro
			if (f instanceof Volume) {
				// esse parenteses quer ficar para variavel f, converta a variavel f em um objetivo do tipo Volume
				System.out.println("Volume = " + ((Volume) f).calcularVolume());
				
			}
		}
	}

}
