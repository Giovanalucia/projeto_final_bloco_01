package projeto_final_bloco_01.model;

public class XicaraPlastico extends Produto {
	
	private String cor;

	public XicaraPlastico(int id, String nome, int tipo, float preco, String cor) {
		super(id, nome, tipo, preco);
		this.cor = cor;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Nome da cor do produto: " + this.cor);
	}

}
