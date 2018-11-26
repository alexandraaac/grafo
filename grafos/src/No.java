import java.util.ArrayList;
import java.util.List;

public class No {
	private String titulo;
	private No source;
	private List<Aresta> arestas = new ArrayList<Aresta>();


	public No(No no) {
		super();
	}

	public No(String titulo) {
		this.titulo = titulo;
		source = null;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public No getPai() {
		return source;
	}

	public void setPai(No pai) {
		this.source = pai;
	}
	public void addVizinho(Aresta a){
		this.arestas.add(a);
	}
	
	public List<No> getVizinhos() {
		
		List<No> vizinhos = new ArrayList<No>();
		
		for (Aresta aresta : arestas) {
			if(aresta.getSource().getTitulo().equals(this.getTitulo())){
				vizinhos.add(aresta.getTarget());
			}else{
				vizinhos.add(aresta.getSource());
			}
		}
		
		return vizinhos;
	}
	public Aresta getAresta(No no) {
		for (Aresta aresta : arestas) {
			if(aresta.getSource().getTitulo().equals(this.getTitulo()) && aresta.getTarget().getTitulo().equals(no.getTitulo())){
				return aresta;
			}
		}
		return null;
	}
	public Aresta getArestaPai(No no) {
		for (Aresta aresta : arestas) {
			if(aresta.getTarget().getTitulo().equals(this.getTitulo()) &&
					aresta.getSource().getTitulo().equals(no.getTitulo())){
				return aresta;
			}
		}
		return null;
	}
	@Override
	public boolean equals(Object obj) {
		No no = (No)obj;
		return no.getTitulo().equals(titulo);
	}
}
