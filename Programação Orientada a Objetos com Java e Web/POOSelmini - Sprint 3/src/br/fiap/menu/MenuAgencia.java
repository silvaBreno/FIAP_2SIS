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
                    showMessageDialog(null, "Opção inválida");
                }
            } catch (NumberFormatException e) {
                showMessageDialog(null, "A opção deve ser um número entre 1 e 5\n");
            }
        } while (opcao != 5);
    }
    private void alterarNomeAgencia() {
        Agencia agencia = buscaValidaAgencia();
        if (agencia != null) {
            String novoNome = showInputDialog("Digite o novo nome da agência: ");
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
            String numAgencia = showInputDialog("Digite o número da agência: ");
            Agencia agenciaInformada = dao.consultar(banco, numAgencia);
            if (agenciaInformada == null) {
                showMessageDialog(null, "A agência informada não existe");
            }
            return agenciaInformada;
        }
        return null;
    }
    private void listarAgencias() {
        Banco banco = buscaValidaBanco();
        if (banco != null) {
            List<Agencia> agencias = dao.listar(banco);
            String texto = "Agências do banco " + banco.getCodBanco() + ": \n\n";
            for (Agencia agencia : agencias) {
                texto += agencia + "\n";
            }
            showMessageDialog(null, texto);
        }
    }
    private void cadastrarAgencia() {
        Banco banco = buscaValidaBanco();
        if (banco != null) {
            String numAgencia = showInputDialog("Digite o número da agência: ");
            int digitoAgencia = parseInt(showInputDialog("Digite o dígito da agência: "));
            String nome = showInputDialog("Digite o nome da agência: ");
            dao.inserir(new Agencia(numAgencia, digitoAgencia, nome, banco));
        }
    }
    private Banco buscaValidaBanco() {
        String codBanco = showInputDialog("Digite o código do banco: ");
        Banco bancoInformado = bancoDao.consultar(codBanco);
        if (bancoInformado == null) {
            showMessageDialog(null, "O código de banco informado não existe");
        }
        return bancoInformado;
    }
    private String gerarMenuAgencia() {
        String menu = "Escolha uma operacao:\n";
        menu += "1. Inserir Agência\n";
        menu += "2. Listar Agências\n";
        menu += "3. Consultar Agência\n";
        menu += "4. Alterar Nome Agência\n";
        menu += "5. Sair";
        return menu;
    }
}
