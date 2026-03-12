package infrastructure.services;

import usecases.ports.IdGenerator;

public class SimpleIdGenerator implements IdGenerator {
    private int currentLibro = 100;
    private int currentRevista = 100;
    private int currentUsuario = 100;
    private int currentPrestamo = 100;

    @Override
    public String nextId(char typeId) {
        return switch (typeId) {
            case 'L' -> "L" + currentLibro++;
            case 'R' -> "R" + currentRevista++;
            case 'U' -> "U" + currentUsuario++;
            case 'P' -> "P" + currentPrestamo++;
            default -> throw new IllegalArgumentException("Tipo de ID no soportado: " + typeId);
        };
    }
}
