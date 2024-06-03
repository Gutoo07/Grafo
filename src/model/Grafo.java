package model;

import java.util.*;

public class Grafo<T> {
	//Vou escolher para este exemplo uma lista por LABEL
	private Map< T,List<T> > map = new HashMap<>();
	
	//add: Adiciona novo elemento
	//has: Verifica se existe um elemento
	//size: Retorna o numero de elementos
	//toString(): imprime na tela
	
	public void add (T source) {
		map.put(source, new LinkedList<T>());
	}
	public void add (T source, T  destination) {
		if (!map.containsKey(source)) {
			add(source);//se o primeiro parametro (router) nao existe, eu crio
		}
		if (!map.containsKey(destination)) {
			add(destination);
		}
		map.get(source).add(destination);//aqui eles se ligam (fazem referencia)
		map.get(destination).add(source);
	}
	public boolean has (T s) {
		return map.containsKey(s);
	}
	public boolean has (T s, T d) {
		return map.get(s).contains(d);
	}
	public int size() {
		return map.keySet().size();
	}
	//Escrever um output do grafo
	@Override public String toString() {
		StringBuilder builder = new StringBuilder();
		
		for (T v : map.keySet()) {
			builder.append(v.toString() + ": ");
			for (T w : map.get(v)) {
				builder.append(w.toString() + " ");
			}
			builder.append("\n");
		}
		return (builder.toString());
	}
}
