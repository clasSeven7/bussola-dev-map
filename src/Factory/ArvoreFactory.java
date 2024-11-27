package Factory;

import Interface.Factory;
import Class.Arvore;

import java.util.List;

public class ArvoreFactory implements Factory<Arvore> {
    @Override
    public Arvore create(Object... params) {
        int rank = (int) params[0];
        List<String> linguagensDeProgramacao = (List<String>) params[1];
        List<String> competencias = (List<String>) params[2];
        List<String> historico = (List<String>) params[3];
        String status = (String) params[4];
        return new Arvore(rank, linguagensDeProgramacao, competencias, historico, status);
    }
}