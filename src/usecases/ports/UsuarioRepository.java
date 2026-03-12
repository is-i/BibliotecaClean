package usecases.ports;

import java.util.List;
import entities.Usuario;

public interface UsuarioRepository {
    void save(Usuario usuario);
    Usuario findById(String id);
    List<Usuario> findAll();
}
