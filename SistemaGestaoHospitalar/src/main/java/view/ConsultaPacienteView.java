package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.sql.Timestamp;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

public class ConsultaPacienteView extends JFrame{


	private JPanel contentPane;
	
	public ConsultaPacienteView() {
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
			
			/** Buttons **/

			/** TextFields, ComboBox, CheckBox **/
			final JComboBox<String> repeticaoBox = new JComboBox<String>();
			
			SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");  
			
			final JFormattedTextField dtNascimentoTextField = new JFormattedTextField(dtf);
			dtNascimentoTextField.setHorizontalAlignment(SwingConstants.CENTER);
			//dtNascimentoTextField.setText(dtf.format());
			//if (rotina.getDataInicio() != null)
			//	dtInicioTextField.setValue(rotina.getDataInicio());

			dtNascimentoTextField.setBounds(442, 90, 101, 22);
			panel.add(dtNascimentoTextField);
			
			JLabel lblDtNascimento = new JLabel("Data de Nascimento:");
			lblDtNascimento.setForeground(Color.BLACK);
			lblDtNascimento.setFont(new Font("SansSerif", Font.BOLD, 12));
			lblDtNascimento.setBounds(432, 63, 121, 16);
			panel.add(lblDtNascimento);
			
			JButton btnAlterar = new JButton("Alterar");
			btnAlterar.setBounds(252, 281, 90, 28);
			panel.add(btnAlterar);
			
			JLabel lblSucesso = new JLabel("");
			lblSucesso.setBounds(270, 269, 54, 16);
			panel.add(lblSucesso);
			
			JLabel lblNewLabel = new JLabel("< Voltar");
			lblNewLabel.setForeground(Color.BLACK);
			lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
			lblNewLabel.setBounds(508, 312, 55, 16);
			panel.add(lblNewLabel);
			
			JLabel lblConsultaPaciente = new JLabel("Consulta Paciente:");
			lblConsultaPaciente.setForeground(new Color(47, 79, 79));
			lblConsultaPaciente.setFont(new Font("Lucida Sans", Font.BOLD, 14));
			lblConsultaPaciente.setBounds(233, 17, 137, 16);
			panel.add(lblConsultaPaciente);
			
			JFormattedTextField cpfTextField = new JFormattedTextField((Format) null);
			cpfTextField.setHorizontalAlignment(SwingConstants.CENTER);
			cpfTextField.setBounds(32, 155, 90, 22);
			panel.add(cpfTextField);
			
			JLabel lblCpf = new JLabel("CPF:");
			lblCpf.setForeground(Color.BLACK);
			lblCpf.setFont(new Font("SansSerif", Font.BOLD, 12));
			lblCpf.setBounds(32, 136, 31, 16);
			panel.add(lblCpf);
			
			JFormattedTextField nomeTextField = new JFormattedTextField((Format) null);
			nomeTextField.setBounds(32, 90, 370, 22);
			panel.add(nomeTextField);
			
			JLabel lblNome = new JLabel("Nome:");
			lblNome.setForeground(Color.BLACK);
			lblNome.setFont(new Font("SansSerif", Font.BOLD, 12));
			lblNome.setBounds(32, 63, 45, 16);
			panel.add(lblNome);
			
			JFormattedTextField convenioTextField = new JFormattedTextField((Format) null);
			convenioTextField.setBounds(32, 214, 234, 22);
			panel.add(convenioTextField);
			
			JLabel lblConvenio = new JLabel("Conv\u00EAnio:");
			lblConvenio.setForeground(Color.BLACK);
			lblConvenio.setFont(new Font("SansSerif", Font.BOLD, 12));
			lblConvenio.setBounds(32, 196, 60, 16);
			panel.add(lblConvenio);
			
			JLabel lblCodigo = new JLabel("Codigo:");
			lblCodigo.setForeground(Color.BLACK);
			lblCodigo.setFont(new Font("SansSerif", Font.BOLD, 12));
			lblCodigo.setBounds(466, 136, 45, 16);
			panel.add(lblCodigo);
			
			JLabel lblCdPessoa = new JLabel("");
			lblCdPessoa.setHorizontalAlignment(SwingConstants.CENTER);
			lblCdPessoa.setForeground(Color.BLACK);
			lblCdPessoa.setFont(new Font("SansSerif", Font.BOLD, 12));
			lblCdPessoa.setBounds(449, 158, 78, 16);
			panel.add(lblCdPessoa);
			
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
