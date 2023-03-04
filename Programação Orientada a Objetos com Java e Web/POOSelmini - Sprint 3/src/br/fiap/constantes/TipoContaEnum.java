package br.fiap.constantes;

public enum TipoContaEnum {
	
	CONTA_CORRENTE("CC", "Conta Corrente"), CONTA_POUPANCA("CP", "Conta Poupanca");
	
	private String valor, descricao;
	
	private TipoContaEnum(String valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}
	
	public String getValor() {
		return valor;
	}
	
	@Override
	public String toString() {
		return descricao;
	}
	
	
	public static TipoContaEnum getEnum(String valor) {
		for (TipoContaEnum tipo : TipoContaEnum.values()) {			
			if(tipo.getValor().equalsIgnoreCase(valor)) {
				return tipo;
			}
		}
		return null;
	}
	
	public static TipoContaEnum getEnumPorDescricao(String descricao) {
		for (TipoContaEnum tipo : TipoContaEnum.values()) {			
			if(tipo.getDescricao().equalsIgnoreCase(descricao)) {
				return tipo;
			}
		}
		return null;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	
}
