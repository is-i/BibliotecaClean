package usecases.services;

public class CalculadoraCosto {
    public int calcularTotal(int costoBase, int dias) {
        if (dias <= ReglasPrestamo.DIAS_GRATIS) {
            return 0;
        }
        return (dias - ReglasPrestamo.DIAS_GRATIS) * costoBase;
    }
}
