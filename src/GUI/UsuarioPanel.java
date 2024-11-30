package GUI;

import javax.swing.*;
import java.awt.*;

import Factory.UsuarioFactory;
import Class.Usuario;

public class UsuarioPanel {

    private void validarCamposObrigatorios(JTextField... campos) throws Exception {
        for (JTextField campo : campos) {
            if (campo.getText().trim().isEmpty()) {
                throw new Exception("Todos os campos devem ser preenchidos.");
            }
        }
    }

    public JPanel createUsuarioPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

        JTextField nomeField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField senhaField = new JTextField();
        JButton criarUsuarioButton = new JButton("Criar Usuário");
        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);

        panel.add(new JLabel("Nome:"));
        panel.add(nomeField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(new JLabel("Senha:"));
        panel.add(senhaField);
        panel.add(criarUsuarioButton);

        // Ação ao clicar no botão de criação de usuário
        criarUsuarioButton.addActionListener(e -> {
            try {
                // Validação de campos obrigatórios
                validarCamposObrigatorios(nomeField, emailField, senhaField);

                String nome = nomeField.getText();
                String email = emailField.getText();
                String senha = senhaField.getText();

                // Criando o usuário com os dados fornecidos
                Usuario usuario = new UsuarioFactory().create(nome, email, senha);

                // Exibindo as informações do usuário criado
                outputArea.setText("Usuário criado com sucesso!\n" +
                        "Nome: " + usuario.getNome() + "\n" +
                        "Email: " + usuario.getEmail() + "\n" +
                        "Senha: " + usuario.getSenha());
            } catch (Exception ex) {
                outputArea.setText("Erro ao criar Usuário: " + ex.getMessage());
            }
        });

        panel.add(new JScrollPane(outputArea));
        return panel;
    }
}
