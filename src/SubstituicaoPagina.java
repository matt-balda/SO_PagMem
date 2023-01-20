package src;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SubstituicaoPagina {
    // Tamanho da memória em frames
    private int tamanhoMemoria;

    // Tamanho de cada página em bytes
    private final int TAMANHO_PAGINA = 4096;

    // Estrutura para armazenar as páginas presentes na memória
    private Queue<Pagina> memoria;

    // Construtor
    public SubstituicaoPagina(int tamanhoMemoria) {
        this.tamanhoMemoria = tamanhoMemoria;
        memoria = new LinkedList<Pagina>();
    }

    // Método para ler o arquivo de trace e simular a alocação de memória
    public void simular(String nomeArquivo, String algoritmo) {
        int paginaFalhas = 0;
        try {
            Scanner entrada = new Scanner(new File(nomeArquivo));
            while (entrada.hasNextLine()) {
                String[] linha = entrada.nextLine().split(" ");
                long endereco = Long.parseLong(linha[2], 16);
                int numeroPagina = (int) (endereco / TAMANHO_PAGINA);
                boolean encontrado = false;
                // Verificar se a página já está na memória
                for (Pagina p : memoria) {
                    if (p.getNumeroPagina() == numeroPagina) {
                        encontrado = true;
                        if (algoritmo.equals("LRU")) {
                            p.setUltimoAcesso(System.nanoTime());
                        }
                        break;
                    }
                }
                
            }
        }
    }
}
