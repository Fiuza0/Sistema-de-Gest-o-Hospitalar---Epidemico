package model;

public class Estoque {
	
	private Produto cdProduto;
	
	private Integer quantidade;

	public Produto getCdProduto() {
		return cdProduto;
	}

	public void setCdProduto(Produto cdProduto) {
		this.cdProduto = cdProduto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

}
