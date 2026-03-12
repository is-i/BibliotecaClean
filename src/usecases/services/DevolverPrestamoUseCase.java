package usecases.services;

import entities.Material;
import entities.Prestamo;
import usecases.dto.OperationResult;
import usecases.ports.PrestamoRepository;

public class DevolverPrestamoUseCase {
    private final PrestamoRepository prestamoRepository;

    public DevolverPrestamoUseCase(PrestamoRepository prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }

    public OperationResult ejecutar(String idPrestamo) {
        Prestamo prestamo = prestamoRepository.findById(idPrestamo);
        if (prestamo == null) {
            return OperationResult.fail("Préstamo no encontrado.");
        }
        if (!prestamo.isActivo()) {
            return OperationResult.fail("Ese préstamo ya fue cerrado.");
        }

        Material material = prestamo.getMaterial();
        material.devolver();
        prestamo.cerrar();
        return OperationResult.ok("Préstamo " + idPrestamo + " devuelto y cerrado.");
    }
}
