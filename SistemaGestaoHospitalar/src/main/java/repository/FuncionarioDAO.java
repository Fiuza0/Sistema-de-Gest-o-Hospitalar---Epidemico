package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConexaoBanco;
import model.Cargo;
import model.Funcionario;
import model.Medico;

public class FuncionarioDAO {

	public boolean cadastroFuncionario(Funcionario func, Integer cdEspecialidade) throws SQLException {

		Connection con = ConexaoBanco.getConnection();
		Statement stm = con.createStatement();

		try {

			String query = "select cd_pessoa from pessoa where cpf = '" + func.getCpf() + "'";

			ResultSet result = stm.executeQuery(query);

			if (result.next()) {
				return false;
			}

			query = "insert into pessoa (cd_pessoa, nome, cpf, dt_nascimento) " + "values (default, '" + func.getNome()
					+ "','" + func.getCpf() + "', '" + func.getDataNascimento() + "')";

			stm.execute(query);

			query = "select cd_pessoa from pessoa where cpf = '" + func.getCpf() + "'";

			func.setCdPessoa(result.getInt("CD_PESSOA"));

			query = "insert into funcionario (cd_pessoa, cd_matricula, senha, cd_cargo, is_ativo) " + "values ("
					+ func.getCdPessoa() + ", default, '123', " + func.getCargoFuncionario().getCdCargo() + ", 1)";

			stm.execute(query);

			if (func.getCargoFuncionario().getNomeCargo().equalsIgnoreCase("medico")) {
				query = "insert into medico_especialidade (cd_medico, cd_especialidade) values ("
						+ func.getCdMatricula() + ", " + cdEspecialidade + ")";

				stm.execute(query);
			}

			return true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
			stm.close();
		}
		return false;

	}

