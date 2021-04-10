import java.util.Scanner;

/*
 * Programa que gestiona y representa una cuenta bancaria introducida por el usuario, permitiendo lo siguiente:
 * 
 * - Creaci�n de cuentas a trav�s de la immplementaci�n de los distintos tipos de constructores (por defecto, con todos los par�metros y de copia). 
 * - Implementaci�n de los m�todos setters y getters para asignar y obtener los datos de la cuenta para la integraci�n de dos clases.
 * - Implementaci�n de un m�todo de comportamiento para realizar una transferencia por defecto de una cuenta de Origen a una Destino.
 * - Visualizaci�n de balances generales y espec�ficos de acuerdo a los movimientos realizados.
 * 
 * @author Carlos Daniel Mart�nez �vila
 * @version 1.0
 */

public class Principal {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        String nombreTitular, numeroCuenta;
        double tipoInteres, saldo, cantidad, cantidadt;
        int tipoTransaccion, respuesta;

        //Uso del constructor por defecto para la creaci�n de una primera cuenta
        Cuenta cuenta1 = new Cuenta();
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("*******************************  BIENVENIDO  ***************************************");
        System.out.println("------------------------------------------------------------------------------------");

        System.out.println("\n-----------------  Registro de Datos de la cuenta del Cliente No. 1-----------------\n");
        System.out.print("Por favor, ingrese el nombre del titular: ");
        nombreTitular = sc.nextLine();   
        System.out.print("A continuaci�n, ingrese el n�mero de cuenta: ");
        numeroCuenta = sc.nextLine();
        System.out.print("Ingrese el impuesto inicial aplicado al saldo a ingresar con , : ");
        tipoInteres = sc.nextDouble();
        System.out.print("Digite el saldo inicial del cliente principal (No. 1) en bol�vares soberanos (bs.S): ");
        saldo = sc.nextDouble();

        cuenta1.setNombreTitular(nombreTitular);
        cuenta1.setNumeroCuenta(numeroCuenta);
        cuenta1.setSaldo(saldo);
        cuenta1.setTipoInteres(tipoInteres);

        //Uso del constructor con par�metros para la creaci�n de una segunda cuenta
        Cuenta cuenta2 = new Cuenta("William", "011616021335", 0.25, 5600000);

         //Uso del constructor copia para la creaci�n de una tercera cuenta igual a la primera

        System.out.println("\n----------------  Directorio de Cuentas de Terceros registradas----------------\n");

        System.out.println("Nombre del Titular: "+ cuenta2.getNombreTitular());
        System.out.println("N�mero de cuenta: "+ cuenta2.getNumeroCuenta());
        System.out.println("Tipo de Inter�s: "+ cuenta2.getTipoInteres());
        System.out.println("Saldo: "+ cuenta2.getSaldo() + "bs.S");
        

        System.out.println("\n");
 
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("*****************************  TRANSACCIONES  **************************************");
        System.out.println("------------------------------------------------------------------------------------\n");

        respuesta = 1;
        while (respuesta != 2){
            System.out.println("*********** CLIENTE No. 1 ******************\n");
            System.out.println("Elija el Tipo de Transacci�n del Cliente No.1: (1-Integro 2- Reintegro)");
            tipoTransaccion = sc.nextInt();
            System.out.println ("Ingrese la cantidad a tramitar en bol�vares soberanos (bs.S): ");
            cantidad = sc.nextDouble();
            cuenta1.transaccion(cantidad, tipoTransaccion);
            System.out.println("Monto de la transacci�n del Cliente No. 1: " + cantidad + " \n");
            System.out.println("********************************************");
            cuenta1.ConsultaTransacc();
            System.out.println("********************************************");
    
            System.out.println("\n�Desea registrar otra transacci�n para el cliente No.1? (1-SI 2-NO)");
            respuesta = sc.nextInt();
        }


        System.out.println("\n*********** CLIENTE No. 2 ******************");
        respuesta = 1;
        while (respuesta != 2){
            System.out.println("Tipo de Transacci�n del Cliente No.2: (1- Integro 2- Reintegro)");
            tipoTransaccion = sc.nextInt();

            System.out.println("Ingrese el monto de la transacci�n del Cliente No.2 en bol�vares soberanos (bs.S): ");
            cantidad = sc.nextDouble();

            cuenta2.transaccion(cantidad, tipoTransaccion);

            System.out.println("*****************************************************");
            cuenta2.ConsultaTransacc();
            System.out.println("*****************************************************\n");

            System.out.println("�Desea registrar otra integro o reintegro para el Cliente No. 2? (1-SI 2-NO2)");
            respuesta = sc.nextInt();

        }
        System.out.println("\n");

        System.out.println("------------------------------------------------------------------------------------");
        cuenta1.Consultar();
        cuenta2.Consultar();
        System.out.println("------------------------------------------------------------------------------------");
        
        //Transferencia predefinida desde la cuenta2 a la cuenta1
        
        System.out.println ("\nProcesando transferencia pendiente de " + cuenta2.getNombreTitular() + " para " + cuenta1.getNombreTitular() + " por concepto de deuda pendiente:  \n");
        System.out.println ("Por favor, ingrese el monto a transferir en bol�vares soberanos (bs.S)");
        cantidadt = sc.nextDouble();
        if ((cuenta2.getSaldo()- cantidadt)<=0){
            System.out.println ("No se puede hacer la transferencia, pues no hay saldo suficiente en la cuenta de " + cuenta2.getNombreTitular());
        } else{
            cuenta1.setSaldo(cuenta1.getSaldo() + cantidadt);
            cuenta2.setSaldo(cuenta2.getSaldo()- cantidadt);
            System.out.println("\n------------------------------------------------------------------------------------");
            System.out.println("El nuevo saldo de " + cuenta1.getNombreTitular()+" es de: "+ cuenta1.getSaldo()+ " bs.S");
            System.out.println("El nuevo saldo de "+ cuenta2.getNombreTitular()+ " es de: "+ cuenta2.getSaldo()+ "bs.S");
            System.out.println("------------------------------------------------------------------------------------");
        }
        sc.close();
        }
}
