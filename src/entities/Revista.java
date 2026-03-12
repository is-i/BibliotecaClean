package entities;

public class Revista extends Material {
    private final int edicion;
    private static final int COSTO_DIA_REVISTA = 700;

    public Revista(String id, String titulo, int edicion) {
        super(id, titulo);
        this.edicion = edicion;
    }

    @Override
    public String getTipo() { return "Revista"; }

    @Override
    public int calcularCostoBase() { return COSTO_DIA_REVISTA; }

    @Override
    public String toString() {
        return super.toString() + " (Edición=" + edicion + ")";
    }
}
