package br.com.ufsc.aps.restaum.network;

import br.com.ufsc.aps.restaum.model.Jogo;
import br.com.ufsc.aps.restaum.view.TelaJogo;
import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.OuvidorProxy;
import br.ufsc.inf.leobr.cliente.Proxy;
import br.ufsc.inf.leobr.cliente.exception.*;

import javax.swing.*;

public class AtorNetGames implements OuvidorProxy {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TelaJogo telajogo;
    private Proxy proxy;
    private Jogo jogo;
    private boolean ehMinhaVez= false;
    public AtorNetGames(TelaJogo telajogo) {
        super();
        this.telajogo = telajogo;
        proxy=Proxy.getInstance();
        proxy.addOuvinte(this);
    }


    public void conectar(String nome, String servidor)
    {
        try {
            proxy.conectar(servidor,nome);
        } catch (JahConectadoException e) {
            JOptionPane.showMessageDialog(null,"Já está conectado");
        } catch (NaoPossivelConectarException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar");

        } catch (ArquivoMultiplayerException e) {
            JOptionPane.showMessageDialog(null, "Problemas com a configuração de rede");

        }
    }
    
    public boolean ehMinhaVez()
    {
    	return ehMinhaVez;
    	
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

        ehMinhaVez=false;
    }

    @Override
    public void iniciarNovaPartida(Integer posicao) {
    	if (posicao==1)
    		ehMinhaVez=true;
    	if(posicao==2)
    		ehMinhaVez=false;
    telajogo.iniciaPartidaRede(ehMinhaVez);
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

      ehMinhaVez=true;
    }

    @Override
    public void tratarConexaoPerdida() {

    }

    @Override
    public void tratarPartidaNaoIniciada(String message) {

    }

    public void desconectar(){
        try {
            proxy.desconectar();
        } catch (NaoConectadoException e) {
            e.printStackTrace();
        }
    }


	public String ObterNomeAdversario() {
		String nome="";
		if(ehMinhaVez)
		nome=proxy.obterNomeAdversario(2);
		else
		nome=proxy.obterNomeAdversario(1);
		return nome;
		
	}
}
