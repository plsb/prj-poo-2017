package br.edu.dao;

import java.util.List;

import br.edu.entidades.Cliente;
import br.edu.util.HibernateUtil;

public class ClienteDAO 
			extends GenericDAO<Cliente>{

	public List<Cliente> listar() {
		List<Cliente> clientes = null;
		try{
			this.sessao = HibernateUtil.getSessionFactory()
					.openSession();
			clientes = this.sessao.createCriteria(Cliente.class).list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			this.sessao.close();
		}		
		return clientes;
	}

}
