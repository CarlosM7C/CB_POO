# CuentaBanco

PROGRAMA CUENTA BANCARIA EN JAVA. 

Escribe una clase Cuenta para representar una cuenta bancaria. Los datos de la cuenta son: nombre del cliente (String), número de cuenta (String), tipo de interés (double) y saldo (double). 

La clase contendrá los siguientes métodos: 

Constructor por defecto 
Constructor con todos los parámetros 
Constructor copia. 

Métodos setters/getters para asignar y obtener los datos de la cuenta. 

Métodos ingreso y reintegro. Un ingreso consiste en aumentar el saldo en la cantidad que se indique. Esa cantidad no puede ser negativa. Un reintegro consiste en disminuir el saldo en una cantidad pero antes se debe comprobar que hay saldo suficiente. La cantidad no puede ser negativa. Los métodos ingreso y reintegro devuelven true si la operación se ha podido realizar o false en caso contrario. 

Método transferencia que permita pasar dinero de una cuenta a otra siempre que en la cuenta de origen haya dinero suficiente para poder hacerla. Ejemplo de uso del método transferencia: cuentaOrigen.transferencia(cuentaDestino, importe); que indica que queremos hacer una transferencia desde cuentaOrigen a cuentaDestino del importe indicado.
