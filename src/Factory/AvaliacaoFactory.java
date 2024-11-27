package Factory;

import Interface.Factory;
import Class.Avaliacao;

import java.util.List;

public class AvaliacaoFactory implements Factory<Avaliacao> {
    @Override
    public Avaliacao create(Object... params) {
        int idDesenvolvedor = (int) params[0];
        List<String> questoes = (List<String>) params[1];
        String conteudo = (String) params[2];
        return new Avaliacao(idDesenvolvedor, questoes, conteudo);
    }
}