package com.bbva.ccol.riskadmissionscalculateincomes.facade.v0.dto;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class DTOTest {

    private static final String DTO_PACKAGE = "com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dto";
    private static final String DTO_PACKAGE_PATH = DTO_PACKAGE.replace('.', '/');
    private static final Logger logger = LogManager.getLogger(DTOTest.class);

    @Test
    public void testToStringMethods() throws IOException {
        Path packagePath = Paths.get("src/main/java", DTO_PACKAGE_PATH);

        try (Stream<Path> paths = Files.walk(packagePath)) {
            paths.filter(Files::isRegularFile).forEach(path -> {
                String fileName = path.getFileName().toString();
                if (fileName.endsWith(".java")) {
                    String className = fileName.replace(".java", "");
                    try {
                        Class<?> dtoClass = Class.forName(DTO_PACKAGE + "." + className);
                        Object dtoInstance = dtoClass.getDeclaredConstructor().newInstance();

                        assertNotNull("El método toString debe retornar un valor no nulo",
                                ReflectionTestUtils.invokeMethod(dtoInstance, "toString"));

                        String toStringResult = dtoInstance.toString();
                        logger.info("Resultado toString de " + dtoClass.getSimpleName() + ": " + toStringResult);

                        assertTrue("El resultado de toString debe contener el nombre de la clase",
                                toStringResult.contains(dtoClass.getSimpleName()));
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                             InvocationTargetException | NoSuchMethodException e) {
                        logger.error("Excepción al instanciar o llamar a toString en " + className, e);
                        fail("Excepción al instanciar o llamar a toString en " + className + ": " + e.getMessage());
                    }
                }
            });
        }
    }
}
