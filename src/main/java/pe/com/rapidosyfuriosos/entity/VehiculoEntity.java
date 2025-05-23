package pe.com.rapidosyfuriosos.entity;

import java.io.Serializable;

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
@Entity(name="VehiculoEntity") 
@Table(name="Vehiculo")
public class VehiculoEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="codVehiculo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long code;
	@Column(name="placa", length = 10, nullable = false)
	private String placa;
	@Column(name="modelo", length = 50, nullable = false)
	private String modelo;
	@Column(name="anioFabricacion", nullable = false)
	private long añoFabricacion;
	@Column(name="estado", nullable = false)
	private boolean estado;
	
	@ManyToOne //relacion de muchos a uno
	@JoinColumn(name="codMarca",nullable = false)//foreignkey
	private MarcaEntity marca;
	@ManyToOne 
	@JoinColumn(name="codColor",nullable = false)
	private ColorEntity color;
	@ManyToOne 
	@JoinColumn(name="codcli",nullable = false)
	private ClienteEntity cliente;
}
