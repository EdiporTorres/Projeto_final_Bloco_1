package coxinha.controller;

import java.util.ArrayList;

import coxinha.model.Coxinha;
import coxinha.repository.CoxinhaRepository;


public class CoxinhaController implements CoxinhaRepository {
	
	private ArrayList<Coxinha> listaProdutos = new ArrayList<Coxinha>();

	int num = 0;

	private int codigo;
	@Override
	public void procurarPorNumero(int codigo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listarTodas() {
		// TODO Auto-generated method stub
		for (var Coxinha : listaProdutos) {
			Coxinha.visualizar();
		}
		
	}

	@Override
	public void cadastrar(Coxinha Coxinha) {
		// TODO Auto-generated method stub
		listaProdutos.add(Coxinha);
		System.out.println("Produto cadastrado com successo ! "+Coxinha.getProduto());
	}

	@Override
	public void atualizar(Coxinha Coxinha) {
		// TODO Auto-generated method stub
		var buscarCoxinha = buscarNaColletion(Coxinha.getCodigo());
		 if (buscarCoxinha != null) {
			 listaProdutos.set(listaProdutos.indexOf(Coxinha), Coxinha);
			 System.out.println("Produto "+Coxinha.getProduto()+" Atualizado com sucesso");
		 }else 
			 System.out.println("Produto não encontrado");
		
	}

	@Override
	public void deletar(int codigo) {
		// TODO Auto-generated method stub
		var codigocox = buscarNaColletion(codigo);{
			if (codigocox != null) {
				if (listaProdutos.remove(codigocox) == true) 
					System.out.println("O produto de codigo" + codigo+ "Foi deletado");	
				}else 
					System.out.println("O Produto não foi encontrado");
		}
	}
	
	public int gerarNumero(){
		return ++codigo;
	}
	public Coxinha buscarNaColletion(int numero) {
		for (var Coxinha: listaProdutos) {
			if(Coxinha.getCodigo() == numero) {
				return Coxinha;
			}
		}
		return null;
	}
}
