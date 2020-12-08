package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConexaoBanco;
import model.Atendente;
import model.Atendimento;
import model.Medico;
import model.Paciente;
import model.Sala;

public class AtendimentoDAO {

	public List<Atendimento> consultarAtendimentos() throws SQLException {

		Connection con = ConexaoBanco.getConnection();
		Statement stm = con.createStatement();
		List<Atendimento> listaAtendimentos = new ArrayList<>();
		FuncionarioDAO dao = new FuncionarioDAO();
		PacienteDAO pacienteDao = new PacienteDAO();
		SalaDAO salaDao = new SalaDAO();
		try {
			String query = "select atendimento.cd_atendimento, atendimento.descricao_atendimento, atendimento.cd_matricula_cadastro, "
					+ "atendimento.cd_matricula_medico, atendimento.cd_paciente, atendimento.dt_marcada_consulta, atendimento.cd_sala, "
					+ "atendimento.fim_consulta from atendimento";

			ResultSet result = stm.executeQuery(query);

			while (result.next()) {
				Atendimento atendimento = new Atendimento();
				Medico medico = dao.consultarMedico(result.getInt("CD_MATRICULA_MEDICO"));
				Atendente atendente = (Atendente) dao.consultarFuncionario(result.getInt("CD_MATRICULA_CADASTRO"));
				Paciente paciente = pacienteDao.consultarPaciente(result.getInt("CD_PACIENTE"));
				Sala sala = salaDao.consultarSala(result.getInt("CD_SALA"));

				atendimento.setCdMedico(medico);
				atendimento.setCdMatriculaCadastro(atendente);
				atendimento.setCdPaciente(paciente);
				atendimento.setCdAtendimento(result.getInt("CD_ATENDIMENTO"));
				atendimento.setDescricaoAtendimento(result.getString("DESCRICAO_ATENDIMENTO"));
				atendimento.setDataMarcadaConsulta(result.getTimestamp("DT_MARCADA_CONSULTA"));
				if (result.getTimestamp("FIM_CONSULTA") != null)
					atendimento.setFimConsulta(result.getTimestamp("FIM_CONSULTA"));

				atendimento.setCdSalaAtendimento(sala);

				listaAtendimentos.add(atendimento);
			}
			return listaAtendimentos;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
			stm.close();
		}

		return null;
	}

	public boolean cadastroAtendimento(Atendimento atendimento) throws SQLException {
		Connection con = ConexaoBanco.getConnection();
		Statement stm = con.createStatement();

		try {
			String query = "insert into atendimento (cd_atendimento, descricao_atendimento, cd_matricula_cadastro, "
					+ "cd_matricula_medico, cd_paciente, dt_marcada_consulta, fim_consulta, cd_sala) "
					+ "values (default, '" + atendimento.getDescricaoAtendimento() + "', " + ""
					+ atendimento.getCdMatriculaCadastro().getCdMatricula() + " , "
					+ atendimento.getCdMedico().getCdMatricula() + ", " + atendimento.getCdPaciente().getCdPessoa()
					+ " , '" + atendimento.getDataMarcadaConsulta() + "','" + atendimento.getFimConsulta() + "',"
					+ atendimento.getCdSalaAtendimento().getCdSalaAtendimento() + " ) )";

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

	public boolean alterarAtendimento(Atendimento atendimento) throws SQLException {
		Connection con = ConexaoBanco.getConnection();
		Statement stm = con.createStatement();

		try {
			String query = "update atendimento " + "set descricao_atendimento = '"
					+ atendimento.getDescricaoAtendimento() + "', " + "cd_matricula_cadastro = "
					+ atendimento.getCdMatriculaCadastro().getCdMatricula() + ", " + "cd_matricula_medico = "
					+ atendimento.getCdMedico().getCdMatricula() + ", " + "cd_paciente = "
					+ atendimento.getCdPaciente().getCdPessoa() + ", " + "dt_marcada_consulta = '"
					+ atendimento.getDataMarcadaConsulta() + "', " + "cd_sala = "
					+ atendimento.getCdSalaAtendimento().getCdSalaAtendimento() + " where cd_atendimento = "
					+ atendimento.getCdAtendimento();

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

	public boolean removeAtendimento(Integer cdAtendimento) throws SQLException {
		Connection con = ConexaoBanco.getConnection();
		Statement stm = con.createStatement();

		try {
			String query = "delete from atendimento where cd_atendimento = " + cdAtendimento;

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
