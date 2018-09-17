package obrero.view;

import java.util.Scanner;


import obrero.entity.Obrero;
import view.InputTypes;

public class ObreroIO {
	
	public static Obrero ingresar(Scanner scanner){
		int CodObrero =
				InputTypes.readInt("Ingresar Codigo de Obrero :", scanner);
		int CI =
				InputTypes.readInt("Ingresar CI:", scanner);
		String NombreCompleto =
				InputTypes.readString("Nombre Completo", scanner);
		String FechadeNacimiento =
				InputTypes.readString("Fecha de nacimiento :", scanner);
		int Telefono =
				InputTypes.readInt("Telefono:", scanner);
		
		return new 
				Obrero (CodObrero, CI, NombreCompleto, FechadeNacimiento, Telefono);
		
	}

}
