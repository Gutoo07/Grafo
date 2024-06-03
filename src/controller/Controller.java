package controller;

import model.Grafo;
import model.ListaEncadeadaSimples;

public class Controller {
	public Controller() {
		super();
	}
	
	public void teste() throws Exception {
		Grafo g = new Grafo();
		
		/*g.add(0,1);
		g.add(0,4);
		g.add(1,2);
		g.add(1,3);
		g.add(1,4);
		g.add(2,3);
		g.add(3,4); */
		g.add("4");	
		g.test();
	}
}
