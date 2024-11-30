package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import Factory.DesenvolvedorFactory;
import Class.Desenvolvedor;


public class DesenvolvedorPanel {

    private void validarCamposObrigatorios(JTextField... campos) throws Exception {
        for (JTextField campo : campos) {
            if (campo.getText().trim().isEmpty()) {
                throw new Exception("Todos os campos devem ser preenchidos.");
            }
        }
    }


    private DesenvolvedorFactory desenvolvedorFactory;
    private List<Desenvolvedor> desenvolvedores;

    public DesenvolvedorPanel(DesenvolvedorFactory desenvolvedorFactory, List<Desenvolvedor> desenvolvedores) {
        this.desenvolvedorFactory = desenvolvedorFactory;
        this.desenvolvedores = desenvolvedores;
    }

    public JPanel createDesenvolvedorPanel() {
        JPanel panel = new JPanel(new GridLayout(9, 2, 10, 10));

        JTextField nomeField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField senhaField = new JTextField();
        JTextField nivelDeExperienciaField = new JTextField();
        JComboBox<Desenvolvedor> mentoresComboBox = new JComboBox<>();
        JButton adicionarMentorButton = new JButton("Adicionar Mentor");
        JComboBox<Desenvolvedor> aprendizesComboBox = new JComboBox<>();
        JButton adicionarAprendizButton = new JButton("Adicionar Aprendiz");
        JButton criarDesenvolvedorButton = new JButton("Criar Desenvolvedor");
        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);

        panel.add(new JLabel("Nome:"));
        panel.add(nomeField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(new JLabel("Senha:"));
        panel.add(senhaField);
        panel.add(new JLabel("Nível de Experiência:"));
        panel.add(nivelDeExperienciaField);

        panel.add(new JLabel("Mentores disponíveis:"));
        panel.add(mentoresComboBox);
        panel.add(adicionarMentorButton);

        panel.add(new JLabel("Aprendizes disponíveis:"));
        panel.add(aprendizesComboBox);
        panel.add(adicionarAprendizButton);

        panel.add(criarDesenvolvedorButton);

        criarDesenvolvedorButton.addActionListener(e -> {
            try {
                // Valida os campos obrigatórios
                validarCamposObrigatorios(nomeField, emailField, senhaField, nivelDeExperienciaField);

                String nome = nomeField.getText();
                String email = emailField.getText();
                String senha = senhaField.getText();
                String nivelDeExperiencia = nivelDeExperienciaField.getText();

                Desenvolvedor desenvolvedor = desenvolvedorFactory.create(nome, email, senha, nivelDeExperiencia);
                desenvolvedores.add(desenvolvedor);

                // Atualiza as listas de mentores e aprendizes
                mentoresComboBox.addItem(desenvolvedor);
                aprendizesComboBox.addItem(desenvolvedor);

                outputArea.setText("Desenvolvedor criado com sucesso!\n" +
                        "Nome: " + desenvolvedor.getNome() + "\n" +
                        "Email: " + desenvolvedor.getEmail() + "\n" +
                        "Nível de Experiência: " + desenvolvedor.getNivelDeExperiencia());
            } catch (Exception ex) {
                outputArea.setText("Erro ao criar Desenvolvedor: " + ex.getMessage());
            }
        });

        adicionarMentorButton.addActionListener(e -> {
            Desenvolvedor mentor = (Desenvolvedor) mentoresComboBox.getSelectedItem();
            Desenvolvedor aprendiz = (Desenvolvedor) aprendizesComboBox.getSelectedItem();

            if (mentor != null && aprendiz != null) {
                mentor.adicionarAprendiz(aprendiz);
                aprendiz.definirMentor(mentor);

                outputArea.setText("Mentor " + mentor.getNome() + " associado ao aprendiz " + aprendiz.getNome() + " com sucesso!");
            } else {
                outputArea.setText("Selecione um mentor e um aprendiz para associar.");
            }
        });

        adicionarAprendizButton.addActionListener(e -> {
            Desenvolvedor mentor = (Desenvolvedor) mentoresComboBox.getSelectedItem();
            Desenvolvedor aprendiz = (Desenvolvedor) aprendizesComboBox.getSelectedItem();

            if (mentor != null && aprendiz != null) {
                aprendiz.definirMentor(mentor);
                mentor.adicionarAprendiz(aprendiz);

                outputArea.setText("Aprendiz " + aprendiz.getNome() + " associado ao mentor " + mentor.getNome() + " com sucesso!");
            } else {
                outputArea.setText("Selecione um mentor e um aprendiz para associar.");
            }
        });

        panel.add(new JScrollPane(outputArea));
        return panel;
    }
}
