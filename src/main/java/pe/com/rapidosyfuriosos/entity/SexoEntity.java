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

//Lombok
@Data
@NoArgsConstructor
@AllArgsConstructor 
@Builder

//Jakarta
@Entity(name="SexoEntity") 
@Table(name="sexo")
public class SexoEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="codsex")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long code;
	@Column(name="nomdsex", length = 20, nullable = false)
	private String nombre;
	@Column(name="estsex", nullable = false)
	private boolean estado;
}
