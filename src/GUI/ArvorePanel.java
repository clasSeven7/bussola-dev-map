package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

import Factory.ArvoreFactory;
import Class.Arvore;

public class ArvorePanel {

    private void validarCamposObrigatorios(JTextField... campos) throws Exception {
        for (JTextField campo : campos) {
            if (campo.getText().trim().isEmpty()) {
                throw new Exception("Todos os campos devem ser preenchidos.");
            }
        }
    }

    private ArvoreFactory arvoreFactory;

    public ArvorePanel(ArvoreFactory arvoreFactory) {
        this.arvoreFactory = arvoreFactory;
    }

    public JPanel createArvorePanel() {
        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));

        JTextField rankField = new JTextField();
        JTextField linguagensField = new JTextField();
        JTextField competenciasField = new JTextField();
        JTextField historicoField = new JTextField();
        JTextField statusField = new JTextField();
        JButton criarArvoreButton = new JButton("Criar Árvore");
        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);

        panel.add(new JLabel("Rank:"));
        panel.add(rankField);
        panel.add(new JLabel("Linguagens (separadas por vírgula):"));
        panel.add(linguagensField);
        panel.add(new JLabel("Competências (separadas por vírgula):"));
        panel.add(competenciasField);
        panel.add(new JLabel("Histórico (separado por vírgula):"));
        panel.add(historicoField);
        panel.add(new JLabel("Status:"));
        panel.add(statusField);
        panel.add(criarArvoreButton);

        criarArvoreButton.addActionListener(e -> {
            try {
                // Valida os campos obrigatórios
                validarCamposObrigatorios(rankField, linguagensField, competenciasField, historicoField, statusField);

                int rank = Integer.parseInt(rankField.getText());
                List<String> linguagens = Arrays.asList(linguagensField.getText().split(","));
                List<String> competencias = Arrays.asList(competenciasField.getText().split(","));
                List<String> historico = Arrays.asList(historicoField.getText().split(","));
                String status = statusField.getText();

                Arvore arvore = arvoreFactory.create(rank, linguagens, competencias, historico, status);

                outputArea.setText("Árvore criada com sucesso!\n" +
                        "Rank: " + arvore.getRank() + "\n" +
                        "Linguagens: " + arvore.getLinguagensDeProgramacao() + "\n" +
                        "Competências: " + arvore.getCompetencias() + "\n" +
                        "Histórico: " + arvore.getHistorico() + "\n" +
                        "Status: " + arvore.getStatus());
            } catch (Exception ex) {
                outputArea.setText("Erro ao criar Árvore: " + ex.getMessage());
            }
        });

        panel.add(new JScrollPane(outputArea));
        return panel;
    }
}
