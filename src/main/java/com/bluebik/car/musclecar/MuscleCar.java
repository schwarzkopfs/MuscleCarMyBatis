package com.bluebik.car.musclecar;

/**
 * Copyright © 2016 Bluebik Group. Created by khakhanat on 24/10/2017 AD.
 */
public class MuscleCar {

	private String carBrand;
	private String carModel;
	private String horsepower;
	private String carEngine;
	
	public MuscleCar() {
		
	}

	public MuscleCar(String carBrand, String carModel, String horsepower, String carEngine) {
		this.carBrand = carBrand;
		this.carModel = carModel;
		this.horsepower = horsepower;
		this.carEngine = carEngine;
	}

	public String getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getHorsepower() {
		return horsepower;
	}

	public void setHorsepower(String horsepower) {
		this.horsepower = horsepower;
	}

	public String getCarEngine() {
		return carEngine;
	}

	public void setCarEngine(String carEngine) {
		this.carEngine = carEngine;
	}
}
