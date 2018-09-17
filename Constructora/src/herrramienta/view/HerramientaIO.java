package herrramienta.view;

import java.util.Scanner;

import herramienta.entity.Herramienta;
import view.InputTypes;

public class HerramientaIO {
	
	public static Herramienta ingresar(Scanner scanner){
		int codHerramienta =
				InputTypes.readInt("Ingresar Codigo Herramienta :", scanner);
		int codInventario =
				InputTypes.readInt("Ingresar Codigo Inventario :", scanner);
		String Nombre=
				InputTypes.readString("Nombre :", scanner);
		String FechaAdquisicion =
				InputTypes.readString("Fecha de Adquisicion :", scanner);
		double precio = 
				InputTypes.readDouble("Precio :", scanner);
		String Especificacion =
				InputTypes.readString("Descripcion :", scanner);
		String LugarOrigen =
				InputTypes.readString("Lugar de origen:", scanner);
		
		return new 
			Herramienta (codHerramienta, codInventario,Nombre, FechaAdquisicion, precio, Especificacion, LugarOrigen);
		
	}
	

}
