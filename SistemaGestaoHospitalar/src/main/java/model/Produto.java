package model;

public class Produto {
	
	private Integer cdProduto;
	
	private String nomeProduto;
	
	private Integer cdFuncionarioCadastro;
	
	private Boolean isDisponivel;

	public Boolean getIsDisponivel() {
		return isDisponivel;
	}

	public void setIsDisponivel(Boolean isDisponivel) {
		this.isDisponivel = isDisponivel;
	}

	public Integer getCdProduto() {
		return cdProduto;
	}

	public void setCdProduto(Integer cdProduto) {
		this.cdProduto = cdProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Integer getCdFuncionarioCadastro() {
		return cdFuncionarioCadastro;
	}

	public void setCdFuncionarioCadastro(Integer cdFuncionarioCadastro) {
		this.cdFuncionarioCadastro = cdFuncionarioCadastro;
	}

	@Override
	public String toString() {
		return "Produto: " + cdProduto + " - " + nomeProduto;
	}
	

}
