package cotizacion.entity;

public class Cotizacion {

	private int NumCotizacion;
	private int CodCliente;
	private int CodObrero;
	private int CodMaterial;
	private String Fecha;
	public Cotizacion(int numCotizacion, int codCliente, int codObrero, int codMaterial, String fecha) {
		super();
		NumCotizacion = numCotizacion;
		CodCliente = codCliente;
		CodObrero = codObrero;
		CodMaterial = codMaterial;
		Fecha = fecha;
	}
	public int getNumCotizacion() {
		return NumCotizacion;
	}
	public void setNumCotizacion(int numCotizacion) {
		NumCotizacion = numCotizacion;
	}
	public int getCodCliente() {
		return CodCliente;
	}
	public void setCodCliente(int codCliente) {
		CodCliente = codCliente;
	}
	public int getCodObrero() {
		return CodObrero;
	}
	public void setCodObrero(int codObrero) {
		CodObrero = codObrero;
	}
	public int getCodMaterial() {
		return CodMaterial;
	}
	public void setCodMaterial(int codMaterial) {
		CodMaterial = codMaterial;
	}
	public String getFecha() {
		return Fecha;
	}
	public void setFecha(String fecha) {
		Fecha = fecha;
	}
	@Override
	public String toString() {
		return "Cotizacion [NumCotizacion=" + NumCotizacion + ", CodCliente=" + CodCliente + ", CodObrero=" + CodObrero
				+ ", CodMaterial=" + CodMaterial + ", Fecha=" + Fecha + "]";
	}
	
	

}
