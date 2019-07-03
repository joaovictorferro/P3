package utilitarios;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exceptions {
	Scanner sc = new Scanner(System.in);

    public int integerInput(){
        while (true){
            try{
                return sc.nextInt();
            }
            catch (InputMismatchException ime){
                sc.next();
                System.out.println("Incompatibilidade de entrada.");
                System.out.println("Por favor, digite um número inteiro.");
            }
        }
    }

    public double doubleInput(){
        while (true){
            try{
                return sc.nextDouble();
            }
            catch (InputMismatchException ime){
                sc.next();
                System.out.println("Incompatibilidade de entrada.");
                System.out.println("Por favor, digite um numero do tipo double.");
            }
        }
    }

    public int toInteger(String info){
        while(true){
            try{
                return Integer.parseInt(info);
            }
            catch (NumberFormatException nfe){
                System.out.println("Exceção de formato numérico.");
                System.out.println("A string não pôde ser convertida em um inteiro.");
                System.out.println("Agenda Invalida.");
                return -1;
            }
        }
    }
}