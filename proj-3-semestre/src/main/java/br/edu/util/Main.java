package br.edu.util;

import br.edu.dao.ClienteDAO;
import br.edu.entidades.Cliente;

public class Main {
	
	public static void main(String[] args) {
		ClienteDAO clienteDAO = new ClienteDAO();
		
		Cliente cliente = new Cliente();
		cliente.setNome("José Augusto");

		clienteDAO.salvar(cliente);
			
	}

}
