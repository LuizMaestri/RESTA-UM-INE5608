package br.com.ufsc.aps.restaum.model;

import br.com.ufsc.aps.restaum.exception.PosicaoInvalidaException;

public class Jogo {
    private Tabuleiro tab1;
    private Tabuleiro tab2;
    private double tempoDeJogo;

    public void jogada(Tabuleiro tab, int inicial, int destino){
        try {
            tab.jogada(inicial, destino);
            if (haVencedor()) {
                finalizarJogo();
            }
        }catch (PosicaoInvalidaException e){
            //TODO implementar
        }
    }

    private void finalizarJogo() {
        //TODO implementar
    }

    private Boolean haVencedor() {
        Jogador jogador1 = tab1.getJogador();
        Jogador jogador2 = tab2.getJogador();
        if(!tab1.bloqueado() && !tab2.bloqueado()) {
            if (tempoDeJogo == 15.0) {
                jogador1.setVencedor(jogador1.getQntPecas() < jogador2.getQntPecas());
                jogador2.setVencedor(jogador2.getQntPecas() < jogador1.getQntPecas());
                return !jogador1.isVencedor() && !jogador2.isVencedor() ? null : true;
            } else {
                jogador1.setVencedor(jogador1.getQntPecas() == 1);
                jogador2.setVencedor(jogador2.getQntPecas() == 1);
                return jogador1.getQntPecas() == 1 || jogador2.getQntPecas() == 1;
            }
        }else{
            jogador1.setVencedor(!tab1.bloqueado());
            jogador2.setVencedor(!tab2.bloqueado());

            return true;
        }
    }
}