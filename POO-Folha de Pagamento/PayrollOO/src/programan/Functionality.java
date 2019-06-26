package programan;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Functionality {
	Exceptions exceptions = new Exceptions();
	public Date calendar;
	private int cont;
	public static ArrayList<Employee> employee = new ArrayList<Employee>();
	 private UndoRedo undoRedo;
	Scanner sc = new Scanner(System.in);
	
	public Functionality() {
		calendar = new Date();
		cont = 1;
        employee = new ArrayList<Employee>();
        undoRedo = new UndoRedo();
	}
	
	 public void addEmployee(){
		 emptyRedo();
		 copy();   
		 System.out.println("Digite o tipo de funcionario:");
		 System.out.println("1-Horista 2-Assalariado 3-Comissionado");
		 int type = exceptions.integerInput();
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
	        String id = Integer.toString(cont);
	        Employee employeeHourly = new Hourly();
	        employeeHourly.setId(id);
	        employee.add(employeeHourly);
	    }

	    public void addSalaried(){
	    	String id = Integer.toString(cont);
	        Employee employeeWageEarner = new WageEarner();
	        employeeWageEarner.setId(id);
	        employee.add(employeeWageEarner);
	    }

	    public void addCommissioned(){
	    	String id = Integer.toString(cont);
	        Employee employeeComissioned = new Comissioned();
	        employeeComissioned.setId(id);
	        employee.add(employeeComissioned);
	    }
	    
	    public void removeEmployee(){
	        boolean found = false;
	    	System.out.println("Digite o id:");
	        String id = sc.nextLine();
	       
	        for(Employee current : employee){
	            if(id.equals(current.getId())){
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
	        String id = sc.nextLine();
	        Employee check = findEmployee(id);
	        
	        if(check == null){
	            System.out.println("Nao a funcionario com esse id.");
	            return;
	        }
	        int weekDay = this.calendar.weekday;

	        if(!(check instanceof Hourly)){
	            System.out.println("Esse funcionario nao e Horista.");
	            return;
	        }

	        ((Hourly)check).timeCard(weekDay);
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
	                	 System.out.println("Pagamento via deposito bancario.");
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
	    
	    public Employee findEmployee(String id){
	        for(Employee current : employee){
	            if(id.equals(current.getId())){
	                return current;
	            }
	        }
	        return null;
	    }
	    public void saleResult() {
	        System.out.println("Digite o Id do funcionario:");
	        String id = sc.nextLine();
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
	        String id = sc.nextLine();
	        Employee check = findEmployee(id);

	        if(check == null){
	            System.out.println("Funcionario nao encontrado");
	            return;
	        }

	        System.out.println("Digite a taxa de servico:");
	        double tax = exceptions.doubleInput();
	        while(tax < 0){
	            System.out.println("Digite um valor correto para a taxa de servico");
	            tax = exceptions.doubleInput();
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
	        String id = sc.nextLine();
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
	        System.out.println("5 -> Taxa da Comissao.");
	        System.out.println("6 -> Sindicato.");
	        System.out.println("7 -> Id do Sindicato.");
	        System.out.println("8 -> Tipo de trabalho.");
	        System.out.println("9 -> Metodo de pagamento.");
	        System.out.println("10-> Taxa do sindicato.");

	        int opc = exceptions.integerInput();
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
	            while(newAddress.equals("")){
	            	System.out.println("Digite um endereco valido.");
	                newAddress = sc.nextLine();
	            }
	            check.setAddress(newAddress);
	            System.out.println("");
	        }else if(opc ==3) {
	        	System.out.println("Digite o novo id do funcionario:");
	            String newId = sc.nextLine();
	            while(newId.contains("equals")){
	            	System.out.println("Digite um numero valido.");
	                newId = sc.nextLine();
	            }
	            check.setId(newId);
	            System.out.println("");
	        }else if(opc == 4) {
	        	System.out.println("Digite o novo salario do Funcionario");
	            double newSalary = exceptions.doubleInput();
	            while(newSalary < 0){
	            System.out.println("Digite um salario valido");
	            	newSalary = exceptions.doubleInput();
	            }
	            check.setSalary(newSalary);
	            
	            if(check instanceof Hourly){
	            	((Hourly)check).setValueOfTimeWorked(check.getSalary()/220.0);
	            }
	                System.out.println("");
	        }else if(opc == 5) {
	                if(check instanceof Comissioned){
	                	System.out.println("Digite a taxa da atualizada da comissao: entre 0 e 1");
	                    double newCommission = exceptions.doubleInput();
	                    while(newCommission < 0 || newCommission > 1){
	                        System.out.println("Digite um valor validio:");
	                        newCommission = exceptions.doubleInput();
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
	                    int newIdSyndicate = exceptions.integerInput();
	                    while(newIdSyndicate < 0){
	                        System.out.println("Digite um valor valido");
	                        newIdSyndicate = exceptions.integerInput();
	                    }
	                    check.setIdSyndicate(newIdSyndicate);
	                    System.out.println(""); 
	                }
	            }else if (opc ==7) {
	                if(check.isSyndicate()){
	                    System.out.println("Digite o novo id do funcionario no Sindicato:");
	                    int newIdSyndicate = exceptions.integerInput();
	                    while(newIdSyndicate < 0){
	                        System.out.println("Digite um numero valido:");
	                        newIdSyndicate = exceptions.integerInput();
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
	            }else if(opc == 10) {
	            	if(check.isSyndicate()){
	                    System.out.println("Digite a nova taxa do sindicato: (valor entre  0 e 1)");
	                    double newFee = exceptions.doubleInput();
	                    while(newFee < 0 || newFee > 1){
	                        System.out.println("Please type a valid number.");
	                        newFee = exceptions.doubleInput();
	                    }
	                    System.out.println("");
	                }
	                else{
	                    System.out.println("Funcionario nao pertence ao sindicato");
	                }
	            }
		}
	   	
		public void Newtype(Employee Id){
			System.out.println("Digite o novo tipo que o funcinario ira pertencer.");
			System.out.println("1-Hourista 2-Assalariado 3-Comissionado");
			int type = exceptions.integerInput();
			
			while(type < 1 || type > 3){
				System.out.println("Digite uma opcao entre 1 e 3");
				type = exceptions.integerInput();
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
				employee.remove(Id);
				employee.add(newWageEarner);
		    }
		}
		public void NewCommissioned(Employee id){
			if(id instanceof Comissioned){
				System.out.println("Esse funcionario ja pertence a esse tipo.");
			}else{
				Comissioned newComissioned = new Comissioned(id);
				System.out.println("Digite a porcentagem da comissao do funcionario:");
				double newCommission = exceptions.doubleInput();
					
				while(newCommission < 0 || newCommission >1){
					System.out.println("Digite um numero entre 0 e 1.");
					newCommission = exceptions.doubleInput();
				}
				newComissioned.setCommission(newCommission);
				employee.remove(id);
				employee.add(newComissioned);
			}
		}
		
		public void payroll() {	    
			for(Employee current : employee){
	            if(current.agenda.isWeekly()){
	                weekPayment(current);
	            }else if(current.agenda.isEachTwoWeeks()){
	                if(current.agenda.isWeekToBePaid()){
	                    twoWeekPayment(current);
	                }else{
	                    current.agenda.setWeekToBePaid(true);
	                }
	            }else if(current.agenda.isMonthly()){
	                monthPayment(current);
	            }
	        }
	    }

	    public void weekPayment(Employee current) {
	        if(current.agenda.getWeekDay() == calendar.weekday) {
	            double value;
	            if (current instanceof Hourly) {
	                value = current.getPay();
	                value -= value*(current.getUnionFee() + current.getServiceTax());
	                printPayment(current,value);
	                current.setPay(0);
	            }
	            else if (current instanceof WageEarner) {
	                value = current.getPay()/4;
	                value -= value*(current.getUnionFee() + current.getServiceTax());
	                printPayment(current,value);
	            }
	            else if (current instanceof Comissioned) {
	                value = current.getPay()/4;
	                value -= value*(current.getUnionFee() + current.getServiceTax());
	                value += ((Comissioned) current).saleResult * ((Comissioned) current).getCommission();
	                ((Comissioned) current).saleResult = 0;
	                printPayment(current,value);
	            }
	        }
	    }

	    public void twoWeekPayment(Employee current) {
	        if(current.agenda.getWeekDay() == calendar.weekday) {
	            double value;
	            if (current instanceof Hourly) {
	                value = current.getPay();
	                value -= value*(current.getUnionFee() + current.getServiceTax());
	                printPayment(current,value);
	                current.setPay(0);
	            }
	            else if (current instanceof WageEarner) {
	                value = current.getPay()/2;
	                value -= value*(current.getUnionFee() + current.getServiceTax());
	                printPayment(current,value);
	            }
	            else if (current instanceof Comissioned) {
	                value = current.getPay()/2;
	                value -= value*(current.getUnionFee() + current.getServiceTax());
	                value += ((Comissioned) current).saleResult * ((Comissioned) current).getCommission();
	                ((Comissioned) current).saleResult = 0;
	                printPayment(current,value);
	            }
	        }
	    }

	    public void monthPayment(Employee current) {
	        boolean NowPay = PayNow(current);
	        if(NowPay) {
	            double value;
	            if (current instanceof Hourly) {
	                value = current.getPay();
	                value -= value*(current.getUnionFee() + current.getServiceTax());
	                printPayment(current,value);
	                current.setPay(0);
	            }
	            else if (current instanceof WageEarner) {
	                value = current.getPay();
	                value -= value*(current.getUnionFee() + current.getServiceTax());
	                printPayment(current,value);
	            }
	            else if (current instanceof Comissioned) {
	                value = current.getPay();
	                value -= value*(current.getUnionFee() + current.getServiceTax());
	                value += ((Comissioned) current).saleResult * ((Comissioned) current).getCommission();
	                ((Comissioned) current).saleResult = 0;
	                printPayment(current,value);
	            }
	        }
	    }
	    
	    public boolean PayNow(Employee current) {
	        if(current.agenda.isLastDay() && calendar.day == (calendar.daysPerMonth[calendar.month] - 1) && calendar.weekday == 7){
	            return true;
	        }else if(current.agenda.isLastDay() && (calendar.day == calendar.daysPerMonth[calendar.month])){
	            return true;
	        }else if(calendar.day == (current.agenda.getMonthDay() - 1) && calendar.day == 7){
	            return true;
	        }else if(calendar.day == current.agenda.getMonthDay()){
	            return true;
	        }
	        return false;
	    }
	    
	    public void printPayment(Employee current, double value) {
	        int opc = current.getPayment();
	        if(opc == 1) {
	        	System.out.println(current.getName() + " Receber: " + value + " - Cheque pelos correios.");
	        }else if(opc == 2) {
	        	System.out.println(current.getName() + " Receber: " + value + " - Cheque em maos.");
	        }else if(opc == 3) {
	        	System.out.println(current.getName() + " Receber: " + value + " - Deposito bancario.");
	        }
	    }   
	    
	    public void newAgendaDefault() {
	        System.out.println("Digite o Id do empregado que queira modificar:");
	        String id = sc.nextLine();
	        Employee check = findEmployee(id);

	        if(check == null){
	            System.out.println("Empregado nao encontrado.");
	            return;
	        }
	        
	        System.out.println("Digite a nova agenda do funcionario:");
	        System.out.println("1-> Semanal  2-> Bissemanal 3-> Mensal");
	        int opc = sc.nextInt();
	        while(opc < 1 || opc > 3) {
	        	System.out.println("Digite um valor valido entre 1 e 3");
	        	opc = exceptions.integerInput();
	        }
	        if(opc == 1){
	            newWeeklyDefault(check);
	        }else if(opc == 2){
	            newEachTwoWeeksDefault(check);
	        }else if(opc == 3){
	            newMonthlyDefault(check);
	        }
	    }
	    
	    public void newWeeklyDefault(Employee current) {
	    	current.agenda.setLastDay(false);
	    	current.agenda.setMonthly(false);
	    	current.agenda.setEachTwoWeeks(false);
	    	current.agenda.setWeekly(true);
	    	current.agenda.setWeekDay(6);
	    }

	    public void newEachTwoWeeksDefault(Employee current) {
	    	current.agenda.setLastDay(false);
	    	current.agenda.setMonthly(false);
	    	current.agenda.setEachTwoWeeks(true);
	    	current.agenda.setWeekly(false);
	    	current.agenda.setWeekDay(6);
	    	current.agenda.setWeekToBePaid(false);
	    }

	    public void newMonthlyDefault(Employee current){
            current.agenda.setLastDay(true);
            current.agenda.setMonthly(true);
            current.agenda.setEachTwoWeeks(false);
            current.agenda.setWeekly(false);
	    }
	    
	    public void newAgenda() {
	        System.out.println("Digite o Id do empregado que queira modificar:");
	        String id = sc.nextLine();
	        Employee check = findEmployee(id);

	        if(check == null){
	            System.out.println("Empregado nao encontrado.");
	            return;
	        }
	        
	        System.out.println("Digite a nova agenda do funcionario:");
	        System.out.println("1-> Semanal  2-> Bissemanal 3-> Mensal");
	        int opc = exceptions.integerInput();
	        
	        while(opc < 1 || opc > 3) {
	        	System.out.println("Digite um valor valido entre 1 e 3");
	        	opc = exceptions.integerInput();
	        }
	        if(opc == 1){
	            newWeekly(check);
	        }else if(opc == 2){
	            newEachTwoWeeks(check);
	        }else if(opc == 3){
	            newMonthly(check);
	        }
	    }

	    public void newWeekly(Employee current) {
	    	
	    	System.out.println("Escolha qual dia da semana queira receber:");
	    	System.out.println("2-> Segunda, 3-> Terca, 4-> Quarta, 5-> Quinta, 6-> Sexta");
	    	int day = exceptions.integerInput();
	    	
	    	while(day < 2 || day > 6) {
	    		System.out.println("Selecione um dia da semana valido.");
	    		day = exceptions.integerInput();
	    	}
	    	current.agenda.setLastDay(false);
	    	current.agenda.setMonthly(false);
	    	current.agenda.setEachTwoWeeks(false);
	    	current.agenda.setWeekly(true);
	    	current.agenda.setWeekDay(day);
	    }

	    public void newEachTwoWeeks(Employee current) {
	        
	    	System.out.println("Escolha qual dia da semana queira receber:");
	    	System.out.println("2-> Segunda, 3-> Terca, 4-> Quarta, 5-> Quinta, 6-> Sexta");
	    	int day = exceptions.integerInput();
	    	
	    	while(day < 2 || day > 6) {
	    		System.out.println("Selecione um dia da semana valido.");
	    		day = exceptions.integerInput();
	    	}
	    	current.agenda.setLastDay(false);
	    	current.agenda.setMonthly(false);
	    	current.agenda.setEachTwoWeeks(true);
	    	current.agenda.setWeekly(false);
	    	current.agenda.setWeekDay(day);
	    	current.agenda.setWeekToBePaid(false);
	    }

	    public void newMonthly(Employee current){
	        System.out.println("Escolhar qual dia do mes voce que receber:");    
	    	int day = exceptions.integerInput();
	    	
	    	while(day < 1 || day > 28) {
	    		System.out.println("Selecione um dia do mes valido.");
	    		day = exceptions.integerInput();
	    	}
	    	current.agenda.setMonthDay(day);
	    	current.agenda.setLastDay(false);
	    	current.agenda.setMonthly(true);
	    	current.agenda.setEachTwoWeeks(false);
	    	current.agenda.setWeekly(false);
	    }
	    
	    public void undo(){
	        if(undoRedo.undoStack.empty() || undoRedo.counterUndo.empty()){
	            return;
	        }
	        undoRedo.redoStack.push(employee);
	        undoRedo.counterRedo.push(cont);
	        employee = undoRedo.undoStack.pop();
	        cont = undoRedo.counterUndo.pop();
	    }

	    public void redo(){
	        if(undoRedo.redoStack.empty() || undoRedo.annualCounterRedo.empty() || undoRedo.counterRedo.empty()){
	            return;
	        }
	        copyRegister();
	        employee = undoRedo.redoStack.pop();
	        cont = undoRedo.counterRedo.pop();
	    }

	    public void emptyRedo(){
	        List<Employee> auxiliar = new ArrayList<Employee>();
	        int trash;
	        while(!undoRedo.redoStack.empty()){
	            auxiliar = undoRedo.redoStack.pop();
	        }
	        while(!undoRedo.annualCounterRedo.empty()){
	            trash = undoRedo.annualCounterRedo.pop();
	        }
	        while(!undoRedo.counterRedo.empty()){
	            trash = undoRedo.counterRedo.pop();
	        }
	    }

	    public void copy(){
	        List<Employee> copy = new ArrayList<Employee>();

	        for(Employee current : employee){
	            if(current instanceof  Hourly){
	                Employee auxiliar = new Hourly(current);
	                ((Hourly)auxiliar).timecard.setArrivalHour(((Hourly)current).timecard.getArrivalHour());
	                ((Hourly)auxiliar).timecard.setArrivalMinute(((Hourly)current).timecard.getArrivalMinute());
	                ((Hourly)auxiliar).timecard.setExitHour(((Hourly)current).timecard.getExitHour());
	                ((Hourly)auxiliar).timecard.setExitMinute(((Hourly)current).timecard.getExitMinute());
	                auxiliar.agenda.setWeekly(current.agenda.isWeekly());
	                auxiliar.agenda.setEachTwoWeeks(current.agenda.isEachTwoWeeks());
	                auxiliar.agenda.setMonthly(current.agenda.isMonthly());
	                auxiliar.agenda.setLastDay(current.agenda.isLastDay());
	                auxiliar.agenda.setWeekToBePaid(current.agenda.isWeekToBePaid());
	                auxiliar.agenda.setWeekDay(current.agenda.getWeekDay());
	                auxiliar.agenda.setMonthDay(current.agenda.getMonthDay());

	                copy.add(auxiliar);
	            }
	            else if(current instanceof  WageEarner){
	                Employee auxiliar = new WageEarner(current);
	                auxiliar.agenda.setWeekly(current.agenda.isWeekly());
	                auxiliar.agenda.setEachTwoWeeks(current.agenda.isEachTwoWeeks());
	                auxiliar.agenda.setMonthly(current.agenda.isMonthly());
	                auxiliar.agenda.setLastDay(current.agenda.isLastDay());
	                auxiliar.agenda.setWeekToBePaid(current.agenda.isWeekToBePaid());
	                auxiliar.agenda.setWeekDay(current.agenda.getWeekDay());
	                auxiliar.agenda.setMonthDay(current.agenda.getMonthDay());

	                copy.add(auxiliar);
	            }
	            else if(current instanceof Comissioned){
	                Employee auxiliar = new Comissioned(current);
	                ((Comissioned)auxiliar).setCommission(((Comissioned)current).getCommission());
	                ((Comissioned) auxiliar).saleResult = ((Comissioned) current).saleResult;
	                auxiliar.agenda.setWeekly(current.agenda.isWeekly());
	                auxiliar.agenda.setEachTwoWeeks(current.agenda.isEachTwoWeeks());
	                auxiliar.agenda.setMonthly(current.agenda.isMonthly());
	                auxiliar.agenda.setLastDay(current.agenda.isLastDay());
	                auxiliar.agenda.setWeekToBePaid(current.agenda.isWeekToBePaid());
	                auxiliar.agenda.setWeekDay(current.agenda.getWeekDay());
	                auxiliar.agenda.setMonthDay(current.agenda.getMonthDay());

	                copy.add(auxiliar);
	            }
	        }
	        undoRedo.undoStack.push(copy);
	        undoRedo.counterUndo.push(cont);
	    }

}