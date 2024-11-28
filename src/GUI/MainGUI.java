package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Factory.ArvoreFactory;
import Factory.UsuarioFactory;
import Factory.AvaliacaoFactory;
import Factory.DesenvolvedorFactory;
import Factory.PortfolioFactory;
import Class.Arvore;
import Class.Usuario;
import Class.Avaliacao;
import Class.Desenvolvedor;
import Class.Portfolio;

public class MainGUI {

    private void validarCamposObrigatorios(JTextField... campos) throws Exception {
        for (JTextField campo : campos) {
            if (campo.getText().trim().isEmpty()) {
                throw new Exception("Todos os campos devem ser preenchidos.");
            }
        }
    }

    private ArvoreFactory arvoreFactory = new ArvoreFactory();
    private AvaliacaoFactory avaliacaoFactory = new AvaliacaoFactory();
    private DesenvolvedorFactory desenvolvedorFactory = new DesenvolvedorFactory();
    private PortfolioFactory portfolioFactory = new PortfolioFactory();

    private List<Desenvolvedor> desenvolvedores = new ArrayList<>();
    private List<Portfolio> portfolios = new ArrayList<>();

    public MainGUI() {
        JFrame frame = new JFrame("Gerenciador de Objetos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Painel de abas
        JTabbedPane tabbedPane = new JTabbedPane();

        // Painéis
        JPanel usuarioPanel = createUsuarioPanel();
        JPanel arvorePanel = createArvorePanel();
        JPanel avaliacaoPanel = createAvaliacaoPanel();
        JPanel desenvolvedorPanel = createDesenvolvedorPanel();
        JPanel portfolioPanel = createPortfolioPanel();

        // Adiciona os painéis ao tabbedPane
        tabbedPane.addTab("Usuário", usuarioPanel);
        tabbedPane.addTab("Árvore", arvorePanel);
        tabbedPane.addTab("Avaliação", avaliacaoPanel);
        tabbedPane.addTab("Desenvolvedor", desenvolvedorPanel);
        tabbedPane.addTab("Portfólio", portfolioPanel);

        // Adiciona o painel de abas ao frame
        frame.getContentPane().add(tabbedPane);
        frame.setVisible(true);
    }

    // painel para Árvore
    private JPanel createArvorePanel() {
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

    // painel para Avaliação
    private JPanel createAvaliacaoPanel() {
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
                // Valida os campos obrigatórios
                validarCamposObrigatorios(idDesenvolvedorField, questoesField, conteudoField);

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


    // painel para Usuário
    private JPanel createUsuarioPanel() {
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
    // painel para Desenvolvedor
    private JPanel createDesenvolvedorPanel() {
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



    //  painel para Portfólio
    private JPanel createPortfolioPanel() {
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



    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainGUI::new);
    }
}
