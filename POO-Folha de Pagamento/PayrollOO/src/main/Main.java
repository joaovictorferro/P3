package main;


import java.util.Locale;
import functionality.*;
import utilitarios.Exceptions;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Exceptions exceptions = new Exceptions();
        Functionality func = new Functionality();
		int i;
		do {
			System.out.println(func.calendar.day + "/" + func.calendar.month + "/" + func.calendar.year);
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

			i = exceptions.integerInput();
			
			if (i>=1 && i < 8) {
				func.emptyRedo();
				func.copyRegister();
			}
			
			if (i == 1) {
				System.out.println("Registrando um funcionario:");
				 func.addEmployee();
				 System.out.println("Registrado com sucesso");
			} else if (i == 2) {
				System.out.println("Removendo um funcionario:");
				func.removeEmployee();
			} else if (i == 3) {
				 System.out.println("Insira o cartao de Ponto do funcionario:");
                 func.timeCard();
			} else if (i == 4) {
				System.out.println("Adicionar resultados de venda:");
				func.saleResult();
			} else if (i == 5) {
				System.out.println("Adicionar taxa de servico:");
                 func.serviceTax();
			} else if (i == 6) {
				System.out.println("Editar um funcionario");
				func.editEmployee();
			} else if (i == 7) {
				System.out.println("Rodar Folha de pagamento:");
				func.payroll();
				System.out.println("Encerrado um dia de atividades do sistema:\n");
                int monthBeforeUpdate = func.calendar.month;
                func.calendar.dateUpgrade();
                if(monthBeforeUpdate != func.calendar.month){
                    func.resetServiceTax();
                }
			} else if (i == 8) {
				System.out.println("Digite [1] para undo e [2] para redo");
				int opc = exceptions.integerInput();
				while(opc < 0 || opc > 2) {
					System.out.println("Digite uma valor entre 1 - 2");
					opc = exceptions.integerInput();
				}
				if(opc == 1) {
					func.undo();
				}else if(opc == 2){
					func.redo();
				}
			} else if (i == 9) {
				System.out.println("Modificar a agenda do funcionario Default.\n");
                func.newAgendaDefault();
			} else if (i == 10) {
				System.out.println("Modificar a agenda do funcionario.\n");
				func.newAgenda();
			}else if (i == 11) {
				System.out.println("Lista de Empregados:");
                func.showList();
			}
		} while (i != 0);
	}
}
