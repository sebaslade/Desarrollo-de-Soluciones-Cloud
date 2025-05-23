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

@Data
@NoArgsConstructor
@AllArgsConstructor 
@Builder

//Jakarta
@Entity(name="ColorEntity") 
@Table(name="Color")
public class ColorEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id //define la clave primaria
	@Column(name="codColor")//define la columna con la cual se relaciona
	@GeneratedValue(strategy = GenerationType.IDENTITY)//es para el auto incremento
	private long code;
	@Column(name="nomColor", length = 50, nullable = false)
	private String nombre;
	@Column(name="estado", nullable = false)
	private boolean estado;
}
