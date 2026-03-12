package usecases.services;

import java.util.List;
import entities.Material;
import entities.Usuario;
import entities.Prestamo;
import usecases.dto.OperationResult;
import usecases.ports.IdGenerator;
import usecases.ports.MaterialRepository;
import usecases.ports.PrestamoRepository;
import usecases.ports.UsuarioRepository;

public class BibliotecaApp {
    private final String nombre;
    private final MaterialRepository materialRepository;
    private final UsuarioRepository usuarioRepository;
    private final PrestamoRepository prestamoRepository;

    private final RegistrarUsuarioUseCase registrarUsuarioUseCase;
    private final RegistrarLibroUseCase registrarLibroUseCase;
    private final RegistrarRevistaUseCase registrarRevistaUseCase;
    private final PrestarMaterialUseCase prestarMaterialUseCase;
    private final DevolverPrestamoUseCase devolverPrestamoUseCase;

    public BibliotecaApp(String nombre,
                         MaterialRepository materialRepository,
                         UsuarioRepository usuarioRepository,
                         PrestamoRepository prestamoRepository,
                         IdGenerator idGenerator) {
        this.nombre = nombre;
        this.materialRepository = materialRepository;
        this.usuarioRepository = usuarioRepository;
        this.prestamoRepository = prestamoRepository;
        CalculadoraCosto calculadoraCosto = new CalculadoraCosto();
        this.registrarUsuarioUseCase = new RegistrarUsuarioUseCase(usuarioRepository, idGenerator);
        this.registrarLibroUseCase = new RegistrarLibroUseCase(materialRepository, idGenerator);
        this.registrarRevistaUseCase = new RegistrarRevistaUseCase(materialRepository, idGenerator);
        this.prestarMaterialUseCase = new PrestarMaterialUseCase(usuarioRepository, materialRepository, prestamoRepository, idGenerator, calculadoraCosto);
        this.devolverPrestamoUseCase = new DevolverPrestamoUseCase(prestamoRepository);
    }

    public String getNombre() { return nombre; }

    public void registrarUsuario(String nombre) { registrarUsuarioUseCase.ejecutar(nombre); }
    public void registrarLibro(String titulo, String autor, int paginas) { registrarLibroUseCase.ejecutar(titulo, autor, paginas); }
    public void registrarRevista(String titulo, int edicion) { registrarRevistaUseCase.ejecutar(titulo, edicion); }

    public List<Usuario> listarUsuarios() { return usuarioRepository.findAll(); }
    public List<Material> listarMateriales() { return materialRepository.findAll(); }
    public List<Prestamo> listarPrestamos() { return prestamoRepository.findAll(); }

    public OperationResult prestar(String idUsuario, String idMaterial, int dias) {
        return prestarMaterialUseCase.ejecutar(idUsuario, idMaterial, dias);
    }

    public OperationResult devolver(String idPrestamo) {
        return devolverPrestamoUseCase.ejecutar(idPrestamo);
    }
}
