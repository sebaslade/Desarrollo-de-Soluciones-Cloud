package pe.com.rapidosyfuriosos.entity;

import java.io.Serializable;

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
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor 
@Builder

@Entity(name="ServicioEntity") 
@Table(name="Servicio")
public class ServicioEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id 
	@Column(name="codServicio")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long code;
	@Column(name="nomServicio", length = 50, nullable = false)
	private String nombre;
	@Column(name = "descripcion", columnDefinition = "TEXT")
	private String descripcion;
	@Column(name = "precio", nullable = false, precision = 10, scale = 2)
	private BigDecimal precio;
	@Column(name="estado", nullable = false)
	private boolean estado;
}
