package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

import Factory.PortfolioFactory;
import Class.Portfolio;

public class PortfolioPanel {

    private void validarCamposObrigatorios(JTextField... campos) throws Exception {
        for (JTextField campo : campos) {
            if (campo.getText().trim().isEmpty()) {
                throw new Exception("Todos os campos devem ser preenchidos.");
            }
        }
    }
    private PortfolioFactory portfolioFactory;
    private List<Portfolio> portfolios;

    public PortfolioPanel(PortfolioFactory portfolioFactory, List<Portfolio> portfolios) {
        this.portfolioFactory = portfolioFactory;
        this.portfolios = portfolios;
    }

    public JPanel createPortfolioPanel() {
        JPanel panel = new JPanel(new GridLayout(8, 2, 10, 10));

        JTextField projetoField = new JTextField();
        JTextField perfilField = new JTextField();
        JTextField ideiaField = new JTextField();
        JTextField descricaoField = new JTextField();
        JTextField tecnologiaField = new JTextField();
        JTextField linkRepositorioField = new JTextField();
        JButton criarPortfolioButton = new JButton("Criar Portfólio");
        JButton exibirPortfoliosButton = new JButton("Exibir Portfólios");
        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);

        panel.add(new JLabel("Projeto:"));
        panel.add(projetoField);
        panel.add(new JLabel("Perfil:"));
        panel.add(perfilField);
        panel.add(new JLabel("Ideia:"));
        panel.add(ideiaField);
        panel.add(new JLabel("Descrição:"));
        panel.add(descricaoField);
        panel.add(new JLabel("Tecnologias Usadas (separadas por vírgula):"));
        panel.add(tecnologiaField);
        panel.add(new JLabel("Link do Repositório:"));
        panel.add(linkRepositorioField);
        panel.add(criarPortfolioButton);
        panel.add(exibirPortfoliosButton);

        // Ação para o botão Criar Portfólio
        criarPortfolioButton.addActionListener(e -> {
            try {
                String projeto = projetoField.getText();
                String perfil = perfilField.getText();
                String ideia = ideiaField.getText();
                String descricao = descricaoField.getText();
                List<String> tecnologiaUsada = Arrays.asList(tecnologiaField.getText().split(","));
                String linkRepositorio = linkRepositorioField.getText();

                Portfolio portfolio = portfolioFactory.create(projeto, perfil, ideia, descricao, tecnologiaUsada, linkRepositorio);
                portfolios.add(portfolio);

                outputArea.setText("Portfólio criado com sucesso!\n" +
                        "Projeto: " + portfolio.getProjeto() + "\n" +
                        "Perfil: " + portfolio.getPerfil() + "\n" +
                        "Ideia: " + portfolio.getIdeia() + "\n" +
                        "Descrição: " + portfolio.getDescricao() + "\n" +
                        "Tecnologias Usadas: " + portfolio.getTecnologiaUsada() + "\n" +
                        "Link do Repositório: " + portfolio.getLinkRepositorio());
            } catch (Exception ex) {
                outputArea.setText("Erro ao criar Portfólio: " + ex.getMessage());
            }
        });

        // Ação para o botão Exibir Portfólios
        exibirPortfoliosButton.addActionListener(e -> {
            StringBuilder sb = new StringBuilder("Portfólios Criados:\n");
            for (Portfolio p : portfolios) {
                sb.append("Projeto: ").append(p.getProjeto()).append("\n")
                        .append("Perfil: ").append(p.getPerfil()).append("\n")
                        .append("Ideia: ").append(p.getIdeia()).append("\n")
                        .append("Descrição: ").append(p.getDescricao()).append("\n")
                        .append("Tecnologias Usadas: ").append(p.getTecnologiaUsada()).append("\n")
                        .append("Link do Repositório: ").append(p.getLinkRepositorio()).append("\n\n");
            }
            outputArea.setText(sb.toString());
        });

        panel.add(new JScrollPane(outputArea));
        return panel;
    }

}
