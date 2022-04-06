package Ex1;
import javax.swing.JOptionPane;

public class Lista<T> {
	
	int total;
	No<T> inicio, fim;
	
	public void Inserir(T dado) {
		No<T> aux = new No<>(dado);
		aux.dado = dado;
		if(total == 0) {
			inicio = aux;
		} else {
			fim.dir = aux;
			aux.esq = fim;
		}
		fim = aux;
		total++;
	}
	
	public No<T> Pesquisar(T dado){
		No<T> aux = inicio;
		boolean achou = false;
		while(aux != null && achou == false) {
			if(aux.dado.equals(dado)) {
				achou = true;
				break;
			}
			aux = aux.dir;
		}
		return aux;
	}
	
	public void Remover(T dado){
		No<T> aux = Pesquisar(dado);
		if(aux != null) {
			if(total == 1) {
				inicio = null;
				fim = null;
			} else if(aux == inicio){
				aux.dir.esq = null;
				inicio = aux.dir;
				aux.dir = null;
			} else if(aux == fim) {
				aux.esq.dir = null;
				fim = aux.esq;
				aux.esq = null;
			} else {
				aux.esq.dir = aux.dir;
				aux.dir.esq = aux.esq;
				aux.esq = null;
				aux.dir = null; 
			}
		total --;	
		}
	}
	
	public void Imprimir(){
		No<T> aux = inicio;
		int total2 = total;
		if (total2 == 0) {
			JOptionPane.showMessageDialog(null, "Não existem contas abertas");
		} else { while(total2 != 0) {
			String var = aux.dado.toString();
			JOptionPane.showMessageDialog(null, var);
			aux = aux.dir;
			total2 --;
		}
		}
	}
}
