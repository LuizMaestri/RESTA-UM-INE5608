package br.com.ufsc.aps.restaum.network;

/**
 * Created by Luiz Maestri on 12/07/2015.
 */
public class JogadaRestaUm implements br.ufsc.inf.leobr.cliente.Jogada {

    private int pecainicial;
    private int pecadestino;
    private int pecacomida;
    private int pecascomidas;
    private String vencedor;

    public int getPecascomidas() {
        return pecascomidas;
    }

    public JogadaRestaUm(int pecainicial, int pecadestino, int pecacomida, String vencedor, int pecascomidas) {
        super();

        this.pecainicial = pecainicial;
        this.pecadestino = pecadestino;
        this.pecacomida = pecacomida;
        this.vencedor = vencedor;
        this.pecascomidas =pecascomidas;
    }

    public int getPecainicial() {
        return pecainicial;
    }

    public int getPecadestino() {
        return pecadestino;
    }

    public int getPecacomida() {
        return pecacomida;
    }

    public String getVencedor() {
        return vencedor;
    }
}
