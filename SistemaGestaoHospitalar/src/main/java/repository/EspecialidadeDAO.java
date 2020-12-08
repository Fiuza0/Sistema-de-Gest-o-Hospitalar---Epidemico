package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConexaoBanco;
import model.Especialidade;

public class EspecialidadeDAO {

	public List<Especialidade> consultarEspecialidades() throws SQLException {

		Connection con = ConexaoBanco.getConnection();
		Statement stm = con.createStatement();
		List<Especialidade> listaEspecialidades = new ArrayList<>();
		try {
			String query = "select nome_especialidade, cd_especialidade from especialidade";

			ResultSet result = stm.executeQuery(query);

			while (result.next()) {
				Especialidade especialidade = new Especialidade();
				especialidade.setCdEspecialidade(result.getInt("CD_ESPECIALIDADE"));
				especialidade.setNome(result.getString("NOME_ESPECIALIDADE"));

				listaEspecialidades.add(especialidade);
			}
			return listaEspecialidades;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
			stm.close();
		}

		return null;
	}

	public boolean cadastroEspecialidade(Especialidade especialidade) throws SQLException {
		Connection con = ConexaoBanco.getConnection();
		Statement stm = con.createStatement();

		try {
			String query = "insert into especialidade (cd_especialidade, nome_especialidade) " + "values (default, '"
					+ especialidade.getNome() + "')";

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

	public boolean alteraEspecialidade(Especialidade especialidade) throws SQLException {
		Connection con = ConexaoBanco.getConnection();
		Statement stm = con.createStatement();

		try {
			String query = "update especialidade set nome_especialidade = '" + especialidade.getNome()
					+ "' where cd_especialidade = " + especialidade.getCdEspecialidade();

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

	public Especialidade consultarEspecialidade(Integer cdEspecialidade) throws SQLException {

		Connection con = ConexaoBanco.getConnection();
		Statement stm = con.createStatement();
		try {
			String query = "select nome_especialidade, cd_especialidade from especialidade where cd_especialidade = "
					+ cdEspecialidade;

			ResultSet result = stm.executeQuery(query);

			if (result.next()) {
				Especialidade especialidade = new Especialidade();
				especialidade.setCdEspecialidade(result.getInt("CD_ESPECIALIDADE"));
				especialidade.setNome(result.getString("NOME_ESPECIALIDADE"));

				return especialidade;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
			stm.close();
		}

		return null;
	}

}
