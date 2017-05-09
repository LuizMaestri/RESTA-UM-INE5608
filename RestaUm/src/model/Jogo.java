package model;

import exception.PosicaoInvalidaException;
import network.AtorNetGames;
import network.JogadaRestaUm;
import view.TelaJogo;

public class Jogo {
    private Tabuleiro[] tabuleiros = new Tabuleiro[2];
    private int rodada;
    private TelaJogo tela;
    private AtorNetGames atorNet;

    public Jogo(String[] nomes, TelaJogo tela, AtorNetGames atorNet) {

        this.tabuleiros[0] = new Tabuleiro(nomes[0]);
        this.tabuleiros[1] = new Tabuleiro(nomes[1]);
        this.rodada = 0;
        this.tela = tela;
        this.atorNet = atorNet;
    }

    public Tabuleiro getTabuleiro(int i) {
        return tabuleiros[i];
    }

    public int getRodada() {
        return rodada;
    }

    public void jogada(int inicial, int destino) {

        int comida = this.fazJogada(0, inicial, destino);

        switch (comida) {
        case -1:
            tela.avisaJogadaInvalida();
            break;
        case -2:
            this.liberaPecasBloqueadas();
            this.enviaJogadaAoNetGames(inicial, destino, -1);
            tela.anunciarVencedor(true, false);
            break;
        case -3:
            this.liberaPecasBloqueadas();
            this.enviaJogadaAoNetGames(inicial, destino, -1);
            tela.anunciarVencedor(false, false);
            break;
        default:
            this.liberaPecasBloqueadas();
            tela.pintarJogada(inicial, destino, comida);
            this.enviaJogadaAoNetGames(inicial, destino, -1);
        }

    }

    public int fazJogada(int tab, int inicial, int destino) {

        try {

            int comida = tabuleiros[tab].jogada(inicial, destino);

            System.out.println(
                    "jogado no tab " + tab + "\n peças comidas: " + tabuleiros[tab].getEstatisticas().getPecasComidas() + "\n peças comidas= " + comida);

            int restante = tabuleiros[tab].getJogador().getQntPecas();
            tabuleiros[tab].getJogador().setQntPecas(restante - 1);
            System.out.println(tabuleiros[tab].getJogador().getQntPecas());
            switch (haVencedor()) {
            case "VENCE":
                return -2;
            case "PERDE":
                return -3;
            default:
                rodada++;
                System.out.println("Rodada = " + rodada);
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
            return jogador1.isVencedor() || jogador2.isVencedor() ? "VENCE" : "JOGA";
        } else {
            jogador1.setVencedor(!tabuleiros[0].isBloqueado());
            jogador2.setVencedor(!tabuleiros[1].isBloqueado());

            return "PERDE";
        }
    }

    public void recebeJogada(JogadaRestaUm jogadaRestaUm1) {
        this.liberaPecasBloqueadas();
        int inicial = jogadaRestaUm1.getPecaInicial();
        int destino = jogadaRestaUm1.getPecaDestino();
        int bloqueada = jogadaRestaUm1.getPecaBloqueada();
        if (bloqueada != -1) {
            this.recebeBloqueio(bloqueada);
        } else {
            int comida = this.fazJogada(1, inicial, destino);
            tela.pintarJogadaOponente(inicial, destino, comida);
        }
        System.out.println("Rodada = " + rodada);
    }

    private void liberaPecasBloqueadas() {

            int posBloqueada = tabuleiros[1].getPosicaoBloqueada();
            if (tabuleiros[1].getPosicaoBloqueada() != -1 && tabuleiros[1].getRodadaBloqueio() < rodada) {
                tabuleiros[1].desbloqueiaPeca(posBloqueada);
                tela.pintaDesbloqueio(posBloqueada);
            }
            posBloqueada = tabuleiros[0].getPosicaoBloqueada();
            if (tabuleiros[0].getPosicaoBloqueada() != -1 && tabuleiros[0].getRodadaBloqueio() < rodada) {
                tabuleiros[0].desbloqueiaPeca(posBloqueada);
                tela.pintaDesbloqueioOponente(posBloqueada);
            }
        }
    
    private void enviaJogadaAoNetGames(int pecainicial, int pecadestino, int pecaBloqueada){
        atorNet.enviarJogada(pecainicial, pecadestino, pecaBloqueada);
    }

    public boolean podeBloquear() {
        return rodada % 5 == 0;
    }

    public void bloqueia(int peca) {
        rodada++;
        this.realizaBloqueio(1, peca);
        tela.pintaBloqueio(peca);
        this.enviaJogadaAoNetGames(-1, -1, peca);
    }

    public void realizaBloqueio(int tab, int peca) {
        tabuleiros[tab].bloqueiaPeca(peca, rodada);
    }

    public void recebeBloqueio(int peca) {
        rodada++;
        this.realizaBloqueio(0, peca);
        tela.pintaBloqueioOponente(peca);
    }
}