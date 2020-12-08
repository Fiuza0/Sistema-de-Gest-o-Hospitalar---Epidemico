/**
 * @author marcony.souza
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import model.Atendimento;
import services.AtendimentoServices;

/**
 * @author marcony.souza
 *
 */
public class AtendimentoView extends JFrame{

	/**
	 * @author marcony.souza
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	  private JLabel titleLabel;
	  private JLabel lblConsultar;
	  private JLabel lblNovoAtendimento;
	  private JLabel lblFinalizar;

	
	public AtendimentoView() {
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
		
		titleLabel = new JLabel("Atendimento");
		titleLabel.setForeground(new Color(47, 79, 79));
		titleLabel.setFont(new Font("Lucida Sans", Font.BOLD, 14));
		titleLabel.setBounds(247, 22, 100, 16);
		panel.add(titleLabel);
		
		JLabel lblNomeDoFuncionario = new JLabel("");
		lblNomeDoFuncionario.setForeground(new Color(0, 102, 204));
		lblNomeDoFuncionario.setFont(new Font("Lucida Sans", Font.BOLD, 10));
		lblNomeDoFuncionario.setBounds(10, 11, 204, 16);
		panel.add(lblNomeDoFuncionario);
		
		lblConsultar = new JLabel("Consultar Atendimento");
		lblConsultar.setForeground(new Color(0, 102, 204));
		lblConsultar.setFont(new Font("Lucida Sans", Font.BOLD, 10));
		lblConsultar.setBounds(239, 89, 129, 16);
		panel.add(lblConsultar);
		
		lblNovoAtendimento = new JLabel("Novo Atendimento");
		lblNovoAtendimento.setForeground(new Color(0, 102, 204));
		lblNovoAtendimento.setFont(new Font("Lucida Sans", Font.BOLD, 10));
		lblNovoAtendimento.setBounds(59, 89, 100, 16);
		panel.add(lblNovoAtendimento);
		
		lblFinalizar = new JLabel("Finalizar Atendimentos");
		lblFinalizar.setForeground(new Color(0, 102, 204));
		lblFinalizar.setFont(new Font("Lucida Sans", Font.BOLD, 10));
		lblFinalizar.setBounds(406, 89, 121, 16);
		panel.add(lblFinalizar);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setBounds(69, 105, 79, 23);
		panel.add(btnNovo);
		
		JButton btnNovo_1 = new JButton("Consultar");
		btnNovo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNovo_1.setBounds(253, 105, 89, 23);
		panel.add(btnNovo_1);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setBounds(416, 105, 89, 23);
		panel.add(btnFinalizar);
		
		JLabel lblNewLabel = new JLabel("< Voltar");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewLabel.setBounds(534, 312, 55, 16);
		panel.add(lblNewLabel);
		
		   ImageIcon background=new ImageIcon(LoginView.class.getResource("/resources/acesso_icon.ico"));
	    Image img=background.getImage();
	    Image temp=img.getScaledInstance(500,600,Image.SCALE_SMOOTH);
	    background=new ImageIcon(temp);
	}
}
