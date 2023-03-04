package br.fiap.arvore;

import br.fiap.cliente.Cliente;
import br.fiap.pilha.TipoPilhaCliente;

public class ABBcliente {

	private class ARVORE {
		ARVORE esq, dir;
		Cliente cliente;
	}

	public ARVORE raiz = null;

	public ARVORE inserir(ARVORE p, Cliente info) {
		if (p == null) {
			p = new ARVORE();
			p.cliente = info;
		}
		else if (info.getSaldo() < p.cliente.getSaldo())
			p.esq = inserir(p.esq, info);
		else
			p.dir = inserir(p.dir, info);
		return p;
	}

	public void listaOrdemDescrente(ARVORE p) {
		if (p != null) {
			listaOrdemDescrente(p.dir);
			System.out.println(p.cliente);
			listaOrdemDescrente(p.esq);
		}
	}

	public void getPilhaOfertadosPorSaldo(ARVORE p, double saldoInformado, TipoPilhaCliente pilha) {
		if (p != null) {
			getPilhaOfertadosPorSaldo(p.esq, saldoInformado, pilha);
			if (p.cliente.getSaldo() > saldoInformado) {
				pilha.push(p.cliente);
			}
			getPilhaOfertadosPorSaldo(p.dir, saldoInformado, pilha);
		}
	}

	public ARVORE removeValor(ARVORE no, Cliente clienteASerRemovido) {
		if (no != null) {
			if (no.cliente.getNumeroConta() == clienteASerRemovido.getNumeroConta()) {
				if (no.esq == null && no.dir == null) {
					return null;
				} else if (no.esq == null) {
					return no.dir;
				} else if (no.dir == null) {
					return no.esq;
				} else {
					ARVORE ref, aux;
					ref = aux = no.dir;
					while (aux.esq != null) {
						aux = aux.esq;
					}
					aux.esq = no.esq;
					return ref;
				}
			} else {
				if (clienteASerRemovido.getSaldo() < no.cliente.getSaldo()) {
					no.esq = removeValor(no.esq, clienteASerRemovido);
				} else {
					no.dir = removeValor(no.dir, clienteASerRemovido);
				}
			}
		}
		return no;
	}

}
