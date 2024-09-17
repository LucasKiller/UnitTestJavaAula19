import static org.junit.jupiter.api.Assertions.assertEquals;
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
}
