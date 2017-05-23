package br.edu.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.dao.ClienteDAO;
import br.edu.tablemodel.ClienteTableModel;

import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class TListaCliente extends JFrame {

	private JPanel contentPane;
	private JTable tbClientes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TListaCliente frame = new TListaCliente();
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
	public TListaCliente() {
		initComponents();
		ClienteDAO clienteDAO = new ClienteDAO();
		ClienteTableModel ctm = 
				new ClienteTableModel(clienteDAO.listar());
		tbClientes.setModel(ctm);
	}
	
	public void initComponents(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tbClientes = new JTable();
		tbClientes.setBounds(12, 50, 404, 214);
		contentPane.add(tbClientes);
	}
}











