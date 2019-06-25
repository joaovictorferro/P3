package programan;

import java.util.Scanner;

public class Hourly extends Employee {
	
	public TimeCard timecard = new TimeCard();
	private double valueOfTimeWorked;
	this.pay = 0;
	Scanner sc = new Scanner(System.in);
	
	 public Hourly(){
	        System.out.println("Digite o nome do funcionario:");
	        String name = sc.nextLine();
	        while(name.equals("")){
	            System.out.println("Digite um nome valido");
	            name = sc.nextLine();
	        }
	        setName(name);
	        System.out.println("");
	        System.out.println("Digite o endereco do funcionairo:");
	        String address = sc.nextLine();
	        while(address.equals("")){
	            System.out.println("Digite um endereco valido");
	            address = sc.nextLine();
	        }
	        setAddress(address);

	        System.out.println("Digite o valor da hora trabalhada:");
	        double salary = sc.nextDouble();
	        setSalary(salary);
	        System.out.println("");

	        setValueOfTimeWorked(salary/220.0);
	        
	        System.out.println("Digite se o funcionario pertence ao sindicato:");
	        setSyndicate();
	        System.out.println("");

	        if(isSyndicate()){
	            System.out.println("Digite o numero de sindicato:");
	            int idSyndicate = sc.nextInt();
	            while(idSyndicate < 0){
	                System.out.println("Digite um numero valido:");
	                idSyndicate = sc.nextInt();
	            }
	            setIdSyndicate(idSyndicate);
	            System.out.println("");

	            System.out.println("Digite a taxa do sindicato");
	            double fee = sc.nextDouble();
	            while(fee < 0 || fee >1){
	                System.out.println("Digite uma porcentagem valida.");
	                fee = sc.nextDouble();
	            }
	            setUnionFee(fee);
	            System.out.println("");
	        }

	        System.out.println("Digite o metodo de pagamento");
	        setPayment();
	        System.out.println("");
	    }

	public double getValueOfTimeWorked() {
		return valueOfTimeWorked;
	}
	
	public void setValueOfTimeWorked(double valueOfTimeWorked) {
		this.valueOfTimeWorked = valueOfTimeWorked;
	}
	
	 public void calculateDailyWage(){
		 double period = this.timecard.dailyWorkingPeriod();

	     if(period > 8){
	    	 double extra = period - 8;
	         this.setPay(this.getPay() + ((8*valueOfTimeWorked) + (extra*1.5*valueOfTimeWorked)));
	     }else{
	         this.setPay(this.getPay() + period*valueOfTimeWorked);
	     }
	 }
	
	public void timeCard(int weekDay) {	   
		this.timecard.arrivalTime();
	    this.timecard.exitTime();
	    calculateDailyWage();
	}
}