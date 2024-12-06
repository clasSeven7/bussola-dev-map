package Class;

import java.util.ArrayList;
import java.util.List;

public class Desenvolvedor extends Usuario {
    private String nivelDeExperiencia;
    private List<Desenvolvedor> mentores;
    private List<Desenvolvedor> aprendizes;
    private List<String> linguagens;
    private List<String> habilidades;

    // Construtor
    public Desenvolvedor(String nome, String email, String senha, String nivelDeExperiencia) {
        super(nome, email, senha);
        this.nivelDeExperiencia = nivelDeExperiencia;
        this.mentores = new ArrayList<>();
        this.aprendizes = new ArrayList<>();
        this.linguagens = new ArrayList<>();
        this.habilidades = new ArrayList<>();
    }

    // Métodos
    public void definirMentor(Desenvolvedor mentor) {
        this.mentores.add(mentor);
    }

    public void adicionarAprendiz(Desenvolvedor aprendiz) {
        this.aprendizes.add(aprendiz);
    }

    // Getters e Setters
    public String getNivelDeExperiencia() {
        return nivelDeExperiencia;
    }

    public void setNivelDeExperiencia(String nivelDeExperiencia) {
        this.nivelDeExperiencia = nivelDeExperiencia;
    }

    public List<Desenvolvedor> getMentores() {
        return mentores;
    }

    public List<Desenvolvedor> getAprendizes() {
        return aprendizes;
    }

    public void setLinguagens(List<String> linguagens) {
    }

    public List<String> getLinguagens() {
        return linguagens;
    }

    public void setHabilidades(List<String> habilidades) {
    }

    public List<String> getHabilidades() {
        return habilidades;
    }
}
