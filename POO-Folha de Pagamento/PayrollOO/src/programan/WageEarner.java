package programan;

import java.util.Scanner;

public class WageEarner extends Employee {
	
	Scanner sc = new Scanner(System.in);
	public WageEarner() {

        System.out.println("Digite o nome do empregado:");
        String name = sc.nextLine();
        while(name.equals("")){
            System.out.println("Digite um nome valido para o empregado.");
            name = sc.nextLine();
        }
        setName(name);
        System.out.println("");

        System.out.println("Digite o endereco do empregado:");
        String address = sc.nextLine();
        while(address.equals("")){
            System.out.println("Digite um endereco valido para o empregado:");
            address = sc.nextLine();
        }
        setAddress(address);

        System.out.println("Digite o salario do empregado:");
        double salary = sc.nextDouble();
        while(salary < 0){
            System.out.println("Digite um salario valido para o empregado:");
            salary = sc.nextDouble();
        }
        setSalary(salary);
        System.out.println("");

        System.out.println("Digite se o funcionario pertence:");
        setSyndicate();
        System.out.println("");

        if(isSyndicate()){
            System.out.println("Digite o numero de sindicato do funcionario:");
            int idSyndicate = sc.nextInt();
            while(idSyndicate < 0){
                System.out.println("Please type a valid number.");
                idSyndicate = sc.nextInt();
            }
            setIdSyndicate(idSyndicate);
            System.out.println("");

            System.out.println("Digite a taxa do sindicato:");
            double fee = sc.nextDouble();
            while(fee < 0 || fee >1){
                System.out.println("Digite uma porcentagem valida.");
                fee = sc.nextDouble();
            }
            setUnionFee(fee);
            System.out.println("");
        }

        System.out.println("Digite o metodo de pagamento:");
        setPayment();
        System.out.println("");
	}
}