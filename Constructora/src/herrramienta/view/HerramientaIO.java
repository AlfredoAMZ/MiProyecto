package herrramienta.view;

import java.util.Scanner;

import herramienta.entity.Herramienta;
import view.InputTypes;

public class HerramientaIO {
	
	public static Herramienta ingresar(Scanner scanner){
		int codHerramienta =
				InputTypes.readInt("Ingresar Codigo Herramienta :", scanner);
		String FechaAdquisicion =
				InputTypes.readString("Fecha de Adquisicion de la Herramienta :", scanner);
		double precio = 
				InputTypes.readDouble("Ingresar precio de la Herramienta :", scanner);
		String Especificacion =
				InputTypes.readString("Descripcion :", scanner);
		String LugarOrigen =
				InputTypes.readString("Lugar de origen de la herramienta :", scanner);
		
		return new 
			Herramienta (codHerramienta, FechaAdquisicion, precio, Especificacion, LugarOrigen);
		
	}
	

}
