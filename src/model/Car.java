package model;

import java.io.Serializable;

public class Car implements Serializable {
	private String ownerName;
	private String carModel;

	public Car() {

	}

	public Car(String ownerName, String carModel) {
		super();
		this.ownerName = ownerName;
		this.carModel = carModel;
	}

	// getters & setters
	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
}
