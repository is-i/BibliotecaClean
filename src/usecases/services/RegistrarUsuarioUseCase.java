package usecases.services;

import entities.Usuario;
import usecases.ports.IdGenerator;
import usecases.ports.UsuarioRepository;

public class RegistrarUsuarioUseCase {
    private final UsuarioRepository usuarioRepository;
    private final IdGenerator idGenerator;

    public RegistrarUsuarioUseCase(UsuarioRepository usuarioRepository, IdGenerator idGenerator) {
        this.usuarioRepository = usuarioRepository;
        this.idGenerator = idGenerator;
    }

    public Usuario ejecutar(String nombre) {
        Usuario usuario = new Usuario(idGenerator.nextId('U'), nombre);
        usuarioRepository.save(usuario);
        return usuario;
    }
}
