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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;

/**
 * @author marcony.souza
 *
 */
public class PesquisaAtendimentoView extends JFrame{

	/**
	 * @author marcony.souza
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	  private JLabel titleLabel;
	  private JLabel lblMedico;

	
	public PesquisaAtendimentoView() {
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
		
		titleLabel = new JLabel("Pesquisa Atendimento");
		titleLabel.setForeground(new Color(47, 79, 79));
		titleLabel.setFont(new Font("Lucida Sans", Font.BOLD, 14));
		titleLabel.setBounds(214, 22, 167, 16);
		panel.add(titleLabel);
		
		JLabel lblNomeDoFuncionario = new JLabel("");
		lblNomeDoFuncionario.setForeground(new Color(0, 102, 204));
		lblNomeDoFuncionario.setFont(new Font("Lucida Sans", Font.BOLD, 10));
		lblNomeDoFuncionario.setBounds(10, 11, 204, 16);
		panel.add(lblNomeDoFuncionario);
		
		lblMedico = new JLabel("M\u00E9dico:");
		lblMedico.setForeground(new Color(0, 102, 204));
		lblMedico.setFont(new Font("Lucida Sans", Font.BOLD, 10));
		lblMedico.setBounds(275, 89, 44, 16);
		panel.add(lblMedico);
		
		JButton btnNovo_1 = new JButton("Consultar");
		btnNovo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNovo_1.setBounds(256, 266, 89, 23);
		panel.add(btnNovo_1);
		
		JLabel lblNewLabel = new JLabel("< Voltar");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewLabel.setBounds(534, 312, 55, 16);
		panel.add(lblNewLabel);
		
		JLabel lblPaciente = new JLabel("Paciente:");
		lblPaciente.setForeground(new Color(0, 102, 204));
		lblPaciente.setFont(new Font("Lucida Sans", Font.BOLD, 10));
		lblPaciente.setBounds(275, 153, 45, 16);
		panel.add(lblPaciente);
		
		JComboBox comboBoxMedico = new JComboBox();
		comboBoxMedico.setBounds(231, 108, 133, 26);
		panel.add(comboBoxMedico);
		
		JComboBox comboBoxPaciente = new JComboBox();
		comboBoxPaciente.setBounds(231, 175, 133, 26);
		panel.add(comboBoxPaciente);
		
		   ImageIcon background=new ImageIcon(LoginView.class.getResource("/resources/acesso_icon.ico"));
	    Image img=background.getImage();
	    Image temp=img.getScaledInstance(500,600,Image.SCALE_SMOOTH);
	    background=new ImageIcon(temp);
	}
}
