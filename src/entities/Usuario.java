package entities;

public class Usuario {
    private final String id;
    private String nombre;

    public Usuario(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.isBlank()) {
            this.nombre = nombre;
        }
    }

    @Override
    public String toString() {
        return "Usuario ID=" + id + ", Nombre='" + nombre + "'";
    }
}
