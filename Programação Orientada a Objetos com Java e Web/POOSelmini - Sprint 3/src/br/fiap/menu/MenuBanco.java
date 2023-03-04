package br.fiap.menu;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import java.util.List;

import br.fiap.dao.BancoDAO;
import br.fiap.entidades.Banco;

public class MenuBanco {

	public void menuBanco() {
        int opcao = 0;
        do {
            try {
                  opcao = parseInt(showInputDialog(gerarMenuAdmin()));
                  switch(opcao) {
                       case 1:
                           inserirBanco();
                           break;
                       case 2:
                           consultarBanco();
                           break;
                       case 3:
                           listarBanco();
                           break;
                       case 4:
                           alterarNomeBanco();
                           break;  
                  }
                }
                catch(NumberFormatException e) {
                       showMessageDialog(null, "A opção deve ser um número entre 1 e 4\n");
               };
           } while (opcao != 5);
    }
    private void consultarBanco() {
        BancoDAO dao = new BancoDAO();
        String codBanco = showInputDialog("Código do Banco");
        Banco banco = dao.consultar(codBanco);
        if(banco == null) {
            showMessageDialog(null, "Banco não encontrado");
        } else {
            showMessageDialog(null, banco);
        }
    }
    private void alterarNomeBanco() {
        BancoDAO dao = new BancoDAO();
        String codBanco = showInputDialog("Código do Banco");
        Banco banco = dao.consultar(codBanco);
        if(banco == null) {
            showMessageDialog(null, "Banco não encontrado");
        }else {
            String novoNome = showInputDialog("Novo nome: ");
            dao.alterar(codBanco, novoNome);
        }
    }
   
    private void inserirBanco() {
        BancoDAO dao = new BancoDAO();  
        String codBanco, nome;
        codBanco = showInputDialog("Código do Banco");
        nome = showInputDialog("Nome");
        Banco banco = new Banco(codBanco, nome);
        dao.inserir(banco);
    }
    private void listarBanco() {
        BancoDAO dao = new BancoDAO();
        List<Banco> lista = dao.listar();
        String aux = "";
        for(Banco banco : lista) {
            aux += banco + "\n";
        }
        showMessageDialog(null, aux);
    }
    public String gerarMenuAdmin() {
       String menu = "Escolha uma operacao:\n";
       menu += "1. Inserir Banco\n";
       menu += "2. Consultar Banco\n";
       menu += "3. Listar Banco\n";
       menu += "4. Alterar Nome Banco\n";
       menu += "5. Sair";
       return menu;
    }


}
