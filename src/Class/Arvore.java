package Class;

import java.util.List;

public class Arvore {
    private int rank;
    private List<String> linguagensDeProgramacao;
    private List<String> competencias;
    private List<String> historico;
    private String status;

    public Arvore(int rank, List<String> linguagensDeProgramacao, List<String> competencias, List<String> historico, String status) {
        this.rank = rank;
        this.linguagensDeProgramacao = linguagensDeProgramacao;
        this.competencias = competencias;
        this.historico = historico;
        this.status = status;
    }

    // Métodos
    public void adicionarCompetencia(String competencia) {
        this.competencias.add(competencia);
    }

    public void atualizarStatus(String status) {
        this.status = status;
    }

    // Getters e Setters
    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public List<String> getLinguagensDeProgramacao() {
        return linguagensDeProgramacao;
    }

    public void setLinguagensDeProgramacao(List<String> linguagensDeProgramacao) {
        this.linguagensDeProgramacao = linguagensDeProgramacao;
    }

    public List<String> getCompetencias() {
        return competencias;
    }

    public void setCompetencias(List<String> competencias) {
        this.competencias = competencias;
    }

    public List<String> getHistorico() {
        return historico;
    }

    public void setHistorico(List<String> historico) {
        this.historico = historico;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
