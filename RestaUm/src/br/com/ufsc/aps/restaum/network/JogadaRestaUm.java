package br.com.ufsc.aps.restaum.network;

/**
 * Created by Luiz Maestri on 12/07/2015.
 */
public class JogadaRestaUm implements br.ufsc.inf.leobr.cliente.Jogada {

    private int pecainicial;
    private int pecadestino;

    public JogadaRestaUm(int pecainicial, int pecadestino) {
        super();

        this.pecainicial = pecainicial;
        this.pecadestino = pecadestino;
    }

    public int getPecainicial() {
        return pecainicial;
    }

    public int getPecadestino() {
        return pecadestino;
    }

}
