package coxinha.repository;

import coxinha.model.Coxinha;

public interface CoxinhaRepository {
	public void procurarPorNumero(int codigo);
	public void listarTodas();
	public void cadastrar(Coxinha Coxinha);
	public void atualizar(Coxinha Coxinha);
	public void deletar(int codigo);
}
