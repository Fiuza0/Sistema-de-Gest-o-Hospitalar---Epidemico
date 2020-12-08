/**
 * @author marcony.souza
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
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
import javax.swing.JButton;

/**
 * @author marcony.souza
 *
 */
public class PacienteView extends JFrame{

	private JPanel contentPane;
	  private JLabel titleLabel;
	  private JLabel lblAtendimento;
	  private JLabel lblSalas;
	  private JButton btnNovo;
	  private JButton btnConsulta;
	  private JLabel lblVoltar;
	  
	public PacienteView() {
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
		
		titleLabel = new JLabel("Paciente");
		titleLabel.setForeground(new Color(47, 79, 79));
		titleLabel.setFont(new Font("Lucida Sans", Font.BOLD, 14));
		titleLabel.setBounds(261, 22, 72, 16);
		panel.add(titleLabel);
		
		JLabel lblNomeDoFuncionario = new JLabel("");
		lblNomeDoFuncionario.setForeground(new Color(0, 102, 204));
		lblNomeDoFuncionario.setFont(new Font("Lucida Sans", Font.BOLD, 10));
		lblNomeDoFuncionario.setBounds(10, 11, 204, 16);
		panel.add(lblNomeDoFuncionario);
		
		lblAtendimento = new JLabel("Consultar Paciente");
		lblAtendimento.setForeground(new Color(0, 102, 204));
		lblAtendimento.setFont(new Font("Lucida Sans", Font.BOLD, 10));
		lblAtendimento.setBounds(353, 107, 104, 16);
		panel.add(lblAtendimento);
		
		lblSalas = new JLabel("Novo Paciente");
		lblSalas.setForeground(new Color(0, 102, 204));
		lblSalas.setFont(new Font("Lucida Sans", Font.BOLD, 10));
		lblSalas.setBounds(152, 107, 77, 16);
		panel.add(lblSalas);
		
		btnNovo = new JButton("Novo");
		btnNovo.setBounds(159, 134, 62, 23);
		panel.add(btnNovo);
		
		btnConsulta = new JButton("Consultar");
		btnConsulta.setBounds(360, 134, 86, 23);
		panel.add(btnConsulta);
		
		lblVoltar = new JLabel("< Voltar");
		lblVoltar.setForeground(Color.BLACK);
		lblVoltar.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblVoltar.setBounds(521, 312, 55, 16);
		panel.add(lblVoltar);
		
		   ImageIcon background=new ImageIcon(LoginView.class.getResource("/resources/acesso_icon.ico"));
	    Image img=background.getImage();
	    Image temp=img.getScaledInstance(500,600,Image.SCALE_SMOOTH);
	    background=new ImageIcon(temp);
	}

}
