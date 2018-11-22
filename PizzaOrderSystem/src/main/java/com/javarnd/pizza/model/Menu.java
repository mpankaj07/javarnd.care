package com.javarnd.pizza.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="menu")
public class Menu {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int pizzaid;
	@Column(name="pizza_name", unique=true)
	private String pizzaName;
	@Column(name="sm_prize")
	private double smallPrize;
	@Column(name="md_prize")
	private double mediumPrize;
	@Column(name="lg_prize")
	private double largePrize;
	
	public int getPizzaid() {
		return pizzaid;
	}
	public void setPizzaid(int pizzaid) {
		this.pizzaid = pizzaid;
	}
	public String getPizzaName() {
		return pizzaName;
	}
	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}
	public double getSmallPrize() {
		return smallPrize;
	}
	public void setSmallPrize(double smallPrize) {
		this.smallPrize = smallPrize;
	}
	public double getMediumPrize() {
		return mediumPrize;
	}
	public void setMediumPrize(double mediumPrize) {
		this.mediumPrize = mediumPrize;
	}
	public double getLargePrize() {
		return largePrize;
	}
	public void setLargePrize(double largePrize) {
		this.largePrize = largePrize;
	}
	
}
