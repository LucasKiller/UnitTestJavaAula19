import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import exercicios.Ordena;

public class OrdenaTest {
    Ordena ord = new Ordena();

    @Test
    @DisplayName("Ordenar os números em ordem crescente")

    public void deveOrdenarNumerosCrescente() {
        int proposto [] = new int[] {10, 9};
        int esperado [] = new int[] {9, 10};
        
        assertArrayEquals(esperado, ord.ordenaNumerosCrescente(proposto));
    }
}
