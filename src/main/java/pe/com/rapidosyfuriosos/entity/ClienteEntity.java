package pe.com.rapidosyfuriosos.entity;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

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

//Lombok
@Data
@NoArgsConstructor
@AllArgsConstructor 
@Builder

//Jakarta
@Entity(name="ClienteEntity") 
@Table(name="cliente")
public class ClienteEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="codcli")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long code;
	@Column(name="nomcli", length = 40, nullable = false)
	private String nombre;
	@Column(name="apepcli", length = 40, nullable = false)
	private String apellidoPaterno;
	@Column(name="apemcli", length = 40, nullable = false)
	private String apellidoMaterno;
	@Column(name="doccli", length = 15, nullable = false)
	private String numeroDocumento;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="feccli", nullable = false)
	private LocalDate fechaNacimiento;
	@Column(name="dircli", length = 100, nullable = false)
	private String direccion;
	@Column(name="telcli", length = 7, nullable = false)
	private String telefono;
	@Column(name="celcli", length = 9, nullable = false)
	private String celular;
	@Column(name="corcli", length = 40, nullable = false)
	private String correo;
	@Column(name="estcli", nullable = false)
	private boolean estado;
	
	@ManyToOne //relacion de muchos a uno
	@JoinColumn(name="coddis",nullable = false)//foreignkey
	private DistritoEntity distrito;
	@ManyToOne 
	@JoinColumn(name="codsex",nullable = false)
	private SexoEntity sexo;
	@ManyToOne 
	@JoinColumn(name="codtipd",nullable = false)
	private TipoDocumentoEntity tipodocumento;
}
