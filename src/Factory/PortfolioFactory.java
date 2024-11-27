package Factory;

import Interface.Factory;
import Class.Portfolio;

import java.util.List;

public class PortfolioFactory implements Factory<Portfolio> {
    @Override
    public Portfolio create(Object... params) {
        String projeto = (String) params[0];
        String perfil = (String) params[1];
        String ideia = (String) params[2];
        String descricao = (String) params[3];
        List<String> tecnologiaUsada = (List<String>) params[4];
        String linkRepositorio = (String) params[5];
        return new Portfolio(projeto, perfil, ideia, descricao, tecnologiaUsada, linkRepositorio);
    }
}