package usecases.services;

import entities.Libro;
import usecases.ports.IdGenerator;
import usecases.ports.MaterialRepository;

public class RegistrarLibroUseCase {
    private final MaterialRepository materialRepository;
    private final IdGenerator idGenerator;

    public RegistrarLibroUseCase(MaterialRepository materialRepository, IdGenerator idGenerator) {
        this.materialRepository = materialRepository;
        this.idGenerator = idGenerator;
    }

    public Libro ejecutar(String titulo, String autor, int paginas) {
        Libro libro = new Libro(idGenerator.nextId('L'), titulo, autor, paginas);
        materialRepository.save(libro);
        return libro;
    }
}
