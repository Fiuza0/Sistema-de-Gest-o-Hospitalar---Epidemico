package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.ConexaoBanco;
import model.Paciente;

public class PacienteDAO {

	public boolean cadastroPaciente(Paciente paciente) throws SQLException {
		Connection con = ConexaoBanco.getConnection();
		Statement stm = con.createStatement();

		try {
			String query = "insert into pessoa (cd_pessoa, nome, cpf, dt_nascimento) " + "values (default, '"
					+ paciente.getNome() + "', '" + paciente.getCpf() + "', '" + paciente.getDataNascimento() + "')";

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

	public Paciente consultarPaciente(Integer cdPessoa) throws SQLException {
		Connection con = ConexaoBanco.getConnection();
		Statement stm = con.createStatement();
		try {
			String query = "select pessoa.cd_pessoa, pessoa.nome, pessoa.nome, pessoa.dt_nascimento from pessoa where cd_pessoa = "
					+ cdPessoa;

			ResultSet result = stm.executeQuery(query);

			if (result.next()) {
				Paciente paciente = new Paciente();

				paciente.setCdPessoa(result.getInt("CD_PESSOA"));
				paciente.setCpf(result.getString("CPF"));
				paciente.setDataNascimento(result.getDate("DT_NASCIMENTO"));
				paciente.setNome(result.getString("NOME"));

				return paciente;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
			stm.close();
		}

		return null;
	}

	public boolean alteraPaciente(Paciente paciente) throws SQLException {
		Connection con = ConexaoBanco.getConnection();
		Statement stm = con.createStatement();

		try {
			String query = "update paciente set nome = '" + paciente.getNome() + "', cpf = '" + paciente.getCpf()
					+ "', " + "dt_nascimento = '" + paciente.getDataNascimento() + "' where cd_pessoa = "
					+ paciente.getCdPessoa();

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
