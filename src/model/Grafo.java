package model;

import model.ListaEncadeadaSimples;
import java.util.*;

public class Grafo<T> {
	//Vou escolher para este exemplo uma lista por LABEL
	//private Map< T, List<T> > map = new HashMap<>();
	private ListaEncadeadaSimples lista = new ListaEncadeadaSimples();
	
	//add: Adiciona novo elemento
	//has: Verifica se existe um elemento
	//size: Retorna o numero de elementos
	//toString(): imprime na tela
	
	public void add (T source) {
		//map.put(source, new LinkedList<T>());
		lista.append(source);
	}
	public String test() {
		return lista.toString();
	}
	public void add (T source, T  destination) {
		/*if (!map.containsKey(source)) {
			add(source);//se o primeiro parametro (router) nao existe, eu crio
		}
		if (!map.containsKey(destination)) {
			add(destination);
		}
		map.get(source).add(destination);//aqui eles se ligam (fazem referencia)
		map.get(destination).add(source);*/
		if (lista.get(source) == null) {
			lista.append(source);
			System.out.println("router " + source + " criado");
		}
		if (lista.get(destination) == null) {
			lista.append(destination);
			System.out.println("router  " + destination + " criado");
		}
		lista.get(source).setLink(destination);
		lista.get(destination).setLink(source);
		System.out.println("source " + source + " linkada com destination " + destination);
	}
	public void remove(T router) {
		lista.remove(router);
	}
	public boolean has (T s) {
		//return map.containsKey(s);
		if (lista.get(s) != null) {
			return true;
		}
		return false;
	}
	public boolean has (T s, T d) {
		//return map.get(s).contains(d);
		if (lista.get(s) != null && lista.get(d) != null) {
			return true;
		}
		return false;
	}
	public int size() {
		//return map.keySet().size();
		return lista.total();
	}
	/*public void remove(T remover) {
		if (lista.get(remover) == null) {
			throw new IllegalArgumentException("Router inexistente.");
		}
		lista.remove(remover);
	}*/
	//Escrever um output do grafo
	/*@Override public String toString() {
		StringBuilder builder = new StringBuilder();
		
		for (T v : map.keySet()) {
			builder.append(v.toString() + ": ");
			for (T w : map.get(v)) {
				builder.append(w.toString() + " ");
			}
			builder.append("\n");
		}
		return (builder.toString());
	}*/
	public void output() {
		lista.output();
	}	
}
