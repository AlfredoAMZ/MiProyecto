package cotizacion.view;

import java.util.Scanner;

import cotizacion.entity.Cotizacion;
import view.InputTypes;

public class CotizacionIO {

	
	public static Cotizacion ingresar(Scanner scanner){
		int NumCotizacion =
				InputTypes.readInt("Ingresar Codigo Cotizacion :", scanner);
		String Fecha =
				InputTypes.readString("Fecha de la Cotizacion:", scanner);
		return new 
			Cotizacion(NumCotizacion, Fecha);
		
	}
}
