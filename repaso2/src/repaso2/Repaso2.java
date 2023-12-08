/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repaso2;

/**
 *
 * @author invitado
 */
public class Repaso2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] matriz = new int [3][4];
        matriz [0][0]=100;
        matriz [0][1]=100;
        matriz [0][2]=100;
        matriz [0][3]=100;
        matriz [1][0]=100;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
              matriz[i][j]=(int)(Math.random()*100) ; 
            }
        }
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("["+matriz[i][j]+"]");
            }
            System.out.println("");
        }
        
    }
    
}
