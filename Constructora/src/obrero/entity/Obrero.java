package obrero.entity;

public class Obrero {
	
	private int CodObrero;
	private int CI;
	private String NombreCompleto;
	private String FechadeNacimiento;
	private int Telefono;
	
	public Obrero(int CodObrero, int CI, String nombreCompleto, String fechadeNacimiento, int telefono) {
		super();
		this.CodObrero = CodObrero;
		this.CI = CI;
		NombreCompleto = nombreCompleto;
		FechadeNacimiento = fechadeNacimiento;
		Telefono = telefono;
	}
	public int CodObrero() {
		return CodObrero;
	}
	public void setCodCliente(int codCliente) {
		CodObrero = codCliente;
	}
	public int getCI() {
		return CI;
	}
	public void setCI(int CI) {
		this.CI = CI;
	}
	public String getNombreCompleto() {
		return NombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		NombreCompleto = nombreCompleto;
	}
	public String getFechadeNacimiento() {
		return FechadeNacimiento;
	}
	public void setFechadeNacimiento(String fechadeNacimiento) {
		FechadeNacimiento = fechadeNacimiento;
	}
	public int getTelefono() {
		return Telefono;
	}
	public void setTelefono(int telefono) {
		Telefono = telefono;
	}
	@Override
	public String toString() {
		return "Obrero [CodObrero=" + CodObrero + ", CI=" + CI + ", NombreCompleto=" + NombreCompleto
				+ ", FechadeNacimiento=" + FechadeNacimiento + ", Telefono=" + Telefono + "]";
	}
	
}
