package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import model.Produto;
import repository.EstoqueDAO;
import repository.ProdutoDAO;


public class ListaProdutosView extends JFrame{

	/**
	 * @author marcony.souza
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	ProdutoDAO produtoDAO = new ProdutoDAO();
	EstoqueDAO estoqueDAO = new EstoqueDAO();
	
	public ListaProdutosView() throws SQLException {
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
				
		final JList<Produto> listProdutos = new JList<Produto>();
		listProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listProdutos.setModel(new AbstractListModel<Produto>() {
			private static final long serialVersionUID = 1L;
			List<Produto> listaProdutos = incluirValor();
			
			List<Produto> incluirValor() throws SQLException{
				
				listaProdutos = produtoDAO.consultarProdutos();
				
				return listaProdutos;
			}
			public int getSize() {
				return listaProdutos.size();
			}
			public Produto getElementAt(int index) {
				return listaProdutos.get(index);
			}
		});
		
		listProdutos.setSelectedIndex(0);
		listProdutos.setBounds(24, 16, 374, 202);
		scrollList.setViewportView(listProdutos);
	
		listProdutos.addKeyListener(new KeyAdapter() {
	         public void keyReleased(KeyEvent ke) {
	            if(ke.getKeyCode() == KeyEvent.VK_ENTER) {
	            	setVisible(false);
					dispose();
					ConsultaProdutoView produtoView = new ConsultaProdutoView(listProdutos.getSelectedValue());
					produtoView.setLocationRelativeTo(null);
					dispatchEvent(new WindowEvent(produtoView, WindowEvent.WINDOW_OPENED));	            
					}
	         }
	      });

		listProdutos.addMouseListener(new MouseAdapter() {
	         public void mouseClicked(MouseEvent me) {
	            if (me.getClickCount() == 2) {
	            	setVisible(false);
					dispose();
					ConsultaProdutoView consultaProdutoView = new ConsultaProdutoView(listProdutos.getSelectedValue());
					consultaProdutoView.setLocationRelativeTo(null);
					dispatchEvent(new WindowEvent(consultaProdutoView, WindowEvent.WINDOW_OPENED));		
	            }
	         }
	      });
		panel.add(scrollList);
		
		JLabel lblProdutos = new JLabel("Produtos");
		lblProdutos.setForeground(new Color(47, 79, 79));
		lblProdutos.setFont(new Font("Lucida Sans", Font.BOLD, 14));
		lblProdutos.setBounds(265, 19, 65, 16);
		panel.add(lblProdutos);
		
		JLabel lblVoltar = new JLabel("< Voltar");
		lblVoltar.setForeground(Color.BLACK);
		lblVoltar.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblVoltar.setBounds(511, 305, 55, 16);
		panel.add(lblVoltar);
		
		JLabel lblNomeDoFuncionario = new JLabel("");
		lblNomeDoFuncionario.setForeground(new Color(0, 102, 204));
		lblNomeDoFuncionario.setFont(new Font("Lucida Sans", Font.BOLD, 10));
		lblNomeDoFuncionario.setBounds(19, 6, 204, 16);
		panel.add(lblNomeDoFuncionario);
	
		
		lblVoltar.addMouseListener(new MouseAdapter() {
	         public void mouseClicked(MouseEvent me) {
	            if (me.getClickCount() == 1) {
	            	setVisible(false);
					dispose();
					ProdutoView produtoView = new ProdutoView();
					produtoView.setLocationRelativeTo(null);
					dispatchEvent(new WindowEvent(produtoView, WindowEvent.WINDOW_OPENED));	
	            }
	         }
	      });
	}


}
