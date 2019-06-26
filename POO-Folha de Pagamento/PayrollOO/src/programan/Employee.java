package programan;

import java.util.Scanner;

public class Employee{
	
	Exceptions exceptions = new Exceptions();
	private String name;
	private boolean payDay;
	private String address;
	private String type;
	private boolean syndicate;
	private double unionFee;
	private int payment;
	private String id;
	private int idSyndicate;
	private double serviceTax;
	private double salary;
	protected double pay;

	public Agenda agenda = new Agenda();
	
	Scanner sc = new Scanner(System.in);
	
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Employee() {
		
	}

	public boolean isSyndicate() {
		return syndicate;
	}
	
	public void setSyndicate(boolean syndicate) {
		this.syndicate = syndicate;
	}
	
	public void setSyndicate() {
	      
	      System.out.println("Digite 1->Sim 0->Nao");
	        int check = exceptions.integerInput();
	        while(check < 0 || 1 < check){
	            System.out.println("Comando invalido. Por favor digite novamente:");
	            check = exceptions.integerInput();
	        }

	        if(check == 1){
	            this.syndicate = true;
	        }else{
	            this.syndicate = false;
	        }
	}

	public double getUnionFee() {
		return unionFee;
	}

	public void setUnionFee(double unionFee) {
		this.unionFee = unionFee;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getIdSyndicate() {
		return idSyndicate;
	}

	public void setIdSyndicate(int idSyndicate) {
		this.idSyndicate = idSyndicate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPayment() {
		return (int)payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public void setPayment() {
		System.out.println("Selecione uma das opcoes abaixo:");
        System.out.println("1->Cheque pelos correios 2->Cheque em Maos 3->Deposito em conta bancaria");

        int auxiliar = exceptions.integerInput();

        while(auxiliar < 1 || 3 < auxiliar){
            System.out.println("Digite uma opcao valida.");
            auxiliar = exceptions.integerInput();
        }
        this.payment = auxiliar;
	}

	public double getPay() {
		return pay;
	}

	public void setPay(double pay) {
		this.pay = pay;
	}

	public double getServiceTax() {
		return serviceTax;
	}

	public void setServiceTax(double serviceTax) {
		this.serviceTax = serviceTax;
	}

	public boolean isPayDay() {
		return payDay;
	}

	public void setPayDay(boolean payDay) {
		this.payDay = payDay;
	}
}