package com.javarnd.pizza.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Developer
 *
 */
@Entity
@Table(name="pizza")
public class Pizza {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int pizzaId;
	private String pizzaName;
	private String size;
	private double smPrize;
	private double mdPrize;
	private double lgPrize;
	
	public double getMdPrize() {
		return mdPrize;
	}
	public void setMdPrize(double mdPrize) {
		this.mdPrize = mdPrize;
	}
	public double getLgPrize() {
		return lgPrize;
	}
	public void setLgPrize(double lgPrize) {
		this.lgPrize = lgPrize;
	}
	public String getPizzaName() {
		return pizzaName;
	}
	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}
	public int getPizzaId() {
		return pizzaId;
	}
	public void setPizzaId(int pizzaId) {
		this.pizzaId = pizzaId;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public double getSmPrize() {
		return smPrize;
	}
	public void setSmPrize(double smPrize) {
		this.smPrize = smPrize;
	}
}
