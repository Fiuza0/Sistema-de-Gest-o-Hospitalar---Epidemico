package services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;

import model.Atendimento;
import model.Medico;
import model.Paciente;
import model.Sala;
import repository.AtendimentoDAO;

public class AtendimentoServices {
	
	public void CadastroAtendimento(Atendimento atend) {
		try {
			if(atend != null && atend.getDataMarcadaConsulta() != null) {
				AtendimentoDAO dao = new AtendimentoDAO();
				dao.cadastroAtendimento(atend);
			}else {
				throw new Exception();
			}
			
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
	public JList<Atendimento> ConsultaAtendimento(JList<Atendimento> atend) {
		try {
			AtendimentoDAO dao = new AtendimentoDAO();
			
			if(dao.consultarAtendimentos() != null || !dao.consultarAtendimentos().isEmpty()) {
				atend = new JList(dao.consultarAtendimentos().toArray());
				return atend;
			}else {
				List<Atendimento> atendd= new ArrayList<Atendimento>();
				Atendimento atenddd = new Atendimento();
				atenddd.setDescricaoAtendimento("Lista Vazia, Por favor Cadastre um novo atendimento para vizualizar");
				atend = new JList(atendd.toArray());
				return atend;
			}
			
		
		} catch (Exception e) {
			List<Atendimento> atendd= new ArrayList<Atendimento>();
			Atendimento atenddd = new Atendimento();
			atenddd.setDescricaoAtendimento("Ocorreu um erro");
			atend = new JList(atendd.toArray());
			return atend;
		}
	}
	
	public void FinalizarAtendimento(Atendimento atend) {
		try {
			AtendimentoDAO dao = new AtendimentoDAO();
			Timestamp dataFim = new Timestamp(System.currentTimeMillis());
			atend.setFimConsulta(dataFim);
			dao.alterarAtendimento(atend);
			
		} catch (Exception e) {
			
		}
		
	}
	public boolean VerificarDisponibilidadeSala(Atendimento atend) {
		try {
			
			atend.getCdSalaAtendimento();
			Sala sala = new Sala();
			//adicionar Consulta no banco com base no codigo da sala
			if(sala.getIsAtiva()) {
				return true;
			}else{
				return false;
			}
			
		} catch (Exception e) {
			return false;
		}
		
		
		
	}

}
