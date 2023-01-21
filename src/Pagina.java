package src;

public class Pagina {
    private int numeroPagina;
    private long ultimoAcesso;
    private boolean referenciado;
    private boolean dirty;

    // Construtor
    public Pagina(int numeroPagina) {
        this.numeroPagina = numeroPagina;
        this.ultimoAcesso = System.nanoTime();
        this.referenciado = true;
        this.dirty = false;
    }

    // Métodos get e set

    public int getNumeroPagina() {
        return numeroPagina;
    }

    public void setNumeroPagina(int numeroPagina) {
        this.numeroPagina = numeroPagina;
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
