package br.com.ufsc.aps.restaum.model;

public class Jogador {

	private int qntPecas;
	private boolean vencedor;
	private boolean jogando;
	private String nome;

	public Jogador(String nome) {
		this.nome = nome;
		qntPecas=32;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public void setVencedor(boolean b) {
		this.vencedor = b;
	}

}
