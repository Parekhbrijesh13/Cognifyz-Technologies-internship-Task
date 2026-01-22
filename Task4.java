
import java.util.Scanner;

public class Task4 {


    public static void main(String args[]) {
        // TODO code application logic here
        
        Temp t1 = new Temp();
        t1.weather();
        
    }
}

class Temp{

    Scanner sc = new Scanner(System.in);
    
    
    public void weather(){
        String choose;
        
        do{
        
            System.out.println("1. Convert Celsius to Fahrenheit");
            System.out.println("2. Convert Fahrenheit to Celsius");

            System.out.println("Enter Your Choice:");
            int choice = sc.nextInt();

            double res;

            switch(choice){

                case 1:

                    System.out.println("Enter a Celsius: ");
                    double cel = sc.nextDouble();

                    res = cel * 9 / 5 + 32;
                    System.out.println("Fahrenheit is :" + res);                
                    break;

                case 2:

                    System.out.println("Enter a Fahrenheit: ");
                    double fah = sc.nextDouble();

                    res = (fah - 32) * 5 / 9;

                    System.out.println("Celsius is :" + res);                
                    break;

                default:
                    System.out.println("Enter Wrong Input.");
                    
            }
            
            
            System.out.println("Do you want to continue?(yes/no)");
            sc.nextLine();
            choose = sc.nextLine();
            
        }while(choose.equalsIgnoreCase("yes"));
    }
}