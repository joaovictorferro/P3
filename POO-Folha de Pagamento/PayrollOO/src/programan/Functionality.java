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
}