package model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Contract {
	private Integer number;
	private LocalDate date;
	private Double totalValue;
	private List<Installments> installments = new ArrayList<>(); 	
 
	public Contract(Integer number, LocalDate date, Double value) {
		this.number = number;
		this.date = date;
		this.totalValue = value;
	}

	public Integer getNumber() {
		return number;
	}

	public LocalDate getDate() {
		return date;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setValue(Double value) {
		this.totalValue = value;
	}

	public List<Installments> getInstallments() {
		return installments;
	}
	
}
