package Class.Factory;


public class UsuarioFactory implements Factory<Usuario> {
    @Override
    public Usuario create(Object... params) {
        String nome = (String) params[0];
        String email = (String) params[1];
        String senha = (String) params[2];
        return new Usuario(nome, email, senha);
    }
}