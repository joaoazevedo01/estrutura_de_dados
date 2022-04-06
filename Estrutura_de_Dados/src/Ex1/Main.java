package Ex1;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import javax.swing.JOptionPane;
import static java.lang.Integer.parseInt;
public class Main {
	static Lista<ContaCorrente> conta = new Lista<>();
	
	
	public static void main(String[] args) {
		
		int opcao;
		
		do {
			opcao= parseInt(showInputDialog(Menu()));
						if(opcao<1||opcao>6) {
							showMessageDialog(null, "Opção invalida");
							
						}else {
							switch (opcao) {
							case 1:
								ExecutaOP1(conta);
								break;
							case 2:
								ExecutaOP2(conta);
								break;
							case 3:
								ExecutaOP3(conta);;
									break;
							case 4:		
							
								conta.Imprimir();
								
								break;
							case 5:
								ExecutaOP5(conta);
								break;
							}
						}
			}while(opcao !=6);
			
		}

	
	public static void ExecutaOP1 (Lista<ContaCorrente> conta) {
		String opNome = showInputDialog("Informe seu nome: ");
		String opCpf = showInputDialog("Informe seu CPF");
		int cpf = Integer.parseInt(opCpf);
		
		if(conta.Pesquisar(new ContaCorrente(cpf,"",0)) == null) {
			ContaCorrente cc = new ContaCorrente(cpf, opNome, 0);
			conta.Inserir(cc);
			JOptionPane.showMessageDialog(null, "Sua conta foi criada com sucesso!\n" + "O CPF do Titular é: "+cc.cpf);
			
		} else {
			JOptionPane.showMessageDialog(null, "Você ja é nosso correntista!\n"+"Se quiser fazer alguma operação por favor volte ao menu.");
		}
		
	}
	
	public static void ExecutaOP2 (Lista<ContaCorrente> conta) {
		String opCpf = JOptionPane.showInputDialog("Informe seu CPF");
		int cpf = Integer.parseInt(opCpf);
		
		if(conta.Pesquisar(new ContaCorrente(cpf,"",0)) == null) {
			JOptionPane.showMessageDialog(null, "CPF errado ou você ainda não é nosso correntista.");
		} else {
			String valorSaque = JOptionPane.showInputDialog("Informe o valor a ser sacado: ");
			double valorS = Double.parseDouble(valorSaque);
			No<ContaCorrente> aux = conta.Pesquisar(new ContaCorrente(cpf,"",0));
			if(aux.dado.valorcc >= valorS) {
				
				aux.dado.Sacar(valorS);
			JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!\n"+"O seu saldo é de: R$ "+aux.dado.valorcc);
			} else {
				JOptionPane.showMessageDialog(null, "Seu saldo é inferior ao valor que deseja sacar!");
			}
		}
	}
	
	public static void ExecutaOP3 (Lista<ContaCorrente>conta) {
		String op3Cpf = JOptionPane.showInputDialog("Informe seu CPF");
		int cpf3 = Integer.parseInt(op3Cpf);
		
		if(conta.Pesquisar(new ContaCorrente(cpf3,"",0)) == null) {
			JOptionPane.showMessageDialog(null, "CPF errado ou você ainda não é nosso correntista.");
		} else {
			String valorDeposito = JOptionPane.showInputDialog("Informe o valor a ser depositado: ");
			double valorD = Double.parseDouble(valorDeposito);
			No<ContaCorrente> aux = conta.Pesquisar(new ContaCorrente(cpf3,"",0));
			aux.dado.Depositar(valorD);
			JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso!\n"+"O seu saldo é de: R$ "+aux.dado.valorcc);
			
		}
	}

	public static void ExecutaOP5 (Lista<ContaCorrente>conta) {
		String op3Cpf = JOptionPane.showInputDialog("Informe o CPF da conta a ser fechada:");
		int cpf3 = Integer.parseInt(op3Cpf);
		if(conta.Pesquisar(new ContaCorrente(cpf3,"",0)) == null) {
			JOptionPane.showMessageDialog(null, "CPF errado ou você ainda não é nosso correntista.");
		} else {
			conta.Remover(new ContaCorrente(cpf3,"",0));
			JOptionPane.showMessageDialog(null, "Sua conta corrente de CPF "+ cpf3 + " foi encerrada com sucesso");
		}
	}
	public static String Menu() {
		String menutxt = "Escolha uma opação: \n"+"[1] Abrir Conta \n"+"[2] Realizar Saque \n"
				+"[3] Realizar Depósito \n"+"[4] Relatório das Contas \n"+"[5] Encerrar Conta \n"
				+ "[6] Fechar App";
		
		return menutxt;
	}

}