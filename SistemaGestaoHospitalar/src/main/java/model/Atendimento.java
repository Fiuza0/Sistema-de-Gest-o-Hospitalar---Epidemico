package model;

import java.sql.Timestamp;

public class Atendimento {
	
	private Integer cdAtendimento;
	
	private String descricaoAtendimento;
	
	private Atendente cdMatriculaCadastro;
	
	private Medico cdMedico;
	
	private Paciente cdPaciente;
	
	private Timestamp dataMarcadaConsulta;
	
	private Timestamp fimConsulta;
	
	private Sala cdSalaAtendimento;

	public Integer getCdAtendimento() {
		return cdAtendimento;
	}

	public void setCdAtendimento(Integer cdAtendimento) {
		this.cdAtendimento = cdAtendimento;
	}

	public String getDescricaoAtendimento() {
		return descricaoAtendimento;
	}

	public void setDescricaoAtendimento(String descricaoAtendimento) {
		this.descricaoAtendimento = descricaoAtendimento;
	}

	public Atendente getCdMatriculaCadastro() {
		return cdMatriculaCadastro;
	}

	public void setCdMatriculaCadastro(Atendente cdMatriculaCadastro) {
		this.cdMatriculaCadastro = cdMatriculaCadastro;
	}

	public Medico getCdMedico() {
		return cdMedico;
	}

	public void setCdMedico(Medico cdMedico) {
		this.cdMedico = cdMedico;
	}

	public Paciente getCdPaciente() {
		return cdPaciente;
	}

	public void setCdPaciente(Paciente cdPaciente) {
		this.cdPaciente = cdPaciente;
	}

	public Timestamp getDataMarcadaConsulta() {
		return dataMarcadaConsulta;
	}

	public void setDataMarcadaConsulta(Timestamp dataMarcadaConsulta) {
		this.dataMarcadaConsulta = dataMarcadaConsulta;
	}

	public Timestamp getFimConsulta() {
		return fimConsulta;
	}

	public void setFimConsulta(Timestamp fimConsulta) {
		this.fimConsulta = fimConsulta;
	}

	public Sala getCdSalaAtendimento() {
		return cdSalaAtendimento;
	}

	public void setCdSalaAtendimento(Sala cdSalaAtendimento) {
		this.cdSalaAtendimento = cdSalaAtendimento;
	}

}