package inventario.view;

import java.util.Scanner;

import inventario.entity.Inventario;
import view.InputTypes;

public class InventarioIO {

	public static Inventario ingresar(Scanner scanner){
		int codInventario =
				InputTypes.readInt("Ingresar Codigo Inventario :", scanner);
		String FechaRevision =
				InputTypes.readString("Fecha de revision del inventario :", scanner);
		
		return new 
				Inventario (codInventario, FechaRevision);
		
	}
}
