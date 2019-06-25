package programan;

import java.util.ArrayList;
import java.util.Scanner;

public class Functionality {
	
	public Date calendar;
	private int cont;
	public static ArrayList<Employee> employee = new ArrayList<Employee>();
	Scanner sc = new Scanner(System.in);
	
	public Functionality() {
		cont = 0;
        employee = new ArrayList<Employee>();
	}
	 public void addEmployee(){
	        System.out.println("Digite o tipo de funcionario:");
	        System.out.println("1-Horista 2-Assalariado 3-Comissionado");
	        int type = sc.nextInt();
	        while(type < 1 || type > 3){
	            System.out.println("Digite um numero valido");
	            System.out.println("1-Horista 2-Assalariado 3-Comissionado");
	            type = sc.nextInt();
	        }
	        if(type == 1) {
	        	addHourly();
	        }else if(type == 2) {
	        	addSalaried();
	        }else if(type == 3) {
	        	addCommissioned();
	        }
	        cont++;
	    }

	    public void addHourly(){
	        int id = cont;
	        Employee employeeHourly = new Hourly();
	        employeeHourly.setId(id);
	        employee.add(employeeHourly);
	    }

	    public void addSalaried(){
	        int id = cont;
	        Employee employeeWageEarner = new WageEarner();
	        employeeWageEarner.setId(id);
	        employee.add(employeeWageEarner);
	    }

	    public void addCommissioned(){
	        int id = cont;
	        Employee employeeComissioned = new Comissioned();
	        employeeComissioned.setId(id);
	        employee.add(employeeComissioned);
	    }
	    
	    public void removeEmployee(){
	        boolean found = false;
	    	System.out.println("Digite o id:");
	        int id = sc.nextInt();
	       
	        for(Employee current : employee){
	            if(id == current.getId()){
	                found = true;
	                employee.remove(current);
	                System.out.println("Empregado Removido com sucesso.\n");
	                cont--;
	                return;
	            }
	        }

	        if(!found){
	            System.out.println("Funcionario nao encontrado");
	        }
	    }
	    
	    public void timeCard() {
	        System.out.println("Digite o Id do funcionario que queira adicionar o cartao de ponto:");
	        int id = sc.nextInt();
	        Employee auxiliar = findEmployee(id);
	        if(auxiliar == null){
	            System.out.println("Nao a funcionario com esse id.");
	            return;
	        }
	        int weekDay = this.calendar.weekday;

	        if(weekDay == 1){
	            System.out.println("Nao pode trbalhar aos domingos");
	            return;
	        }

	        if(!(auxiliar instanceof Hourly)){
	            System.out.println("Esse funcionario nao e Horista.");
	            return;
	        }

	        ((Hourly)auxiliar).timeCard(weekDay);
	    }
	    
	    public void showList() {
	    	for(Employee current : employee){
	            System.out.println("Name: " + current.getName() + ".");
	            System.out.println("Endereco: " + current.getAddress() + ".");
	            System.out.println("Id: " + current.getId() + ".");
	            System.out.println("Salario: " + current.getSalary() + ".");
	            
	            if(current instanceof Hourly){
	                System.out.println("Trabalhador tipo: Horista.");
	            }
	            else if(current instanceof WageEarner){
	                System.out.println("Trabalhador tipo: Assalariado.");
	            }
	            else if(current instanceof Comissioned){
	                System.out.println("Trabalhador tipo: Comissionado.");
	                System.out.println("Comissao: " + ((Comissioned)current).getCommission());
	            }

	                if(current.getPayment() == 1) {	
	                    System.out.println("Pagamento pelos correios.");
	                }
	                if(current.getPayment() == 2) {
	                    System.out.println("Pagamento em maos.");
	                }
	                 if(current.getPayment() == 3) {
	                	 System.out.println("Pamento via deposito bancario.");
	                 }
	            
	            if(current.isSyndicate()){
	                System.out.println("Funcionario pertence ao sindicato:");
	                System.out.println("Id do Sindicato: " + current.getIdSyndicate());
	                System.out.println("Taxa do Sindicato: " + current.getUnionFee());
	            }
	            else{
	                System.out.println("O Funcionario nao pertence ao sindicato");
	            }
	        }
	    }
	    
