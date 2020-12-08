package model;

import java.sql.Timestamp;

public class Log {
	
	private Integer cdLog;
	
	private Timestamp dtAcesso;
	
	private Integer cdMatricula;

	public Integer getCdMatricula() {
		return cdMatricula;
	}

	public void setCdMatricula(Integer cdMatricula) {
		this.cdMatricula = cdMatricula;
	}

	public Integer getCdLog() {
		return cdLog;
	}

	public void setCdLog(Integer cdLog) {
		this.cdLog = cdLog;
	}

	public Timestamp getDtAcesso() {
		return dtAcesso;
	}

	public void setDtAcesso(Timestamp dtAcesso) {
		this.dtAcesso = dtAcesso;
	}

}
