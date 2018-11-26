public class Aresta {
	private No source;
	private No target;
	private int peso;
	private int capacidade;
	private int fluxo;
	private Aresta residual;
	private Aresta origem;

	public Aresta(No source, No target, int capacidade, int fluxo) {
		this.source = source;
		this.target = target;
		this.fluxo = fluxo;
		this.capacidade = capacidade;
	}

	public void setFluxo(int fluxo) {
		this.fluxo = fluxo;
	}

	public int getFluxo() {
		return fluxo;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public int getCapacidade() {
		return capacidade;
	}


	public int getCapResidual() {
		return capacidade - fluxo;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public No getSource() {
		return source;
	}

	public void setSource(No source) {
		this.source = source;
	}

	public No getTarget() {
		return target;
	}

	public void setTarget(No target) {
		this.target = target;
	}

	public Aresta getResidual() {
		return residual;
	}

	public void setResidual(Aresta residual) {
		this.residual = residual;
	}

	public Aresta getOrigem() {
		return origem;
	}

	public void setOrigem(Aresta origem) {
		this.origem = origem;
	}
}
