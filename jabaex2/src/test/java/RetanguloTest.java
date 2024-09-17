import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import exercicios.Retangulo;

public class RetanguloTest {
    Retangulo ret = new Retangulo(10, 2);

    @Test
    @DisplayName("Calcular a área do retângulo")

    public void deveCalcularArea() {
        int resultadoEsperado = 20;

        assertEquals(resultadoEsperado, ret.calcularArea());
    }

    @Test
    @DisplayName("Calcular o perímetro do retângulo")

    public void deveCalcularPerimetro() {
        int resultadoEsperado = 24;

        assertEquals(resultadoEsperado, ret.calcularPerimetro());
    }
}
