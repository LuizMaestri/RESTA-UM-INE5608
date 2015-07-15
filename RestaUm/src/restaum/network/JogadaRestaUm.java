package restaum.network;

public class JogadaRestaUm implements br.ufsc.inf.leobr.cliente.Jogada {

    private int pecaInicial;
    private int pecaDestino;

    public JogadaRestaUm(int pecaInicial, int pecaDestino) {
        super();
        this.pecaInicial = pecaInicial;
        this.pecaDestino = pecaDestino;
    }

    public int getPecainicial() {
        return pecaInicial;
    }

    public int getPecadestino() {
        return pecaDestino;
    }

}
