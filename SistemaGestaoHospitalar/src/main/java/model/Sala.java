package model;

public class Sala {
	
	private Integer cdSala;
	
	private Integer numSala;

	private Boolean isAtiva;

	public Integer getNumSala() {
		return numSala;
	}

	public void setNumSala(Integer numSala) {
		this.numSala = numSala;
	}

	public Boolean getIsAtiva() {
		return isAtiva;
	}

	public void setIsAtiva(Boolean isAtiva) {
		this.isAtiva = isAtiva;
	}

	public Integer getCdSalaAtendimento() {
		return cdSala;
	}

	public void setCdSalaAtendimento(Integer cdSala) {
		this.cdSala = cdSala;
	}
}
