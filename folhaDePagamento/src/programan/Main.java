package programan;

import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		int i;
		int diaMes = 0;
		int mes = 0;
		int id = 0;
		int semanaQ = 1;
		Scanner sc = new Scanner(System.in);

		String[][] empregado = new String[100][16];
		String[][][] undo = new String [100][50][16];
		String[][][] redo = new String [100][50][16];
		String[] comandos = new String [1000];
		int[] idLivres = new int[50];
		int j,q,contUndo = 0,contRedo = 0, contComandos = 0;

		for (j = 0; j < 50; j++) {
			idLivres[j] = 0;
		}

		do {

			if (diaMes > 30) {
				mes += 1;
				diaMes = 1;
				for(j=0;j<50;j++) {
					if(idLivres[j] == 1 && empregado[j][10].equals("Sim")) {
						empregado[id][15] = "1";
					}
				}
				
			}
			
			System.out.println("Digite [0] se deseja parar o programa:");
			System.out.println("Digite [1] se deseja adicionar um empregado:");
			System.out.println("Digite [2] se deseja remover um empregado:");
			System.out.println("Digite [3] se deseja lan�ar um cart�o de ponto:");
			System.out.println("Digite [4] se deseja lan�ar um resultado de venda:");
			System.out.println("Digite [5] se deseja lan�ar uma taxa de servi�o:");
			System.out.println("Digite [6] se deseja alterar dados de um empregado:");
			System.out.println("Digite [7] se deseja rodar a folha de pagamento:");
			System.out.println("Digite [8] para Undo/Redo:");
			System.out.println("Digite [9] se deseja alterar sua agenda de pagamentos:");
			System.out.println("Digite [10] para criar uma nova agenda de pagamento:");
			System.out.println("Digite [11] se deseja listar os empregados:");

			i = sc.nextInt();
			sc.nextLine();
			
			if (i > 0 && i < 8){	
				comandos[contComandos] = Integer.toString(i);
				contComandos += 1;
				for(q = 0;q < 50;q++) {
					for(j = 0;j < 16;j++) {
						undo[contUndo][q][j] = empregado[q][j];
					}
				}
				contUndo += 1;
			}
			
			if (i == 1) {

				for (j = 0; j < 50; j++) {
					if (idLivres[j] == 0) {
						id = j;
					}
				}
				System.out.println("Digite o nome do empregado:");
				empregado[id][0] = sc.nextLine();
				System.out.println("Digite o endere�o do empregado:");
				empregado[id][1] = sc.nextLine();
				System.out.println("Digite se o empregado � Horista ou Assalariado:");
				empregado[id][2] = sc.nextLine();
				
				if (empregado[id][2].equals("Horista")) {
					System.out.println("Digite o valor da hora trabalhada do empregado (ex: 200.00):");
					empregado[id][3] = sc.nextLine();
					empregado[id][4] = "Nao";
					empregado[id][5] = "0";
					empregado[id][6] = "Semanal";
					empregado[id][8] = "Sexta";
					empregado[id][14] = "0.0";
					empregado[id][13] = "0.0";
					
				} else if (empregado[id][2].equals("Assalariado")) {
					System.out.println("Digite o sal�rio do empregado (ex: 200.00):");
					empregado[id][14] = sc.nextLine();
					System.out.println("O empregado � comissionado?(Sim/Nao)");
					empregado[id][4] = sc.nextLine();

					if (empregado[id][4].equals("Sim")) {
						System.out.println("Digite o valor da comiss�o em porcentagem:");
						empregado[id][5] = sc.nextLine();
						empregado[id][8] = "Sexta";
						empregado[id][6] = "Bissemanal";
						empregado[id][13] = "0.0";
					} else {
						empregado[id][5] = "0.0";
						empregado[id][6] = "Mensal";
						empregado[id][8] = "30";
						empregado[id][13] = "0.0";
					}
				}

				System.out.println("Digite o m�todo de pagamento:(Cheque pelos correios/Cheque em m�os/Dep�sito em conta banc�ria");
				empregado[id][9] = sc.nextLine();
				System.out.println("O empregado pertence ao sindicato?(Sim/Nao)");
				empregado[id][10] = sc.nextLine();

				if (empregado[id][10].equals("Sim")) {
					empregado[id][15] = "1";
					empregado[id][7] = "0.0";
					empregado[id][11] = Integer.toString(id+1);
					System.out.println("Digite o valor $ da taxa sindical (Ex: 200.00):");
					empregado[id][12] = sc.nextLine();
				}else {
					empregado[id][12] = "0.0"; 
				}
				System.out.println("O ID do empregado �: " + id + "\n");

				idLivres[id] = 1;
			} else if (i == 2) {

				System.out.println("Digite o ID do empregado que deseja remover:");
				int ID = sc.nextInt();
				sc.nextLine();
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
				System.out.println("Removido com sucesso!!\n");
			} else if (i == 3) {

				System.out.println("Digite o ID do empregado que deseja lan�ar o cart�o de ponto:");
				int Id = sc.nextInt();
				
				if (empregado[Id][2].equals("Horista")) {
					System.out.println("Digite a hora de entrada:(Formato 24h)");
					double HoradeEntrada = sc.nextDouble();
					System.out.println("Digite o minuto de entrada:");
					double MinutodeEntrada = sc.nextDouble();
					System.out.println("Digite a hora de sa�da:(Formato 24h)");
					double HoradeSaida = sc.nextDouble();
					System.out.println("Digite o minuto de sa�da:");
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
					System.out.println("O empregado n�o � Horista.");
				}

			} else if (i == 4) {

				System.out.println("Digite o id do empregado que deseja lan�ar o resultado de venda:");
				id = sc.nextInt();
				if (empregado[id][4].equals("Sim")) {
					System.out.println("Digite o valor da venda: (Ex: 200.00)");
					double res = sc.nextDouble();
					double res2 = Double.parseDouble(empregado[id][5]);
					res = res * res2 / 100;
					empregado[id][13] = Double.toString(res);
				} else {
					System.out.println("O empregado n�o � comissionado.");
				}

			} else if (i == 5) {

				System.out.println("Digite o ID do empregado que deseja lan�ar uma taxa de servi�o:");
				id = sc.nextInt();
				if (empregado[id][10].equals("Sim")) {
					System.out.println("Digite o valor da taxa de servi�o: (Ex: 200.00)");
					double res = Double.parseDouble(empregado[id][7]);
					res += sc.nextDouble();
					empregado[id][7] = Double.toString(res);
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
				System.out.println("Deseja alterar o endere�o do empregado:(Sim/Nao)");
				resposta = sc.nextLine();
				if (resposta.equals("Sim")) {
					System.out.println("Digite o novo endere�o: (Tudo junto)");
					empregado[id][1] = sc.next();
				}
				System.out.println("Deseja mudar o tipo (Horista/Assalariado) do empregado?(Sim/Nao)");
				resposta = sc.nextLine();
				if (resposta.equals("Sim")) {
					if (empregado[id][2].equals("Horista")) {
					
						System.out.println("Digite o novo sal�rio: (Ex: 200.00)");
						empregado[id][14] = sc.next();
						System.out.println("O empregado ser� comissionado?(Sim/Nao)");
						empregado[id][4] = sc.next();
						if (empregado[id][4].equals("Sim")) {
							System.out.println("Digite a comiss�o do empregado em porcentagem: (Ex: 20):");
							empregado[id][5] = sc.next();
							empregado[id][7] = "2";
							empregado[id][8] = "Sexta";
							empregado[id][6] = "Bissemanal";
							empregado[id][13] = "0.0";
						}else {
							empregado[id][5] = "0.0";
							empregado[id][6] = "Mensal";
							empregado[id][7] = "0";
							empregado[id][8] = "30";
							empregado[id][13] = "0.0";
						}
					} else {
						empregado[id][2] = "Horista";
						System.out.println("Digite o valor da hora trabalhada: (Ex: 200.00)");
						empregado[id][3] = sc.next();
						empregado[id][4] = "Nao";
						empregado[id][5] = "0.0";
						empregado[id][6] = "Semanal";
						empregado[id][7] = "1";
						empregado[id][8] = "Sexta";
						empregado[id][13] = "0.0";
						empregado[id][14] = "0.0";
					}
				}
				System.out.println("Deseja mudar o m�todo de pagamento do empregado?(Sim/Nao)");
				resposta = sc.nextLine();
				if (resposta.equals("Sim")) {
					System.out.println("Digite o m�todo de pagamento:(Cheque pelos correios/Cheque em m�os/Dep�sito em conta banc�ria");
					empregado[id][9] = sc.nextLine();
				}
				
				if (empregado[id][10].equals("Sim")) {
					System.out.println("Deseja que o empregado saia do sindicato?(Sim/Nao)");
					resposta = sc.nextLine();
					if (resposta.equals("Sim")) {
						empregado[id][10] = "Nao";
						empregado[id][11] = null;
						empregado[id][12] = "0.0";
					}
				} else if (empregado[id][10].equals("Nao")) {
					System.out.println("Deseja que o empregado entre no sindicato?(Sim/Nao)");
					resposta = sc.nextLine();
					if (resposta.equals("Sim")) {
						empregado[id][10] = "Sim";
						empregado[id][15] = "1";
						String ID = Integer.toString(id+1);
						empregado[id][11] = ID;
						System.out.println("Digite o valor da taxa sindical $: (Ex: 200.00)");
						empregado[id][12] = sc.next();
						empregado[id][7] = "0.0";
					}
				}
			} else if (i == 7) {
				
				int k = 0;
				String[] semana = { "Domingo", "Segunda", "Ter�a", "Quarta", "Quinta", "Sexta", "Sabado" };
				String[] meses = { "Janeiro", "Fevereiro", "Mar�o", "Abril", "Maio", "Junho", "Julho", "Agosto",
						"Setembro", "Outubro", "Novembro", "Dezembro" };
				String diadaSemana = semana[(diaMes + 2 * mes) % 7];
				System.out.println("Data: " + diaMes + "/" + meses[mes] + "   Dia da Semana: " + diadaSemana);

				for (k = 0; k < 50; k++) {
					
					if (semanaQ % 2 == 0 && diadaSemana.equals(empregado[k][8]) && empregado[k][6].equals("Bissemanal")) {
						double salarioP = Double.parseDouble(empregado[k][14]);
						double taxaVenda = Double.parseDouble(empregado[k][13]);
						empregado[k][13] = "0.0";
						double despesas = 0;
						if (empregado[k][10].equals("Sim") && empregado[k][15].equals("1")) {
							despesas += Double.parseDouble(empregado[k][12]);
							empregado[k][15] = "0";
						}
						despesas += Double.parseDouble(empregado[k][7]);
						empregado[k][7] = "0.0";
						salarioP -= despesas;
						salarioP += taxaVenda;
						
						if(empregado[k][2].equals("Horista")) {
							empregado[k][14] = "0.0";
						}
						
						System.out.println("Sal�rio do empregado " + empregado[k][0] + ": R$" + salarioP +"Paga via:"+ empregado[id][9]+"\n");
					}
					
					if ("Mensal".equals(empregado[k][6])) {
						
						int diaReceber = Integer.parseInt(empregado[k][8]);
						
						if (diadaSemana.equals("sexta") && diaMes + 1 == diaReceber
								|| diadaSemana.equals("sexta") && diaMes + 2 == diaReceber) {
							
							double salarioP = Double.parseDouble(empregado[k][14]);
							double despesas = 0.0;
							double taxaDeVenda = Double.parseDouble(empregado[k][13]);
							empregado[k][13] = "0.0";
							if (empregado[k][10].equals("Sim") && empregado[k][15].equals("1")) {
								despesas += Double.parseDouble(empregado[k][12]);
								empregado[k][15] = "0";
							}
							despesas += Double.parseDouble(empregado[k][7]);
							empregado[k][7] = "0.0";
							salarioP -= despesas;
							salarioP += taxaDeVenda;
							if(empregado[k][2].equals("Horista")) {
								empregado[k][14] = "0.0";
							}
							System.out.println("Sal�rio do empregado " + empregado[k][0] + ": R$" + salarioP +"Paga via:"+ empregado[id][9]+"\n");
						}else if (diaMes == diaReceber) {
							if(diadaSemana.equals("Segunda") || diadaSemana.equals("Ter�a") || diadaSemana.equals("Quarta") || diadaSemana.equals("Quinta") || diadaSemana.equals("Sexta")) {
								double salarioP = Double.parseDouble(empregado[k][14]);
								double despesas = 0.0;
								double taxaDeVenda = Double.parseDouble(empregado[k][13]);
								empregado[k][13] = "0.0";
								if (empregado[k][10].equals("Sim") && empregado[k][15].equals("1")) {
									despesas += Double.parseDouble(empregado[k][12]);
									empregado[k][15] = "0";
								}
								despesas += Double.parseDouble(empregado[k][7]);
								empregado[k][7] = "0.0";
								salarioP -= despesas;
								salarioP += taxaDeVenda;
								if(empregado[k][2].equals("Horista")) {
									empregado[k][14] = "0.0";
								}
								System.out.println("Sal�rio do empregado " + empregado[k][0] + ": R$" + salarioP +"Paga via:"+ empregado[id][9]+"\n");
							}
						}
					}
					
					if ("Semanal".equals(empregado[k][6])) {
						if (diadaSemana.equals(empregado[k][8])) {
							double salarioP = Double.parseDouble(empregado[k][14]);
							double taxaDeVenda = Double.parseDouble(empregado[k][13]);
							empregado[k][13] = "0.0";
							if(empregado[k][2].equals("Horista")) {
								empregado[k][14] = "0.0";
							}
							
							double despesas = 0.0;
							if (empregado[k][10].equals("Sim") && empregado[k][15].equals("1")) {
								despesas += Double.parseDouble(empregado[k][12]);
								empregado[k][15] = "0";
							}
							despesas += Double.parseDouble(empregado[k][7]);
							empregado[k][7] = "0.0";
							salarioP -= despesas;
							salarioP += taxaDeVenda;
							System.out.println("Sal�rio do empregado " + empregado[k][0] + ": R$" + salarioP +"Paga via:"+ empregado[id][9]+"\n");
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
				System.out.println("Encerrou mais um dia de trabalho\n");

			} else if (i == 8) {
				
				System.out.println("digite [1] para fazer o undo:");
				System.out.println("digite [2] para fazer o redo:");
				int opt = sc.nextInt();
				
				if(opt == 1) {
					
					if(comandos[contComandos-1].equals("7")) {
						if(diaMes > 30) {
							diaMes = 30;
							mes -= 1;
						}else {
							diaMes -= 1;
						}
					}
					for(q = 0;q < 50;q++) {
						for(j = 0;j < 15;j++) {
							empregado[q][j] = undo[contUndo-1][q][j];
							redo[contRedo][q][j] = undo[contUndo][q][j];
						}
					}
					contRedo += 1;
					contUndo -= 1;
					contComandos -= 1;
				}else if(opt == 2) {
					
					if(comandos[contComandos].equals("7")) {
						diaMes += 1;
						if(diaMes > 30) {
							diaMes = 1;
							mes += 1;
						}
					}
					for(q = 0;q < 50;q++) {
						for(j = 0;j < 15;j++) {
							empregado[q][j] = redo[contRedo][q][j];
							undo[contUndo][q][j] = redo[contRedo][q][j];
						}
					}
					contRedo -= 1;
					contUndo += 1;
					contComandos += 1;
				}
				
			} else if (i == 9) {
				int m;
				System.out.println("Digite o ID do empregado que deseja modificar a sua agenda:");
				id = sc.nextInt();
				sc.nextLine();
				
				System.out.println("Digite a Nova agenda de pagamento do empregado: [1]Semanal [2] Bissemanal [3]Mensal");
				m = sc.nextInt();
				
				double salario = Double.parseDouble(empregado[id][14]);
				double newsalario = 0.0;
				
				if(m == 1) {
					
					if(empregado[id][4].equals("Sim")&& empregado[id][6].equals("Bissemanal")) {
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
					}else if(empregado[id][2].equals("Assalariado") && empregado[id][6].equals("Bissemanal")){
						newsalario = salario/2.0;
						empregado[id][14] = Double.toString(newsalario);
						empregado[id][6] = "Semanal";
						empregado[id][8] = "Sexta";
					}else if(empregado[id][2].equals("Horista")){
						empregado[id][6] = "Semanal";
						empregado[id][8] = "Sexta";
					}
				}else if(m == 2) {
					
					if(empregado[id][4].equals("Sim")&& empregado[id][6].equals("Semanal")) {
						newsalario = salario * 2.0;
						empregado[id][14] = Double.toString(newsalario);
						empregado[id][6] = "Bissemanal";
						empregado[id][8] = "Sexta";
					}else if(empregado[id][4].equals("Sim")&& empregado[id][6].equals("Mensal")){
						newsalario = salario/2.0;
						empregado[id][14] = Double.toString(newsalario);
						empregado[id][6] = "Bissemanal";
						empregado[id][8] = "Sexta";
					} else if(empregado[id][2].equals("Assalariado") && empregado[id][6].equals("Mensal")) {
						newsalario = salario/2.0;
						empregado[id][14] = Double.toString(newsalario);
						empregado[id][6] = "Bissemanal";
						empregado[id][8] = "Sexta";
					}else if(empregado[id][2].equals("Assalariado") && empregado[id][6].equals("Semanal")){
						newsalario = salario * 2.0;
						empregado[id][14] = Double.toString(newsalario);
						empregado[id][6] = "Bissemanal";
						empregado[id][8] = "Sexta";
					}else if(empregado[id][2].equals("Horista")) {
						empregado[id][6] = "Bissemanal";
						empregado[id][8] = "Sexta";
					}
				}else if(m==3) {
					if(empregado[id][4].equals("Sim")&& empregado[id][6].equals("Bissemanal")) {
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
					}else if(empregado[id][2].equals("Assalariado") && empregado[id][6].equals("Bissemanal")){
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
				
				System.out.println("Digite o ID do funcionario que deseja modificar sua agenda de pagamento:");
				id = sc.nextInt();
				
				System.out.println("Digite a Nova agenda de pagamento do empregado: [1]Semanal [2] Bissemanal [3]Mensal");
				int m = sc.nextInt();
				
				double salario = Double.parseDouble(empregado[id][14]);
				double newsalario = 0.0;
				
				if(m == 1) {
					
					if(empregado[id][4].equals("Sim")&& empregado[id][6].equals("Bissemanal")) {
						newsalario = salario/2.0;
						empregado[id][14] = Double.toString(newsalario);
						empregado[id][6] = "Semanal";
						System.out.println("Digite o dia da semana que deseja receber:");
						empregado[id][8] = sc.next();
					}else if(empregado[id][4].equals("Sim")&& empregado[id][6].equals("Mensal")){
						newsalario = salario/4.0;
						empregado[id][14] = Double.toString(newsalario);
						empregado[id][6] = "Semanal";
						System.out.println("Digite o dia da semana que deseja receber:");
						empregado[id][8] = sc.next();
					} else if(empregado[id][2].equals("Assalariado") && empregado[id][6].equals("Mensal")) {
						newsalario = salario/4.0;
						empregado[id][14] = Double.toString(newsalario);
						empregado[id][6] = "Semanal";
						System.out.println("Digite o dia da semana que deseja receber:");
						empregado[id][8] = sc.next();
					}else if(empregado[id][2].equals("Assalariado") && empregado[id][6].equals("Bissemanal")){
						newsalario = salario/2.0;
						empregado[id][14] = Double.toString(newsalario);
						empregado[id][6] = "Semanal";
						System.out.println("Digite o dia da semana que deseja receber:");
						empregado[id][8] = sc.next();
					}else if(empregado[id][2].equals("Horista")) {
						empregado[id][6] = "Semanal";
						System.out.println("Digite o dia da semana que deseja receber:");
						empregado[id][8] = sc.next();
					}
				}else if(m == 2) {
					
					if(empregado[id][4].equals("Sim")&& empregado[id][6].equals("Semanal")) {
						newsalario = salario * 2.0;
						empregado[id][14] = Double.toString(newsalario);
						empregado[id][6] = "Bissemanal";
						System.out.println("Digite o dia da semana que deseja receber:");
						empregado[id][8] = sc.next();
					}else if(empregado[id][4].equals("Sim")&& empregado[id][6].equals("Mensal")){
						newsalario = salario/2.0;
						empregado[id][14] = Double.toString(newsalario);
						empregado[id][6] = "Bissemanal";
						System.out.println("Digite o dia da semana que deseja receber:");
						empregado[id][8] = sc.next();
					} else if(empregado[id][2].equals("Assalariado") && empregado[id][6].equals("Mensal")) {
						newsalario = salario/2.0;
						empregado[id][14] = Double.toString(newsalario);
						empregado[id][6] = "Bissemanal";
						System.out.println("Digite o dia da semana que deseja receber:");
						empregado[id][8] = sc.next();
					}else if(empregado[id][2].equals("Assalariado") && empregado[id][6].equals("Semanal")){
						newsalario = salario * 2.0;
						empregado[id][14] = Double.toString(newsalario);
						empregado[id][6] = "Bissemanal";
						System.out.println("Digite o dia da semana que deseja receber:");
						empregado[id][8] = sc.next();
					}else if(empregado[id][2].equals("Horista")) {
						empregado[id][6] = "Bissemanal";
						System.out.println("Digite o dia da semana que deseja receber:");
						empregado[id][8] = sc.next();
					}
				}else if(m==3) {
					if(empregado[id][4].equals("Sim")&& empregado[id][6].equals("Bissemanal")) {
						newsalario = salario * 2.0;
						empregado[id][14] = Double.toString(newsalario);
						empregado[id][6] = "Mensal";
						System.out.println("Digite o dia que deseja receber:");
						empregado[id][8] = sc.next();
					}else if(empregado[id][4].equals("Sim")&& empregado[id][6].equals("Semanal")){
						newsalario = salario * 4.0;
						empregado[id][14] = Double.toString(newsalario);
						empregado[id][6] = "Mensal";
						System.out.println("Digite o dia que deseja receber:");
						empregado[id][8] = sc.next();
					} else if(empregado[id][2].equals("Assalariado") && empregado[id][6].equals("Semanal")) {
						newsalario = salario * 4.0;
						empregado[id][14] = Double.toString(newsalario);
						empregado[id][6] = "Mensal";
						System.out.println("Digite o dia que deseja receber:");
						empregado[id][8] = sc.next();
					}else if(empregado[id][2].equals("Assalariado") && empregado[id][6].equals("Bissemanal")){
						newsalario = salario * 2.0;
						empregado[id][14] = Double.toString(newsalario);
						empregado[id][6] = "Mensal";
						System.out.println("Digite o dia que deseja receber:");
						empregado[id][8] = sc.next();
					}else if(empregado[id][2].equals("Horista")) {
						empregado[id][6] = "Mensal";
						System.out.println("Digite o dia que deseja receber:");
						empregado[id][8] = sc.next();
					}
				}
			}else if (i == 11) {

				int k = 0;
				for (k = 0; k < 50; k++) {
					if (idLivres[k] != 0) {
						System.out.printf("Nome: " + empregado[k][0] + " Endereco: " + empregado[k][1] + " Tipo: "
								+ empregado[k][2] + " Valor de hora trabalhada: " + empregado[k][3] + " Comissionado: "
								+ empregado[k][4] + " Comissao: " + empregado[k][5] + " Agenda de Pagamento: "
								+ empregado[k][6] + " Dia de receber: " + empregado[k][8] 
								+ " Metodo de Pagamento: " + empregado[k][9] + " Sindicato: "
								+ empregado[k][10] + " Identificacao no Sindicato: " + empregado[k][11]
								+ " Taxa de Sindicato: " + empregado[k][12] + "Salario: " + empregado[k][14]+"\n");
					}
				}
			}
		} while (i != 0);

		sc.close();
	}
}