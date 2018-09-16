package cotizacion.entity;

public class Cotizacion {

	private int NumCotizacion;
	private String Fecha;
	
	public Cotizacion(int NumCotizacion, String fecha) {
		super();
		this.NumCotizacion = NumCotizacion;
		Fecha = fecha;
	}
	public int getCodCotizacion() {
		return NumCotizacion;
	}
	public void setCodCotizacion(int NumCotizacion) {
		this.NumCotizacion = NumCotizacion;
	}
	public String getFecha() {
		return Fecha;
	}
	public void setFecha(String fecha) {
		Fecha = fecha;
	}
	@Override
	public String toString() {
		return "Cotizacion [NumCotizacion=" + NumCotizacion + ", Fecha=" + Fecha + "]";
	}
	
}
