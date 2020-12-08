package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import model.Funcionario;
import services.LoginServices;

public class LoginView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	  private JLabel matriculaIcon;
	  private JLabel senhaIcon;
	  private JLabel titleLabel;
	  private JLabel acessoIcon;
	  private JLabel lblErrorMessage;
	  private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginView() {
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
		
	    JFormattedTextField matriculaField = new JFormattedTextField();
		matriculaField.setBounds(240, 100, 114, 20);	
		matriculaField.setColumns(10);
		panel.add(matriculaField);
		
		matriculaIcon = new JLabel("");
		matriculaIcon.setIcon(new ImageIcon(LoginView.class.getResource("/resources/login_icon.png")));
		matriculaIcon.setBounds(281, 53, 32, 32);
		panel.add(matriculaIcon);
		
		senhaIcon = new JLabel("");
		senhaIcon.setIcon(new ImageIcon(LoginView.class.getResource("/resources/senha_icon.png")));
		senhaIcon.setBounds(281, 135, 32, 32);
		panel.add(senhaIcon);
		
		titleLabel = new JLabel("Sistema de Gest\u00E3o Hospitalar");
		titleLabel.setForeground(new Color(47, 79, 79));
		titleLabel.setFont(new Font("Lucida Sans", Font.BOLD, 14));
		titleLabel.setBounds(188, 22, 218, 16);
		panel.add(titleLabel);
		
		acessoIcon = new JLabel("");
		acessoIcon.setIcon(new ImageIcon(LoginView.class.getResource("/resources/loginIn_icon.png")));
		acessoIcon.setBounds(281, 217, 32, 32);
		acessoIcon.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				if (me.getClickCount() == 1) {
					setVisible(false);
					dispose();
						
						Funcionario userSession = new Funcionario();
						userSession.setCdMatricula(Integer.parseInt(matriculaField.getText()));
						userSession.setSenhaFuncionario(passwordField.getSelectedText());
						LoginServices bo = new LoginServices();
					//	if(bo.LogarFuncionario(userSession)) {
						DashboardView DashboardFrame = new DashboardView(userSession);
						
						DashboardFrame.setLocationRelativeTo(null);
						dispatchEvent(new WindowEvent(DashboardFrame, WindowEvent.WINDOW_OPENED));
					//	}
					
						}
			}
		});
		panel.add(acessoIcon);
		
		lblErrorMessage = new JLabel("");
		lblErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorMessage.setForeground(new Color(255, 0, 0));
		lblErrorMessage.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		lblErrorMessage.setBounds(171, 262, 253, 16);
		panel.add(lblErrorMessage);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(240, 182, 114, 20);
		panel.add(passwordField);
		
		ImageIcon background=new ImageIcon(LoginView.class.getResource("/resources/acesso_icon.ico"));
	    Image img=background.getImage();
	    Image temp=img.getScaledInstance(500,600,Image.SCALE_SMOOTH);
	    background=new ImageIcon(temp);
	}
}
