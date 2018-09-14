package material.view;

import java.util.Scanner;

import material.entity.Material;
import view.InputTypes;

public class MaterialIO {

	public static Material ingresar(Scanner scanner){
		int codInventario =
				InputTypes.readInt("Ingresar Codigo Material :", scanner);
		double Cantidad = 
				InputTypes.readDouble("Cantidad de Materiales :", scanner);
		double Dimensiones = 
				InputTypes.readDouble("Dimensiones del Material :", scanner);
		double Precio = 
				InputTypes.readDouble("Ingresar precio de Material :", scanner);
		String LugarOrigen =
				InputTypes.readString("Lugar de origen del Material :", scanner);
		
		return new 
				Material (codInventario, Cantidad, Dimensiones, Precio, LugarOrigen);
		
	}
	
}
