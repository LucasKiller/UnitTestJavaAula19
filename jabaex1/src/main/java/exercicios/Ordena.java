package exercicios;

public class Ordena {
    public int[] ordenaNumerosCrescente(int[] iVet) {
        int iA, iB, iT;

        for (iA = 1; iA < iVet.length; iA++) {
            for (iB = iVet.length - 1; iB >= iA; iB--) {
                if (iVet[iB - 1] > iVet[iB]) {
                    iT = iVet[iB - 1];
                    iVet[iB - 1] = iVet[iB];
                    iVet[iB] = iT;
                }
            }
        }
        return iVet;
    }
}
