package Class;

import java.util.List;

public class Avaliacao {
    private int idDesenvolvedor;
    private List<String> questoes;
    private String conteudo;

    public Avaliacao(int idDesenvolvedor, List<String> questoes, String conteudo) {
        this.idDesenvolvedor = idDesenvolvedor;
        this.questoes = questoes;
        this.conteudo = conteudo;
    }

    public String avaliar() {
        return "Avaliação realizada para o desenvolvedor ID: " + idDesenvolvedor;
    }

    // Getters e Setters
    public int getIdDesenvolvedor() {
        return idDesenvolvedor;
    }

    public List<String> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<String> questoes) {
        this.questoes = questoes;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}