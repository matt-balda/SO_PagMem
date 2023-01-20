package src;

public class Main {
    public static void main(String[] args) {
        String[] traces = { "bzip.trace", "gcc.trace", "sixpack.trace", "swim.trace", "bigone.trace" };

        for (String trace : traces) {
            SubstituicaoPagina pr = new SubstituicaoPagina(100);
            pr.simular(trace, "LRU");
            System.out.println("Número de falhas de página com LRU no trace " + trace + ": " + pr.getPaginaFalhas());

            pr = new SubstituicaoPagina(100);
            pr.simular(trace, "FIFO");
            System.out.println("Número de falhas de página com FIFO no trace " + trace + ": " + pr.getPaginaFalhas());

            pr = new SubstituicaoPagina(100);
            pr.simular(trace, "VMS");
            System.out.println("Número de falhas de página com VMS no trace " + trace + ": " + pr.getPaginaFalhas());
        }
    }
}