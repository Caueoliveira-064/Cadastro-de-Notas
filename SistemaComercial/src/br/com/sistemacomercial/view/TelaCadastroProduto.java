package br.com.sistemacomercial.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class TelaCadastroProduto extends JFrame {
	
    private JTextField txtNome, txtPreco;
    private JButton btnSalvar, btnEditar, btnExcluir;
    private JTable tabela;
    private DefaultTableModel modelo;

    public TelaCadastroProduto() {
        setTitle("Cadastro de Produtos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Campos de entrada
        JLabel lblNome = new JLabel("Nome:");
        txtNome = new JTextField(20);

        JLabel lblPreco = new JLabel("Preço:");
        txtPreco = new JTextField(10);

        btnSalvar = new JButton("Salvar");
        btnEditar = new JButton("Editar");
        btnExcluir = new JButton("Excluir");

        JPanel panelTopo = new JPanel();
        panelTopo.add(lblNome);
        panelTopo.add(txtNome);
        panelTopo.add(lblPreco);
        panelTopo.add(txtPreco);
        panelTopo.add(btnSalvar);
        panelTopo.add(btnEditar);
        panelTopo.add(btnExcluir);

        // Tabela
        modelo = new DefaultTableModel(new Object[]{"Nome", "Preço"}, 0);
        tabela = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabela);

        add(panelTopo, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        // Ações do Botão
        btnSalvar.addActionListener(e -> salvarProduto());
        btnEditar.addActionListener(e -> editarProduto());
        btnExcluir.addActionListener(e -> excluirProduto());
    }

    private void salvarProduto() {
        String nome = txtNome.getText();
        String preco = txtPreco.getText();
        if (!nome.isEmpty() && !preco.isEmpty()) {
            modelo.addRow(new Object[]{nome, preco});
            txtNome.setText("");
            txtPreco.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
        }
    }

    private void editarProduto() {
        int linhaSelecionada = tabela.getSelectedRow();
        if (linhaSelecionada != -1) {
            modelo.setValueAt(txtNome.getText(), linhaSelecionada, 0);
            modelo.setValueAt(txtPreco.getText(), linhaSelecionada, 1);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um produto para editar!");
        }
    }

    private void excluirProduto() {
        int linhaSelecionada = tabela.getSelectedRow();
        if (linhaSelecionada != -1) {
            modelo.removeRow(linhaSelecionada);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um produto para excluir!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaCadastroProduto().setVisible(true));
    }
}
