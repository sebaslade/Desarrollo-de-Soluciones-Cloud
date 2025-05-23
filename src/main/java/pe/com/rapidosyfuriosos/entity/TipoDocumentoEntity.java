package pe.com.rapidosyfuriosos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Entity(name="TipoDocumentoEntity") 
@Table(name="tipodocumento")
public class TipoDocumentoEntity {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="codtipd")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long code;
	@Column(name="nomtipd", length = 30, nullable = false)
	private String nombre;
	@Column(name="esttipd", nullable = false)
	private boolean estado;
}
