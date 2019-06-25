package programan;

import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		int i;
		Functionality func = new Functionality();
		do {
			
			System.out.println("Digite [0] se deseja parar o programa:");
			System.out.println("Digite [1] se deseja adicionar um empregado:");
			System.out.println("Digite [2] se deseja remover um empregado:");
			System.out.println("Digite [3] se deseja lançar um cartão de ponto:");
			System.out.println("Digite [4] se deseja lançar um resultado de venda:");
			System.out.println("Digite [5] se deseja lançar uma taxa de serviço:");
			System.out.println("Digite [6] se deseja alterar dados de um empregado:");
			System.out.println("Digite [7] se deseja rodar a folha de pagamento:");
			System.out.println("Digite [8] para Undo/Redo:");
			System.out.println("Digite [9] se deseja alterar sua agenda de pagamentos:");
			System.out.println("Digite [10] para criar uma nova agenda de pagamento:");
			System.out.println("Digite [11] se deseja listar os empregados:");

			i = sc.nextInt();
			
			if (i == 1) {
				System.out.println("Registrando um funcionario:");
				 func.addEmployee();
				 System.out.println("Registrado com sucesso");
			} else if (i == 2) {
				System.out.println("Removendo um funcionario:");
				func.removeEmployee();
			} else if (i == 3) {
				 System.out.println("Inputing timecard info.");
                 func.timeCard();
				
			} else if (i == 4) {

				
			} else if (i == 5) {
			} else if (i == 6) {

			} else if (i == 7) {
				
			} else if (i == 8) {
				
			} else if (i == 9) {
			} else if (i == 10) {
			}else if (i == 11) {
				System.out.println("Lista de Empregados:");
                func.showList();
			}
		} while (i != 0);

		sc.close();
	}

}
