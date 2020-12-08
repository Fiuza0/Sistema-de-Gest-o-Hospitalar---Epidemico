package services;

import model.Produto;

public class ProdutoServices {

	public void ManterProduto(Produto produto) {
		produto.getCdProduto();
		produto.getIsDisponivel();
		produto.getCdFuncionarioCadastro();
		//Adicionar Persistencia de produto
		//adicionar produto ao estoque
	}
	public Produto ConsultarProduto(Produto produto) {
		try {
			//retornar objeto produto preenchido após consulta no banco
			return produto;
		} catch (Exception e) {
			return produto;
		}
	}
	public boolean ConsultarDisponibilidadeProduto(Produto produto) {
		try {
			//adicionar consulta no banco
			
			if(produto.getIsDisponivel()) {
				return true;
			}else {
				return false;
			}
			
		} catch (Exception e) {
			return false;
		}
	}
}
