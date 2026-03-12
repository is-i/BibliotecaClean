package entities;

public abstract class Material implements Prestable {
    private final String id;
    private String titulo;
    private boolean disponible = true;

    protected Material(String id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public String getId() { return id; }
    public String getTitulo() { return titulo; }

    public void setTitulo(String titulo) {
        if (titulo != null && !titulo.isBlank()) {
            this.titulo = titulo;
        }
    }

    public abstract String getTipo();
    public abstract int calcularCostoBase();

    @Override
    public void prestar() { disponible = false; }

    @Override
    public void devolver() { disponible = true; }

    @Override
    public boolean estaDisponible() { return disponible; }

    @Override
    public String toString() {
        return "[" + getTipo() + "] id=" + id + ", Título='" + titulo + "', Disponible=" + disponible;
    }
}
