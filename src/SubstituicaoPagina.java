package src;

import java.io.File;
import java.io.FileNotFoundException;
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
    private int paginaFalhas = 0;

    // Construtor
    public SubstituicaoPagina(int tamanhoMemoria) {
        this.tamanhoMemoria = tamanhoMemoria;
        memoria = new LinkedList<Pagina>();
    }

    // Método para ler o arquivo de trace e simular a alocação de memória
    public void simular(String nomeArquivo, String algoritmo) {
        try {
            Scanner entrada = new Scanner(new File(nomeArquivo));
            while (entrada.hasNextLine()) {
                String[] linha = entrada.nextLine().split(" ");
                long endereco = Long.parseLong(linha[0], 16);
                int numeroPagina = (int) (endereco / TAMANHO_PAGINA);
                boolean encontrado = false;
                // Verificar se a página já está na memória
                for (Pagina p : memoria) {
                    if (p.getNumeroPagina() == numeroPagina) {
                        encontrado = true;
                        if (algoritmo.equals("LRU")) {
                            p.setUltimoAcesso(System.nanoTime());
                        }
                        if (linha[1].equals("W")) {
                            p.setDirty(true);
                        }
                        break;
                    }
                }
                if (!encontrado) {
                    // Aplicar a política de substituição escolhida
                    if (memoria.size() == tamanhoMemoria) {
                        if (algoritmo.equals("LRU")) {
                            long acessoMaisAntigo = Long.MAX_VALUE;
                            Pagina paginaMaisAntiga = null;
                            for (Pagina p : memoria) {
                                if (p.getUltimoAcesso() < acessoMaisAntigo) {
                                    acessoMaisAntigo = p.getUltimoAcesso();
                                    paginaMaisAntiga = p;
                                }
                            }
                            memoria.remove(paginaMaisAntiga);
                        } else if (algoritmo.equals("FIFO")) {
                            memoria.remove();
                        } else if (algoritmo.equals("VMS")) { // por página mais antiga, não referenciada
                            long acessoMaisAntigo = Long.MAX_VALUE;
                            Pagina paginaMaisAntiga = null;
                            for (Pagina p : memoria) {
                                if (p.getUltimoAcesso() < acessoMaisAntigo) {
                                    acessoMaisAntigo = p.getUltimoAcesso();
                                    paginaMaisAntiga = p;
                                }
                            }
                            memoria.remove(paginaMaisAntiga);
                            for (Pagina p : memoria) {
                                if (p.isReferenciado()) {
                                    p.setReferenciado(false);
                                }
                            }
                        }
                        paginaFalhas++;
                    }
                    // Adicionar a página à memória
                    memoria.add(new Pagina(numeroPagina));
                    if (linha[1].equals("W")) {
                        Pagina last = ((LinkedList<Pagina>)memoria).getLast();
                        last.setDirty(true);
                    }
                }
            }
            entrada.close();
        } catch (FileNotFoundException e) {
            throw new ExceptionMessage("Arquivo de trace não encontrado.");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ExceptionMessage("Erro: formato de linha inválido no arquivo de trace.");
        } catch (NumberFormatException e) {
            throw new ExceptionMessage("Erro: endereço inválido no arquivo de trace.");
        }

    }

    // Método para retornar o número de falhas de página
    public int getPaginaFalhas() {
        return paginaFalhas;
    }
}
