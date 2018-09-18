package view;

import java.sql.SQLException;
import java.util.Scanner;

import control.Conexion;
import control.Consultas;
import view.InputTypes;

public class Menu {

	public static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("*******BIENVENIDO******* ");
			System.out.println("---Ingrese una opcion--- ");
			System.out.println("------------------------ ");
			System.out.println("1. Registrar Cliente");
			System.out.println("2. Registrar Herramienta");
			System.out.println("3. Registrar Material");
			System.out.println("4. Registrar Obrero");
			System.out.println("5. Registrar Cotizacion ");
			System.out.println("6. Sacar Recibo de la Cotizacion ");
			System.out.println("7. Revisar Inventario");
			System.out.println("8. Modificar Inventario");
			System.out.println("9. Ver Ganancias");
			
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 9) {
				return opcion;
			}
		}
	}

	public static void menú(Scanner scanner) throws ClassNotFoundException, SQLException {
		boolean salir = false;
		
		Conexion conexión = new Conexion("root","","constructora");
		Consultas consultas = new Consultas(conexión, scanner);
		
		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
			{
			consultas.RegistroCliente();
			salir = true;
			break;
			}
			case 2:
			{
			consultas.RegistroHerramientas();
			salir = true;
			break;	
			}
			case 3:
			{
			consultas.RegistroMaterial();
			salir = true;
			break;
			}
			case 4:
			{
			consultas.RegistroObrero();
			salir = true;
			break;
			}
			case 5:
			{
			consultas.SacarCotizacion();	
			salir = true;
			break;
			}
			case 6:
			{
			consultas.ObtenerRecibo();	
			salir = true;
			break;
			}
			case 7:
			{
			consultas.ObtenerInventario();
			salir = true;
			break;
			}
			case 8:
			{
			consultas.ModificarInventario();
			salir = true;
			break;
			}
			case 9:
			{
			System.out.println("No pudimos hacer este ING :( ");
			salir = true;
			break;
			}
		}
			System.out.println();
			System.out.println("***DEBE VOLVER A INICIAR EL PROGRAMA PARA REALIZAR OTRO SERVICIO***");
			System.out.println();
		conexión.close();
	}
}
}
