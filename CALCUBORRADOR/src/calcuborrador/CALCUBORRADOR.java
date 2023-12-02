/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calcuborrador;

import java.util.Scanner;

public class CALCUBORRADOR {
//Quisiera declarale mi amor, pero solo se declarar variables(no le se a hacer arreglos)  
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("---------------Calculadora Binaria--------------");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Convertidor de número decimal a Binario");
            System.out.println("6. Salir");
            System.out.print("Elija una opción: ");
            int opcion = scanner.nextInt();

            if (opcion == 6) {
                System.out.println("---------------Saliendo de la calculadora--------------");
                break;
            }

            if (opcion == 5) {
                System.out.print("Ingrese el primer número decimal: ");
                int decimal = scanner.nextInt();
                System.out.print("Ingrese el segundo número decimal: ");
                int decimal2 = scanner.nextInt();
                if (!verificarNumero(decimal) || !verificarNumero(decimal2)) {
                    System.out.print("ERROR: Tiene que ser un número entero positivo. ");
                    return;
                }

                String binario = Integer.toBinaryString(decimal);
                String binario2 = Integer.toBinaryString(decimal2);
                System.out.println("Resultado del primer numero binario: " + binario);
                System.out.println("Resultado del segundo numero en binario: " + binario2);
                break;
            }

            System.out.print("Ingrese el primer número binario: ");
            String numero1 = scanner.next();
            System.out.print("Ingrese el segundo número binario: ");
            String numero2 = scanner.next();
            
           if (!verificarBinario(numero1) || !verificarBinario(numero2)) {
                System.out.println("Por favor, ingrese SOLO números binarios válidos.");
                return;
            }

            switch (opcion) {
                case 1:
                    String suma = sumarBinarios(numero1, numero2);
                    System.out.println("");
                    System.out.println("Resultado: " + suma);
                    System.out.println("");

                    break;
                case 2:
                    String resta = restarBinarios(numero1, numero2);
                    System.out.println("");
                    System.out.println("Resultado: " + resta);
                    System.out.println("");
                    break;
                case 3:
                    String multiplicacion = multiplicarBinarios(numero1, numero2);
                    System.out.println("");
                    System.out.println("Resultado: " + multiplicacion);
                    System.out.println("");
                    break;
                case 4:
                    String division = dividirBinarios(numero1, numero2);
                    System.out.println("");
                    System.out.println("Resultado: " + division);
                    System.out.println("");
                    break;
                default:
                    while(true){
                    System.out.println("");
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    System.out.println("");
                    break;
                    }
            }
        }
    }

    //  Suma  
    public static String sumarBinarios(String bin1, String bin2) {
        int maxLength = Math.max(bin1.length(), bin2.length());
        bin1 = padLeft(bin1, maxLength);
        bin2 = padLeft(bin2, maxLength);

        StringBuilder resultado = new StringBuilder();
        int carry = 0;

        for (int i = maxLength - 1; i >= 0; i--) {
            int bit1 = Character.getNumericValue(bin1.charAt(i));
            int bit2 = Character.getNumericValue(bin2.charAt(i));

            int suma = bit1 + bit2 + carry;
            resultado.insert(0, suma % 2);
            carry = suma / 2;
        }

        if (carry > 0) {
            resultado.insert(0, carry);
        }

        return resultado.toString();
    }

    // Resta 
    public static String restarBinarios(String bin1, String bin2) {
        int maxLength = Math.max(bin1.length(), bin2.length());
        bin1 = padLeft(bin1, maxLength);
        bin2 = padLeft(bin2, maxLength);

        StringBuilder resultado = new StringBuilder();
        int borrow = 0;

        for (int i = maxLength - 1; i >= 0; i--) {
            int bit1 = Character.getNumericValue(bin1.charAt(i));
            int bit2 = Character.getNumericValue(bin2.charAt(i));

            int resta = bit1 - bit2 - borrow;
            if (resta < 0) {
                resta += 2;
                borrow = 1;
            } else {
                borrow = 0;
            }

            resultado.insert(0, resta);
        }

        return resultado.toString();
    }

    // Multiplicación  
    public static String multiplicarBinarios(String bin1, String bin2) {
        return Integer.toBinaryString(Integer.parseInt(bin1, 2) * Integer.parseInt(bin2, 2));
    }

    //Dividición 
    public static String dividirBinarios(String bin1, String bin2) {
        int numero1 = Integer.parseInt(bin1, 2);
        int numero2 = Integer.parseInt(bin2, 2);

        if (numero2 == 0) {
            return "Error: División por cero";
        }

        return Integer.toBinaryString(numero1 / numero2);
    }

    //Verificador de numeros binarios 
    public static boolean verificarBinario(String binario) {
        for (char digito : binario.toCharArray()) {
            if (digito != '0' && digito != '1') {
                return false;
            }
        }
        return true;
    }
     //Verificador de numero entero positivo
    public static boolean verificarNumero (int n){
        return n >= 0;
    }
   

    //Rellenado de una cadena con ceros a la izquierda
    public static String padLeft(String s, int length) {
        return String.format("%" + length + "s", s).replace(' ', '0');
    }
}
