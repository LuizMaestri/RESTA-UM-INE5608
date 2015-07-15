package restaum.model;

public class Estatisticas {

	private Integer pecasComidas = 0;
	private long tempoComeco;

	public Estatisticas(){
        tempoComeco=System.currentTimeMillis();
	}
	
	public String tempo(){
		long tempoagora = System.currentTimeMillis();
		String a= String.format("%.0f",(tempoagora-tempoComeco)/1000.0);
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
