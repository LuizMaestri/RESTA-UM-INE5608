package br.com.ufsc.aps.restaum.model;

import br.com.ufsc.aps.restaum.exception.PosicaoInvalidaException;

import java.util.Arrays;

public class Tabuleiro {

	private Posicao[] posicoes = new Posicao[33];
	private Estatisticas estatisticas;
	private Jogador jogador;

	public Tabuleiro() {
		Arrays.fill(posicoes, new Posicao());
		this.iniciarTabuleiro();
	}

    public Posicao[] getPosicoes() {
        return posicoes;
    }

    public Estatisticas getEstatisticas() {
        return estatisticas;
    }

    public Jogador getJogador() {
        return jogador;
    }

    private void iniciarTabuleiro() {
		jogador = new Jogador();
        
		for (int i=0; i<33; i++){
            if(i != 0 && i != 3 && i != 6 && i != 13 && i != 20 && i != 27 && i != 30)
                posicoes[i].setPosicaoDireita(posicoes[i+1]);
            if(i != 2 && i != 5 && i != 12 && i != 19 && i != 26 && i != 29 && i != 32)
                posicoes[i].setPosicaoEsquerda(posicoes[i-1]);
            if(i != 20 && i != 21 && i != 25 && i != 26 && i != 30 && i != 31 && i != 32) {
                if (i != 0 && i != 1 && i != 2 && i != 27 && i != 28 && i != 29){
                    if(i != 3 && i != 4 && i != 5 && i != 22 && i != 23 && i != 24)
                        posicoes[i].setPosicaoAbaixo(posicoes[i+7]);
                    else
                        posicoes[i].setPosicaoAbaixo(posicoes[i+5]);
                }else
                    posicoes[i].setPosicaoAbaixo(posicoes[i+3]);
            }
            if(i != 0 && i != 1 && i != 2 && i != 6 && i != 7 && i != 11 && i != 12) {
                if (i != 3 && i != 4 && i != 5 && i != 30 && i != 31 && i != 32){
                    if(i != 8 && i != 9 && i != 10 && i != 27 && i != 28 && i != 29)
                    posicoes[i].setPosicaoAcima(posicoes[i-7]);
                    else
                    posicoes[i].setPosicaoAcima(posicoes[i-5]);
                }else
                    posicoes[i].setPosicaoAcima(posicoes[i-3]);
            }
        }
        posicoes[16].setOcupada(false);

	}

	public void jogada(int inicial, int destino) throws PosicaoInvalidaException {
		if (posicoes[inicial].valida(posicoes[destino])) {
            alterarPosicao(inicial, destino);
            estatisticas.setPecasComidas(estatisticas.getPecasComidas() + 1);
            alteraJogador();
        }else
            throw new PosicaoInvalidaException();
	}

	private void alteraJogador() {
		jogador.setJogando(!jogador.isJogando());
	}

	private void alterarPosicao(int a, int b) {
		posicoes[a].setOcupada(!posicoes[a].isOcupada());
        posicoes[b].setOcupada(!posicoes[b].isOcupada());
    }

    public void bloqueiaPecas(){
        for(Posicao pos : posicoes){
            boolean posicaoAbaixoOcupada = pos.getPosicaoAbaixo() != null && !pos.getPosicaoAbaixo().isOcupada();
            boolean posicaoAcimaOcupada = pos.getPosicaoAcima() != null && !pos.getPosicaoAcima().isOcupada();
            boolean posicaoEsquerdaOcupada = pos.getPosicaoEsquerda() != null && !pos.getPosicaoEsquerda().isOcupada();
            boolean posicaoDireitaOcupada = pos.getPosicaoDireita() != null && !pos.getPosicaoDireita().isOcupada();
           
            if(!posicaoAbaixoOcupada && !posicaoAcimaOcupada && !posicaoDireitaOcupada && !posicaoEsquerdaOcupada){
                pos.setBloqueada(true);
            }
        }
    }
    
    public boolean bloqueado(){
        for(Posicao pos : posicoes){
            if(!pos.isBloqueada()){
                return false;
            }
        }
        return true;
    }

}
