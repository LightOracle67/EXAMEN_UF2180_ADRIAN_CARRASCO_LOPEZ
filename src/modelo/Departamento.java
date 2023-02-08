package modelo;

import java.util.Objects;

public class Departamento {
	private int cod_Departamento;
	private int cod_Centro;
	private String tipo_dir;
	private int presupuesto;
	private String nombre;
	
	public Departamento() {
		this.nombre="";
	}
	
	public Departamento(int cod_dep,int cod_centro,String tipo_dir,int presupuesto,String nombre) {
		this.cod_Departamento=cod_dep;
		this.cod_Centro=cod_centro;
		this.tipo_dir = tipo_dir;
		this.presupuesto = presupuesto;
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cod_Departamento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		return cod_Departamento == other.cod_Departamento;
	}

	@Override
	public String toString() {
		return "Departamento [cod_Departamento=" + cod_Departamento + ", cod_Centro=" + cod_Centro + ", "
				+ (tipo_dir != null ? "tipo_dir=" + tipo_dir + ", " : "") + "presupuesto=" + presupuesto + ", "
				+ (nombre != null ? "nombre=" + nombre : "") + "]";
	}

	/**
	 * @return el cod_Departamento
	 */
	public int getCod_Departamento() {
		return cod_Departamento;
	}

	/**
	 * @param cod_Departamento el cod_Departamento a establecer
	 */
	public void setCod_Departamento(int cod_Departamento) {
		this.cod_Departamento = cod_Departamento;
	}

	/**
	 * @return el cod_Centro
	 */
	public int getCod_Centro() {
		return cod_Centro;
	}

	/**
	 * @param cod_Centro el cod_Centro a establecer
	 */
	public void setCod_Centro(int cod_Centro) {
		this.cod_Centro = cod_Centro;
	}

	/**
	 * @return el tipo_dir
	 */
	public String getTipo_dir() {
		return tipo_dir;
	}

	/**
	 * @param tipo_dir el tipo_dir a establecer
	 */
	public void setTipo_dir(String tipo_dir) {
		this.tipo_dir = tipo_dir;
	}

	/**
	 * @return el presupuesto
	 */
	public int getPresupuesto() {
		return presupuesto;
	}

	/**
	 * @param presupuesto el presupuesto a establecer
	 */
	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}

	/**
	 * @return el nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre el nombre a establecer
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
