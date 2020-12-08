package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import connection.ConexaoBanco;
import model.Log;

public class LogDAO {

	public boolean cadastroLog(Log log) throws SQLException {
		Connection con = ConexaoBanco.getConnection();
		Statement stm = con.createStatement();

		try {
			String query = "insert into log (cd_log, cd_matricula, dt_acesso) " + "values (default, "
					+ log.getCdMatricula() + " , '" + new java.sql.Timestamp(new Date().getTime()) + "')";

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

	public List<Log> consultarLogs(Integer cdMatricula) throws SQLException {

		Connection con = ConexaoBanco.getConnection();
		Statement stm = con.createStatement();
		List<Log> listaLogs = new ArrayList<>();
		try {
			String query = "select cd_log, cd_matricula, dt_acesso from log where cd_matricula = " + cdMatricula;

			ResultSet result = stm.executeQuery(query);

			while (result.next()) {
				Log log = new Log();
				log.setCdLog(result.getInt("CD_LOG"));
				log.setCdMatricula(cdMatricula);
				log.setDtAcesso(result.getTimestamp("dt_acesso"));

				listaLogs.add(log);
			}
			return listaLogs;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
			stm.close();
		}

		return null;
	}

}
