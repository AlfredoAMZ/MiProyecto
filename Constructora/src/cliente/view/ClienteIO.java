package cliente.view;

import java.util.Scanner;

import cliente.entity.Cliente;
import view.InputTypes;

public class ClienteIO {
	public static Cliente ingresar(Scanner scanner){
		int codCliente =
				InputTypes.readInt("Ingresar Codigo Cliente :", scanner);
		int ciCliente = 
				InputTypes.readInt("Ingresar CI del Cliente :", scanner);
		String NombreCompleto =
				InputTypes.readString("Nombre completo :", scanner);
		return new 
			Cliente(codCliente, ciCliente, NombreCompleto);
		
	}

}
