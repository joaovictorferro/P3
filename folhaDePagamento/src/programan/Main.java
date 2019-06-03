package programan;

import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		int i;
		int diaMes = 1;
		int mes = 0;
		int id = 0;
		int semanaQ = 1;
		Scanner sc = new Scanner(System.in);

		String[][] empregado = new String[100][15];
		String[][] undo = new String[1000][15];
		String[][] redo = new String[1000][15];
		
		int[] idLivres = new int[100];
		int j,q,stop=0,stop2 = 0,stop3 = 0;

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
			
			if (i > 0 && i < 8) {
				
				for(q = stop;q < stop*2;q++) {
					for(j = 0;j < 15;j++) {
						undo[q][j] = empregado[stop2][j];
						stop2++;
					}
				}
				stop += 50;
			}
			if (i == 1) {

				for (j = 0; j < 50; j++) {
					if (idLivres[j] == 0) {
						id = j;
					}
				}

				System.out.println("Digite o nome do empregado (Somente o primeiro nome):");
				empregado[id][0] = sc.next();
				System.out.println("Digite o endereço do empregado (escreva tudo junto):");
				empregado[id][1] = sc.next();
				System.out.println("Digite se o empregado é Horista ou Assalariado:");
				empregado[id][2] = sc.next();
				
				if (empregado[id][2].equals("Horista")) {
					System.out.println("Digite o valor da hora trabalhada do empregado (ex: 200.00):");
					empregado[id][3] = sc.next();
					empregado[id][4] = "Nao";
					empregado[id][5] = "0";
					empregado[id][6] = "Semanal";
					empregado[id][8] = "Sexta";
					empregado[id][7] = "1";
					empregado[id][14] = "0.0";
					empregado[id][13] = "0.0";
					
				} else if (empregado[id][2].equals("Assalariado")) {
					System.out.println("Digite o salário do empregado (ex: 200.00):");
					empregado[id][14] = sc.next();
					System.out.println("O empregado é comissionado?(Sim/Nao)");
					empregado[id][4] = sc.next();

					if (empregado[id][4].equals("Sim")) {
						System.out.println("Digite o valor da comissão em porcentagem:");
						empregado[id][5] = sc.next();
						empregado[id][8] = "Sexta";
						empregado[id][6] = "Bisemanal";
						empregado[id][7] = "2";
						empregado[id][13] = "1.0";
					} else {
						empregado[id][5] = "0.0";
						empregado[id][6] = "Mensal";
						empregado[id][7] = "0";
						empregado[id][8] = "30";
						empregado[id][13] = "0.0";
					}
				}

				System.out.println(
						"Digite o método de pagamento:(cheque pelos correios digite:(chequeC)/cheque em mãos digite: (chequeM) /depósito em conta bancária) digite: (contaB)");
				empregado[id][9] = sc.next();
				System.out.println("O empregado pertence ao sindicato?(Sim/Nao)");
				empregado[id][10] = sc.next();

				if (empregado[id][10].equals("Sim")) {
					empregado[id][11] = Integer.toString(id);
					System.out.println("Digite o valor $ da taxa sindical (Ex: 200.00):");
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
					double HoradeEntrada = sc.nextDouble();
					System.out.println("Digite o minuto de entrada:");
					double MinutodeEntrada = sc.nextDouble();
					System.out.println("Digite a hora de saída:(Formato 24h)");
					double HoradeSaida = sc.nextDouble();
					System.out.println("Digite o minuto de saída:");
					double MinutodeSaida = sc.nextDouble();

					double TempoemMinutos = (HoradeSaida * 60.0 + MinutodeSaida) - (HoradeEntrada * 60.0 + MinutodeEntrada);
					double TempoExtra = TempoemMinutos - 480.0;
					double result = Double.parseDouble(empregado[Id][3]);
					double resultSalario = Double.parseDouble(empregado[Id][14]);
					double diaria = 0.0;

					if (TempoExtra > 0.0) {
						TempoemMinutos -= TempoExtra;
						diaria += TempoExtra * 1.5 * result / 60.0;
					}

					diaria += TempoemMinutos * result / 60.0;
					resultSalario += diaria;

					empregado[Id][14] = Double.toString(resultSalario);
				} else {
					System.out.println("O empregado não é Horista.");
				}

			} else if (i == 4) {

				System.out.println("Digite o id do empregado que deseja lançar o resultado de venda:");
				id = sc.nextInt();
				if (empregado[id][4].equals("Sim")) {
					System.out.println("Digite o valor da venda:");
					double res = sc.nextDouble();
					double res2 = Double.parseDouble(empregado[id][13]);
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
					System.out.println("Digite o novo nome: (Somente o primeiro nome)");
					empregado[id][0] = sc.nextLine();
				}
				System.out.println("Deseja alterar o endereço do empregado:(Sim/Nao)");
				resposta = sc.nextLine();
				if (resposta.equals("Sim")) {
					System.out.println("Digite o novo endereço: (Tudo junto)");
					empregado[id][1] = sc.next();
				}
				System.out.println("Deseja mudar o tipo (Horista/Assalariado) do empregado?(Sim/Nao)");
				resposta = sc.nextLine();
				if (resposta.equals("Sim")) {
					if (empregado[id][2].equals("Horista")) {
						empregado[id][2] = "Assalariado";
						empregado[id][8] = "30";
						empregado[id][6] = "Mensal";
						System.out.println("Digite o novo salário: (Ex: 200.00)");
						empregado[id][14] = sc.next();
						System.out.println("O empregado será comissionado?(Sim/Nao)");
						empregado[id][4] = sc.next();
						if (empregado[id][4].equals("Sim")) {
							System.out.println("Digite a comissão do empregado em porcentagem: (Ex: 20):");
							empregado[id][5] = sc.next();
							empregado[id][7] = "2";
							empregado[id][8] = "Sexta";
							empregado[id][6] = "Bisemanal";
							empregado[id][13] = "0.0";
						}
					} else {
						empregado[id][2] = "Horista";
						System.out.println("Digite o valor da hora trabalhada: (Ex: 200.00)");
						empregado[id][3] = sc.next();
						empregado[id][4] = "Nao";
						empregado[id][5] = "0";
						empregado[id][6] = "Semanal";
						empregado[id][7] = "1";
						empregado[id][8] = "Sexta";
						empregado[id][13] = "1.0";
						empregado[id][14] = "0.0";
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
						System.out.println("Digite o valor da taxa sindical $: (Ex: 200.00)");
						empregado[id][12] = sc.next();
					}
				}
			} else if (i == 7) {
				
				int k = 0;
				String[] semana = { "Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sabado" };
				String[] meses = { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto",
						"Setembro", "Outubro", "Novembro", "Dezembro" };
				String diadaSemana = semana[(diaMes + 2 * mes) % 7];
				System.out.println("Data: " + diaMes + "/" + meses[mes] + "   Dia da Semana: " + diadaSemana);

				for (k = 0; k < 50; k++) {
					
					if (semanaQ % 2 == 0 && diadaSemana.equals(empregado[k][8]) && empregado[k][6].equals("Bisemanal")) {
						double salarioP = Double.parseDouble(empregado[k][14]);
						double taxaDeVenda = Double.parseDouble(empregado[k][13]);
						empregado[k][13] = "0.0";
						double despesas = 0;
						if (empregado[k][10].equals("Sim")) {
							despesas += Double.parseDouble(empregado[k][12]);
						}
						salarioP -= despesas;
						
						if(empregado[k][2].equals("Horista")) {
							empregado[k][14] = "0.0";
						}
						salarioP += taxaDeVenda;
						System.out.println("Salário do empregado " + empregado[k][0] + ": R$" + salarioP +"Paga via:"+ empregado[id][9]+"\n");
					}
					
					if ("Mensal".equals(empregado[k][6])) {
						
						int diaReceber = Integer.parseInt(empregado[k][8]);
						
						if (diadaSemana.equals("sexta") && diaMes + 1 == diaReceber
								|| diadaSemana.equals("sexta") && diaMes + 2 == diaReceber) {
							
							double salarioP = Double.parseDouble(empregado[k][14]);
							double despesas = 0.0;
							double taxaDeVenda = Double.parseDouble(empregado[k][13]);
							if (empregado[k][10].equals("Sim")) {
								despesas += Double.parseDouble(empregado[k][12]);
							}
							salarioP -= despesas;
							salarioP += taxaDeVenda;
							if(empregado[k][2].equals("Horista")) {
								empregado[k][14] = "0.0";
							}
							System.out.println("Salário do empregado " + empregado[k][0] + ": R$" + salarioP +"Paga via:"+ empregado[id][9]+"\n");
						}else if (diaMes == diaReceber) {
							if(diadaSemana.equals("Segunda") || diadaSemana.equals("Terça") || diadaSemana.equals("Quarta") || diadaSemana.equals("Quinta") || diadaSemana.equals("Sexta")) {
								double salarioP = Double.parseDouble(empregado[k][14]);
								double despesas = 0.0;
								double taxaDeVenda = Double.parseDouble(empregado[k][13]);
								if (empregado[k][10].equals("Sim")) {
									despesas += Double.parseDouble(empregado[k][12]);
								}
								salarioP -= despesas;
								salarioP += taxaDeVenda;
								if(empregado[k][2].equals("Horista")) {
									empregado[k][14] = "0.0";
								}
								System.out.println("Salário do empregado " + empregado[k][0] + ": R$" + salarioP +"Paga via:"+ empregado[id][9]+"\n");
							}
						}
					}
					
					if ("Semanal".equals(empregado[k][6])) {
						if (diadaSemana.equals(empregado[k][8])) {
							double salarioP = Double.parseDouble(empregado[k][14]);
							double taxaDeVenda = Double.parseDouble(empregado[k][13]);
							if(empregado[k][2].equals("Horista")) {
								empregado[k][14] = "0.0";
							}
							
							double despesas = 0.0;
							if (empregado[k][10].equals("Sim")) {
								despesas += Double.parseDouble(empregado[k][12]);
							}
							salarioP -= despesas;
							salarioP += taxaDeVenda;
							System.out.println("Salário do empregado " + empregado[k][0] + ": R$" + salarioP +"Paga via:"+ empregado[id][9]+"\n");
						}
					}
					
				}
			 if (diadaSemana.equals("Domingo")) {
				 semanaQ += 1;
				if (semanaQ > 4) {
					semanaQ -= 3;
				}
			 }
				diaMes += 1;
				System.out.println("Encerrou mais um dia de trabalho");

			} else if (i == 8) {
				
				int opt = sc.nextInt();
				System.out.println("digite [1] para fazer o undo:");
				System.out.println("digite [2] para fazer o redo:");
				
				if(opt == 1) {
					for(q = stop;q < stop*2;q++) {
						for(j = 0;j < 15;j++) {
							empregado[stop2][j] = undo[stop][j];
							stop2 ++;
						}
					}
					stop -= 50;
				}else if(opt == 2) {
					for(q = stop3;q < stop3*2;q++) {
						for(j = 0;j < 15;j++) {
							empregado[stop2][j] = redo[stop][j];
							stop2 ++;
						}
					}
					stop3 += 50;
				}
				
			} else if (i == 9) {
				int m;
				System.out.println("Digite o ID do empregado:");
				id = sc.nextInt();
				sc.nextLine();
				
				System.out.println("Digite a Nova agenda de pagamento do empregado: [1]Semanal [2] Bisemanal [3]Mensal");
				m = sc.nextInt();
				
				double salario = Double.parseDouble(empregado[id][14]);
				double newsalario = 0.0;
				
				if(m == 1) {
					
					if(empregado[id][4].equals("Sim")&& empregado[id][6].equals("Bisemanal")) {
						newsalario = salario/2.0;
						empregado[id][14] = Double.toString(newsalario);
						empregado[id][6] = "Semanal";
						empregado[id][8] = "Sexta";
					}else if(empregado[id][4].equals("Sim")&& empregado[id][6].equals("Mensal")){
						newsalario = salario/4.0;
						empregado[id][14] = Double.toString(newsalario);
						empregado[id][6] = "Semanal";
						empregado[id][8] = "Sexta";
					} else if(empregado[id][2].equals("Assalariado") && empregado[id][6].equals("Mensal")) {
						newsalario = salario/4.0;
						empregado[id][14] = Double.toString(newsalario);
						empregado[id][6] = "Semanal";
						empregado[id][8] = "Sexta";
					}else if(empregado[id][2].equals("Assalariado") && empregado[id][6].equals("Bisemanal")){
						newsalario = salario/2.0;
						empregado[id][14] = Double.toString(newsalario);
						empregado[id][6] = "Semanal";
						empregado[id][8] = "Sexta";
					}else if(empregado[id][2].equals("Horista")) {
						empregado[id][6] = "Semanal";
						empregado[id][8] = "Sexta";
					}
				}else if(m == 2) {
					
					if(empregado[id][4].equals("Sim")&& empregado[id][6].equals("Semanal")) {
						newsalario = salario * 2.0;
						empregado[id][14] = Double.toString(newsalario);
						empregado[id][6] = "Bisemanal";
						empregado[id][8] = "Sexta";
					}else if(empregado[id][4].equals("Sim")&& empregado[id][6].equals("Mensal")){
						newsalario = salario/2.0;
						empregado[id][14] = Double.toString(newsalario);
						empregado[id][6] = "Bisemanal";
						empregado[id][8] = "Sexta";
					} else if(empregado[id][2].equals("Assalariado") && empregado[id][6].equals("Mensal")) {
						newsalario = salario/2.0;
						empregado[id][14] = Double.toString(newsalario);
						empregado[id][6] = "Bisemanal";
						empregado[id][8] = "Sexta";
					}else if(empregado[id][2].equals("Assalariado") && empregado[id][6].equals("Semanal")){
						newsalario = salario * 2.0;
						empregado[id][14] = Double.toString(newsalario);
						empregado[id][6] = "Bisemanal";
						empregado[id][8] = "Sexta";
					}else if(empregado[id][2].equals("Horista")) {
						empregado[id][6] = "Bisemanal";
						empregado[id][8] = "Sexta";
					}
				}else if(m==3) {
					if(empregado[id][4].equals("Sim")&& empregado[id][6].equals("Bisemanal")) {
						newsalario = salario * 2.0;
						empregado[id][14] = Double.toString(newsalario);
						empregado[id][6] = "Mensal";
						empregado[id][8] = "30";
					}else if(empregado[id][4].equals("Sim")&& empregado[id][6].equals("Semanal")){
						newsalario = salario * 4.0;
						empregado[id][14] = Double.toString(newsalario);
						empregado[id][6] = "Mensal";
						empregado[id][8] = "30";
					} else if(empregado[id][2].equals("Assalariado") && empregado[id][6].equals("Semanal")) {
						newsalario = salario * 4.0;
						empregado[id][14] = Double.toString(newsalario);
						empregado[id][6] = "Mensal";
						empregado[id][8] = "30";
					}else if(empregado[id][2].equals("Assalariado") && empregado[id][6].equals("Bisemanal")){
						newsalario = salario * 2.0;
						empregado[id][14] = Double.toString(newsalario);
						empregado[id][6] = "Mensal";
						empregado[id][8] = "30";
					}else if(empregado[id][2].equals("Horista")) {
						empregado[id][6] = "Mensal";
						empregado[id][8] = "30";
					}
				}

			} else if (i == 10) {

			} else if (i == 11) {

				int k = 0;
				for (k = 0; k < 50; k++) {
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