	    public Employee findEmployee(int id){
	        for(Employee current : employee){
	            if(id == current.getId()){
	                return current;
	            }
	        }
	        return null;
	    }
	    public void saleResult() {
	        System.out.println("Digite o Id do funcionario:");
	        int id = sc.nextInt();
	        Employee check = findEmployee(id);

	        if(check == null){
	            System.out.println("Funcionario Nao encontrado");
	            return;
	        }

	        if(!(check instanceof Comissioned)){
	            System.out.println("Funcionario nao e comissionado");
	            return;
	        }
	        ((Comissioned)check).saleResult();
	    }
	    
	    public void serviceTax() {
	        System.out.println("Digite o ID do funcionario:");
	        int id = sc.nextInt();
	        Employee check = findEmployee(id);

	        if(check == null){
	            System.out.println("Funcionario nao encontrado");
	            return;
	        }

	        System.out.println("Digite a taxa de servico:");
	        double tax = sc.nextDouble();
	        while(tax < 0){
	            System.out.println("Digite um valor correto para a taxa de servico");
	            tax = sc.nextDouble();
	        }

	        check.setServiceTax(tax);
	    }

	    public void resetServiceTax() {
	        for(Employee current : employee){
	            current.setServiceTax(0);
	        }
	    
	    }
	    
		public void editEmployee(){
	        System.out.println("Digite o Id do funcionaro que queira alterar:");
	        int id = sc.nextInt();
	        Employee check = findEmployee(id);
	        if(check == null){
	            System.out.println("Funcionario nao encontrado");
	            return;
	        }

	        System.out.println("Selecione o que deseja alterar:");
	        System.out.println("1 -> Nome.");
	        System.out.println("2 -> Endereco.");
	        System.out.println("3 -> Id.");
	        System.out.println("4 -> Salario.");
	        System.out.println("5 -> Taxa de Comissao.");
	        System.out.println("6 -> Sindicato.");
	        System.out.println("7 -> Id do Sindicato.");
	        System.out.println("8 -> Tipo de trabalho.");
	        System.out.println("9 -> Metodo de pagamento.");

	        int opc = sc.nextInt();
	        while(opc < 1 || opc > 10){
	            System.out.println("Digite uma opcao entre 1-10");
	            opc = sc.nextInt();
	        }
	        
	        if(opc ==1){
                System.out.println("Digite o novo nome do funcionario:");
                String newName = sc.nextLine();
                while(newName.equals("")){
                    System.out.println("Digite um nome valido para o funcionario");
                    newName = sc.nextLine();
                }
                check.setName(newName);
                System.out.println("");
	        }else if(opc == 2) {
	        	System.out.println("Digite o novo endereco do funcionario");
	            String newAddress = sc.nextLine();
	            while(newAdress.equals("")){
	            	System.out.println("Digite um endereco valido.");
	                newAdress = sc.nextLine();
	            }
	            check.setAddress(newAddress);
	            System.out.println("");
	        }else if(opc ==3) {
	        	System.out.println("Digite o novo id do funcionario:");
	            int newId = sc.nextInt();
	            while(newId < 0){
	            	System.out.println("Digite um numero valido.");
	                newId = sc.nextInt();
	            }
	            check.setId(newId);
	            System.out.println("");
	        }else if(opc == 4) {
	        	System.out.println("Digite o novo salario do Funcionario");
	            double newSalary = sc.nextDouble();
	            while(newSalary < 0){
	            System.out.println("Digite um salario valido");
	            	newSalary = sc.nextDouble();
	            }
	            check.setSalary(newSalary);
	            
	            if(check instanceof Hourly){
	            	((Hourly)check).setValueOfTimeWorked(check.getSalary()/220.0);
	            }
	                System.out.println("");
	        }else if(opc == 5) {
	                if(check instanceof Comissioned){
	                	System.out.println("Digite a taxa da atualizada da comissao: entre 0 e 1");
	                    double newCommission = sc.nextDouble();
	                    while(newCommission < 0 || newCommission > 1){
	                        System.out.println("Digite um valor validio:");
	                        newCommission = sc.nextDouble();
	                    }
	                    ((Comissioned)check).setCommission(newCommission);
	                }
	                else{
	                    System.out.println("Funcionario nao comissionado.");
	                }
	            }else if(opc == 6) {
	                boolean check2 = check.isSyndicate();
	                System.out.println("Digite se o funcionario ira pertence ou nao ao sindicato:");
	                check.setSyndicate();
	                System.out.println("");
	                if(!check2 && check.isSyndicate()){
	                    System.out.println("Digite o novo id do funcionario no Sindicato:");
	                    int newIdSyndicate = sc.nextInt();
	                    while(newIdSyndicate < 0){
	                        System.out.println("Digite um valor valido");
	                        newIdSyndicate = sc.nextInt();
	                    }
	                    check.setIdSyndicate(newIdSyndicate);
	                    System.out.println(""); 
	                }
	            }else if (opc ==7) {
	                if(check.isSyndicate()){
	                    System.out.println("Digite o novo id do funcionario no Sindicato:");
	                    int newIdSyndicate = sc.nextInt();
	                    while(newIdSyndicate < 0){
	                        System.out.println("Digite um numero valido:");
	                        newIdSyndicate = sc.nextInt();
	                    }
	                    check.setIdSyndicate(newIdSyndicate);
	                    System.out.println("");
	                }else{
	                    System.out.println("Nao pertence ao sindicato.");
	                }
	            }else if( opc == 8) {
	                Newtype(check);
	            }else if (opc == 9) {
	                System.out.println("Digite o novo metodo:");
	                check.setPayment();
	                System.out.println("");
	            }
		}
	   	
