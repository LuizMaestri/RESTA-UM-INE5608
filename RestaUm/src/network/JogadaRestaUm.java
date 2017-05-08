package network;

public class JogadaRestaUm implements br.ufsc.inf.leobr.cliente.Jogada {

    private static final long serialVersionUID = 1268772608889006858L;

    private int pecaInicial;
    private int pecaDestino;
    private int pecaBloqueada;

    public JogadaRestaUm(int pecaInicial, int pecaDestino, int pecaBloqueada) {
        super();
        this.pecaInicial = pecaInicial;
        this.pecaDestino = pecaDestino;
        this.pecaBloqueada = pecaBloqueada;
    }

    public int getPecaInicial() {
        return pecaInicial;
    }

    public int getPecaDestino() {
        return pecaDestino;
    }

    public int getPecaBloqueada() {
        return pecaBloqueada;
    }

    public void setPecaBloqueada(int pecaBloqueada) {
        this.pecaBloqueada = pecaBloqueada;
    }
}
