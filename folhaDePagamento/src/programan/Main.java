package programan;

import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		int i;
		int diaMes = 1;
		int mes = 1;
		int id = 0;
		int semanaQ = 0;
		Scanner sc = new Scanner(System.in);
		// String buffer;

		String[][] empregado = new String[100][15];

		int[] idLivres = new int[100];
		int j;

		for (j = 0; j < 100; j++) {
			idLivres[j] = 0;
		}

		do {

			if (diaMes > 30) {
				mes += 1;
				diaMes = 1;
			}

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

				for (j = 0; j < 100; j++) {
					if (idLivres[j] == 0) {
						id = j;
					}
				}

				System.out.println("Digite o nome do empregado:(somente o primeiro nome)");
				empregado[id][0] = sc.next();
				System.out.println("Digite o endereço do empregado:");
				empregado[id][1] = sc.next();
				System.out.println("Digite se o empregado é Horista ou Assalariado:");
				empregado[id][2] = sc.next();

				// System.out.println(empregado[id][2]);
				if (empregado[id][2].equals("Horista")) {
					System.out.println("Digite o valor da hora trabalhada do empregado:");
					empregado[id][3] = sc.next();
					empregado[id][4] = "Nao";
					empregado[id][5] = "0";
					empregado[id][6] = "sexta";
					empregado[id][7] = "1";
				} else if (empregado[id][2].equals("Assalariado")) {
					System.out.println("Digite o salário do empregado:");
					empregado[id][14] = sc.next();
					System.out.println("O empregado é comissionado?(Sim/Nao)");
					empregado[id][4] = sc.next();

					if (empregado[id][4].equals("Sim")) {
						System.out.println("Digite o valor da comissão em porcentagem:");
						empregado[id][5] = sc.next();
						empregado[id][6] = "sexta";
						empregado[id][7] = "1";
					} else {
						empregado[id][5] = "0";
						empregado[id][6] = "mensalmente";
						empregado[id][7] = "0";
						empregado[id][8] = "30";
					}
				}

				System.out.println(
						"Digite o método de pagamento:(cheque pelos correios digite:(chequeC)/cheque em mãos digite: (chequeM) /depósito em conta bancária) digite: (contaB)");
				empregado[id][9] = sc.next();
				System.out.println("O empregado pertence ao sindicato?(Sim/Nao)");
				empregado[id][10] = sc.next();

				if (empregado[id][10].equals("Sim")) {
					empregado[id][11] = Integer.toString(id);
					System.out.println("Digite o valor $ da taxa sindical:");
					empregado[id][12] = sc.next();
				}
				System.out.println("O ID do empregado é: " + id + "\n");

				idLivres[id] = 1;
			} else if (i == 2) {

				System.out.println("Digite o ID do empregado que deseja remover:");
				int ID = sc.nextInt();
				idLivres[ID] = 0;

				empregado[ID][0] = null;
				empregado[ID][1] = null;
				empregado[ID][2] = null;
				empregado[ID][3] = null;
				empregado[ID][4] = null;
				empregado[ID][5] = null;
				empregado[ID][6] = null;
				empregado[ID][7] = null;
				empregado[ID][8] = null;
				empregado[ID][9] = null;
				empregado[ID][10] = null;
				empregado[ID][11] = null;
				empregado[ID][12] = null;
				empregado[ID][13] = null;
				empregado[ID][14] = null;
				System.out.println("Removido com sucesso!!");
			} else if (i == 3) {

				System.out.println("Digite o ID do empregado que deseja lançar o cartão de ponto:");
				int Id = sc.nextInt();
				
				if (empregado[Id][2].equals("Horista")) {
					System.out.println("Digite a hora de entrada:(Formato 24h)");
					int HoradeEntrada = sc.nextInt();
					System.out.println("Digite o minuto de entrada:");
					int MinutodeEntrada = sc.nextInt();
					System.out.println("Digite a hora de saída:(Formato 24h)");
					int HoradeSaida = sc.nextInt();
					System.out.println("Digite o minuto de saída:");
					int MinutodeSaida = sc.nextInt();

					int TempoemMinutos = (HoradeSaida * 60 + MinutodeSaida) - (HoradeEntrada * 60 + MinutodeEntrada);
					int TempoExtra = TempoemMinutos - 480;
					double result = Double.parseDouble(empregado[Id][3]);
					double resultSalario = Double.parseDouble(empregado[Id][14]);
					double diaria = 0;
					int diarias = Integer.parseInt(empregado[Id][13]);

					if (TempoExtra > 0) {
						TempoemMinutos -= TempoExtra;
						diaria += TempoExtra * 1.5 * result / 60;
					}

					diaria += TempoemMinutos * result / 60;
					resultSalario += diaria;
					diarias += 1;

					empregado[Id][14] = Double.toString(resultSalario);
					empregado[Id][13] = Integer.toString(diarias);
				} else {
					System.out.println("O empregado não é Horista.");
				}

			} else if (i == 4) {

				System.out.println("Digite o id do empregado que deseja lançar o resultado de venda:");
				id = sc.nextInt();
				sc.nextLine();
				if (empregado[id][4].equals("Sim")) {
					System.out.println("Digite o valor da venda:");
					double res = sc.nextDouble();
					double res2 = Double.parseDouble(empregado[id][5]);
					res = res * res2 / 100;
					double resSalario = Double.parseDouble(empregado[id][14]);

					resSalario += res;
					empregado[id][14] = Double.toString(resSalario);
				} else {
					System.out.println("O empregado não é comissionado.");
				}

			} else if (i == 5) {

				System.out.println("Digite o ID do empregado que deseja lançar uma taxa de serviço:");
				id = sc.nextInt();
				if (empregado[id][10].equals("Sim")) {
					System.out.println("Digite o valor da taxa de serviço:");
					double res = Double.parseDouble(empregado[id][12]);
					res += sc.nextDouble();
					empregado[id][12] = Double.toString(res);
				}
			} else if (i == 6) {

				System.out.println("Digite o ID do empregado:");
				id = sc.nextInt();
				sc.nextLine();
				System.out.println("Deseja alterar o nome do empregado?(Sim/Nao)");
				String resposta = sc.nextLine();
				if (resposta.equals("Sim")) {
					System.out.println("Digite o novo nome:");
					empregado[id][0] = sc.nextLine();
				}
				System.out.println("Deseja alterar o endereço do empregado:(Sim/Nao)");
				resposta = sc.nextLine();
				if (resposta.equals("Sim")) {
					System.out.println("Digite o novo endereço:");
					empregado[id][1] = sc.nextLine();
				}
				System.out.println("Deseja mudar o tipo (Horista/Assalariado) do empregado?(Sim/Nao)");
				resposta = sc.nextLine();
				if (resposta.equals("Sim")) {
					if (empregado[id][2].equals("Horista")) {
						empregado[id][2] = "Assalariado";
						empregado[id][8] = "30";
						empregado[id][6] = "mensalmente";
						System.out.println("Digite o novo salário:");
						empregado[id][14] = sc.next();
						System.out.println("O empregado será comissionado?(Sim/Nao)");
						empregado[id][4] = sc.next();
						if (empregado[id][4].equals("Sim")) {
							System.out.println("Digite a comissão do empregado em porcentagem:");
							empregado[id][5] = sc.next();
							empregado[id][7] = "2";
							empregado[id][8] = "sexta";
						}
					} else {
						empregado[id][2] = "Horista";
						empregado[id][7] = "1";
						empregado[id][6] = "sexta";
						System.out.println("Digite o valor da hora trabalhada:");
						empregado[id][14] = sc.next();
						empregado[id][4] = "Nao";
						empregado[id][5] = "0";
					}
				}
				System.out.println("Deseja mudar o método de pagamento do empregado?(Sim/Nao)");
				resposta = sc.nextLine();
				if (resposta.equals("Sim")) {
					System.out.println(
							"Digite o método de pagamento:(cheque pelos correios digite:(chequeC)/cheque em mãos digite: (chequeM) /depósito em conta bancária) digite: (contaB)");
					empregado[id][9] = sc.nextLine();
				}
				if (empregado[id][10].equals("Sim")) {
					System.out.println("Deseja que o empregado saia do sindicato?(Sim/Nao)");
					resposta = sc.nextLine();
					if (resposta.equals("Sim")) {
						empregado[id][10] = "Nao";
						empregado[id][11] = null;
						empregado[id][12] = null;
					}
				} else if (empregado[id][10].equals("Nao")) {
					System.out.println("Deseja que o empregado entre no sindicato?(Sim/Nao)");
					resposta = sc.nextLine();
					if (resposta.equals("Sim")) {
						empregado[id][10] = "Sim";
						String ID = Integer.toString(id);
						empregado[id][11] = ID;
						System.out.println("Digite o valor da taxa sindical $$:");
						empregado[id][12] = sc.next();
					}
				}
			} else if (i == 7) {

				String[] semana = { "domingo", "segunda", "terça", "quarta", "quinta", "sexta", "sabado" };
				String[] meses = { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto",
						"Setembro", "Outubro", "Novembro", "Dezembro" };
				String diadaSemana = semana[(diaMes + 2 * mes) % 7];
				System.out.println("Data: " + diaMes + "/" + meses[mes] + "   Dia da Semana: " + diadaSemana);

				for (i = 0; i < 100; i++) {
					if (empregado[i][4].equals("Sim")) {
						double n = Double.parseDouble(empregado[i][14]);
						n += n / 30;
						empregado[i][14] = Double.toString(n);

						if (diadaSemana.equals("domingo")) {
							semanaQ += 1;
							if (semanaQ > 4) {
								semanaQ -= 4;
							}
						}
						if (semanaQ % 2 == 0 && diadaSemana.equals(empregado[i][8])) {
							double salarioP = Double.parseDouble(empregado[i][14]);
							empregado[i][14] = "0";
							double despesas = 0;
							if (empregado[i][10].equals("Sim")) {
								despesas += Double.parseDouble(empregado[i][12]);
							}
							salarioP -= despesas;
							System.out.println("Salário do empregado " + empregado[i][0] + ": R$" + salarioP + "\n");
						}
					} else if (empregado[i][2].equals("Assalariado")) {
						double n = Double.parseDouble(empregado[i][14]);
						n += n / 30;
						int diaReceber = Integer.parseInt(empregado[i][8]);
						if (diadaSemana.equals("sexta") && diaMes + 1 == diaReceber
								|| diadaSemana.equals("sexta") && diaMes + 2 == diaReceber) {
							double salarioP = Double.parseDouble(empregado[i][14]);
							empregado[i][14] = "0";
							double despesas = 0;

							if (empregado[i][10].equals("Sim")) {
								despesas += Double.parseDouble(empregado[i][12]);
							}
							salarioP -= despesas;
							System.out.println("Salário do empregado " + empregado[i][0] + ": R$" + salarioP + "\n");
						} else if (diaMes == Double.parseDouble(empregado[i][8]) && !diadaSemana.equals("sabado")
								&& !diadaSemana.equals("domingo")) {
							double salarioP = Double.parseDouble(empregado[i][14]);
							empregado[i][14] = "0";
							double despesas = 0;

							if (empregado[i][10].equals("Sim")) {
								despesas += Double.parseDouble(empregado[i][12]);
							}
							salarioP -= despesas;
							System.out.println("Salário do empregado " + empregado[i][0] + ": R$" + salarioP + "\n");
						}
					} else if (empregado[i][2].equals("Horista")) {
						if (diadaSemana.equals(empregado[i][6])) {
							double salarioP = Double.parseDouble(empregado[i][14]);
							empregado[i][14] = "0";
							double despesas = 0;
							if (empregado[i][10].equals("Sim")) {
								despesas += Double.parseDouble(empregado[i][12]);
							}
							salarioP -= despesas;
							System.out.println("Salário do empregado " + empregado[i][0] + ": R$" + salarioP + "\n");
						}
					}
				}
				diaMes += 1;

			} else if (i == 8) {

			} else if (i == 9) {

				System.out.println("Digite o ID do empregado:");
				id = sc.nextInt();
				sc.nextLine();
				System.out.println("Escolha uma das seguintes agendas de pagamento:");

				if (empregado[id][2].equals("Assalariado")) {
					System.out.println("Digite o novo dia de receber:");
					empregado[id][8] = sc.next();
				} else {
					System.out.println("Digite o novo dia para receber:");
					empregado[id][6] = sc.next();
				}
				System.out.println("Agenda alterada com sucesso.");

			} else if (i == 10) {

				System.out.println(
						"Digite [1] se deseja criar uma nova agenda de pagamentos para horistas e comissionados:");
				System.out.println("Digite [2] se deseja criar uma nova agenda de pagamentos para assalariados:");
				// int n = sc.nextInt();
				sc.nextLine();

				// if(n == 1) {
				// System.out.println("Digite um dia da semana (entre segunda e sexta) para ser
				// uma nova agenda de pagamento:");
				// String agenda = sc.nextLine();
				// int flag = 0;

				// for(String s: agendadePagamentosSemanal) {
				// if(s.equals(agenda)) {
				// flag = 1;
				// }
				// }
				// if(flag == 0) {
				// agendadePagamentosSemanal.add(agenda);
				// }
				// } else if(n == 2){
				// System.out.println("Digite um dia do mês (entre 1 e 30) para ser uma nova
				// agenda de pagamento:");
				// int agenda = sc.nextInt();
				// int flag = 0;
				// for(Integer i: agendadePagamentosMensal) {
				// if(i == agenda) {
				// flag = 1;
				// }
				// }
				// if(flag == 0) {
				// agendadePagamentosMensal.add(agenda);
				// }
				// }
			} else if (i == 11) {

				int k = 0;
				for (k = 0; k < 100; k++) {
					if (idLivres[k] != 0) {
						System.out.printf("Nome: " + empregado[k][0] + " Endereco: " + empregado[k][1] + " Tipo: "
								+ empregado[k][2] + " Valor de hora trabalhada: " + empregado[k][3] + " Comissionado: "
								+ empregado[k][4] + " Comissao: " + empregado[k][5] + " Agenda de Pagamento: "
								+ empregado[k][6] + " Semana: " + empregado[k][7] + " Dia de receber: "
								+ empregado[k][8] + " Metodo de Pagamento: " + empregado[k][9] + " Sindicato: "
								+ empregado[k][10] + " Identificacao no Sindicato: " + empregado[k][11]
								+ " Taxa de Sindicato: " + empregado[k][12] + "Salario: " + empregado[k][14] + "\n");

					}
				}
			}
		} while (i != 0);

		sc.close();
	}
}