package restaum.model;

import restaum.exception.PosicaoInvalidaException;


public class Tabuleiro {

	private Posicao[] posicoes = new Posicao[33];
	private Estatisticas estatisticas = new Estatisticas();
	private Jogador jogador;


	public Tabuleiro(String nomeJogador) {
		for (int i = 0; i < posicoes.length; i++) posicoes[i] = new Posicao(i);
		this.iniciarTabuleiro();
		estatisticas=new Estatisticas();
		jogador = new Jogador(nomeJogador);
	}

    private void iniciarTabuleiro() {

        for (int i=0; i<posicoes.length; i++){
            if(i != 0 && i != 3 && i != 6 && i != 13 && i != 20 && i != 27 && i != 30)
                posicoes[i].setPosicaoEsquerda(posicoes[i - 1]);
            if(i != 2 && i != 5 && i != 12 && i != 19 && i != 26 && i != 29 && i != 32)
                posicoes[i].setPosicaoDireita(posicoes[i+1]);
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
            if(i == 4 || i == 14 || i == 18 || i == 28)
                posicoes[i].setBloqueada(false);
        }
        posicoes[16].setOcupada(false);

    }

    public Estatisticas getEstatisticas() {
        return estatisticas;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public boolean isBloqueado(){
        for(Posicao pos : posicoes){
            if(!pos.isBloqueada()){
                return false;
            }
        }
        return true;
    }

	public int jogada(int inicial, int destino) throws PosicaoInvalidaException {
		int comida = posicoes[inicial].valida(posicoes[destino]);
        if (comida != -1) {
            alterarPosicao(inicial, destino, comida);
            bloqueiaPecas();
            estatisticas.setPecasComidas(estatisticas.getPecasComidas() + 1);
            alteraJogador();
            return comida;
        }else
            throw new PosicaoInvalidaException();
	}

	private void alteraJogador() {
		jogador.setJogando(!jogador.isJogando());
	}

	private void alterarPosicao(int inicial, int destino, int comida) {
		posicoes[inicial].setOcupada(false);
        posicoes[destino].setOcupada(true);
        posicoes[comida].setOcupada(false);
    }

    public void bloqueiaPecas(){
        for(Posicao pos : posicoes){
            boolean jogadaAbaixoValida = (pos.getPosicaoAbaixo() != null && pos.getPosicaoAbaixo().getPosicaoAbaixo() != null) && pos.valida(pos.getPosicaoAbaixo().getPosicaoAbaixo()) != -1;
            boolean jogadaAcimaValida = (pos.getPosicaoAcima() != null && pos.getPosicaoAcima().getPosicaoAcima() != null) && pos.valida(pos.getPosicaoAcima().getPosicaoAcima()) != -1;
            boolean jogadaEsquerdaValida = (pos.getPosicaoDireita() != null && pos.getPosicaoDireita().getPosicaoDireita() != null) && pos.valida(pos.getPosicaoDireita().getPosicaoDireita()) != -1;
            boolean jogadaDireitaValida = (pos.getPosicaoEsquerda() != null && pos.getPosicaoEsquerda().getPosicaoEsquerda() != null) && pos.valida(pos.getPosicaoEsquerda().getPosicaoEsquerda()) != -1;
            pos.setBloqueada((!jogadaAbaixoValida && !jogadaAcimaValida && !jogadaDireitaValida && !jogadaEsquerdaValida)|| !pos.isOcupada());
        }
    }

}
