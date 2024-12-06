package Factory;

import Interface.Factory;
import Class.Desenvolvedor;

import java.util.ArrayList;
import java.util.List;

public class DesenvolvedorFactory implements Factory<Desenvolvedor> {
    @Override
    public Desenvolvedor create(Object... params) {
        String nome = (String) params[0];
        String email = (String) params[1];
        String senha = (String) params[2];
        String nivelDeExperiencia = (String) params[3];

        return new Desenvolvedor(nome, email, senha, nivelDeExperiencia);
    }
}
