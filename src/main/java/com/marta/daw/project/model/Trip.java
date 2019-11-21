package com.marta.daw.project.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Trip {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotNull
	private int userId;
	
	@NotEmpty
	@Size(min=1, max=30)
	private String origin;
	
	@NotEmpty
	@Size(min=1, max=30)
	private String destination;
	
	@NotNull
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date startDate;
	
	@NotNull
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date endDate;
	
	@NotNull
	private int reasonId;	

	@NotNull
	private int precio;
	
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getPais_origen() {
		return pais_origen;
	}
	public void setPais_origen(String pais_origen) {
		this.pais_origen = pais_origen;
	}
	public String getPais_destino() {
		return pais_destino;
	}
	public void setPais_destino(String pais_destino) {
		this.pais_destino = pais_destino;
	}
	@NotEmpty
	@Size(min=1, max=2)
	private String pais_origen;

	@NotEmpty
	@Size(min=1, max=2)
	private String pais_destino;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getReasonId() {
		return reasonId;
	}
	public void setReasonId(int reasonId) {
		this.reasonId = reasonId;
	}
}
