package exercicios;

public class Checksum {

    public String calcularChecksum(char[] dados) {
        int soma = 0;
        for (char c : dados) {
            soma += (int) c;
        }

        soma = soma & 0xFF;

        int complemento2 = (~soma + 1) & 0xFF;

        return String.format("%8s", Integer.toBinaryString(complemento2)).replace(' ', '0');
    }

    public String toHex(char[] dados) {
        StringBuilder hexString = new StringBuilder();
        for (char c : dados) {
            hexString.append(String.format("%02X", (int) c));
        }
        return hexString.toString();
    }
}
