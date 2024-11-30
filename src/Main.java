package GUI;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import Class.Desenvolvedor;
import Class.Portfolio;

import Factory.ArvoreFactory;
import Factory.AvaliacaoFactory;
import Factory.DesenvolvedorFactory;
import Factory.PortfolioFactory;

public class MainGUI {
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

        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Usuário", new UsuarioPanel().createUsuarioPanel());
        tabbedPane.addTab("Árvore", new ArvorePanel(arvoreFactory).createArvorePanel());
        tabbedPane.addTab("Avaliação", new AvaliacaoPanel(avaliacaoFactory).createAvaliacaoPanel());
        tabbedPane.addTab("Desenvolvedor", new DesenvolvedorPanel(desenvolvedorFactory, desenvolvedores).createDesenvolvedorPanel());
        tabbedPane.addTab("Portfólio", new PortfolioPanel(portfolioFactory, portfolios).createPortfolioPanel());

        frame.getContentPane().add(tabbedPane);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new MainGUI();
    }
}
