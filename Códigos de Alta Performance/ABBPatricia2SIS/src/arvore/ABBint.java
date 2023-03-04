package arvore;

public class ABBint {

	private class ARVORE{
		int  dado;
		ARVORE esq, dir;
	}
	public ARVORE raiz = null;
	
	public ARVORE inserir(ARVORE p, int info) {
	    // insere elemento em uma ABB
	    if (p == null) {
	        p = new ARVORE();
	        p.dado = info;
	        p.esq = null;
	        p.dir = null;
	    }
	    else if (info < p.dado) 
	        p.esq= inserir (p.esq, info);
	         else
	        p.dir=inserir(p.dir, info); 
	    return p;
	    }
	
	public void listaEmOrdem(ARVORE p) {
		if (p == null) {
			listaEmOrdem(p.esq);
			System.out.println("dado: " + p.dado);
			listaEmOrdem(p.dir);
	
		}
	}
	
	public int contaNos(ARVORE p, int cont) {

		if (p != null) {
			cont++;
			cont = contaNos(p.esq, cont);
			cont = contaNos(p.dir, cont);
		}

		
		return cont;
		
	}

	public boolean consulta(ARVORE p, int info) {
		if (p != null) {
			if (info == p.dado) {
				return true;
			}
			else {
				if (info < p.dado) {
					return (consulta(p.esq, info));
				}else {
					return (consulta(p.dir, info));
				}
			}
		} else {
			return false;			
		}
	}

	public ARVORE removeValor(ARVORE p, int info) {
		if(p != null){
			if(p.esq == null && p.dir == null) {
				return null;
			} else if (p.esq == null ){
				return p.dir;
			} else if (p.dir == null){
				return p.esq;
			} else {
				ARVORE ref, aux;
				ref = aux = p.dir;
				while(aux.esq != null) {
					aux = aux.esq;
				}
				aux.esq = p.esq;
				return ref;
			}
		} else {
			if(info < p.dado) {
				p.esq = removeValor(p.esq, info);
			} else {
				p.dir = removeValor(p.esq, info);
			}
		} 
		return null;
	}
}
