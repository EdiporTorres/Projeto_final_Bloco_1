package coxinha.model;

public class Coxinha {
	private int codigo;
	private int quant;
	private String produto;
	private int tipo;

	public Coxinha(int codigo, int quant, String produto, int tipo) {
		super();
		this.codigo = codigo;
		this.quant = quant;
		this.produto = produto;
		this.tipo = tipo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

}
