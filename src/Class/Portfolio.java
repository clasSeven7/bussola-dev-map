package Class;

import java.util.List;

public class Portfolio {
    private String projeto;
    private String perfil;
    private String ideia;
    private String descricao;
    private List<String> tecnologiaUsada;
    private String linkRepositorio;

    public Portfolio(String projeto, String perfil, String ideia, String descricao, List<String> tecnologiaUsada, String linkRepositorio) {
        this.projeto = projeto;
        this.perfil = perfil;
        this.ideia = ideia;
        this.descricao = descricao;
        this.tecnologiaUsada = tecnologiaUsada;
        this.linkRepositorio = linkRepositorio;
    }


    // Getters e Setters
    public String getProjeto() {
        return projeto;
    }

    public void setProjeto(String projeto) {
        this.projeto = projeto;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getIdeia() {
        return ideia;
    }

    public void setIdeia(String ideia) {
        this.ideia = ideia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<String> getTecnologiaUsada() {
        return tecnologiaUsada;
    }

    public void setTecnologiaUsada(List<String> tecnologiaUsada) {
        this.tecnologiaUsada = tecnologiaUsada;
    }

    public String getLinkRepositorio() {
        return linkRepositorio;
    }

    public void setLinkRepositorio(String linkRepositorio) {
        this.linkRepositorio = linkRepositorio;
    }
}
