package controller;

import model.Grafo;

public class Controller {
	public Controller() {
		super();
	}
	
	public String teste() throws Exception {
		Grafo<Integer> g = new Grafo<Integer>();
		
		g.add(0,1);
		g.add(0,4);
		g.add(1,2);
		g.add(1,3);
		g.add(1,4);
		g.add(2,3);
		g.add(3,4);
		
		return g.toString();
	}
}
