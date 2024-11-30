package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

import Factory.AvaliacaoFactory;
import Class.Avaliacao;

public class AvaliacaoPanel {
    private AvaliacaoFactory avaliacaoFactory;

    public AvaliacaoPanel(AvaliacaoFactory avaliacaoFactory) {
        this.avaliacaoFactory = avaliacaoFactory;
    }

    public JPanel createAvaliacaoPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        JTextField idDesenvolvedorField = new JTextField();
        JTextField questoesField = new JTextField();
        JTextField conteudoField = new JTextField();
        JButton criarAvaliacaoButton = new JButton("Criar Avaliação");
        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);

        panel.add(new JLabel("ID do Desenvolvedor:"));
        panel.add(idDesenvolvedorField);
        panel.add(new JLabel("Questões (separadas por vírgula):"));
        panel.add(questoesField);
        panel.add(new JLabel("Conteúdo:"));
        panel.add(conteudoField);
        panel.add(criarAvaliacaoButton);

        criarAvaliacaoButton.addActionListener(e -> {
            try {
                int idDesenvolvedor = Integer.parseInt(idDesenvolvedorField.getText());
                List<String> questoes = Arrays.asList(questoesField.getText().split(","));
                String conteudo = conteudoField.getText();

                Avaliacao avaliacao = avaliacaoFactory.create(idDesenvolvedor, questoes, conteudo);

                outputArea.setText("Avaliação criada com sucesso!\n" +
                        "ID Desenvolvedor: " + avaliacao.getIdDesenvolvedor() + "\n" +
                        "Questões: " + avaliacao.getQuestoes() + "\n" +
                        "Conteúdo: " + avaliacao.getConteudo() + "\n" +
                        "Resultado da Avaliação: " + avaliacao.avaliar());
            } catch (Exception ex) {
                outputArea.setText("Erro ao criar Avaliação: " + ex.getMessage());
            }
        });

        panel.add(new JScrollPane(outputArea));
        return panel;
    }
}
