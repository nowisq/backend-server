package com.example.car;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cars")
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String brand;
	private String model;
	private int price;
	private String image;
	
	public Car() {
    }
	
	public Car(String brand, String model, int price, String image) {
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.image = image;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public String getModel() {
		return model; 
	}
	
	public int getPrice() {
		return price;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
}
