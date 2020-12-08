package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import model.Atendimento;
import model.Funcionario;
import services.AtendimentoServices;
import services.FuncionarioServices;
public class CadastroAtendimentoView extends JFrame{


	private JPanel contentPane;
	
	public CadastroAtendimentoView() {
		setAutoRequestFocus(false);
		setVisible(true);
		setBackground(Color.DARK_GRAY);
		setOpacity(1.0f);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginView.class.getResource("/resources/icon_hospital.png")));
		setTitle("Sistema de Gestão Hospitalar");
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
			
			JLabel lblMedico = new JLabel("M\u00E9dico Respons\u00E1vel:");
			lblMedico.setFont(new Font("SansSerif", Font.BOLD, 12));
			lblMedico.setForeground(new Color(0, 0, 0));
			lblMedico.setBounds(432, 161, 121, 16);
			panel.add(lblMedico);

			JLabel lblDescricaoAtendimento = new JLabel("Descri\u00E7\u00E3o do Atendimento:");
			lblDescricaoAtendimento.setFont(new Font("SansSerif", Font.BOLD, 12));
			lblDescricaoAtendimento.setForeground(new Color(0, 0, 0));
			lblDescricaoAtendimento.setBounds(216, 45, 163, 16);
			panel.add(lblDescricaoAtendimento);

			JLabel lblPaciente = new JLabel("Paciente:");
			lblPaciente.setFont(new Font("SansSerif", Font.BOLD, 12));
			lblPaciente.setForeground(new Color(0, 0, 0));
			lblPaciente.setBounds(266, 161, 62, 16);
			panel.add(lblPaciente);
			
			/** Buttons **/

			/** TextFields, ComboBox, CheckBox **/
			final JComboBox<String> repeticaoBox = new JComboBox<String>();
			
			TextArea textArea = new TextArea();
			textArea.setEditable(false);
			textArea.setBounds(120, 67, 355, 57);
			panel.add(textArea);
			
			SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy HH:mm");  
			Timestamp now = new Timestamp(new Date().getTime());
			
			final JFormattedTextField dtMarcadaTextField = new JFormattedTextField(dtf);
			dtMarcadaTextField.setText(dtf.format(now));
			//if (rotina.getDataInicio() != null)
			//	dtInicioTextField.setValue(rotina.getDataInicio());
			FuncionarioServices func = new FuncionarioServices();
			String[] lista = {};
			dtMarcadaTextField.setBounds(16, 177, 127, 22);
			panel.add(dtMarcadaTextField);
			JComboBox comboBoxMedico = new JComboBox(func.ListarMedicos(lista));
			comboBoxMedico.setBounds(416, 178, 147, 20);
			panel.add(comboBoxMedico);
			//falta criar listagem de pacientes no DAO;
			JComboBox comboBoxPaciente = new JComboBox();
			comboBoxPaciente.setBounds(224, 178, 147, 20);
			panel.add(comboBoxPaciente);
			
			JLabel lblDtMarcada = new JLabel("Data Marcada:");
			lblDtMarcada.setForeground(Color.BLACK);
			lblDtMarcada.setFont(new Font("SansSerif", Font.BOLD, 12));
			lblDtMarcada.setBounds(25, 161, 91, 16);
			panel.add(lblDtMarcada);
			
			JLabel lblSala = new JLabel("Sala de Atendimento:");
			lblSala.setForeground(Color.BLACK);
			lblSala.setFont(new Font("SansSerif", Font.BOLD, 12));
			lblSala.setBounds(233, 220, 128, 16);
			panel.add(lblSala);
			
			JComboBox comboBoxPaciente_1 = new JComboBox();
			comboBoxPaciente_1.setBounds(224, 237, 147, 20);
			panel.add(comboBoxPaciente_1);
			
			JButton btnCadastrar = new JButton("Cadastrar");
			btnCadastrar.setBounds(252, 281, 90, 28);
			panel.add(btnCadastrar);
			
			JLabel lblSucesso = new JLabel("");
			lblSucesso.setBounds(270, 269, 54, 16);
			panel.add(lblSucesso);
			
			JLabel lblNewLabel = new JLabel("< Voltar");
			lblNewLabel.setForeground(Color.BLACK);
			lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
			lblNewLabel.setBounds(508, 312, 55, 16);
			panel.add(lblNewLabel);
			
			JLabel lblCadastroAtendimento = new JLabel("Cadastro Atendimento");
			lblCadastroAtendimento.setForeground(new Color(47, 79, 79));
			lblCadastroAtendimento.setFont(new Font("Lucida Sans", Font.BOLD, 14));
			lblCadastroAtendimento.setBounds(216, 17, 162, 16);
			panel.add(lblCadastroAtendimento);
			btnCadastrar.addMouseListener(new MouseAdapter() {
		         public void mouseClicked(MouseEvent me) {
		            if (me.getClickCount() == 2) {
		            	setVisible(false);
						dispose();
						AtendimentoServices atendService = new AtendimentoServices();
						Atendimento atend = new Atendimento();
						//atend.setCdPaciente(comboBoxPaciente.getSelectedItem());;
						atendService.CadastroAtendimento(atend);
						
							
		            }
		         }
		      });
			/*if(AlteraRotinaView.this.listaDeRotinas != null) {
				JButton btnRemover = new JButton("Remover");	
				btnRemover.setFont(new Font("SansSerif", Font.BOLD, 12));
				btnRemover.setBounds(28, 197, 93, 22);
				btnRemover.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent me) {
						if (me.getClickCount() == 1) {
							
							if (controller.removerRotina(rotina.getCdRotina())) {
								dispose();
								ListaRotinasView listaRotinasView = new ListaRotinasView(null, AlteraRotinaView.this.listaDeRotinas, "S");
								listaRotinasView.setLocationRelativeTo(null);
								dispatchEvent(new WindowEvent(listaRotinasView, WindowEvent.WINDOW_OPENED));
							} else {
								lblSucesso.setText("Erro ao remover rotina");
								lblSucesso.setVisible(true);
								lblSucesso.setFont(new Font("SansSerif", Font.BOLD, 12));
								lblSucesso.setBackground(Color.DARK_GRAY);
								lblSucesso.setForeground(Color.RED);
								lblSucesso.setBounds(147, 171, 130, 16);
								panel.add(lblSucesso);
								revalidate();
								repaint();	
							}

						}
					}
				});
				panel.add(btnRemover);
			}
	*/
			/*if (rotina.getHistorico() != null) {
				JButton btnHistorico = new JButton("Historico");
				btnHistorico.setFont(new Font("SansSerif", Font.BOLD, 12));
				btnHistorico.setBounds(295, 152, 90, 28);
				btnHistorico.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent me) {
						if (me.getClickCount() == 1) {
							setVisible(false);
							dispose();
							ListaHistoricoView listHistoricoFrame = new ListaHistoricoView(rotina);
							listHistoricoFrame.setLocationRelativeTo(null);
							dispatchEvent(new WindowEvent(listHistoricoFrame, WindowEvent.WINDOW_OPENED));
							
						}
					}
				});

				panel.add(btnHistorico);
			}
	*/
			/*JButton btnAgendar = new JButton("Agendar");
			btnAgendar.setFont(new Font("SansSerif", Font.BOLD, 12));
			btnAgendar.setBounds(167, 190, 86, 36);
			btnAgendar.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent me) {
					if (me.getClickCount() == 1) {
						if (nomeRotinaTextField.getText() == null
								|| nomeRotinaTextField.getText().trim().equalsIgnoreCase("")) {
							JOptionPane.showMessageDialog(null, "Nome da rotina precisa ser preenchido",
									"Erro de validação", JOptionPane.ERROR_MESSAGE);
							return;
						}
						if (urlTextField.getText() == null || urlTextField.getText().trim().equalsIgnoreCase("")) {
							JOptionPane.showMessageDialog(null, "Url da rotina precisa ser preenchido", "Erro de validação",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
						if (dtInicioTextField.getText() == null
								|| dtInicioTextField.getText().trim().equalsIgnoreCase("")) {
							JOptionPane.showMessageDialog(null, "Data de inicio da rotina precisa ser preenchido",
									"Erro de validação", JOptionPane.ERROR_MESSAGE);
							return;
						}

						Timestamp dtInicio = new Timestamp(new Date(dtInicioTextField.getText()).getTime());
						rotina.setNomeRotina(nomeRotinaTextField.getText());
						rotina.setPeridiocidade(periodicidade.getSelectedIndex() == 0 ? "Diario" : "Mensal");
						rotina.setDataInicio(dtInicio);
						if(rotina.getPeridiocidade().equalsIgnoreCase("Mensal")) {
						rotina.setCdRepeticao(34);
						} else {
						rotina.setCdRepeticao(repeticaoBox.getSelectedIndex());
						}
						rotina.setUrl(urlTextField.getText());
						rotina.setHabilitar(chckbxHabilitar.isSelected());
						
						if(rotina.getCdRotina() != null) {
							controller.alterarRotina(rotina);
							lblSucesso.setText("Alterado!");
							lblSucesso.setVisible(true);
							lblSucesso.setFont(new Font("SansSerif", Font.BOLD, 12));
							lblSucesso.setBackground(Color.DARK_GRAY);
							lblSucesso.setForeground(Color.GREEN);
							lblSucesso.setBounds(184, 162, 55, 16);
							panel.add(lblSucesso);
							repaint();

						}
						else if (controller.inserirRotina(rotina)) {
							lblSucesso.setText("Sucesso!");
							lblSucesso.setVisible(true);
							lblSucesso.setFont(new Font("SansSerif", Font.BOLD, 12));
							lblSucesso.setBackground(Color.DARK_GRAY);
							lblSucesso.setForeground(Color.GREEN);
							lblSucesso.setBounds(184, 162, 55, 16);
							panel.add(lblSucesso);
							repaint();
						} else {
							lblSucesso.setText("Erro!");
							lblSucesso.setVisible(true);
							lblSucesso.setFont(new Font("SansSerif", Font.BOLD, 12));
							lblSucesso.setBackground(Color.DARK_GRAY);
							lblSucesso.setForeground(Color.RED);
							lblSucesso.setBounds(184, 162, 55, 16);
							panel.add(lblSucesso);
							revalidate();
							repaint();	
						}

					}
				}
			});

			panel.add(btnAgendar);
			*/
	}

	

}
