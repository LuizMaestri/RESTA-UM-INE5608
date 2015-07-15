package restaum.model;

public class Jogador {

	private int qntPecas;
	private boolean vencedor;
	private boolean jogando;
	private String nome;

	public Jogador(String nome) {
		this.nome = nome;
		qntPecas=32;
	}

	public void setQntPecas(int qntPecas) {
		this.qntPecas = qntPecas;
	}

	public void setJogando(boolean jogando) {
		this.jogando = jogando;
	}

	public boolean isJogando() {
		return jogando;
	}

	public int getQntPecas() {
		return qntPecas;
	}

	public boolean isVencedor() {
		return vencedor;
	}

	public void setVencedor(boolean vencedor) {
		this.vencedor = vencedor;
	}

}
