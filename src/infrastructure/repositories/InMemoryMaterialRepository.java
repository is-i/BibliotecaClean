package infrastructure.repositories;

import java.util.ArrayList;
import java.util.List;
import entities.Material;
import usecases.ports.MaterialRepository;

public class InMemoryMaterialRepository implements MaterialRepository {
    private final List<Material> materiales = new ArrayList<>();

    @Override
    public void save(Material material) {
        materiales.add(material);
    }

    @Override
    public Material findById(String id) {
        for (Material material : materiales) {
            if (material.getId().equals(id)) {
                return material;
            }
        }
        return null;
    }

    @Override
    public List<Material> findAll() {
        return new ArrayList<>(materiales);
    }
}
