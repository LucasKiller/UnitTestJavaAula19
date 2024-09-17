import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import exercicios.Checksum;

public class ChecksumTest {
    Checksum check = new Checksum();

    char[] proposto = {'C', 'a', 's', 'a', '1'};

    @Test
    @DisplayName("Calcular Soma e Complemento de 2 (Checksum)")

    public void deveCalcularChecksum() {
        String esperado = "01010111";

        assertEquals(esperado, check.calcularChecksum(proposto));
    }

    @Test
    @DisplayName("Calcular conversão para hexadecimal")

    public void deveCalcularToHex() {
        String esperado = "4361736131";

        assertEquals(esperado, check.toHex(proposto));
    }

    @Test
    @DisplayName("Calcular Soma e Complemento de 2 em um arquivo de texto")

    public void deveCalcularChecksumArquivoTexto() throws IOException {
        File inputFile = File.createTempFile("checksumTestInput", ".txt");
        try (FileWriter writer = new FileWriter(inputFile)) {
            writer.write("Casa1");
        }

        File outputFile = File.createTempFile("checksumTestOutput", ".txt");

        check.calcularChecksumDoArquivoTexto(inputFile.getAbsolutePath(), outputFile.getAbsolutePath());

        String content = Files.readString(Path.of(outputFile.getAbsolutePath()));

        assertEquals(false, content.contains("Checksum: 01010111"));

        inputFile.delete();
        outputFile.delete();
    }
}
