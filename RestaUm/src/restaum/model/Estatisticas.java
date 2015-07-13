package restaum.model;

public class Estatisticas {

	private Integer pecasComidas = 0;
	private long tempocomeço ;
	private long tempoagora;

	public Estatisticas(){
		tempocomeço=System.currentTimeMillis();
		
	}
	
	public String tempo(){
		tempoagora=System.currentTimeMillis();
		String a= String.format("%.0f",(tempoagora-tempocomeço)/1000.0);
		a+="seg.";
		return a;
	}
	public Integer getPecasComidas() {
		return pecasComidas;
	}
	public void setPecasComidas(Integer pecasComidas) {
		this.pecasComidas = pecasComidas;
	}

}
