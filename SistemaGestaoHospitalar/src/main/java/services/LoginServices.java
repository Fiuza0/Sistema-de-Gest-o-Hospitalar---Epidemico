package services;

import model.Funcionario;
import model.Paciente;

public class LoginServices {
	
	public boolean LogarFuncionario(Funcionario func) {
		try {
			//adicionar consulta no banco
			
			return true;
			
		} catch (Exception e) {
			
			return false;
			
		}
		
	}
	public boolean LogarPaciente(Paciente paciente) {
		try {
			//Adicionar Consulta no banco
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
