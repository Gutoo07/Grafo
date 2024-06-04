package model;

public class No<T> {
	private T valor;
	private No<T> proximo;
	private ListaEncadeadaSimples listaLinkada = new ListaEncadeadaSimples();
	
	public No (T valor) {
		this.valor = valor;
		this.proximo = null;
	}
	public No (T valor, No<T> proximo) {
		this.valor = valor;
		this.proximo = proximo;
	}
	public void setValor(T valor) {
		this.valor = valor;
	}
	public T getValor() {
		return this.valor;
	}
	public void setProximo(No<T> proximo) {
		this.proximo = proximo;
	}
	public No<T> getProximo() {
		return this.proximo;
	}
	public void setLink(T router) {
		listaLinkada.append(router);
	}
	public ListaEncadeadaSimples getLink() {
		return this.listaLinkada;
	}
	@Override
		public String toString() {
			return valor.toString();
		}
}
	
