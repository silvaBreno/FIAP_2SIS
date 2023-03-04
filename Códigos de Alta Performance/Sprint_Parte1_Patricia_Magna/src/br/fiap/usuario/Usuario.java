package br.fiap.usuario;

import br.fiap.tipoPilha.TipoPilha;

public class Usuario {

	public static final String STATUS_OK = "Ok";
	public static final String STATUS_NAO_OK = "Não Ok";
	private int id;
	private String nome;
	private String statusAtendimento;
	private TipoPilha pilhaMensagens;

	public Usuario(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
		this.statusAtendimento = STATUS_OK;
		pilhaMensagens = new TipoPilha();
		pilhaMensagens.init();
	}

	public String getStatusAtendimento() {
		return statusAtendimento;
	}

	public void setStatusAtendimento(String statusAtendimento) {
		this.statusAtendimento = statusAtendimento;
	}

	public void enviaMsg(String msg) {
		pilhaMensagens.push(msg);
		statusAtendimento = STATUS_NAO_OK;
	}

	public void leMsg() {
		System.out.println("");
		while (!pilhaMensagens.isEmpty()) {
			System.out.println("Mensagem Recebida: " + pilhaMensagens.pop());
			System.out.println( "-----------------------------------------------------------------");
		}

		statusAtendimento = STATUS_OK;

	}

}
