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
public class FuncionarioView extends JFrame{

	private JFrame frame;
	private JPanel contentPane;
	  private JLabel titleLabel;
	  private JLabel lblNovoFuncionario;
	  private JLabel lblConsultar;
	  private JButton btnNovo;
	  private JLabel lblVoltar;

	
	public FuncionarioView() {
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
		
		titleLabel = new JLabel("Funcionarios");
		titleLabel.setForeground(new Color(47, 79, 79));
		titleLabel.setFont(new Font("Lucida Sans", Font.BOLD, 14));
		titleLabel.setBounds(251, 22, 92, 16);
		panel.add(titleLabel);
		
		JLabel lblNomeDoFuncionario = new JLabel("");
		lblNomeDoFuncionario.setForeground(new Color(0, 102, 204));
		lblNomeDoFuncionario.setFont(new Font("Lucida Sans", Font.BOLD, 10));
		lblNomeDoFuncionario.setBounds(10, 11, 204, 16);
		panel.add(lblNomeDoFuncionario);
		
		lblNovoFuncionario = new JLabel("Novo Funcionario");
		lblNovoFuncionario.setForeground(new Color(0, 102, 204));
		lblNovoFuncionario.setFont(new Font("Lucida Sans", Font.BOLD, 10));
		lblNovoFuncionario.setBounds(175, 99, 95, 16);
		panel.add(lblNovoFuncionario);
		
		lblConsultar = new JLabel("Consultar Funcionario");
		lblConsultar.setForeground(new Color(0, 102, 204));
		lblConsultar.setFont(new Font("Lucida Sans", Font.BOLD, 10));
		lblConsultar.setBounds(329, 99, 121, 16);
		panel.add(lblConsultar);
		
		btnNovo = new JButton("Novo");
		btnNovo.setBounds(190, 123, 65, 23);
		panel.add(btnNovo);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(343, 123, 92, 23);
		panel.add(btnConsultar);
		
		lblVoltar = new JLabel("< Voltar");
		lblVoltar.setForeground(Color.BLACK);
		lblVoltar.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblVoltar.setBounds(522, 312, 55, 16);
		panel.add(lblVoltar);
		
		   ImageIcon background=new ImageIcon(LoginView.class.getResource("/resources/acesso_icon.ico"));
	    Image img=background.getImage();
	    Image temp=img.getScaledInstance(500,600,Image.SCALE_SMOOTH);
	    background=new ImageIcon(temp);
	}
}
