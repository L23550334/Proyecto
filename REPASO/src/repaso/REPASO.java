/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repaso;

import java.util.Scanner;

/**
 *
 * @author invitado
 */
public class REPASO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input= new Scanner(System.in);
        String cade=input.nextLine();
        
        System.out.println(cade.charAt(4));
        
        for (int i = 0; i < cade.length(); i++) {
            System.out.print("["+cade.charAt(i)+"]");
        }
    }
    
}
