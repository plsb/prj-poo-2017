package br.edu.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.dao.ClienteDAO;
import br.edu.entidades.Cliente;
import br.edu.tablemodel.ClienteTableModel;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tbClientes.getSelectedRow()<0){
					JOptionPane.showMessageDialog(null, 
							"Selecione uma linha!");
				} else {
					ClienteTableModel ctm = (ClienteTableModel) 
												tbClientes.getModel();
					Cliente clienteASerExcluido = 
									ctm.getValueAt(tbClientes.getSelectedRow());
					ClienteDAO clienteDAO = new ClienteDAO();
					clienteDAO.deletar(clienteASerExcluido);
				}
			}
		});
		btnExcluir.setBounds(221, 285, 117, 25);
		contentPane.add(btnExcluir);
	}
	
	public void initComponents(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tbClientes = new JTable();
		tbClientes.setBounds(12, 24, 404, 214);
		contentPane.add(tbClientes);
	}
}











