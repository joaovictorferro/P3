package programan;

import java.util.Scanner;

public class Comissioned extends Employee {
    private double commission;
    public double saleResults;
    Scanner sc = new Scanner(System.in);
	public Comissioned() {
		   this.saleResults = 0;

	        System.out.println("Digite o nome do empregado:");
	        String name = sc.nextLine();
	        while(name.equals("")){
	            System.out.println("Digite um nome valido");
	            name = sc.nextLine();
	        }
	        setName(name);
	        System.out.println("");

	        System.out.println("Digite o endereco do empregado:");
	        String address = sc.nextLine();
	        while(address.equals("")){
	            System.out.println("Digite um endereco valido.");
	            address = sc.nextLine();
	        }
	        setAddress(address);

	        System.out.println("Digite o salario do empregado:");
	        double salary = sc.nextDouble();
	        while(salary < 0){
	            System.out.println("Digite um salario valido.");
	            salary = sc.nextDouble();
	        }
	        setSalary(salary);
	        System.out.println("");

	        System.out.println("O empregado pertence o sindicato:");
	        setSyndicate();
	        System.out.println("");

	        if(isSyndicate()){
	            System.out.println("Digite o numero de registro do funcionario no sindicato:");
	            int idSyndicate = sc.nextInt();
	            while(idSyndicate < 0){
	                System.out.println("Digite um numero valido.");
	                idSyndicate = sc.nextInt();
	            }
	            setIdSyndicate(idSyndicate);
	            System.out.println("");

	            System.out.println("Digite a taxa do sindicato:");
	            double fee = sc.nextDouble();
	            while(fee < 0 || fee >1){
	                System.out.println("Digite uma taxa valida.");
	                fee = sc.nextDouble();
	            }
	            setUnionFee(fee);
	            System.out.println("");
	        }

	        System.out.println("Digite o metodo de pagamento:");
	        setPayment();
	        System.out.println("");

	        System.out.println("Digite a taxa da comissao");
	        double commission = sc.nextDouble();
	        while(commission < 0 || commission > 1){
	            System.out.println("Digite um valor valido para a comissao.");
	            commission = sc.nextDouble();
	        }
	        setCommission(commission);
	}

	public double getCommission() {
		return commission;
	}

	public void setCommission(double commission) {
		this.commission = commission;
	}
}
