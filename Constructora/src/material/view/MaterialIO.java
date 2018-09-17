package material.view;

import java.util.Scanner;

import material.entity.Material;
import view.InputTypes;

public class MaterialIO {

	public static Material ingresar(Scanner scanner){
		int codMaterial =
				InputTypes.readInt("Ingresar Codigo Material :", scanner);
		int CodInventario=
		        InputTypes.readInt("Ingresar Codigo Inventario :", scanner);
		String Nombre = 
				InputTypes.readString("Nombre del material :", scanner);
		double Cantidad = 
				InputTypes.readDouble("Cantidad:", scanner);
		String Dimensiones = 
				InputTypes.readString("Dimensiones:", scanner);
		double Precio = 
				InputTypes.readDouble("Precio:", scanner);
		String LugarOrigen =
				InputTypes.readString("Lugar de origen:", scanner);
		
		return new 
				Material (codMaterial,CodInventario, Nombre, Cantidad, Dimensiones, Precio, LugarOrigen);
		
	}
	
}
