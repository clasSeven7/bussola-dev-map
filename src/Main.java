import java.util.Arrays;

import Interface.Factory;
import Class.Usuario;
import Class.Desenvolvedor;
import Class.Portfolio;
import Class.Arvore;
import Class.Avaliacao;
import Factory.UsuarioFactory;
import Factory.DesenvolvedorFactory;
import Factory.PortfolioFactory;
import Factory.ArvoreFactory;
import Factory.AvaliacaoFactory;

public class Main {
    public static void main(String[] args) {
        // Criar um Usuario
        Factory<Usuario> usuarioFactory = new UsuarioFactory();
        Usuario usuario = usuarioFactory.create("Saulo Justiniano", "saulo@example.com", "123456");
        System.out.println("Usuário criado: " + usuario.getNome());

        // Criar um Desenvolvedor
        Factory<Desenvolvedor> desenvolvedorFactory = new DesenvolvedorFactory();
        Desenvolvedor dev = desenvolvedorFactory.create("João Silva", "joao@example.com", "senha123", "Intermediário");
        System.out.println("Desenvolvedor criado: " + dev.getNome() + " - " + dev.getNivelDeExperiencia());

        // Criar um Portfolio
        Factory<Portfolio> portfolioFactory = new PortfolioFactory();
        Portfolio portfolio = portfolioFactory.create(
                "Projeto X",
                "Frontend",
                "Ideia inovadora",
                "Descrição do projeto",
                Arrays.asList("JavaScript", "React"),
                "https://github.com/joao/projeto-x"
        );
        System.out.println("Portfólio criado: " + portfolio.getProjeto());

        // Criar uma Arvore
        Factory<Arvore> arvoreFactory = new ArvoreFactory();
        Arvore arvore = arvoreFactory.create(
                1,
                Arrays.asList("Java", "Python"),
                Arrays.asList("OOP", "Design Patterns"),
                Arrays.asList("Projeto 1", "Projeto 2"),
                "Ativo"
        );
        System.out.println("Árvore criada com Rank: " + arvore.getRank());

        // Criar uma Avaliação
        Factory<Avaliacao> avaliacaoFactory = new AvaliacaoFactory();
        Avaliacao avaliacao = avaliacaoFactory.create(
                1,
                Arrays.asList("Questão 1", "Questão 2"),
                "Ótima performance"
        );
        System.out.println("Avaliação criada: " + avaliacao.avaliar());
    }
}
