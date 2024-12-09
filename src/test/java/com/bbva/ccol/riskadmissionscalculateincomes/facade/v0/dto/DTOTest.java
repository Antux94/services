package com.bbva.ccol.riskadmissionscalculateincomes.facade.v0.dto;

import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class DTOTest {

    private static final String DTO_PACKAGE = "com.bbva.ccol.riskadmissionscalculateincomes.facade.v0.dto";  // Cambia esto por el nombre de tu paquete DTO
    private static final String DTO_PACKAGE_PATH = DTO_PACKAGE.replace('.', '/');  // Convertir el nombre del paquete en una ruta

    @Test
    public void testToStringMethods() throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // Obtener la ruta del paquete DTO
        Path packagePath = Paths.get("src/main/java", DTO_PACKAGE_PATH);

        try (Stream<Path> paths = Files.walk(packagePath)) {
            paths
                .filter(Files::isRegularFile)
                .forEach(path -> {
                    String fileName = path.getFileName().toString();
                    if (fileName.endsWith(".java")) {
                        String className = fileName.replace(".java", "");
                        try {
                            // Cargar la clase DTO usando reflection
                            Class<?> dtoClass = Class.forName(DTO_PACKAGE + "." + className);

                            // Crear una instancia del DTO
                            Object dtoInstance = dtoClass.getDeclaredConstructor().newInstance();

                            // Verificar que el método toString no sea nulo
                            assertNotNull("El método toString debe retornar un valor no nulo",
                                    ReflectionTestUtils.invokeMethod(dtoInstance, "toString"));

                            // Si es necesario, verifica el formato del método toString
                            String toStringResult = dtoInstance.toString();
                            System.out.println("Resultado toString de " + dtoClass.getSimpleName() + ": " + toStringResult);

                            // Asegúrate de que toString contiene información relevante
                            assertTrue("El resultado de toString debe contener el nombre de la clase",
                                    toStringResult.contains(dtoClass.getSimpleName()));
                        } catch (Exception e) {
                            fail("Excepción al instanciar o llamar a toString en " + className + ": " + e.getMessage());
                        }
                    }
                });
        }
    }
}

