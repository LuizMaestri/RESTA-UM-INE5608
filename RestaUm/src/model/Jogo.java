package model;

import exception.PosicaoInvalidaException;
import view.TelaJogo;

public class Jogo {
	private Tabuleiro[] tabuleiros = new Tabuleiro[2];
	private int rodada;
	private TelaJogo tela;

	public Jogo(String[] nomes,TelaJogo tela) {

		tabuleiros[0] = new Tabuleiro(nomes[0]);
		tabuleiros[1] = new Tabuleiro(nomes[1]);
		rodada = 0;
		tela=tela;
	}

	public Tabuleiro getTabuleiro(int i) {
		return tabuleiros[i];
	}

	public int getRodada() {
		return rodada;
	}

	public int jogada(int tab, int inicial, int destino) {
		try {
			int comida = tabuleiros[tab].jogada(inicial, destino);

			System.out.println("jogado no tab " + tab + "\n peças comidas: "
					+ tabuleiros[tab].getEstatisticas().getPecasComidas() + "\n peças comidas= " + comida);
			int restante = tabuleiros[tab].getJogador().getQntPecas();
			tabuleiros[tab].getJogador().setQntPecas(restante - 1);
			System.out.println(tabuleiros[tab].getJogador().getQntPecas());
			switch (haVencedor()) {
			case -1:
				return -2;
			case -2:
				return -3;
			default:
				rodada++;
				return comida;
			}
		} catch (PosicaoInvalidaException e) {
			return -1;
		}

	}

	private String haVencedor() {
		Jogador jogador1 = tabuleiros[0].getJogador();
		Jogador jogador2 = tabuleiros[1].getJogador();
		if (!tabuleiros[0].isBloqueado() && !tabuleiros[1].isBloqueado()) {
			jogador1.setVencedor(jogador1.getQntPecas() == 1);
			jogador2.setVencedor(jogador2.getQntPecas() == 1);
			return jogador1.isVencedor() || jogador2.isVencedor() ? -1 : 0;
		} else {
			jogador1.setVencedor(!tabuleiros[0].isBloqueado());
			jogador2.setVencedor(!tabuleiros[1].isBloqueado());

			return -2;
		}
	}
}