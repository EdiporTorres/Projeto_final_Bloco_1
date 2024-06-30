package coxinha.model;

public abstract class Coxinha {
	protected int codigo;
	private int tipo;
	private int quant;
	private String produto;


	public Coxinha(int codigo, int tipo, int quant, String produto) {
		this.codigo = codigo;
		this.tipo = tipo;
		this.quant = quant;
		this.produto = produto;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public int getTipo() {
		return tipo;
	}


	public void setTipo(int tipo) {
		this.tipo = tipo;
	}


	public int getQuant() {
		return quant;
	}


	public void setQuant(int quant) {
		this.quant = quant;
	}


	public String getProduto() {
		return produto;
	}


	public void setProduto(String produto) {
		this.produto = produto;
	}


	public void visualizar() {
		String tipo = " ";

		switch (this.tipo) {
		case 1:
			tipo = "Frito";
			break;
		case 2:
			tipo = "Assado";
			break;
		}
		System.out.println("\n\n***********************************************************");
		System.out.println("O produto escolhido para ver foi ::::");
		System.out.println("***********************************************************");
		System.out.println("Codigo do produto: " +this.codigo);
		System.out.println("Tipo do Produto " + tipo);
		System.out.println("Nome do Produto: "+  this.produto);
		System.out.println("Quantidade: : " + this.quant);
}

	public static void deletar(int codigo2) {
		// TODO Auto-generated method stub
		
	}}

