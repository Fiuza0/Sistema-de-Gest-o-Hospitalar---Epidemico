package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JTextField;
import java.text.Format;

public class ConsultaAtendimentoView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public ConsultaAtendimentoView() {
		setAutoRequestFocus(false);
		setVisible(true);
		setBackground(Color.DARK_GRAY);
		setOpacity(1.0f);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginView.class.getResource("/resources/icon_hospital.png")));
		setTitle("Sistema de Gest�o Hospitalar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		/** Painel **/

		final JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 240, 245));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		/** Labels **/
		final JLabel lblResponsavelCadastro = new JLabel("Repetir a cada:");

		JLabel lblMedico = new JLabel("M\u00E9dico Respons\u00E1vel:");
		lblMedico.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblMedico.setForeground(new Color(0, 0, 0));
		lblMedico.setBounds(237, 53, 121, 16);
		panel.add(lblMedico);

		JLabel lblCdAtendimento = new JLabel("C\u00F3digo do Atendimento:");
		lblCdAtendimento.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblCdAtendimento.setForeground(new Color(0, 0, 0));
		lblCdAtendimento.setBounds(18, 53, 134, 16);
		panel.add(lblCdAtendimento);

		JLabel lblDescricaoAtendimento = new JLabel("Descri\u00E7\u00E3o do Atendimento:");
		lblDescricaoAtendimento.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblDescricaoAtendimento.setForeground(new Color(0, 0, 0));
		lblDescricaoAtendimento.setBounds(18, 184, 163, 16);
		panel.add(lblDescricaoAtendimento);

		JLabel lblPaciente = new JLabel("Paciente:");
		lblPaciente.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblPaciente.setForeground(new Color(0, 0, 0));
		lblPaciente.setBounds(266, 115, 62, 16);
		panel.add(lblPaciente);

		lblResponsavelCadastro.setText("Respons\u00E1vel pelo Cadastro:");
		lblResponsavelCadastro.setHorizontalAlignment(SwingConstants.CENTER);
		lblResponsavelCadastro.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblResponsavelCadastro.setForeground(new Color(0, 0, 0));
		lblResponsavelCadastro.setBounds(406, 50, 179, 22);
		lblResponsavelCadastro.setVisible(true);
		panel.add(lblResponsavelCadastro);

		/** Buttons **/

		/** TextFields, ComboBox, CheckBox **/
		final JComboBox<String> repeticaoBox = new JComboBox<String>();

		TextArea textArea = new TextArea();
		textArea.setEditable(false);
		textArea.setBounds(18, 206, 340, 57);
		panel.add(textArea);

		SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Timestamp now = new Timestamp(new Date().getTime());

		final JFormattedTextField dtMarcadaTextField = new JFormattedTextField(dtf);
		dtMarcadaTextField.setText(dtf.format(now));
		// if (rotina.getDataInicio() != null)
		// dtInicioTextField.setValue(rotina.getDataInicio());

		dtMarcadaTextField.setBounds(18, 139, 127, 22);
		panel.add(dtMarcadaTextField);

		JLabel lblCodigo = new JLabel("");
		lblCodigo.setBounds(38, 86, 79, 14);
		panel.add(lblCodigo);

		JComboBox comboBoxMedico = new JComboBox();
		comboBoxMedico.setEditable(true);
		comboBoxMedico.setBounds(224, 83, 147, 20);
		panel.add(comboBoxMedico);

		JLabel lblRespCadastro = new JLabel("");
		lblRespCadastro.setBounds(416, 85, 169, 16);
		panel.add(lblRespCadastro);

		JComboBox comboBoxPaciente = new JComboBox();
		comboBoxPaciente.setEditable(true);
		comboBoxPaciente.setBounds(224, 140, 147, 20);
		panel.add(comboBoxPaciente);

		JLabel lblDtMarcada = new JLabel("Data Marcada:");
		lblDtMarcada.setForeground(Color.BLACK);
		lblDtMarcada.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblDtMarcada.setBounds(18, 115, 91, 16);
		panel.add(lblDtMarcada);

		JLabel lblDtFimConsulta = new JLabel("Data de Finaliza\u00E7\u00E3o:");
		lblDtFimConsulta.setForeground(Color.BLACK);
		lblDtFimConsulta.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblDtFimConsulta.setBounds(437, 115, 114, 16);
		panel.add(lblDtFimConsulta);

		JFormattedTextField dtFimConsulta = new JFormattedTextField((Format) null);
		dtFimConsulta.setEnabled(false);
		dtFimConsulta.setEditable(false);
		dtFimConsulta.setBounds(431, 139, 127, 22);
		panel.add(dtFimConsulta);

		JLabel lblSala = new JLabel("Sala de Atendimento:");
		lblSala.setForeground(Color.BLACK);
		lblSala.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblSala.setBounds(441, 184, 128, 16);
		panel.add(lblSala);

		JComboBox comboBoxPaciente_1 = new JComboBox();
		comboBoxPaciente_1.setEditable(true);
		comboBoxPaciente_1.setBounds(425, 229, 147, 20);
		panel.add(comboBoxPaciente_1);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(237, 287, 90, 28);
		panel.add(btnAlterar);

		JLabel lblSucesso = new JLabel("");
		lblSucesso.setHorizontalAlignment(SwingConstants.CENTER);
		lblSucesso.setBounds(270, 269, 134, 16);
		panel.add(lblSucesso);
		
		JLabel lblVoltar = new JLabel("< Voltar");
		lblVoltar.setForeground(Color.BLACK);
		lblVoltar.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblVoltar.setBounds(530, 312, 55, 16);
		panel.add(lblVoltar);
		
		JLabel lblConsultaAtendimento = new JLabel("Informa\u00E7\u00F5es Atendimento");
		lblConsultaAtendimento.setForeground(new Color(47, 79, 79));
		lblConsultaAtendimento.setFont(new Font("Lucida Sans", Font.BOLD, 14));
		lblConsultaAtendimento.setBounds(204, 25, 187, 16);
		panel.add(lblConsultaAtendimento);
		
		JLabel lblNomeDoFuncionario = new JLabel("");
		lblNomeDoFuncionario.setForeground(new Color(0, 102, 204));
		lblNomeDoFuncionario.setFont(new Font("Lucida Sans", Font.BOLD, 10));
		lblNomeDoFuncionario.setBounds(6, 6, 204, 16);
		panel.add(lblNomeDoFuncionario);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(345, 287, 90, 28);
		panel.add(btnRemover);

		/*
		 * if(AlteraRotinaView.this.listaDeRotinas != null) { JButton btnRemover = new
		 * JButton("Remover"); btnRemover.setFont(new Font("SansSerif", Font.BOLD, 12));
		 * btnRemover.setBounds(28, 197, 93, 22); btnRemover.addMouseListener(new
		 * MouseAdapter() { public void mouseClicked(MouseEvent me) { if
		 * (me.getClickCount() == 1) {
		 * 
		 * if (controller.removerRotina(rotina.getCdRotina())) { dispose();
		 * ListaRotinasView listaRotinasView = new ListaRotinasView(null,
		 * AlteraRotinaView.this.listaDeRotinas, "S");
		 * listaRotinasView.setLocationRelativeTo(null); dispatchEvent(new
		 * WindowEvent(listaRotinasView, WindowEvent.WINDOW_OPENED)); } else {
		 * lblSucesso.setText("Erro ao remover rotina"); lblSucesso.setVisible(true);
		 * lblSucesso.setFont(new Font("SansSerif", Font.BOLD, 12));
		 * lblSucesso.setBackground(Color.DARK_GRAY);
		 * lblSucesso.setForeground(Color.RED); lblSucesso.setBounds(147, 171, 130, 16);
		 * panel.add(lblSucesso); revalidate(); repaint(); }
		 * 
		 * } } }); panel.add(btnRemover); }
		 */
		/*
		 * if (rotina.getHistorico() != null) { JButton btnHistorico = new
		 * JButton("Historico"); btnHistorico.setFont(new Font("SansSerif", Font.BOLD,
		 * 12)); btnHistorico.setBounds(295, 152, 90, 28);
		 * btnHistorico.addMouseListener(new MouseAdapter() { public void
		 * mouseClicked(MouseEvent me) { if (me.getClickCount() == 1) {
		 * setVisible(false); dispose(); ListaHistoricoView listHistoricoFrame = new
		 * ListaHistoricoView(rotina); listHistoricoFrame.setLocationRelativeTo(null);
		 * dispatchEvent(new WindowEvent(listHistoricoFrame,
		 * WindowEvent.WINDOW_OPENED));
		 * 
		 * } } });
		 * 
		 * panel.add(btnHistorico); }
		 */
		/*
		 * JButton btnAgendar = new JButton("Agendar"); btnAgendar.setFont(new
		 * Font("SansSerif", Font.BOLD, 12)); btnAgendar.setBounds(167, 190, 86, 36);
		 * btnAgendar.addMouseListener(new MouseAdapter() { public void
		 * mouseClicked(MouseEvent me) { if (me.getClickCount() == 1) { if
		 * (nomeRotinaTextField.getText() == null ||
		 * nomeRotinaTextField.getText().trim().equalsIgnoreCase("")) {
		 * JOptionPane.showMessageDialog(null, "Nome da rotina precisa ser preenchido",
		 * "Erro de valida��o", JOptionPane.ERROR_MESSAGE); return; } if
		 * (urlTextField.getText() == null ||
		 * urlTextField.getText().trim().equalsIgnoreCase("")) {
		 * JOptionPane.showMessageDialog(null, "Url da rotina precisa ser preenchido",
		 * "Erro de valida��o", JOptionPane.ERROR_MESSAGE); return; } if
		 * (dtInicioTextField.getText() == null ||
		 * dtInicioTextField.getText().trim().equalsIgnoreCase("")) {
		 * JOptionPane.showMessageDialog(null,
		 * "Data de inicio da rotina precisa ser preenchido", "Erro de valida��o",
		 * JOptionPane.ERROR_MESSAGE); return; }
		 * 
		 * Timestamp dtInicio = new Timestamp(new
		 * Date(dtInicioTextField.getText()).getTime());
		 * rotina.setNomeRotina(nomeRotinaTextField.getText());
		 * rotina.setPeridiocidade(periodicidade.getSelectedIndex() == 0 ? "Diario" :
		 * "Mensal"); rotina.setDataInicio(dtInicio);
		 * if(rotina.getPeridiocidade().equalsIgnoreCase("Mensal")) {
		 * rotina.setCdRepeticao(34); } else {
		 * rotina.setCdRepeticao(repeticaoBox.getSelectedIndex()); }
		 * rotina.setUrl(urlTextField.getText());
		 * rotina.setHabilitar(chckbxHabilitar.isSelected());
		 * 
		 * if(rotina.getCdRotina() != null) { controller.alterarRotina(rotina);
		 * lblSucesso.setText("Alterado!"); lblSucesso.setVisible(true);
		 * lblSucesso.setFont(new Font("SansSerif", Font.BOLD, 12));
		 * lblSucesso.setBackground(Color.DARK_GRAY);
		 * lblSucesso.setForeground(Color.GREEN); lblSucesso.setBounds(184, 162, 55,
		 * 16); panel.add(lblSucesso); repaint();
		 * 
		 * } else if (controller.inserirRotina(rotina)) {
		 * lblSucesso.setText("Sucesso!"); lblSucesso.setVisible(true);
		 * lblSucesso.setFont(new Font("SansSerif", Font.BOLD, 12));
		 * lblSucesso.setBackground(Color.DARK_GRAY);
		 * lblSucesso.setForeground(Color.GREEN); lblSucesso.setBounds(184, 162, 55,
		 * 16); panel.add(lblSucesso); repaint(); } else { lblSucesso.setText("Erro!");
		 * lblSucesso.setVisible(true); lblSucesso.setFont(new Font("SansSerif",
		 * Font.BOLD, 12)); lblSucesso.setBackground(Color.DARK_GRAY);
		 * lblSucesso.setForeground(Color.RED); lblSucesso.setBounds(184, 162, 55, 16);
		 * panel.add(lblSucesso); revalidate(); repaint(); }
		 * 
		 * } } });
		 * 
		 * panel.add(btnAgendar);
		 */
	}
}
