package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.ConexaoBanco;
import model.Estoque;
import model.Produto;

public class EstoqueDAO {

	public Estoque consultaEstoque(Produto prod) throws SQLException {

		Connection con = ConexaoBanco.getConnection();
		Statement stm = con.createStatement();
		ProdutoDAO dao = new ProdutoDAO();

		try {
			prod = dao.consultaProduto(prod.getCdProduto());
			
			String query = "Select quantidade from estoque where cd_produto = " + prod.getCdProduto();

			ResultSet result = stm.executeQuery(query);
			if (result.next()) {

				Estoque estoque = new Estoque();
				estoque.setCdProduto(prod);
				estoque.setQuantidade(result.getInt("quantidade"));

				return estoque;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
			stm.close();
		}
		return null;
	}

	public boolean alteraEstoque(Integer cdProduto, Integer quantidade) throws SQLException {

		Connection con = ConexaoBanco.getConnection();
		Statement stm = con.createStatement();

		try {
			String query = "update estoque set quantidade =" + quantidade + " where cd_produto = " + cdProduto;

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

}
