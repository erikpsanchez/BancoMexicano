import java.util.Scanner;

public class VistaCliente {
    private Scanner lectura;

    public Integer menu() {

        lectura = new Scanner(System.in);

        System.out.println("\n\n\t***Menú de Banco***");
        System.out.println("1.- Agregar cliente");
        System.out.println("2.- Realizar depósito");
        System.out.println("3.- Realizar retiro");
        System.out.println("4.- Realizar transferencia");
        System.out.println("5.- Busqueda de cliente por cuenta");
        System.out.println("6.- Salir");
        System.out.print("\n* Opción: ");
        Integer op = lectura.nextInt();
        System.out.print("\n");

        return op;
    }

    public String pedirNombre() {
        System.out.print("Escribe el nombre del cliente: ");
        return lectura.next();
    }

    public String pedirApellido() {
        System.out.print("Escribe el apellido del cliente: ");
        return lectura.next();
    }

    public double pedirSaldo() {
        System.out.print("Escribe el saldo del cliente: ");
        return lectura.nextDouble();
    }

    public Integer pedirNumeroDeCuenta() {
        System.out.print("Escribe el número de cuenta del cliente: ");
        return lectura.nextInt();
    }

    public Integer pedirNumeroDeCuentaDestino() {
        System.out.print("Escribe el número de cuenta del cliente al que desea realizarle la transferencia: ");
        return lectura.nextInt();
    }

    public void imprimirInfoCliente(Cliente obj1) {
        if (obj1 != null) {
            System.out.println("\n- El nombre del cliente es: " + obj1.getNombre());
            System.out.println("- El apellido del cliente es: " + obj1.getApellido());
            System.out.println("- El saldo del cliente es: $" + obj1.getSaldo());
        } else {
            System.out.println("\nX Error. No se encontro un cliente con ese número de cuenta");
        }
    }

    public double pedirMontoDeposito() {
        lectura = new Scanner(System.in);
        System.out.print("\n¿Cuánto desea depositar? ");
        return lectura.nextDouble();
    }

    public double pedirMontoRetiro() {
        lectura = new Scanner(System.in);
        System.out.print("\n¿Cuánto desea retirar? ");
        return lectura.nextDouble();
    }

    public double pedirMontoTransferencia() {
        lectura = new Scanner(System.in);
        System.out.print("\n¿Cuánto desea transferir? ");
        return lectura.nextDouble();
    }

    public void mensajeDeposito(Cliente obj1, Integer resultado) {
        if (resultado == 0) { 
            System.out.print("\nX Error. No se encontro un cliente con ese número de cuenta");
        }else{ // resultado == 1
            System.out.print("\nDepósito realizado con éxito. El nuevo saldo es de: $" + obj1.getSaldo());
        }
    }

    public void mensajeRetiro(Cliente obj1, Integer resultado) {
        if (resultado == 0) {
            System.out.print("\nX Error. No se encontro un cliente con ese número de cuenta");
        } else if (resultado == 1) {
            System.out.print("\nRetiro realizado con éxito. El nuevo saldo es de: $" + obj1.getSaldo());
        }else { //resultado == 2
            System.out.print("\nX Error. No cuenta con saldo suficiente para realizar el retiro");
        }
    }

    public void mensajeTransferencia(Cliente obj1, Integer resultado) {
        if (resultado == 0) {
            System.out.print("\nX Error. No se encontro un cliente con ese número de cuenta");
        } else if (resultado == 1) {
            System.out.print("\nTransferencia realizada con éxito. El nuevo saldo es de: $" + obj1.getSaldo());
        }else { //resultado == 2
            System.out.print("\nX Error. No cuenta con saldo suficiente para realizar la tranferencia");
        }
    }
}
