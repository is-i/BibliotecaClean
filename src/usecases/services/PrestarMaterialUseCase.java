package usecases.services;

import entities.Material;
import entities.Prestamo;
import entities.Usuario;
import usecases.dto.OperationResult;
import usecases.ports.IdGenerator;
import usecases.ports.MaterialRepository;
import usecases.ports.PrestamoRepository;
import usecases.ports.UsuarioRepository;

public class PrestarMaterialUseCase {
    private final UsuarioRepository usuarioRepository;
    private final MaterialRepository materialRepository;
    private final PrestamoRepository prestamoRepository;
    private final IdGenerator idGenerator;
    private final CalculadoraCosto calculadoraCosto;

    public PrestarMaterialUseCase(
            UsuarioRepository usuarioRepository,
            MaterialRepository materialRepository,
            PrestamoRepository prestamoRepository,
            IdGenerator idGenerator,
            CalculadoraCosto calculadoraCosto) {
        this.usuarioRepository = usuarioRepository;
        this.materialRepository = materialRepository;
        this.prestamoRepository = prestamoRepository;
        this.idGenerator = idGenerator;
        this.calculadoraCosto = calculadoraCosto;
    }

    public OperationResult ejecutar(String idUsuario, String idMaterial, int dias) {
        Usuario usuario = usuarioRepository.findById(idUsuario);
        if (usuario == null) {
            return OperationResult.fail("Usuario no encontrado.");
        }

        Material material = materialRepository.findById(idMaterial);
        if (material == null) {
            return OperationResult.fail("Material no encontrado.");
        }

        if (!material.estaDisponible()) {
            return OperationResult.fail("El material NO está disponible (ya está prestado).");
        }

        if (dias > ReglasPrestamo.DIAS_MAX_PRESTAMO) {
            return OperationResult.fail("Días exceden el máximo permitido (" + ReglasPrestamo.DIAS_MAX_PRESTAMO + ").");
        }

        Prestamo prestamo = new Prestamo(idGenerator.nextId('P'), usuario, material, dias);
        prestamoRepository.save(prestamo);
        material.prestar();

        int costoBase = material.calcularCostoBase();
        int total = calculadoraCosto.calcularTotal(costoBase, dias);

        return OperationResult.ok(
                "Préstamo creado: ID=" + prestamo.getId() + "\n" +
                "Costo base = " + costoBase + " | Total = " + total);
    }
}
