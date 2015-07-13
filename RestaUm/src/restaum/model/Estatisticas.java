package restaum.model;

public class Estatisticas {

	private Integer pecasComidas = 0;
	private long tempocomeco;
	private long tempoagora;

	public Estatisticas(){
		tempocomeco=System.currentTimeMillis();
		
	}
	
	public String tempo(){
		tempoagora=System.currentTimeMillis();
		String a= String.format("%.0f",(tempoagora-tempocomeco)/1000.0);
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
