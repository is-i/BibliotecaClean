package usecases.ports;

import java.util.List;
import entities.Material;

public interface MaterialRepository {
    void save(Material material);
    Material findById(String id);
    List<Material> findAll();
}
