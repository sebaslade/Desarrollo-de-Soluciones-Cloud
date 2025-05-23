package pe.com.rapidosyfuriosos.entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor 
@Builder

//Jakarta
@Entity(name="EmpleadoEntity") 
@Table(name="empleado")
public class EmpleadoEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="codemp")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long code;
	@Column(name="nomemp", length = 40, nullable = false)
	private String nombre;
	@Column(name="apepemp", length = 40, nullable = false)
	private String apellidoPaterno;
	@Column(name="apememp", length = 30, nullable = false)
	private String apellidoMaterno;
	@Column(name="dniemp", length = 8, nullable = false)
	private String numeroDocumento;
	@Column(name="fecemp", nullable = false)
	private LocalDate fechaNacimiento;
	@Column(name="diremp", length = 50, nullable = false)
	private String direccion;
	@Column(name="telemp", length = 7, nullable = false)
	private String telefono;
	@Column(name="celemp", length = 9, nullable = false)
	private String celular;
	@Column(name="coremp", length = 40, nullable = false)
	private String correo;
	@Column(name="sexemp", length = 9,nullable = false)
	private String sexoEmpleado;
	@Column(name="usuemp", length = 40,nullable = false)
	private String usuario;
	@Column(name="claemp", length = 40,nullable = false)
	private String clase;
	@Column(name="estemp", nullable = false)
	private boolean estado;
	
	@ManyToOne //relacion de muchos a uno
	@JoinColumn(name="coddis",nullable = false)//foreignkey
	private DistritoEntity distrito;
	@ManyToOne 
	@JoinColumn(name="codrol",nullable = false)
	private RolEntity rol;
}
