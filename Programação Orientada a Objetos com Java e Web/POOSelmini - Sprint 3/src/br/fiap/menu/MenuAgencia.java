package br.fiap.menu;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import java.util.List;

import br.fiap.dao.AgenciaDAO;
import br.fiap.dao.BancoDAO;
import br.fiap.entidades.Agencia;
import br.fiap.entidades.Banco;

public class MenuAgencia {
	
	private BancoDAO bancoDao;
    private AgenciaDAO dao;
    public void menuAgencia() {
        int opcao = 0;
        dao = new AgenciaDAO();
        bancoDao = new BancoDAO();
        do {
            try {
                opcao = parseInt(showInputDialog(gerarMenuAgencia()));
                switch (opcao) {
                case 1:
                    cadastrarAgencia();
                    break;
                case 2:
                    listarAgencias();
                    break;
                case 3:
                    consultarAgencia();
                    break;
                case 4:
                    alterarNomeAgencia();
                    break;
                case 5:
                    break;
                default:
                    showMessageDialog(null, "Op��o inv�lida");
                }
            } catch (NumberFormatException e) {
                showMessageDialog(null, "A op��o deve ser um n�mero entre 1 e 5\n");
            }
        } while (opcao != 5);
    }
    private void alterarNomeAgencia() {
        Agencia agencia = buscaValidaAgencia();
        if (agencia != null) {
            String novoNome = showInputDialog("Digite o novo nome da ag�ncia: ");
            agencia.setNome(novoNome);
            dao.alterar(agencia);
        }
    }
    private void consultarAgencia() {
        Agencia agenciaBuscada = buscaValidaAgencia();
        if (agenciaBuscada != null) {
            showMessageDialog(null, agenciaBuscada);
        }
    }
    private Agencia buscaValidaAgencia() {
        Banco banco = buscaValidaBanco();
        if (banco != null) {
            String numAgencia = showInputDialog("Digite o n�mero da ag�ncia: ");
            Agencia agenciaInformada = dao.consultar(banco, numAgencia);
            if (agenciaInformada == null) {
                showMessageDialog(null, "A ag�ncia informada n�o existe");
            }
            return agenciaInformada;
        }
        return null;
    }
    private void listarAgencias() {
        Banco banco = buscaValidaBanco();
        if (banco != null) {
            List<Agencia> agencias = dao.listar(banco);
            String texto = "Ag�ncias do banco " + banco.getCodBanco() + ": \n\n";
            for (Agencia agencia : agencias) {
                texto += agencia + "\n";
            }
            showMessageDialog(null, texto);
        }
    }
    private void cadastrarAgencia() {
        Banco banco = buscaValidaBanco();
        if (banco != null) {
            String numAgencia = showInputDialog("Digite o n�mero da ag�ncia: ");
            int digitoAgencia = parseInt(showInputDialog("Digite o d�gito da ag�ncia: "));
            String nome = showInputDialog("Digite o nome da ag�ncia: ");
            dao.inserir(new Agencia(numAgencia, digitoAgencia, nome, banco));
        }
    }
    private Banco buscaValidaBanco() {
        String codBanco = showInputDialog("Digite o c�digo do banco: ");
        Banco bancoInformado = bancoDao.consultar(codBanco);
        if (bancoInformado == null) {
            showMessageDialog(null, "O c�digo de banco informado n�o existe");
        }
        return bancoInformado;
    }
    private String gerarMenuAgencia() {
        String menu = "Escolha uma operacao:\n";
        menu += "1. Inserir Ag�ncia\n";
        menu += "2. Listar Ag�ncias\n";
        menu += "3. Consultar Ag�ncia\n";
        menu += "4. Alterar Nome Ag�ncia\n";
        menu += "5. Sair";
        return menu;
    }
}
