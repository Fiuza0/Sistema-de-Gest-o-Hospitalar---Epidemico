package model;

public class Funcionario extends Pessoa{
	
	private Integer cdMatricula;
	
	private String senhaFuncionario;
	
	private Boolean isAtivo;
	
	private Cargo cargoFuncionario;
	
	public Boolean getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Boolean isAtivo) {
		this.isAtivo = isAtivo;
	}

	
	public Integer getCdMatricula() {
		return cdMatricula;
	}

	public void setCdMatricula(Integer cdMatricula) {
		this.cdMatricula = cdMatricula;
	}

	public String getSenhaFuncionario() {
		return senhaFuncionario;
	}

	public void setSenhaFuncionario(String senhaFuncionario) {
		this.senhaFuncionario = senhaFuncionario;
	}

	public Cargo getCargoFuncionario() {
		return cargoFuncionario;
	}

	public void setCargoFuncionario(Cargo cargoFuncionario) {
		this.cargoFuncionario = cargoFuncionario;
	}

}
