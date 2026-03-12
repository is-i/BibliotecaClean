package entities;

public class Libro extends Material {
    private final String autor;
    private final int paginas;
    private static final int COSTO_DIA_LIBRO = 1000;

    public Libro(String id, String titulo, String autor, int paginas) {
        super(id, titulo);
        this.autor = autor;
        this.paginas = paginas;
    }

    @Override
    public String getTipo() { return "Libro"; }

    @Override
    public int calcularCostoBase() { return COSTO_DIA_LIBRO; }

    @Override
    public String toString() {
        return super.toString() + " (Autor=" + autor + ", Páginas=" + paginas + ")";
    }
}
