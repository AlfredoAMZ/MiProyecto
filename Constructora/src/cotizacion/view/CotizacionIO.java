package cotizacion.view;

import java.util.Scanner;

import cotizacion.entity.Cotizacion;
import view.InputTypes;

public class CotizacionIO {

	
	public static Cotizacion ingresar(Scanner scanner){
		int NumCotizacion =
				InputTypes.readInt("Ingresar Codigo Cotizacion :", scanner);
		int CodCliente =
				InputTypes.readInt("Ingresar Codigo del Cliente :", scanner);
		int CodObrero =
				InputTypes.readInt("Ingresar Codigo del Obrero que realizará la obra :", scanner);
		int CodMaterial =
				InputTypes.readInt("Ingresar Codigo del material con el que se realizará :", scanner);
		String Fecha =
				InputTypes.readString("Fecha de la Cotizacion:", scanner);
		return new 
			Cotizacion(NumCotizacion, CodCliente, CodMaterial, CodObrero, Fecha);
		
	}
}
