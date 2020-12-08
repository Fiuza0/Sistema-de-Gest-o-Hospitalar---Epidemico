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

public class CadastroCargoView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNome;

	public CadastroCargoView() {
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

		SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Timestamp now = new Timestamp(new Date().getTime());

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(252, 247, 90, 28);
		panel.add(btnCadastrar);

		JLabel lblSucesso = new JLabel("");
		lblSucesso.setBounds(270, 269, 54, 16);
		panel.add(lblSucesso);
		
		JLabel lblVoltar = new JLabel("< Voltar");
		lblVoltar.setForeground(Color.BLACK);
		lblVoltar.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblVoltar.setBounds(530, 312, 55, 16);
		panel.add(lblVoltar);
		
		JLabel lblNomeDoCargo = new JLabel("Nome do Cargo:");
		lblNomeDoCargo.setForeground(Color.BLACK);
		lblNomeDoCargo.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNomeDoCargo.setBounds(248, 70, 99, 16);
		panel.add(lblNomeDoCargo);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(167, 97, 261, 28);
		panel.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblCadastroCargo = new JLabel("Cadastro Cargo");
		lblCadastroCargo.setForeground(new Color(47, 79, 79));
		lblCadastroCargo.setFont(new Font("Lucida Sans", Font.BOLD, 14));
		lblCadastroCargo.setBounds(242, 27, 111, 16);
		panel.add(lblCadastroCargo);
		
		JLabel lblNomeDoFuncionario = new JLabel("");
		lblNomeDoFuncionario.setForeground(new Color(0, 102, 204));
		lblNomeDoFuncionario.setFont(new Font("Lucida Sans", Font.BOLD, 10));
		lblNomeDoFuncionario.setBounds(16, 6, 204, 16);
		panel.add(lblNomeDoFuncionario);

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
		 * "Erro de validação", JOptionPane.ERROR_MESSAGE); return; } if
		 * (urlTextField.getText() == null ||
		 * urlTextField.getText().trim().equalsIgnoreCase("")) {
		 * JOptionPane.showMessageDialog(null, "Url da rotina precisa ser preenchido",
		 * "Erro de validação", JOptionPane.ERROR_MESSAGE); return; } if
		 * (dtInicioTextField.getText() == null ||
		 * dtInicioTextField.getText().trim().equalsIgnoreCase("")) {
		 * JOptionPane.showMessageDialog(null,
		 * "Data de inicio da rotina precisa ser preenchido", "Erro de validação",
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
