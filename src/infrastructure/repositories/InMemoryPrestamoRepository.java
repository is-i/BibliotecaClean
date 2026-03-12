package infrastructure.repositories;

import java.util.ArrayList;
import java.util.List;
import entities.Prestamo;
import usecases.ports.PrestamoRepository;

public class InMemoryPrestamoRepository implements PrestamoRepository {
    private final List<Prestamo> prestamos = new ArrayList<>();

    @Override
    public void save(Prestamo prestamo) {
        prestamos.add(prestamo);
    }

    @Override
    public Prestamo findById(String id) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getId().equals(id)) {
                return prestamo;
            }
        }
        return null;
    }

    @Override
    public List<Prestamo> findAll() {
        return new ArrayList<>(prestamos);
    }
}
