package src;

public class Main {
    public static void main(String[] args) {
        String[] traces = { "bzip.trace", "gcc.trace", "sixpack.trace", "swim.trace", "bigone.trace" };
        int[] tamanhosQuadro = {4096, 8192, 16384, 32768};

        for (String trace : traces) {
            for (int tamanhoQuadro : tamanhosQuadro) {
                SubstituicaoPagina pr = new SubstituicaoPagina(100, tamanhoQuadro);
                pr.simular(trace, "LRU");
                System.out.println("Número de falhas de página com LRU e tamanho de quadro " + tamanhoQuadro + " no trace " + trace + ": " + pr.getPaginaFalhas());

                pr = new SubstituicaoPagina(100, tamanhoQuadro);
                pr.simular(trace, "FIFO");
                System.out.println("Número de falhas de página com FIFO e tamanho de quadro " + tamanhoQuadro + " no trace " + trace + ": " + pr.getPaginaFalhas());

                pr = new SubstituicaoPagina(100, tamanhoQuadro);
                pr.simular(trace, "VMS");
                System.out.println("Número de falhas de página com VMS e tamanho de quadro " + tamanhoQuadro + " no trace " + trace + ": " + pr.getPaginaFalhas());
            }
        }
}