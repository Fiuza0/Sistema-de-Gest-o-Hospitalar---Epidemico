package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import model.Atendimento;


public class ListaCargosView extends JFrame{

	private JPanel contentPane;

	
	public ListaCargosView() {
		
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
	
		JScrollPane scrollList = new javax.swing.JScrollPane();
		scrollList.setLocation(91, 48);
		scrollList.setSize(412,213);
				
		final JList<Atendimento> listCargos = new JList<Atendimento>();
		listCargos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listCargos.setModel(new AbstractListModel<Atendimento>() {
			private static final long serialVersionUID = 1L;
			List<Atendimento> listaHistorico = incluirValor();
			
			List<Atendimento> incluirValor(){
				
				//controller = new RotinaController();
			//	listaHistorico = controller.buscarLogs(rotina.getCdRotina());
				
		//		ListaHistoricoView.this.listaDeHistoricos = listaHistorico;
				return listaHistorico;
			}
			public int getSize() {
				return listaHistorico.size();
			}
			public Atendimento getElementAt(int index) {
				return listaHistorico.get(index);
			}
		});
		
		listCargos.setSelectedIndex(0);
		listCargos.setBounds(24, 16, 374, 202);
		scrollList.setViewportView(listCargos);
		
		/*listHistoricos.addKeyListener(new KeyAdapter() {
	         public void keyReleased(KeyEvent ke) {
	            if(ke.getKeyCode() == KeyEvent.VK_ENTER) {
	            	setVisible(false);
					dispose();
					HistoricoView historicoView = new HistoricoView(rotina, listHistoricos.getSelectedValue());
					historicoView.setLocationRelativeTo(null);
					dispatchEvent(new WindowEvent(historicoView, WindowEvent.WINDOW_OPENED));	            
					}
	         }
	      });

		listHistoricos.addMouseListener(new MouseAdapter() {
	         public void mouseClicked(MouseEvent me) {
	            if (me.getClickCount() == 2) {
	            	setVisible(false);
					dispose();
					HistoricoView historicoView = new HistoricoView(rotina, listHistoricos.getSelectedValue());
					historicoView.setLocationRelativeTo(null);
					dispatchEvent(new WindowEvent(historicoView, WindowEvent.WINDOW_OPENED));		
	            }
	         }
	      });*/
		panel.add(scrollList);
		
		JLabel lblCargos = new JLabel("Cargos");
		lblCargos.setForeground(new Color(47, 79, 79));
		lblCargos.setFont(new Font("Lucida Sans", Font.BOLD, 14));
		lblCargos.setBounds(270, 19, 55, 16);
		panel.add(lblCargos);
		
		JLabel lblNewLabel = new JLabel("< Voltar");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewLabel.setBounds(511, 305, 55, 16);
		panel.add(lblNewLabel);
		
		JLabel lblNomeDoFuncionario = new JLabel("");
		lblNomeDoFuncionario.setForeground(new Color(0, 102, 204));
		lblNomeDoFuncionario.setFont(new Font("Lucida Sans", Font.BOLD, 10));
		lblNomeDoFuncionario.setBounds(19, 6, 204, 16);
		panel.add(lblNomeDoFuncionario);
		
		/*JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVoltar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnVoltar.setBackground(Color.YELLOW);
		btnVoltar.setBounds(325, 223, 82, 22);
		btnVoltar.addMouseListener(new MouseAdapter() {
	         public void mouseClicked(MouseEvent me) {
	            if (me.getClickCount() == 1) {
	            	setVisible(false);
					dispose();
					List<Rotina> listAux = null;
					AlteraRotinaView alteraRotinaFrame = new AlteraRotinaView(rotina, listAux);
					alteraRotinaFrame.setLocationRelativeTo(null);
					dispatchEvent(new WindowEvent(alteraRotinaFrame, WindowEvent.WINDOW_OPENED));	
	            }
	         }
	      });
		panel.add(btnVoltar);
	*/}


}
