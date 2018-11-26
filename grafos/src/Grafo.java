import java.util.ArrayList;
import java.util.List;

public class Grafo {
	private List<No> nos;
	private List<Aresta> arestas;

	public Grafo() {
		nos = new ArrayList<>();
		arestas = new ArrayList<>();
	}

	public void addNo(No no) {
		this.nos.add(no);
	}

	public void addAresta(Aresta aresta) {
		this.arestas.add(aresta);
	}

	public List<No> getVizinhosDe(No no) {
		List<No> vizinhos = new ArrayList<>();
		for (Aresta aresta : arestas)
			if(aresta.getSource().equals(no))
				vizinhos.add(aresta.getTarget());
		return vizinhos;
	}

	public Aresta getAresta(No source, No target) {
		for (Aresta aresta : arestas)
			if(aresta.getSource().equals(source) && aresta.getTarget().equals(target))
				return aresta;

		return null;
	}
	
	public No getNo(String titulo) {
		for(No no : nos) {
			if(no.getTitulo().equals(titulo)) {
				return no;
			}
		}
		return null;
	}

	public List<Aresta> getArestas() {
		return arestas;
	}

	public List<No> getNos() {
		return nos;
	}

	public void setNos(List<No> nos) {
		this.nos = nos;
	}

	public void setArestas(List<Aresta> arestas) {
		this.arestas = arestas;
	}
	public No getNo(No no) {
		for (No aux : nos ) {
			if(aux.getTitulo().equals(no.getTitulo())) {
				return aux;
			}
		}
		return null;
		
	}
	

}
