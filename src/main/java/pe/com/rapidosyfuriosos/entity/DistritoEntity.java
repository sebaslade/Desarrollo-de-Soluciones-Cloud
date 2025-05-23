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
@Data //genera los metodos GET y SET
@NoArgsConstructor //metodo constructor sin parametros
@AllArgsConstructor //metodo constructor con parametros
@Builder //genera la clase builder

//Jakarta
@Entity(name="DistritoEntity") //define la entidad
@Table(name="distrito") //define la tabla con la cual se relaciona
public class DistritoEntity implements Serializable {
	//codigo de serializacion
	private static final long serialVersionUID = 1L;
	
	@Id //define la clave primaria
	@Column(name="coddis")//define la columna con la cual se relaciona
	@GeneratedValue(strategy = GenerationType.IDENTITY)//es para el auto incremento
	private long code;
	@Column(name="nomdis", length = 50, nullable = false)
	private String nombre;
	@Column(name="estdis", nullable = false)
	private boolean estado;
}
