package infrastructure.repositories;

import java.util.ArrayList;
import java.util.List;
import entities.Usuario;
import usecases.ports.UsuarioRepository;

public class InMemoryUsuarioRepository implements UsuarioRepository {
    private final List<Usuario> usuarios = new ArrayList<>();

    @Override
    public void save(Usuario usuario) {
        usuarios.add(usuario);
    }

    @Override
    public Usuario findById(String id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                return usuario;
            }
        }
        return null;
    }

    @Override
    public List<Usuario> findAll() {
        return new ArrayList<>(usuarios);
    }
}
