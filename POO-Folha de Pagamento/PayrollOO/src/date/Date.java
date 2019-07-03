package date;

import java.util.Scanner;

import utilitarios.Exceptions;

public class Date {
	Exceptions exceptions = new Exceptions();
    static Scanner sc = new Scanner(System.in);
    public int day;
    public int month;
    public int year;
    public int[] daysPerMonth = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    public int weekday;

    public Date(){
        System.out.println("Digite a data Atual.");
        System.out.println("Ano:");
        year = exceptions.integerInput();
        System.out.println("Mes:");
        month = exceptions.integerInput();
        while(month < 1 || month > 12){
            System.out.println("Digite um mes valido.");
            month = exceptions.integerInput();
        }
        System.out.println("Dia:");
        day = exceptions.integerInput();
        while (day < 1 || day > daysPerMonth[month]){
            System.out.println("Digite um dia valido.");
            day = exceptions.integerInput();
        }
        System.out.println("Digite o dia da semana:");
        System.out.println("1-Domingo 2-Segunda 3-Terca 4-Quarta 5-Quinta 6-Sexta 7-Sabado");
        weekday = exceptions.integerInput();
        while(weekday < 1 || weekday > 7){
            System.out.println("Digite um dia valido referente a semana.");
            weekday = exceptions.integerInput();
        }
    }

    public void dateUpgrade() {
        this.weekday ++;
        if(weekday > 7){
            weekday = 1;
        }
        this.day ++;
        if(this.day > daysPerMonth[this.month]){
            this.day = 1;
            this.month++;
        }
        if(this.month > 12){
            this.month = 1;
            this.year++;
        }
    }
}