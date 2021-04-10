/*
 * Programa que gestiona y representa una cuenta bancaria introducida por el usuario, permitiendo lo siguiente:
 * 
 * - Creación de cuentas a través de la immplementación de los distintos tipos de constructores (por defecto, con todos los parámetros y de copia). 
 * - Implementación de los métodos setters y getters para asignar y obtener los datos de la cuenta para la integración de dos clases.
 * - Implementación de un método de comportamiento para realizar una transferencia por defecto de una cuenta de Origen a una Destino.
 * - Visualización de balances generales y específicos de acuerdo a los movimientos realizados.
 * 
 * @author Carlos Daniel Martínez Ávila
 * @version 1.0
 */

public class Cuenta{
	
	//Atributos
	private String nombreTitular, numeroCuenta, tipoTransacciones;
    private double tipoInteres, saldo;

    
    //Constructores
    
    //Constructor por defecto
	public Cuenta(){ 
        //Inicializa los valores por defecto de un objeto instanciado, en este caso, a la cuenta principal.
    }

    //Constructor con todos los parámetros para instanciar una cuenta
    public Cuenta(String nombreTitular, String numeroCuenta, double tipoInteres, double saldo){
        this.nombreTitular = nombreTitular;
        this.numeroCuenta = numeroCuenta;
        this.tipoInteres = tipoInteres;
        this.saldo = saldo;
    }

    //Constructor copia
    public Cuenta(Cuenta c){
        nombreTitular = c.nombreTitular;
        tipoInteres = c.tipoInteres;
        saldo = c.saldo;
    }


	//Métodos Getters y Setters
	void setNombreTitular(String n){
		this.nombreTitular = n;
    }
    
	String getNombreTitular(){
		return this.nombreTitular;
	}

	void setNumeroCuenta(String nc){
		this.numeroCuenta = nc;
	}
	
	String getNumeroCuenta(){
		return this.numeroCuenta;
	} 	

	void setTipoInteres(double ti){
		this.tipoInteres = ti;
	}	

    double getTipoInteres(){
	    return this.tipoInteres;
	} 

    void setSaldo(double s){
		this.saldo = s;
    }	
    
    double getSaldo(){
	    return this.saldo;
    } 
    
    //Métodos de Comportamiento
    public void transaccion(double cantidad, int tipoTransaccion){
        //Integro
        if(tipoTransaccion==1){
            this.saldo += cantidad;

            tipoTransacciones = "Integro";
        }

        //Reintegro
        if (tipoTransaccion == 2){
            if (this.saldo < cantidad){
                System.out.println ("ERROR: Fondos Insuficientes");
            } else{
                this.saldo -= cantidad;
                tipoTransacciones ="Reintegro";
            }
        }

        if (tipoTransaccion == 0){
            System.out.println("ERROR");
        }
    }
    
    //Método para Integrar
    public boolean integro(double i){
        boolean integroValido = true;
        if (i<0){
            integroValido = false;
        }else{
            saldo = saldo + i;
        }
        return integroValido;
    }
    //Método de Consulta de Transacciones
    public void ConsultaTransacc(){
        System.out.println("El tipo de transaccion fue: " + tipoTransacciones + ", consolidando un nuevo saldo de: " + saldo + "bs.S");
    }

    public void Consultar(){
        System.out.println("Cliente " + nombreTitular +  ", titular de la Cuenta: " + numeroCuenta + ", su saldo definitivo es de: " + saldo +  "bs.S");
    }
    
    //Método para Reintegrar
    public boolean reintegro(double r){
        boolean reintegroValido = true;
        if(r<0){
            reintegroValido = false;
        } else if (saldo >= r){
            saldo -= r;
        } else{
            reintegroValido = false;
        }
        return reintegroValido;
    }

    //Método para Transferir
    public boolean transferir(Cuenta c, double t){
        boolean transferenciaValida = true;
        if (t<0){
            transferenciaValida = false;
        } else if (saldo >= t){
            reintegro(t);
            c.integro(t);
        } else {
            transferenciaValida = false;
        }
        return transferenciaValida;
    }
}