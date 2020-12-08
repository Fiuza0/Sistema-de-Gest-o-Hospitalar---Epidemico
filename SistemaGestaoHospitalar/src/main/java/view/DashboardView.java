package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import model.Funcionario;

public class DashboardView extends JFrame{

	private JFrame frame;
	private JPanel contentPane;
	  private JLabel atendimentoIcon;
	  private JLabel pacienteIcon;
	  private JLabel titleLabel;
	  private JLabel historicoIcon;
	  private JLabel produtoIcon;
	  private JLabel funcionarioIcon;
	  private JLabel salaIcon;
	  private JLabel lblAtendimento;
	  private JLabel lblSalas;
	  private JLabel lblHistorico;
	  private JLabel lblPaciente;
	  private JLabel lblProduto;
	  private JLabel lblFuncionario;
	  private JLabel especialidadesCargoIcon;
	  private JLabel lblAlterarSenha;
	/**
	 * Create the application.
	 */
	public DashboardView(Funcionario userSession) {
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
		
		JPanel panel = new JPanel();
		panel.setForeground(UIManager.getColor("Button.background"));
		panel.setBackground(new Color(255, 240, 245));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		atendimentoIcon = new JLabel("");
		atendimentoIcon.setIcon(new ImageIcon(DashboardView.class.getResource("/resources/atendimento_icon.png")));
		atendimentoIcon.setBounds(56, 131, 32, 32);
		panel.add(atendimentoIcon);
		
		pacienteIcon = new JLabel("");
		pacienteIcon.setIcon(new ImageIcon(DashboardView.class.getResource("/resources/paciente_icon.png")));
		pacienteIcon.setBounds(325, 131, 32, 32);
		panel.add(pacienteIcon);
		
		titleLabel = new JLabel("Modulos do Sistema");
		titleLabel.setForeground(new Color(47, 79, 79));
		titleLabel.setFont(new Font("Lucida Sans", Font.BOLD, 14));
		titleLabel.setBounds(224, 22, 147, 16);
		panel.add(titleLabel);
		
		historicoIcon = new JLabel("");
		historicoIcon.setIcon(new ImageIcon(DashboardView.class.getResource("/resources/historico_icon.png")));
		historicoIcon.setBounds(232, 131, 37, 32);
		panel.add(historicoIcon);
		
		produtoIcon = new JLabel("");
		produtoIcon.setIcon(new ImageIcon(DashboardView.class.getResource("/resources/prod_icon.png")));
		produtoIcon.setBounds(413, 131, 32, 32);
		panel.add(produtoIcon);
		
		funcionarioIcon = new JLabel("");
		funcionarioIcon.setIcon(new ImageIcon(DashboardView.class.getResource("/resources/funcio_icon.png")));
		funcionarioIcon.setBounds(501, 131, 32, 32);
		panel.add(funcionarioIcon);
		
		salaIcon = new JLabel("");
		salaIcon.setIcon(new ImageIcon(DashboardView.class.getResource("/resources/salas_icon.png")));
		salaIcon.setBounds(144, 131, 32, 32);
		panel.add(salaIcon);
		
		JLabel logoutIcon = new JLabel("");
		logoutIcon.setIcon(new ImageIcon(DashboardView.class.getResource("/resources/logoout_icon.png")));
		logoutIcon.setBounds(553, 291, 32, 32);
		panel.add(logoutIcon);
		
		JLabel lblNomeDoFuncionario = new JLabel("");
		lblNomeDoFuncionario.setForeground(new Color(0, 102, 204));
		lblNomeDoFuncionario.setFont(new Font("Lucida Sans", Font.BOLD, 10));
		lblNomeDoFuncionario.setBounds(10, 11, 204, 16);
		panel.add(lblNomeDoFuncionario);
		
		lblAtendimento = new JLabel("Atendimento");
		lblAtendimento.setForeground(new Color(0, 102, 204));
		lblAtendimento.setFont(new Font("Lucida Sans", Font.BOLD, 10));
		lblAtendimento.setBounds(39, 107, 72, 16);
		panel.add(lblAtendimento);
		
		lblSalas = new JLabel("Salas");
		lblSalas.setForeground(new Color(0, 102, 204));
		lblSalas.setFont(new Font("Lucida Sans", Font.BOLD, 10));
		lblSalas.setBounds(144, 107, 32, 16);
		panel.add(lblSalas);
		
		lblHistorico = new JLabel("Historico");
		lblHistorico.setForeground(new Color(0, 102, 204));
		lblHistorico.setFont(new Font("Lucida Sans", Font.BOLD, 10));
		lblHistorico.setBounds(224, 107, 47, 16);
		panel.add(lblHistorico);
		
		lblPaciente = new JLabel("Paciente");
		lblPaciente.setForeground(new Color(0, 102, 204));
		lblPaciente.setFont(new Font("Lucida Sans", Font.BOLD, 10));
		lblPaciente.setBounds(325, 107, 47, 16);
		panel.add(lblPaciente);
		
		lblProduto = new JLabel("Produto");
		lblProduto.setForeground(new Color(0, 102, 204));
		lblProduto.setFont(new Font("Lucida Sans", Font.BOLD, 10));
		lblProduto.setBounds(407, 107, 47, 16);
		panel.add(lblProduto);
		
		lblFuncionario = new JLabel("Funcionarios");
		lblFuncionario.setForeground(new Color(0, 102, 204));
		lblFuncionario.setFont(new Font("Lucida Sans", Font.BOLD, 10));
		lblFuncionario.setBounds(488, 107, 72, 16);
		panel.add(lblFuncionario);
		
		JLabel lblEspecialidadesECargos = new JLabel("Especialidades/\r\nCargos");
		lblEspecialidadesECargos.setForeground(new Color(0, 102, 204));
		lblEspecialidadesECargos.setFont(new Font("Lucida Sans", Font.BOLD, 10));
		lblEspecialidadesECargos.setBounds(39, 188, 131, 32);
		panel.add(lblEspecialidadesECargos);
		
		especialidadesCargoIcon = new JLabel("");
		especialidadesCargoIcon.setIcon(new ImageIcon(DashboardView.class.getResource("/resources/especialidade_icon.png")));
		especialidadesCargoIcon.setBounds(79, 215, 32, 32);
		panel.add(especialidadesCargoIcon);
		
		lblAlterarSenha = new JLabel("Alterar Senha");
		lblAlterarSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAlterarSenha.setForeground(Color.DARK_GRAY);
		lblAlterarSenha.setBounds(22, 309, 89, 14);
		panel.add(lblAlterarSenha);
		
		   ImageIcon background=new ImageIcon(LoginView.class.getResource("/resources/acesso_icon.ico"));
	    Image img=background.getImage();
	    Image temp=img.getScaledInstance(500,600,Image.SCALE_SMOOTH);
	    background=new ImageIcon(temp);
	}
}
