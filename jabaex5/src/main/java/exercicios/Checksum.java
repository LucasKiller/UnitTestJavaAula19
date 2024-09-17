package exercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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

    public void calcularChecksumDoArquivoTexto(String inputFilePath, String outputFilePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        }

        char[] dados = content.toString().toCharArray();

        String checksum = calcularChecksum(dados);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            writer.write(content.toString());
            writer.newLine();
            writer.write("Checksum: " + checksum);
        }
    }

    public String calcularCRC(char[] dados) {
        int crc = 0xFFFF;

        int polynomial = 0x1021;

        for (char c : dados) {
            crc ^= (c << 8);

            for (int bit = 0; bit < 8; bit++) {
                if ((crc & 0x8000) != 0) {
                    crc = (crc << 1) ^ polynomial;
                } else {
                    crc <<= 1;
                }
                crc &= 0xFFFF;
            }
        }

        return String.format("%04X", crc);
    }
}

