package herramienta.entity;


public class Herramienta {
	
	private int CodHerramienta;
	private String FechaAdquisicion;
	private double Precio;
	private String Especificacion;
	private String LugarOrigen;
	
	public Herramienta(int codHerramienta, String fechaAdquisicion, double precio, String especificacion,
			String lugarOrigen) {
		super();
		CodHerramienta = codHerramienta;
		FechaAdquisicion = fechaAdquisicion;
		Precio = precio;
		Especificacion = especificacion;
		LugarOrigen = lugarOrigen;
	}
	
	public int getCodHerramienta() {
		return CodHerramienta;
	}
	public void setCodHerramienta(int codHerramienta) {
		CodHerramienta = codHerramienta;
	}
	public String getFechaAdquisicion() {
		return FechaAdquisicion;
	}
	public void setFechaAdquisicion(String fechaAdquisicion) {
		FechaAdquisicion = fechaAdquisicion;
	}
	public double getPrecio() {
		return Precio;
	}
	public void setPrecio(double precio) {
		Precio = precio;
	}
	public String getEspecificacion() {
		return Especificacion;
	}
	public void setEspecificacion(String especificacion) {
		Especificacion = especificacion;
	}
	public String getLugarOrigen() {
		return LugarOrigen;
	}
	public void setLugarOrigen(String lugarOrigen) {
		LugarOrigen = lugarOrigen;
	}
	@Override
	public String toString() {
		return "Herramienta [CodHerramienta=" + CodHerramienta + ", FechaAdquisicion=" + FechaAdquisicion + ", Precio="
				+ Precio + ", Especificacion=" + Especificacion + ", LugarOrigen=" + LugarOrigen + "]";
	}
	
}
