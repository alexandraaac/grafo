import java.util.ArrayList;
import java.util.List;
//alex


public class Main {

	public static void main(String[] args) throws Exception {
		Grafo grafo = new Grafo ();

		criarGrafo(grafo);
		//grafo = criarGrafotxt(grafo);

		System.out.println("gerando grafo");
		for(int i = 0 ; i < grafo.getNos().size() ; i++){
			ArrayList<No> noslist =  new ArrayList<No>();
			for(int j = 0 ; j < grafo.getNos().size() ; j++){
				No conectado = BL(grafo.getNos().get(i),grafo.getNos().get(j));
				if(conectado != null){
					noslist.add(conectado);
				}
			}
		}


	}


	//CRIA GRAFO PRIMARIO
	public static void criarGrafo(Grafo grafo) {


		No a = new No ("a");
		No b = new No ("b");
		No c = new No ("c");
		No d = new No ("d");
		No e = new No ("e");
		No f = new No ("f");

		Aresta ab = new Aresta(a,b,10,0);
		Aresta bc = new Aresta(b,c,4,0); 
		Aresta cd = new Aresta(c,d,10,0); 

		Aresta ae = new Aresta(a,e,10,0); 
		Aresta ef = new Aresta(e,f,9,0); 
		Aresta fd = new Aresta(f,d,10,0); 

		Aresta be = new Aresta(b,e,2,0); 
		Aresta bf = new Aresta(b,f,8,0); 
		Aresta cf = new Aresta(f,c,6,0); 

		a.addVizinho(ab);
		a.addVizinho(ae);
		b.addVizinho(bc);
		b.addVizinho(be);
		b.addVizinho(bf);
		c.addVizinho(cd);
		c.addVizinho(cf);

		grafo.addNo(a);
		grafo.addNo(b);
		grafo.addNo(c);
		grafo.addNo(d);
		grafo.addNo(e);
		grafo.addNo(f);

		grafo.addAresta(ab);
		grafo.addAresta(bc);
		grafo.addAresta(cd);

		grafo.addAresta(ae);
		grafo.addAresta(ef);
		grafo.addAresta(fd);

		grafo.addAresta(be);
		grafo.addAresta(bf);
		grafo.addAresta(cf);


	}
	//CRIA GRAFO PRIMARIO DE TXT
	public static Grafo criarGrafotxt(Grafo grafo) {
		ArrayList<String> dados = new ArrayList<String>();
		dados = Carregar.ler();
		int ctl = 0;
		String[] dado;

		for(String no : dados) {
			if(no.equals("arestas")) {
				ctl = 1;
			}

			if(ctl != 1 && !no.equals("nos")) {
				No node = new No(no);
				grafo.addNo(node);
			}
			else {
				if(!no.equals("arestas") && !no.equals("nos")) {
					dado = no.split(";");
					int capacidade = Integer.parseInt(dado[2]);
					int fluxo = Integer.parseInt(dado[3]);

					Aresta aresta = new Aresta(grafo.getNo(dado[0]),grafo.getNo(dado[1]),capacidade,fluxo);   
					grafo.addAresta(aresta);
				}
			}
		}

		return grafo;
	}
 



	//VERIFICA SE A ARESTA AXISTE
	public static boolean Contem(ArrayList<Aresta> arestasG,No source,No target ) {
		for(int i = 0 ; i < arestasG.size() ;i++) {
			if(arestasG.get(i).getSource() == source && arestasG.get(i).getTarget() == target ) {
				return true;
			}
		}

		return false;

	}



	//BUSCA EM LARGURA
	public static No BL (No inicio,No fim) {
		List<No> nos = new ArrayList<No>();
		No no = inicio;
		nos.add(no);


		while(nos.size() != 0 ) {
			no = nos.get(0);

			if(no.getTitulo().equals(fim.getTitulo())) { 
				return no;
			}else {
				List<No> vizinhos = new ArrayList<No>();
				vizinhos = vizinhos(no);
				nos.addAll(vizinhos);
				nos.remove(0);

			}
		}

		return null;
	}

	//BUSCA VIZINHOS
	public static List<No> vizinhos (No no) {
		List<No> vizinhos = new ArrayList<No>(no.getVizinhos());


		vizinhos.remove(no.getPai());

		for(int i = 0 ; i < vizinhos.size() ; i++) {
			if(vizinhos.get(i).getPai()==null) {
				vizinhos.get(i).setPai(no);


			}
		}
		return vizinhos;

	}


}