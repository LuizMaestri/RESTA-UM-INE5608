package br.com.ufsc.aps.restaum.model;

import br.com.ufsc.aps.restaum.exception.PosicaoInvalidaException;

public class Jogo {
    private Tabuleiro[] tabuleiros = new Tabuleiro[2];

    public Jogo() {
        tabuleiros[0] = new Tabuleiro();
        tabuleiros[1] = new Tabuleiro();
    }

    public Tabuleiro getTabuleiro(int i){
        return tabuleiros[i];
    }

    public int jogada(int tab, int inicial, int destino){
        try {
            int comida = tabuleiros[tab].jogada(inicial, destino);
            if (haVencedor()) {
                finalizarJogo();
            }
            return comida;
        }catch (PosicaoInvalidaException e){
            //TODO implementar
            return -1;
        }
    }

    public void iniciarPartida() {
    }
    private void finalizarJogo() {
        //TODO implementar
    }

    private Boolean haVencedor() {
        Jogador jogador1 = tabuleiros[0].getJogador();
        Jogador jogador2 = tabuleiros[1].getJogador();
        if(!tabuleiros[0].isBloqueado() && !tabuleiros[1].isBloqueado()) {
            jogador1.setVencedor(jogador1.getQntPecas() == 1);
            jogador2.setVencedor(jogador2.getQntPecas() == 1);
            return jogador1.getQntPecas() == 1 || jogador2.getQntPecas() == 1;
        }else{
            jogador1.setVencedor(!tabuleiros[0].isBloqueado());
            jogador2.setVencedor(!tabuleiros[1].isBloqueado());

            return true;
        }
    }
}