package Ex1;

public class ContaCorrente {
	int cpf;
	String nome;
	double valorcc;
	
	public ContaCorrente(int cpf, String nome, double valorcc) {
		this.cpf = cpf;
		this.nome = nome;
		this.valorcc = valorcc;
	}
	
	public void Depositar(double valor) {
		this.valorcc += valor;
	}
	
	public void Sacar(double valor) {
		if(valorcc > valor) {
			this.valorcc -= valor;
		}
	}
	
	public boolean equals(Object obj) {
		ContaCorrente aux = (ContaCorrente) obj;
		if(aux.cpf == cpf) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String aux = "";
		aux += "CPF: "+cpf+"\n";
		aux += "NOME: "+nome+"\n";
		aux += "SALDO: "+valorcc;
		return aux;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValorcc() {
		return valorcc;
	}

	public void setValorcc(double valorcc) {
		this.valorcc = valorcc;
	}
	
	
}
