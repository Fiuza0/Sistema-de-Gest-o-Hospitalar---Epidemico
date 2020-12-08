package services;

import java.text.SimpleDateFormat;

import model.Cargo;
import model.Funcionario;
import repository.FuncionarioDAO;

public class FuncionarioServices {
	
	public String[] ListarMedicos(String[] lista){
		try {
			FuncionarioDAO dao = new FuncionarioDAO();
			int cont = 0;
			for (Funcionario func : dao.consultarFuncionarios()) {
				if(func.getCargoFuncionario().getNomeCargo().toUpperCase() == "MEDICO") {
					lista[cont] = func.getCargoFuncionario().getNomeCargo();
					cont++;
				}
			}
			return lista;
		} catch (Exception e) {
			return lista;
		}
	}
	public void CadastroFuncionario(String cargo, String nome,String cpf, String senha, String dataNascimento) {
		try {
			Funcionario func = new Funcionario();
			Cargo cargoFuncionario = new Cargo();
			FuncionarioDAO dao = new FuncionarioDAO();
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			if(!dataNascimento.isBlank()) {
				java.sql.Date data = new java.sql.Date(format.parse(dataNascimento).getTime());
			
			cargoFuncionario.setNomeCargo(cargo);
			func.setNome(nome);
			func.setCargoFuncionario(cargoFuncionario);
			func.setCpf(cpf);
			func.setSenhaFuncionario(senha);
			func.setDataNascimento(data);
			}
			if(func.getNome().isBlank() || func.getDataNascimento() == null||func.getCpf().isBlank()) {
				throw new Exception();
			}else {
				dao.cadastroFuncionario(func, 1);
			}
		} catch (Exception e) {
			
		}
		
	}
	/*
	 * public String[] ListarPaciente(String[] lista){ try { PacienteDAO dao = new
	 * PacienteDAO(); int cont = 0; for (Funcionario func : dao.) {
	 * if(func.getCargoFuncionario().getNomeCargo().toUpperCase() == "MEDICO") {
	 * lista[cont] = func.getCargoFuncionario().getNomeCargo(); cont++; } } return
	 * lista; } catch (Exception e) { return lista; } }
	 */
}
