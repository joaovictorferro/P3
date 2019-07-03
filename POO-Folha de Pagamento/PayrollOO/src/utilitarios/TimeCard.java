package utilitarios;

import java.util.Scanner;

public class TimeCard {
	 Scanner sc = new Scanner(System.in);
	    
	 private int arrivalHour;
	 private int arrivalMinute;
	 private int exitHour;
	 private int exitMinute;

	 public double dailyWorkingPeriod(){ 
		 
		 double amount;
		 double hours;
		 double minutes;

	     hours = exitHour - arrivalHour;
	     minutes = exitMinute - arrivalMinute;
	     if(minutes < 0){
	    	 minutes += 60;
	         hours --;
	       }

	      amount = hours + (minutes/60.0);

	     return amount;
	    }

	    public int getArrivalHour(){
	        return arrivalHour;
	    }

	    public void setArrivalHour(int arrivalHour) {
	        this.arrivalHour = arrivalHour;
	    }

	    public int getArrivalMinute() {
	        return arrivalMinute;
	    }

	    public void setArrivalMinute(int arrivalMinute) {
	        this.arrivalMinute = arrivalMinute;
	    }

	    public int getExitHour() {
	        return exitHour;
	    }

	    public void setExitHour(int exitHour) {
	        this.exitHour = exitHour;
	    }

	    public int getExitMinute() {
	        return exitMinute;
	    }

	    public void setExitMinute(int exitMinute) {
	        this.exitMinute = exitMinute;
	    }

	    public void arrivalTime() {
	        System.out.println("Hora de entrada.");
	        System.out.println("Digite a hora de entrada:");
	        int hour = sc.nextInt();
	        while(hour < 0 || hour > 24){
	            System.out.println("Digite uma hora valida");
	            hour = sc.nextInt();
	        }
	        this.arrivalHour = hour;
	        System.out.println("Digite os minutos:");
	        int minutes = sc.nextInt();
	        while(minutes < 0 || minutes > 59){
	            System.out.println("Please type a valid minute.");
	            minutes = sc.nextInt();
	        }
	        this.arrivalMinute = minutes;
	    }

	    public void exitTime() {
	        System.out.println("Hora da saida.");
	        System.out.println("Digite a hora de saida:");
	        int hour = sc.nextInt();
	        while(hour < 0 || hour > 24 || hour <= this.getArrivalHour()){
	            System.out.println("Digite uma hora valida");
	            hour = sc.nextInt();
	        }
	        this.exitHour = hour;
	        System.out.println("Digite os minutos da saida:");
	        int minutes = sc.nextInt();
	        while(minutes < 0 || minutes > 59){
	            System.out.println("Digite o minuto de saida.");
	            minutes = sc.nextInt();
	        }
	        this.exitMinute = minutes;
	    }
}