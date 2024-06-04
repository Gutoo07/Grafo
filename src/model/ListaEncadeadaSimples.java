package model;
import model.No;
import java.lang.Exception;

public class ListaEncadeadaSimples<T> {
	private No<T> inicio = null;
	//private ListaEncadeadaSimples<T> listaLinkada = null;
	
	public void append(T elemento) {
		No<T> buffer = new No<>(elemento);
		if (this.inicio == null) {
			this.inicio = buffer;
		} else {
			this.last().setProximo(buffer);
		}
	}
	
	/*public void appendOrdena(T elemento) {
		No<T> buffer = new No<>(elemento);
		if (this.inicio == null) {
			this.inicio = buffer;
		} else {
			this.last().setProximo(buffer);
		}
		ordena();
	}*/
	public No<T> get(int index) throws IllegalArgumentException {			
			if (this.inicio == null) {
				throw new IllegalArgumentException("Lista vazia.");
			}			
			No<T> buffer = this.inicio;
			int i = 0;
			while (i < index) {
				buffer = buffer.getProximo();
				i++;
			}
			if ( buffer == null ) {
				throw new IllegalArgumentException("O indice informado nao existe.");
			}
			return buffer;
	}
	public No<T> get (T router) throws IllegalArgumentException {
		if (this.inicio == null) {
			return null;
		}
		No<T> buffer = this.inicio;
			while(buffer != null) {		
				if (buffer.getValor().equals(router)) {
					return buffer;
				}
				buffer = buffer.getProximo();
				
			}			
		return buffer;
	}
	/*public int index (T elemento) throws IllegalArgumentException {
		if (this.inicio == null) {
			throw new IllegalArgumentException("Lista vazia.");
		}
		int index = 0;
		if (this.inicio.getValor().equals(elemento)){
			return index;
		}
		No<T> buffer = this.inicio;
		while (buffer.getProximo() != null) {
			index++;
			buffer = buffer.getProximo();
			if (buffer.getValor().equals(elemento)) {
				return index;
			}
		}
		throw new IllegalArgumentException("Item nao encontrado na lista.");
	}*/
	public int index (T router) throws IllegalArgumentException {
		if (this.inicio == null) {
			throw new IllegalArgumentException("Lista vazia.");
		}
		int index = 0;
		if (this.inicio.getValor().equals(router)){
			return index;
		}
		No<T> buffer = this.inicio;
		while (buffer.getProximo() != null) {
			index++;
			buffer = buffer.getProximo();
			if (buffer.getValor().equals(router)) {
				return index;
			}
		}
		throw new IllegalArgumentException("Item nao encontrado na lista.");
	}
	/*public void insert (int index, T elemento) throws IllegalArgumentException {
		No<T> novo = new No<>(elemento);

		if (index == 0) {
			if (this.inicio != null) {
				No<T> buffer_inicio = this.inicio;
				novo.setProximo(buffer_inicio);
				this.inicio = novo;
			} else {
				this.inicio = novo;
			}
		} else {
			this.insert( this.get(--index) , elemento );
		}
	}*/
	/*public void insert (No<T> anterior, T elemento) throws IllegalArgumentException {
		No<T> novo = new No<>(elemento);
		No<T> buffer_proximo = anterior.getProximo();
		anterior.setProximo(novo);
		novo.setProximo(buffer_proximo);
	}*/
	public No<T> last() throws IllegalArgumentException {
		if (this.inicio == null) {
			throw new IllegalArgumentException ("Lista vazia.");
		}
		No<T> buffer = this.inicio;
		while (buffer.getProximo() != null) {
			buffer = buffer.getProximo();
		}
		return buffer;
	}
	/*Metodo de remover buscando por index
	public void remove (int index) throws IllegalArgumentException {
		if (index == 0) {
			if (this.inicio == null) {
				throw new IllegalArgumentException ("Lista vazia.");
			} else {
				this.inicio.setValor(null);
				if (this.inicio.getProximo() == null) {
					this.inicio = null;
				} else {
					No<T> buffer = this.inicio.getProximo();
					this.inicio.setProximo(null);
					this.inicio = buffer;
				}
				return;
			}
		}
		No<T> anterior = this.inicio;
		No<T> remover = null;
		for (int i = 0; i < index-1; i++) {
			anterior = anterior.getProximo();
			remover = anterior.getProximo();
		}
		No<T> anterior = this.get(index - 1);
		No<T> remover = this.get(index);
		No<T> remover_proximo = remover.getProximo();
		remover.setProximo(null);
		remover.setValor(null);
		anterior.setProximo(remover_proximo);
	}*/
	public void remove (T router) throws IllegalArgumentException {
		No<T> routers = this.inicio;
		while(routers != null) {
			ListaEncadeadaSimples listaLinkada = routers.getLink();
			listaLinkada.removeLink(router);
			routers = routers.getProximo();
		}
		if (this.inicio.getValor().equals(router)) {			
			this.inicio.setValor(null);
			if (this.inicio.getProximo() == null) {
				this.inicio = null;
			} else {
				No<T> buffer = this.inicio.getProximo();				
				this.inicio.setProximo(null);
				this.inicio = buffer;
			}
			return;
			}		
		No<T> anterior = this.get(index(router) - 1);
		No<T> remover = this.get(router);
		No<T> remover_proximo = remover.getProximo();
		remover.setProximo(null);
		remover.setValor(null);
		anterior.setProximo(remover_proximo);
		
	}
	public void removeLink(T router) {
		if (this.inicio.getValor().equals(router)) {			
			this.inicio.setValor(null);
			if (this.inicio.getProximo() == null) {
				this.inicio = null;
			} else {
				No<T> buffer = this.inicio.getProximo();
				this.inicio.setProximo(null);
				this.inicio = buffer;
			}
			return;
			}
		if (get(router) != null) {
			No<T> anterior = this.get(index(router) - 1);
			No<T> remover = this.get(router);
			No<T> remover_proximo = remover.getProximo();
			remover.setProximo(null);
			remover.setValor(null);
			anterior.setProximo(remover_proximo);
		}
	}
		
	
	public int total() {
		if (this.inicio == null) {
			return 0;
		}
		int total = 1;
		No<T> buffer = this.inicio;
		while (buffer.getProximo() != null) {
			buffer = buffer.getProximo();
			total++;
		}
		return total;
	}
	@Override
	public String toString() {
		if (this.inicio == null) {
			return "[]";
		}
		StringBuilder builder = new StringBuilder("[");
		No<T> buffer = this.inicio;
		builder.append( buffer.getValor() );
		while (buffer.getProximo() != null) {
			builder.append(",");
			buffer = buffer.getProximo();
			builder.append( buffer.getValor() );
		}
		builder.append("]");
		return builder.toString();
	}
	/*@Override
	public String toString() {
		if (this.inicio == null) {
			return "[]";
		}
		StringBuilder builder = new StringBuilder("[");
		No<T> buffer = this.inicio;
		builder.append( buffer.getValor() );
		while (buffer.getProximo() != null) {
			builder.append(": ");
			ListaEncadeadaSimples listaLinkada = buffer.getLink();
			System.out.println(listaLinkada.toString2(builder));
			buffer = buffer.getProximo();
			builder.append("[");
			builder.append( buffer.getValor() );
		}
		builder.append("]");
		return builder.toString();
	}*/
	public void output() {
		if (this.inicio == null) {
			System.out.println("[]");;
		}
		No<T> buffer = this.inicio;
		while (buffer != null) {
			System.out.print("["+buffer.getValor());
			System.out.print(": ");
			ListaEncadeadaSimples listaLinkada = buffer.getLink();
			listaLinkada.output2();
			buffer = buffer.getProximo();

		}
	}
	public void output2() {
		if (this.inicio == null) {
			System.out.print("()");;
		}
		No<T> buffer = this.inicio;
		System.out.print(buffer.getValor());
		while (buffer.getProximo() != null) {
			System.out.print(", ");
			buffer = buffer.getProximo();
			System.out.print(buffer.getValor());
		}
		System.out.print("]");
	
	}
	/*public void ordena() {
		for (int i = 0; i < total(); i++) {
			for (int j = 0; j < (total()-1); j++) {
				if ( (int)get(j).getValor() > (int)get(j+1).getValor() ) {
					T aux = get(j).getValor();
					get(j).setValor( get(j+1).getValor() );
					get(j+1).setValor(aux);
				}
			}			
		}
	}
	public void toArray() {
		int[] No = new int[total()];
		for (int i = 0; i < total(); i++) {
			No[i] = (int)get(i).getValor();
			if ( i == 0 ) {
				System.out.print(" ");
			}
			if ( i == total()-1 ) {
				System.out.println(No[i]);
			} else {
				System.out.print(No[i]);
				System.out.print(",");
			}
		}
		
	}*/
}






