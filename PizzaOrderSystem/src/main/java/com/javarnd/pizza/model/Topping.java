package com.javarnd.pizza.model;

import javax.persistence.Column;
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
@Table(name="toppings")
public class Topping {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="topping_id")
	private int toppingId;
	@Column(name="topping_name", unique=true)
	private String toppingName;
	@Column(name="topping_prize")
	private double toppingPrize;
	
	public String getToppingName() {
		return toppingName;
	}
	public void setToppingName(String toppingName) {
		this.toppingName = toppingName;
	}
	public int getToppingId() {
		return toppingId;
	}
	public void setToppingId(int toppingId) {
		this.toppingId = toppingId;
	}
	public double getToppingPrize() {
		return toppingPrize;
	}
	public void setToppingPrize(double toppingPrize) {
		this.toppingPrize = toppingPrize;
	}
}
