package network;

import javax.swing.JOptionPane;

import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.OuvidorProxy;
import br.ufsc.inf.leobr.cliente.Proxy;
import br.ufsc.inf.leobr.cliente.exception.ArquivoMultiplayerException;
import br.ufsc.inf.leobr.cliente.exception.JahConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoJogandoException;
import br.ufsc.inf.leobr.cliente.exception.NaoPossivelConectarException;
import model.Jogo;
import view.TelaJogo;

public class AtorNetGames implements OuvidorProxy {

	private static final long serialVersionUID = 1L;
	private String nome;
    private TelaJogo telajogo;
	private Jogo jogo;
    private Proxy proxy;
    private boolean minhaVez= false;

    public AtorNetGames(TelaJogo telajogo) {
        super();
        this.telajogo = telajogo;
        proxy=Proxy.getInstance();
        proxy.addOuvinte(this);
    }

    public void iniciarNovaPartida(Integer posicao) {
    	if (posicao==1)
    		minhaVez=true;
    	if(posicao==2)
    		minhaVez=false;
    	
    	String nomes[]= new String[2];
    	nomes[0]=nome;
    	nomes[1]=this.obterNomeAdversario();
    	jogo = new Jogo(nomes,telajogo,this);
    	telajogo.setJogo(jogo);
        telajogo.exibeMensagemJogoComecou(minhaVez);
    }

    public void finalizarPartidaComErro(String message) {
       telajogo.anunciarVencedor(true,true);
    }

    public void receberMensagem(String msg) {

    }

    public void receberJogada(Jogada jogada) {
    	System.out.println("recebeu");
        JogadaRestaUm jogadaRestaUm1 = (JogadaRestaUm)jogada;
        jogo.recebeJogada(jogadaRestaUm1);
        minhaVez=true;
    }

    public void tratarConexaoPerdida() {
    }

    public void tratarPartidaNaoIniciada(String message) {
        telajogo.anunciaEmEspera();
    }

    public boolean conectar(String nome, String servidor) {
        this.nome=nome;
        boolean conectado = true;
        try {
            proxy.conectar(servidor,nome);
        } catch (JahConectadoException e) {
            JOptionPane.showMessageDialog(null,"Já está conectado");
            conectado = true;
        } catch (NaoPossivelConectarException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar");
            conectado = false;

        } catch (ArquivoMultiplayerException e) {
            JOptionPane.showMessageDialog(null, "Problemas com a configuração de rede");
            conectado =false;
        }
        
        return conectado;
    }

    public boolean isMinhaVez() {
        return minhaVez;
    }

    public void solicitarInicio(){
        try {
            proxy.iniciarPartida(2);
        } catch (NaoConectadoException e) {
            JOptionPane.showMessageDialog(null,"Não está conectado");
        }
    }

    public void enviarJogada(int pecainicial, int pecadestino, int pecaBloqueada){
        JogadaRestaUm jogadaRestaUm = new JogadaRestaUm(pecainicial,pecadestino,pecaBloqueada);
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
	
	   public String getNome() {
	        return nome;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }
}
