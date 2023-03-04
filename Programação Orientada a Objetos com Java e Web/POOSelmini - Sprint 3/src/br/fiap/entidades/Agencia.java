package br.fiap.entidades;

public class Agencia {
	
	    private String numAgencia;
	    private int digito;
	    private String nome;
	    private Banco banco;
	    public Agencia(String numAgencia, int digito, String nome, Banco banco) {
	        this.numAgencia = numAgencia;
	        this.digito = digito;
	        this.nome = nome;
	        this.banco = banco;
	    }
	    public String getNumAgencia() {
	        return numAgencia;
	    }
	    public void setNumAgencia(String numAgencia) {
	        this.numAgencia = numAgencia;
	    }
	    public int getDigito() {
	        return digito;
	    }
	    public void setDigito(int digito) {
	        this.digito = digito;
	    }
	    public String getNome() {
	        return nome;
	    }
	    public void setNome(String nome) {
	        this.nome = nome;
	    }
	    public Banco getBanco() {
	        return banco;
	    }
	    public void setBanco(Banco banco) {
	        this.banco = banco;
	    }
	    public String getCodBanco() {
	        if (banco != null) {
	            return banco.getCodBanco();
	        }
	        return null;
	    }
	    @Override
	    public String toString() {
	        return "Agência número " + numAgencia + "-" + digito + " | nome: " + nome + " | banco: " + banco.getNome();
	    }
	
}
