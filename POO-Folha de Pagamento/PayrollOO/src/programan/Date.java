package programan;

import java.util.Scanner;

public class Date {
    static Scanner sc = new Scanner(System.in);
    public int day;
    public int month;
    public int year;
    public int[] daysPerMonth = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    public int weekday;

    public Date(){
        System.out.println("Digite a data Atual.");
        System.out.println("Ano:");
        year = sc.nextInt();
        if(bissextYear()){
            this.daysPerMonth[2] = 29;
        }
        else{
            this.daysPerMonth[2] = 28;
        }
        System.out.println("Mes:");
        month = sc.nextInt();
        while(month < 1 || month > 12){
            System.out.println("Digite um ano valido.");
            month = sc.nextInt();
        }
        System.out.println("Dia:");
        day = sc.nextInt();
        while (day < 1 || day > daysPerMonth[month]){
            System.out.println("Digite um dia valido.");
            day = sc.nextInt();
        }
        System.out.println("Digite o dia da semana:");
        System.out.println("1-Domingo 2-Segunda 3-Terca 4-Quarta 5-Quinta 6-Sexta 7-Sabado");
        weekday = sc.nextInt();
        while(weekday < 1 || weekday > 7){
            System.out.println("Digite um dia valido referente a semana.");
            weekday = sc.nextInt();
        }
    }

    public boolean dateManager() {
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
            if(bissextYear()){
                this.daysPerMonth[2] = 29;
            }
            else{
                this.daysPerMonth[2] = 28;
            }
            return true;
        }
        return false;
    }

    public boolean bissextYear() {
        if(this.year % 400 == 0 || (this.year % 4 == 0 && this.year % 100 != 0)){
            return true;
        }
        return false;
    }

}
