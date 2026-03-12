package usecases.services;

import entities.Revista;
import usecases.ports.IdGenerator;
import usecases.ports.MaterialRepository;

public class RegistrarRevistaUseCase {
    private final MaterialRepository materialRepository;
    private final IdGenerator idGenerator;

    public RegistrarRevistaUseCase(MaterialRepository materialRepository, IdGenerator idGenerator) {
        this.materialRepository = materialRepository;
        this.idGenerator = idGenerator;
    }

    public Revista ejecutar(String titulo, int edicion) {
        Revista revista = new Revista(idGenerator.nextId('R'), titulo, edicion);
        materialRepository.save(revista);
        return revista;
    }
}
