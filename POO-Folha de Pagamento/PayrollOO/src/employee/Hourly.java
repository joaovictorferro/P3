package employee;

import utilitarios.TimeCard;

public class Hourly extends Employee{

	public TimeCard timecard = new TimeCard();
	private double valueOfTimeWorked = 0;
	
	public Hourly(Employee id){
		
		HourlyAgenda();
		setName(id.getName());
		setAddress(id.getAddress());
		setSalary(id.getSalary());
		this.pay = 0;
		this.valueOfTimeWorked = getSalary()/220.0;
		setId(id.getId());
		setPayment(id.getPayment());
		setSyndicate(id.isSyndicate());
		if(isSyndicate()){
			setIdSyndicate(id.getIdSyndicate());
			setUnionFee (id.getUnionFee());
			setServiceTax (id.getServiceTax());
		}
	}
	
	public Hourly(){
		
		HourlyAgenda();
		setPayDay(true);
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
		
		System.out.println("Digite o valor total do salario que ele pode ganhar:");
		double salary = exceptions.doubleInput();;
		setSalary(salary);
		System.out.println("");

		setValueOfTimeWorked(salary/240.0);
		
		System.out.println("Digite se o funcionario pertence ao sindicato:");
		setSyndicate();
		System.out.println("");
		
		if(isSyndicate()){
			System.out.println("Digite o ID do funcionario no sindicato:");
			int idSyndicate = exceptions.integerInput();
			while(idSyndicate < 0){
				System.out.println("Digite um valor valido.");
				idSyndicate = exceptions.integerInput();
			}
			setIdSyndicate(idSyndicate);
			System.out.println("Digite a taxa do sindicato:");
			double fee = exceptions.doubleInput();
			while(fee < 0 || fee >1){
				System.out.println("Digite uma porcentagem valida.");
				fee = exceptions.doubleInput();
			}
			setUnionFee(fee);
			System.out.println("");
		}

		System.out.println("Digite o metodo de pagamento");
		setPayment();
		System.out.println("");
	}

	public void calculateDailyWage(){
		double period = this.timecard.dailyWorkingPeriod();
		
		if(period > 8){
			double extra = period - 8;
			this.setPay(this.getPay() + ((8*getValueOfTimeWorked()) + (extra*1.5*getValueOfTimeWorked())));
	     }else{
	    	 this.setPay(this.getPay() + period*getValueOfTimeWorked());
	     }
	 }
	
	public void timeCard(int weekDay) {	   
		this.timecard.arrivalTime();
	    this.timecard.exitTime();
	    calculateDailyWage();
	}
	public double getValueOfTimeWorked() {
		return valueOfTimeWorked;
	}
	
	public void setValueOfTimeWorked(double valueOfTimeWorked) {
		this.valueOfTimeWorked = valueOfTimeWorked;
	}
	
	 public void HourlyAgenda(){
	        this.agenda.setWeekly(true);
	        this.agenda.setWeekDay(5);
	    }
}