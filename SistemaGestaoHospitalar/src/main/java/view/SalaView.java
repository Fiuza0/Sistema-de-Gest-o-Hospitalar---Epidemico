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
public class SalaView extends JFrame{


	/**
	 * @author marcony.souza
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	  private JLabel titleLabel;
	  private JLabel lblNovaSala;
	  private JLabel lblSalas;
	  private JButton btnNovo;
	  private JButton btnConsultar;
	  private JLabel lblVoltar;

	
	public SalaView() {
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
		
		titleLabel = new JLabel("Salas de Atendimento");
		titleLabel.setForeground(new Color(47, 79, 79));
		titleLabel.setFont(new Font("Lucida Sans", Font.BOLD, 14));
		titleLabel.setBounds(215, 22, 164, 16);
		panel.add(titleLabel);
		
		JLabel lblNomeDoFuncionario = new JLabel("");
		lblNomeDoFuncionario.setForeground(new Color(0, 102, 204));
		lblNomeDoFuncionario.setFont(new Font("Lucida Sans", Font.BOLD, 10));
		lblNomeDoFuncionario.setBounds(10, 11, 204, 16);
		panel.add(lblNomeDoFuncionario);
		
		lblNovaSala = new JLabel("Nova Sala");
		lblNovaSala.setForeground(new Color(0, 102, 204));
		lblNovaSala.setFont(new Font("Lucida Sans", Font.BOLD, 10));
		lblNovaSala.setBounds(168, 105, 56, 16);
		panel.add(lblNovaSala);
		
		lblSalas = new JLabel("Consultar Salas");
		lblSalas.setForeground(new Color(0, 102, 204));
		lblSalas.setFont(new Font("Lucida Sans", Font.BOLD, 10));
		lblSalas.setBounds(364, 105, 82, 16);
		panel.add(lblSalas);
		
		btnNovo = new JButton("Novo");
		btnNovo.setBounds(165, 121, 63, 23);
		panel.add(btnNovo);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(345, 121, 120, 23);
		panel.add(btnConsultar);
		
		lblVoltar = new JLabel("< Voltar");
		lblVoltar.setForeground(Color.BLACK);
		lblVoltar.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblVoltar.setBounds(518, 307, 55, 16);
		panel.add(lblVoltar);
		
		   ImageIcon background=new ImageIcon(LoginView.class.getResource("/resources/acesso_icon.ico"));
	    Image img=background.getImage();
	    Image temp=img.getScaledInstance(500,600,Image.SCALE_SMOOTH);
	    background=new ImageIcon(temp);
	}
	
}
