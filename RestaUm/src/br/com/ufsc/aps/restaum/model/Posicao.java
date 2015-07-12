package br.com.ufsc.aps.restaum.model;

public class Posicao {

	private boolean ocupada = true;
	private Posicao posicaoAcima;
	private Posicao posicaoAbaixo;
	private Posicao posicaoEsquerda;
	private Posicao posicaoDireita;
    private boolean bloqueada = false;
    private int index;

    public Posicao(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isOcupada() {
		return ocupada;
	}

	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}

	public Posicao getPosicaoAcima() {
		return posicaoAcima;
	}

	public void setPosicaoAcima(Posicao posicaoAcima) {
		this.posicaoAcima = posicaoAcima;
	}

	public Posicao getPosicaoAbaixo() {
		return posicaoAbaixo;
	}

	public void setPosicaoAbaixo(Posicao posicaoAbaixo) {
		this.posicaoAbaixo = posicaoAbaixo;
	}

	public Posicao getPosicaoEsquerda() {
		return posicaoEsquerda;
	}

	public void setPosicaoEsquerda(Posicao posicaoEsquerda) {
		this.posicaoEsquerda = posicaoEsquerda;
	}

	public Posicao getPosicaoDireita() {
		return posicaoDireita;
	}

	public void setPosicaoDireita(Posicao posicaoDireita) {
		this.posicaoDireita = posicaoDireita;
	}

	public int valida(Posicao posicao) {
        if (this.isOcupada()) {
            Posicao abaixo2 = posicaoAbaixo != null? posicaoAbaixo.getPosicaoAbaixo(): null;
            Posicao acima2 = posicaoAcima != null? posicaoAcima.getPosicaoAcima(): null;
            Posicao direita2 = posicaoDireita != null? posicaoDireita.getPosicaoDireita(): null;
            Posicao esquerda2 = posicaoEsquerda != null? posicaoEsquerda.getPosicaoEsquerda(): null;
            if (posicaoAbaixo != null && posicaoAbaixo.isOcupada())
                if (abaixo2 != null && abaixo2.equals(posicao))
                    if (!posicao.isOcupada())
                        return this.getPosicaoAbaixo().getIndex();
            if (posicaoAcima != null && posicaoAcima.isOcupada())
                if (acima2 != null && acima2.equals(posicao))
                    if (!posicao.isOcupada())
                        return this.getPosicaoAcima().getIndex();
            if (posicaoDireita != null && posicaoDireita.isOcupada())
                if (direita2 != null && direita2.equals(posicao))
                    if (!posicao.isOcupada())
                        return this.getPosicaoDireita().getIndex();
            if (posicaoEsquerda != null && posicaoEsquerda.isOcupada())
                if (esquerda2 != null && esquerda2.equals(posicao))
                    if (!posicao.isOcupada())
                        return this.getPosicaoEsquerda().getIndex();
        }
        return -1;
    }

    public void setBloqueada(boolean bloqueada) {
        this.bloqueada = bloqueada;
    }

    public boolean isBloqueada() {
        return bloqueada;
    }
}
