package src;

import java.util.Queue;

public class SubstituicaoPagina {
    // Tamanho da memória em frames
    private int tamanhoMemoria;

    // Tamanho de cada página em bytes
    private final int TAMANHO_PAGINA = 4096;

    // Estrutura para armazenar as páginas presentes na memória
    private Queue<Pagina> memoria;
}
