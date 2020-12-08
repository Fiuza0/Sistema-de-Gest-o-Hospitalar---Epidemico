package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConexaoBanco;
import model.Estoque;
import model.Produto;

public class ProdutoDAO {

	public boolean cadastroProduto(Produto produto, Integer cdFuncionarioCadastro, Integer quantidade)
			throws SQLException {
		Connection con = ConexaoBanco.getConnection();
		Statement stm = con.createStatement();

		try {
			if (produto.getNomeProduto().trim().equals("")) {
				String query = "insert into produto (cd_produto, nome_produto, cd_funcionario_cadastro, is_disponivel) "
						+ "values (default, '" + produto.getNomeProduto() + "', " + cdFuncionarioCadastro + ", 1))";

				stm.execute(query);

				query = "select cd_produto from produto where nome_produto = '" + produto.getNomeProduto()
						+ "' and cd_funcionario_cadastro = " + cdFuncionarioCadastro;
				ResultSet result = stm.executeQuery(query);

				if (result.next()) {
					produto = consultaProduto(result.getInt("CD_PRODUTO"));
					Estoque estoque = new Estoque();
					estoque.setCdProduto(produto);
					estoque.setQuantidade(quantidade);
					criaEstoqueProduto(estoque);

					return true;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
			stm.close();
		}
		return false;
	}

	public boolean alteraProduto(Produto produto, Estoque estoque) throws SQLException {
		Connection con = ConexaoBanco.getConnection();
		Statement stm = con.createStatement();
		EstoqueDAO dao = new EstoqueDAO();

		try {
			int isDisponivel = produto.getIsDisponivel() ? 1 : 0;

			String query = "update produto " + "set nome_produto = '" + produto.getNomeProduto() + "', is_disponivel = "
					+ isDisponivel + "" + " where cd_produto = " + produto.getCdProduto();

			stm.execute(query);
			dao.alteraEstoque(estoque.getCdProduto().getCdProduto(), estoque.getQuantidade());
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
			stm.close();
		}
		return false;
	}

	public Produto consultaProduto(Integer cdProduto) throws SQLException {

		Connection con = ConexaoBanco.getConnection();
		Statement stm = con.createStatement();

		try {
			String query = "select nome_produto, cd_funcionario_cadastro, is_disponivel from produto where cd_produto = "
					+ cdProduto;

			ResultSet result = stm.executeQuery(query);
			if (result.next()) {

				Produto produto = new Produto();
				produto.setCdProduto(cdProduto);
				produto.setCdFuncionarioCadastro(result.getInt("CD_FUNCIONARIO_CADASTRO"));
				produto.setIsDisponivel(result.getInt("IS_DISPONIVEL") == 1 ? true : false);
				produto.setNomeProduto(result.getString("NOME_PRODUTO"));

				return produto;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
			stm.close();
		}
		return null;
	}

	public boolean removeProduto(Integer cdProduto) throws SQLException {
		Connection con = ConexaoBanco.getConnection();
		Statement stm = con.createStatement();

		try {
			String query = "delete from estoque where cd_produto = " + cdProduto;

			stm.execute(query);

			query = "delete from produto where cd_produto = " + cdProduto;

			stm.execute(query);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
			stm.close();
		}
		return false;
	}

	public boolean criaEstoqueProduto(Estoque estoque) throws SQLException {

		Connection con = ConexaoBanco.getConnection();
		Statement stm = con.createStatement();

		try {
			String query = "insert into estoque (cd_produto, quantidade) values ("
					+ estoque.getCdProduto().getCdProduto() + ", " + estoque.getQuantidade() + ")";

			stm.execute(query);

			return true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
			stm.close();
		}
		return false;

	}
	
	public List<Produto> consultarProdutos() throws SQLException {

		Connection con = ConexaoBanco.getConnection();
		Statement stm = con.createStatement();
		List<Produto> listaProdutos = new ArrayList<>();
		try {
			String query = "select cd_produto, nome_produto, cd_funcionario_cadastro, is_disponivel";

			ResultSet result = stm.executeQuery(query);

			while (result.next()) {
				Produto produto = new Produto();
				
				produto.setCdFuncionarioCadastro(result.getInt("CD_FUNCIONARIO_CADASTRO"));
				produto.setCdProduto(result.getInt("CD_PRODUTO"));
				produto.setIsDisponivel(result.getInt("IS_DISPONIVEL") == 1 ? true : false);
				produto.setNomeProduto(result.getString("NOME_PRODUTO"));
				
				listaProdutos.add(produto);
			}
			return listaProdutos;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
			stm.close();
		}

		return null;
	}

}
