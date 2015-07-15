package restaum.network;

import restaum.view.TelaJogo;
import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.OuvidorProxy;
import br.ufsc.inf.leobr.cliente.Proxy;
import br.ufsc.inf.leobr.cliente.exception.*;

import javax.swing.*;

public class AtorNetGames implements OuvidorProxy {

	private static final long serialVersionUID = 1L;
	private TelaJogo telajogo;
    private Proxy proxy;
    private boolean minhaVez= false;

    public AtorNetGames(TelaJogo telajogo) {
        super();
        this.telajogo = telajogo;
        proxy=Proxy.getInstance();
        proxy.addOuvinte(this);
    }

    @Override
    public void iniciarNovaPartida(Integer posicao) {
    	if (posicao==1)
    		minhaVez=true;
    	if(posicao==2)
    		minhaVez=false;
        telajogo.iniciaPartidaRede(minhaVez);
    }

    @Override
    public void finalizarPartidaComErro(String message) {

    }

    @Override
    public void receberMensagem(String msg) {

    }

    @Override
    public void receberJogada(Jogada jogada) {
    	System.out.println("recebeu");
        JogadaRestaUm jogadaRestaUm1 = (JogadaRestaUm)jogada;
        telajogo.recebeJogadaNet(jogadaRestaUm1);
        minhaVez=true;
    }

    @Override
    public void tratarConexaoPerdida() {

    }

    @Override
    public void tratarPartidaNaoIniciada(String message) {

    }

    public void conectar(String nome, String servidor) {
        try {
            proxy.conectar(servidor,nome);
        } catch (JahConectadoException e) {
            JOptionPane.showMessageDialog(null,"Já está conectado");
        } catch (NaoPossivelConectarException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar");
            System.exit(0);

        } catch (ArquivoMultiplayerException e) {
            JOptionPane.showMessageDialog(null, "Problemas com a configuração de rede");

        }
    }

    public boolean isMinhaVez() {
        return minhaVez;
    }

    public void iniciarPartida(){
        try {
            proxy.iniciarPartida(2);
        } catch (NaoConectadoException e) {
            JOptionPane.showMessageDialog(null,"Não está conectado");
        }
    }

    public void enviarJogada(int pecainicial, int pecadestino){
        JogadaRestaUm jogadaRestaUm = new JogadaRestaUm(pecainicial,pecadestino);
        try {
            proxy.enviaJogada(jogadaRestaUm);
        } catch (NaoJogandoException e) {
            JOptionPane.showMessageDialog(null,"Você não está jogando");
        }
        minhaVez=false;
    }

    public void desconectar(){
        try {
            proxy.desconectar();
        } catch (NaoConectadoException e) {
            e.printStackTrace();
        }
    }

	public String obterNomeAdversario() {
		String nome;
		if(minhaVez)
		    nome=proxy.obterNomeAdversario(2);
		else
		    nome=proxy.obterNomeAdversario(1);
		return nome;
	}
}