		public void Newtype(Employee Id){
			System.out.println("Digite o novo tipo que o funcinario ira pertencer.");
			System.out.println("1-Hourly 2-Salaried 3-Commissioned");
			int type = sc.nextInt();
			
			while(type < 1 || type > 3){
				System.out.println("Digite uma opcao entre 1 e 3");
				type = sc.nextInt();
			}
		        if(type == 1) {
		        	NewHourly(Id);
		        }else if(type == 2) {
		        	NewSalaried(Id);
		        }else if(type == 3) {	
		        	NewCommissioned(Id);
		        }
		    }

		public void NewHourly(Employee Id){
			if(Id instanceof Hourly){
				System.out.println("Funcionario ja e desse tipo");
			}else{
				Hourly newHourly = new Hourly(Id);
				employee.remove(Id);
				employee.add(newHourly);
		        }
		    }

		public void NewSalaried(Employee Id){
			if(Id instanceof WageEarner){
				System.out.println("O funcionario ja e desse tipo");
			}else{
				WageEarner newWageEarner = new WageEarner(Id);
				id.remove(original);
				id.add(switched);
		    }
		}

		    public void NewCommissioned(Employee id){
		        if(original instanceof Commissioned){
		            System.out.println("This employee is already a commissioned one.");
		        }
		        else{
		            Commissioned switched = new Commissioned(original);
		            System.out.println("Please type the employee's commission:");
		            double newCommission = handler.doubleInput();
		            while(newCommission < 0 || newCommission >1){
		                System.out.println("Please type a valid number.");
		                newCommission = handler.doubleInput();
		            }
		            switched.setCommission(newCommission);
		            register.remove(original);
		            register.add(switched);
		        }
		    }
}