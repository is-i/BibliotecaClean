package usecases.ports;

import java.util.List;
import entities.Prestamo;

public interface PrestamoRepository {
    void save(Prestamo prestamo);
    Prestamo findById(String id);
    List<Prestamo> findAll();
}