	public Funcionario autenticaFuncionario(Funcionario func) throws SQLException {

		Connection con = ConexaoBanco.getConnection();
		Statement stm = con.createStatement();
		try {
			if (func != null) {

				String query = "select cargo.nome_cargo, pessoa.cd_pessoa, pessoa.nome, pessoa.cpf, "
						+ "pessoa.dt_nascimento, funcionario.cd_cargo from funcionario "
						+ "inner join pessoa on pessoa.cd_pessoa = funcionario.cd_pessoa "
						+ "inner join cargo on cargo.cd_cargo = funcionario.cd_cargo" + "where cd_matricula = "
						+ func.getCdMatricula() + " and is_ativo = 1 and senha = '" + func.getSenhaFuncionario() + "'";

				ResultSet result = stm.executeQuery(query);

				if (result.next()) {

					Cargo cargo = new Cargo();
					cargo.setCdCargo(result.getInt("CD_CARGO"));
					cargo.setNomeCargo(result.getString("NOME_CARGO"));
					func.setCargoFuncionario(cargo);
					func.setCdPessoa(result.getInt("CD_PESSOA"));
					func.setCpf(result.getString("CPF"));
					func.setDataNascimento(result.getDate("DT_NASCIMENTO"));
					func.setIsAtivo(true);
					func.setNome(result.getString("NOME"));
					return func;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
			stm.close();
		}
		return null;
	}

	public boolean alteraFuncionario(Funcionario func) throws SQLException {
		Connection con = ConexaoBanco.getConnection();
		Statement stm = con.createStatement();

		try {
			String query = "update pessoa " + "set nome = '" + func.getNome() + "', cpf = '" + func.getCpf()
					+ "', dt_nascimento = '" + func.getDataNascimento() + "' " + "where cd_pessoa = "
					+ func.getCdPessoa();

			stm.executeQuery(query);

			int isAtivo = func.getIsAtivo() ? 1 : 0;

			query = "update funcionario " + "set cd_cargo = " + func.getCargoFuncionario().getCdCargo()
					+ ", is_ativo = " + isAtivo + " where cd_pessoa = " + func.getCdPessoa();

			stm.executeQuery(query);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		finally {
			con.close();
			stm.close();
		}

	}

	public boolean alteraSenha(String senhaAtual, String novaSenha, Integer cdMatricula) throws SQLException {
		Connection con = ConexaoBanco.getConnection();
		Statement stm = con.createStatement();

		try {
			String query = "select 1 = 1 from funcionario where senha = '" + senhaAtual + "' and cd_matricula = '"
					+ cdMatricula + "'";

			ResultSet result = stm.executeQuery(query);

			if (result.next()) {
				query = "update funcionario set senha = '" + novaSenha + "' where cd_matricula = " + cdMatricula;
				stm.executeQuery(query);
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		finally {
			con.close();
			stm.close();
		}
		return false;
	}

	public List<Funcionario> consultarFuncionarios() throws SQLException {
		Connection con = ConexaoBanco.getConnection();
		Statement stm = con.createStatement();
		List<Funcionario> listaFuncionarios = new ArrayList<>();
		try {
			String query = "select funcionario.cd_matricula, funcionario.senha, funcionario.is_ativo, "
					+ "cargo.nome_cargo, pessoa.cd_pessoa, pessoa.nome, pessoa.cpf, pessoa.dt_nascimento, "
					+ "funcionario.cd_cargo from funcionario "
					+ "inner join pessoa on pessoa.cd_pessoa = funcionario.cd_pessoa "
					+ "inner join cargo on cargo.cd_cargo = funcionario.cd_cargo";

			ResultSet result = stm.executeQuery(query);

			while (result.next()) {
				Funcionario func = new Funcionario();
				Cargo cargo = new Cargo();
				cargo.setCdCargo(result.getInt("CD_CARGO"));
				cargo.setNomeCargo(result.getString("NOME_CARGO"));
				func.setCargoFuncionario(cargo);
				func.setCdMatricula(result.getInt("CD_MATRICULA"));
				func.setCdPessoa(result.getInt("CD_PESSOA"));
				func.setCpf(result.getString("CPF"));
				func.setDataNascimento(result.getDate("DT_NASCIMENTO"));
				func.setIsAtivo(result.getInt("IS_ATIVO") == 1 ? true : false);
				func.setNome(result.getString("NOME"));
				func.setSenhaFuncionario(result.getString("SENHA"));

				listaFuncionarios.add(func);
			}
			return listaFuncionarios;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
			stm.close();
		}

		return null;
	}

	public Medico consultarMedico(Integer cdMatricula) throws SQLException {
		Connection con = ConexaoBanco.getConnection();
		Statement stm = con.createStatement();
		EspecialidadeDAO especialidadeDao = new EspecialidadeDAO();
		try {

			Medico medico = (Medico) consultarFuncionario(cdMatricula);

			String query = "select medico_especialidade.cd_especialidade from medico_especialidade "
					+ "where medico_especialidade.cd_matricula = " + medico.getCdMatricula();

			ResultSet result = stm.executeQuery(query);

			if (result.next()) {
				medico.setEspecialidade(especialidadeDao.consultarEspecialidade(result.getInt("CD_ESPECIALIDADE")));
			}
			
			return medico;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
			stm.close();
		}

		return null;
	}

	public Funcionario consultarFuncionario(Integer cdMatricula) throws SQLException {
		Connection con = ConexaoBanco.getConnection();
		Statement stm = con.createStatement();
		CargoDAO cargoDao = new CargoDAO();
		try {
			String query = "funcionario.cd_matricula, funcionario.senha, funcionario.is_ativo, "
					+ "cargo.nome_cargo, pessoa.cd_pessoa, pessoa.nome, pessoa.cpf, pessoa.dt_nascimento, "
					+ "funcionario.cd_cargo from funcionario "
					+ "inner join pessoa on pessoa.cd_pessoa = funcionario.cd_pessoa "
					+ "inner join cargo on cargo.cd_cargo = funcionario.cd_cargo where cd_matricula = " + cdMatricula;

			ResultSet result = stm.executeQuery(query);

			if (result.next()) {
				Funcionario func = new Funcionario();
				Cargo cargo = cargoDao.consultarCargo(result.getInt("CD_CARGO"));
				func.setCargoFuncionario(cargo);

				func.setCdMatricula(result.getInt("CD_MATRICULA"));
				func.setCdPessoa(result.getInt("CD_PESSOA"));
				func.setCpf(result.getString("CPF"));
				func.setDataNascimento(result.getDate("DT_NASCIMENTO"));
				func.setIsAtivo(result.getInt("IS_ATIVO") == 1 ? true : false);
				func.setNome(result.getString("NOME"));
				func.setSenhaFuncionario(result.getString("SENHA"));

				return func;
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
