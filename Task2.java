/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

import java.util.Scanner;

public class Task2 {


    public static void main(String args[]) {
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter a number of row:");
        int row = sc.nextInt();
        
        for(int i = 1; i <= row; i++){
            
            for(int j = 1; j <= i; j++){
                
                System.out.print(" * ");
            }
            System.out.println();
        }
        sc.close();
    }
}
