package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConexaoBanco;
import model.Cargo;

public class CargoDAO {

	public List<Cargo> consultarCargos() throws SQLException {

		Connection con = ConexaoBanco.getConnection();
		Statement stm = con.createStatement();
		List<Cargo> listaCargo = new ArrayList<>();
		try {
			String query = "select nome_cargo, cd_cargo from cargo";

			ResultSet result = stm.executeQuery(query);

			while (result.next()) {
				Cargo cargo = new Cargo();
				cargo.setCdCargo(result.getInt("CD_CARGO"));
				cargo.setNomeCargo(result.getString("NOME_ESPECIALIDADE"));

				listaCargo.add(cargo);
			}
			return listaCargo;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
			stm.close();
		}

		return null;
	}
	
	public Cargo consultarCargo(Integer cdCargo) throws SQLException {

		Connection con = ConexaoBanco.getConnection();
		Statement stm = con.createStatement();
		try {
			String query = "select nome_cargo, cd_cargo from cargo where cd_cargo = " + cdCargo;

			ResultSet result = stm.executeQuery(query);

			if (result.next()) {
				Cargo cargo = new Cargo();
				cargo.setCdCargo(result.getInt("CD_CARGO"));
				cargo.setNomeCargo(result.getString("NOME_ESPECIALIDADE"));

				return cargo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
			stm.close();
		}

		return null;
	}

	public boolean cadastroCargo(Cargo cargo) throws SQLException {
		Connection con = ConexaoBanco.getConnection();
		Statement stm = con.createStatement();

		try {
			String query = "insert into cargo (cd_cargo, nome_cargo) " + "values (default, '" + cargo.getNomeCargo()
					+ "')";

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

	public boolean alteraCargo(Cargo cargo) throws SQLException {
		Connection con = ConexaoBanco.getConnection();
		Statement stm = con.createStatement();

		try {
			String query = "update cargo set nome_cargo = '" + cargo.getNomeCargo() + "' where cd_cargo = "
					+ cargo.getCdCargo();

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
