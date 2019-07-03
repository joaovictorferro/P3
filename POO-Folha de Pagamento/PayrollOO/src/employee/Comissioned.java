package employee;

public class Comissioned extends Employee{
    
	private double commission = 0;
    public double saleResult = 0;
    public Comissioned() {
    	
    	CommissionedAgenda();
    	setPay(0);
    	setPayDay(true);
    	this.saleResult = 0.0;  
    	
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
	        double salary = exceptions.doubleInput();
	        while(salary < 0){
	            System.out.println("Digite um salario valido.");
	            salary = exceptions.doubleInput();
	        }
	        setSalary(salary);
	        System.out.println("");
	        setPay(salary);
	        System.out.println("O empregado pertence o sindicato:");
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
	                System.out.println("Digite uma taxa valida.");
	                fee = exceptions.doubleInput();
	            }
	            setUnionFee(fee);
	            System.out.println("");
	        }

	        System.out.println("Digite o metodo de pagamento:");
	        setPayment();
	        System.out.println("");

	        System.out.println("Digite a taxa da comissao de venda:");
	        double commission = exceptions.doubleInput();
	        while(commission < 0 || commission > 1){
	            System.out.println("Digite um valor valido para a comissao.");
	            commission = exceptions.doubleInput();
	        }
	        setCommission(commission);
	}

    public Comissioned(Employee id) {
    	CommissionedAgenda();
        setName(id.getName());
        setAddress(id.getAddress());
        setSalary (id.getSalary());
        this.pay = id.getSalary();
        setId(id.getId());
        setPayment(id.getPayment());
    	if(isSyndicate()){
			setIdSyndicate(id.getIdSyndicate());
			setUnionFee (id.getUnionFee());
			setServiceTax(id.getServiceTax());
		}
        this.saleResult = 0.0;
    }
	public double getCommission() {
		return commission;
	}

	public void setCommission(double commission) {
		this.commission = commission;
	}
	
    public void saleResult(){
        System.out.println("Digite o resultado de venda:");
        double result = exceptions.doubleInput();
        while(result < 0){
            System.out.println("Digite um numero valido.");
            result = exceptions.doubleInput();
        }
        this.saleResult += result;
    }
    
    public void CommissionedAgenda(){
        this.agenda.setEachTwoWeeks(true);
        this.agenda.setWeekDay(5);
    }
}