package src;

public class Pagina {
    private int numeroPagina;
    private int numeroQuadro;
    private long ultimoAcesso;
    private boolean referenciado;
    private boolean dirty;

    // Construtor
    public Pagina(int numeroPagina, int numeroQuadro) {
        this.numeroPagina = numeroPagina;
        this.numeroQuadro = numeroQuadro;
        this.ultimoAcesso = System.nanoTime();
        this.dirty = false;
        this.referenciado = true;
    }

    // Métodos get e set


    public int getNumeroPagina() {
        return numeroPagina;
    }

    public void setNumeroPagina(int numeroPagina) {
        this.numeroPagina = numeroPagina;
    }

    public int getNumeroQuadro() {
        return numeroQuadro;
    }

    public void setNumeroQuadro(int numeroQuadro) {
        this.numeroQuadro = numeroQuadro;
    }

    public long getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setUltimoAcesso(long ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }

    public boolean isReferenciado() {
        return referenciado;
    }

    public void setReferenciado(boolean referenciado) {
        this.referenciado = referenciado;
    }

    public boolean isDirty() {
        return dirty;
    }

    public void setDirty(boolean dirty) {
        this.dirty = dirty;
    }
}
