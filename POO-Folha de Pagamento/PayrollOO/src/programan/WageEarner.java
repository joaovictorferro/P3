package programan;

public class WageEarner extends Employee {

	public WageEarner() {
		WageEarnerAgenda();
		setPayDay(true);
        setPay(0);
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
        double salary = exceptions.doubleInput();
        while(salary < 0){
            System.out.println("Digite um salario valido para o empregado:");
            salary = exceptions.doubleInput();
        }
        setSalary(salary);
        System.out.println("");
        setPay(salary);
        System.out.println("Digite se o funcionario pertence ao sindicado:");
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

        System.out.println("Digite o metodo de pagamento:");
        setPayment();
        System.out.println("");
	}
	
	public WageEarner(Employee id){
		
		WageEarnerAgenda();
		setName(id.getName());
		setAddress(id.getAddress());
		setSalary(id.getSalary());
		this.pay = id.getSalary();
		setId(id.getId());
		setPayment(id.getPayment());
		setSyndicate(id.isSyndicate());
		if(isSyndicate()){
			setIdSyndicate(id.getIdSyndicate());
			setUnionFee (id.getUnionFee());
			setServiceTax(id.getServiceTax());
		}
    }
	
    public void WageEarnerAgenda(){
        this.agenda.setMonthly(true);
        this.agenda.setLastDay(true);
    }
}