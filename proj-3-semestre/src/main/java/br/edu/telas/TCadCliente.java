package br.edu.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.dao.ClienteDAO;
import br.edu.entidades.Cliente;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TCadCliente extends JFrame {

	private JPanel contentPane;
	private JTextField tfNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TCadCliente frame = new TCadCliente();
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
	public TCadCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfNome = new JTextField();
		tfNome.setBounds(0, 49, 114, 19);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		JButton btSalvar = new JButton("New button");
		btSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente();
				cliente.setNome(tfNome.getText().toString());
				
				ClienteDAO clienteDAO = new ClienteDAO();
				clienteDAO.salvar(cliente);
				
				limpaCampos();
				JOptionPane.showMessageDialog(null, 
						"Cliente cadastrado com sucesso!");
			}
		});
		btSalvar.setBounds(12, 183, 117, 25);
		contentPane.add(btSalvar);
	}
	
	public void limpaCampos(){
		tfNome.setText("");
	}
}









