package Class;

import java.util.ArrayList;
import java.util.List;

public class Desenvolvedor extends Usuario {
    private String nivelDeExperiencia;
    private List<Desenvolvedor> mentores = new ArrayList<>();
    private List<Desenvolvedor> aprendizes = new ArrayList<>();
    private List<String> linguagens = new ArrayList<>();
    private List<String> habilidades = new ArrayList<>();

    // Construtor
    public Desenvolvedor(String nome, String email, String senha, String nivelDeExperiencia) {
        super(nome, email, senha);
        this.nivelDeExperiencia = nivelDeExperiencia;
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

    public List<String> getLinguagens() {
        return linguagens;
    }

    public void setLinguagens(List<String> linguagens) {
        this.linguagens = linguagens;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }
}

