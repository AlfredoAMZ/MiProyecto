package obrero.view;

import java.util.Scanner;


import obrero.entity.Obrero;
import view.InputTypes;

public class ObreroIO {
	
	public static Obrero ingresar(Scanner scanner){
		int CodObrero =
				InputTypes.readInt("Ingresar Codigo Inventario :", scanner);
		int CI =
				InputTypes.readInt("Ingresar Codigo Inventario :", scanner);
		String NombreCompleto =
				InputTypes.readString("Fecha de revision del inventario :", scanner);
		String FechadeNacimiento =
				InputTypes.readString("Fecha de revision del inventario :", scanner);
		int Telefono =
				InputTypes.readInt("Ingresar Codigo Inventario :", scanner);
		
		return new 
				Obrero (CodObrero, CI, NombreCompleto, FechadeNacimiento, Telefono);
		
	}

}
