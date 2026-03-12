# BibliotecaClean

Refactorización del proyecto Biblioteca siguiendo lineamientos de Clean Architecture.

## Estructura

- `entities`: entidades del dominio (`Material`, `Libro`, `Revista`, `Usuario`, `Prestamo`).
- `usecases`: casos de uso y puertos (`PrestarMaterialUseCase`, `DevolverPrestamoUseCase`, repositorios, generador de IDs).
- `infrastructure`: implementaciones concretas en memoria y generador de IDs.
- `adapters.console`: interfaz de usuario por consola.

## Principales cambios

1. Las entidades ya no dependen de clases de servicio ni de infraestructura.
2. La lógica del préstamo se movió a `PrestarMaterialUseCase`.
3. La devolución se movió a `DevolverPrestamoUseCase`.
4. Se introdujeron puertos (`Repository`, `IdGenerator`) para desacoplar reglas de negocio de detalles concretos.
5. `BibliotecaApp` actúa como fachada de aplicación para la UI.

## Compilación

Desde la carpeta `BibliotecaClean`:

```bash
javac -d out $(find src -name "*.java")
```

## Ejecución

```bash
java -cp out adapters.console.Main
```
