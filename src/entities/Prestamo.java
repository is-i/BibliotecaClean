package entities;

public class Prestamo {
    private final String id;
    private final Usuario usuario;
    private final Material material;
    private final int dias;
    private boolean activo;

    public Prestamo(String id, Usuario usuario, Material material, int dias) {
        this.id = id;
        this.usuario = usuario;
        this.material = material;
        this.dias = dias <= 0 ? 1 : dias;
        this.activo = true;
    }

    public String getId() { return id; }
    public Usuario getUsuario() { return usuario; }
    public Material getMaterial() { return material; }
    public int getDias() { return dias; }
    public boolean isActivo() { return activo; }

    public void cerrar() { this.activo = false; }

    @Override
    public String toString() {
        return "Préstamo ID=" + id +
               " | Usuario=" + usuario.getNombre() +
               " | Material=" + material.getTitulo() +
               " | Días=" + dias +
               " | Activo=" + activo;
    }
}
