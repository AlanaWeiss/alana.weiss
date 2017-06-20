import java.util.Scanner;

class exercicioNumeros {

    public static void main(String[] args) {
        try (final Scanner scanner = new Scanner(System.in)) {
			int numero = scanner.nextInt();
			
			if (numero % 2 == 0)
				 System.out.println("Numero par - " + numero);
			else 
				System.out.println("Numero impar - " + numero);
			
        } catch (Exception e) {
            //...
        }
    }
}