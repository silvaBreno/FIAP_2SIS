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

	public static TipoContaEnum getEnum(String valor) {
		for (TipoContaEnum tipo : TipoContaEnum.values()) {
			if (tipo.getValor().equalsIgnoreCase(valor)) {
				return tipo;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return descricao;
	}
}
