package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.ConexaoBanco;
import model.Sala;

public class SalaDAO {

	public Sala consultarSala(Integer cdSala) throws SQLException {
		Connection con = ConexaoBanco.getConnection();
		Statement stm = con.createStatement();
		try {
			String query = "select cd_sala, num_sala, is_ativa from sala where cd_sala = " + cdSala;

			ResultSet result = stm.executeQuery(query);

			if (result.next()) {
				Sala sala = new Sala();

				sala.setCdSalaAtendimento(cdSala);
				sala.setIsAtiva(result.getInt("IS_ATIVA") == 1 ? true : false);
				sala.setNumSala(result.getInt("NUM_SALA"));

				return sala;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
			stm.close();
		}

		return null;
	}

	private void cadastroSala() {
		// TODO Auto-generated method stub

	}

	private void alteraSala() {
		// TODO Auto-generated method stub

	}

}
