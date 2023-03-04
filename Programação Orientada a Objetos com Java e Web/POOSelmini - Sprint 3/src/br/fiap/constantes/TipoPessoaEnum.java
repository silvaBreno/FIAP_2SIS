package br.fiap.constantes;

public enum TipoPessoaEnum {
	PESSOA_FISICA (1), PESSOA_JURIDICA(2);
	
	private int valor;
	
	private TipoPessoaEnum(int valor) {
		this.valor = valor;
		
	}
	
	public int getValor() {
		return valor;
	}
	
	public static TipoPessoaEnum getEnum(int valor) {
		for (TipoPessoaEnum tipo : TipoPessoaEnum.values()) {
			if(tipo.getValor() == valor) {
				return tipo;
			}
		}
		return null;
	}
}
