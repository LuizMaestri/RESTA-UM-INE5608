package restaum.model;

public class Estatisticas {

	private Integer pecasComidas = 0;
	private long tempocome�o ;
	private long tempoagora;

	public Estatisticas(){
		tempocome�o=System.currentTimeMillis();
		
	}
	
	public String tempo(){
		tempoagora=System.currentTimeMillis();
		String a= String.format("%.0f",(tempoagora-tempocome�o)/1000.0);
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
