package br.edu.tablemodel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.edu.entidades.Cliente;

public class ClienteTableModel extends AbstractTableModel {

	private String[] colunas = new String[] {"Código", "Nome"};
	private List<Cliente> clientes;
	
	public ClienteTableModel(List<Cliente> clientes){
		this.clientes = clientes;
	}
	
	public int getRowCount() {
		return this.clientes.size();
	}

	public int getColumnCount() {
		return colunas.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Cliente cliente = clientes.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return cliente.getId();
		case 1:
			return cliente.getNome();
		default:
			break;
		}
		return null;
	}
	
	public Cliente getValueAt(int rowIndex){
		return clientes.get(rowIndex);
	}
	
	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return colunas[0];
		case 1:
			return colunas[1];
		default:
			break;
		}
	
		return null;
	}

}













































