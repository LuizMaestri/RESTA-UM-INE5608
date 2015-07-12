package br.com.ufsc.aps.restaum.network;

import br.com.ufsc.aps.restaum.model.Jogo;
import br.com.ufsc.aps.restaum.view.TelaJogo;

import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.OuvidorProxy;
import br.ufsc.inf.leobr.cliente.Proxy;
import br.ufsc.inf.leobr.cliente.exception.*;

import javax.swing.*;

public class AtorNetGames implements OuvidorProxy {
    private TelaJogo telajogo;
    private Proxy proxy;
    private Jogo jogo;
    public AtorNetGames(TelaJogo telajogo) {
        super();
        this.telajogo = telajogo;
        proxy=Proxy.getInstance();
        proxy.addOuvinte(this);
    }


    public void conectar(String nome, String servidor)
    {
        try {
            proxy.conectar(servidor,nome);
        } catch (JahConectadoException e) {
            JOptionPane.showMessageDialog(null,"Já está conectado");
        } catch (NaoPossivelConectarException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar");

        } catch (ArquivoMultiplayerException e) {
            JOptionPane.showMessageDialog(null, "Problemas com a configuração de rede");

        }
    }

    public void iniciarPartida(){
        try {
            proxy.iniciarPartida(2);
        } catch (NaoConectadoException e) {
            JOptionPane.showMessageDialog(null,"Não está conectado");
        }
    }

    public void enviarJogada(int pecainicial, int pecadestino, int pecacomida, String vencedor,int pecascomidas){
        JogadaRestaUm jogadaRestaUm = new JogadaRestaUm(pecainicial,pecadestino,pecacomida,vencedor,pecascomidas);
        try {
            proxy.enviaJogada(jogadaRestaUm);
        } catch (NaoJogandoException e) {
            JOptionPane.showMessageDialog(null,"Você não está jogando");
        }
    }

    @Override
    public void iniciarNovaPartida(Integer posicao) {
    jogo.iniciarPartida();
    }

    @Override
    public void finalizarPartidaComErro(String message) {

    }

    @Override
    public void receberMensagem(String msg) {

    }

    @Override
    public void receberJogada(Jogada jogada) {
    JogadaRestaUm jogadaRestaUm1 = (JogadaRestaUm)jogada;
      telajogo.recebeJogadaNet(jogadaRestaUm1);
    }

    @Override
    public void tratarConexaoPerdida() {

    }

    @Override
    public void tratarPartidaNaoIniciada(String message) {

    }

    public void desconectar(){
        try {
            proxy.desconectar();
        } catch (NaoConectadoException e) {
            e.printStackTrace();
        }
    }
}
