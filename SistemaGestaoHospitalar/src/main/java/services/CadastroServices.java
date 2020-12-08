package services;

import model.Funcionario;
import model.Paciente;

public class CadastroServices {
	
	public void ManterCadastroFuncionario(Funcionario func) {
		func.getNome();
		func.getCargoFuncionario();
		func.getCpf();
		func.getSenhaFuncionario();
		func.getCdMatricula();
		
		//Adicionar Persistencia de dados
		
	}
	public void ManterCadastroPaciente(Paciente paciente) {
		paciente.getCdPessoa();
		paciente.getConvenio();
		paciente.getCpf();
		paciente.getNome();
		//adiconar persistencia de dados
	}

}
