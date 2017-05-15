package br.edu.dao;

import java.util.List;

public interface DAO<T> {

	public boolean salvar(T t);
	public boolean editar(T t);
	public boolean deletar(T t);
	public List<T> listar();
}
