package br.com.ufsc.aps.restaum.model;

public class Posicao {

	private boolean ocupada = true;
	private Posicao posicaoAcima;
	private Posicao posicaoAbaixo;
	private Posicao posicaoEsquerda;
	private Posicao posicaoDireita;
    private boolean bloqueada = false;

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

	public boolean valida(Posicao posicao) {
		if (this.getPosicaoAbaixo().isOcupada())
            if(this.getPosicaoAbaixo().getPosicaoAbaixo().equals(posicao))
                if(!posicao.isOcupada())
                    return true;
        if (this.getPosicaoAcima().isOcupada())
            if(this.getPosicaoAcima().getPosicaoAcima().equals(posicao))
                if(!posicao.isOcupada())
                    return true;
        if (this.getPosicaoDireita().isOcupada())
            if(this.getPosicaoDireita().getPosicaoDireita().equals(posicao))
                if(!posicao.isOcupada())
                    return true;
        if (this.getPosicaoEsquerda().isOcupada())
            if(this.getPosicaoEsquerda().getPosicaoEsquerda().equals(posicao))
                if(!posicao.isOcupada())
                    return true;
        return false;
    }

    public void setBloqueada(boolean bloqueada) {
        this.bloqueada = bloqueada;
    }

    public boolean isBloqueada() {
        return bloqueada;
    }
}
