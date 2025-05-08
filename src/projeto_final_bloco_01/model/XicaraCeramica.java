package projeto_final_bloco_01.model;

public class XicaraCeramica extends Produto {
	
	private String durabilidade;

	public XicaraCeramica(int id, String nome, int tipo, float preco, String durabilidade) {
		super(id, nome, tipo, preco);
		this.durabilidade = durabilidade;
	}

	public String getDurabilidade() {
		return durabilidade;
	}

	public void setDurabilidade(String durabilidade) {
		this.durabilidade = durabilidade;
	}
	
	
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Tipo da durabilidade da Xícara: " + this.durabilidade);
	}

}
