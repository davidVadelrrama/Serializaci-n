package main;

import model.Car;
import model.CarData;

public class Main {

	public static void main(String[] args) {

		CarData data = new CarData();
		/*
		data.addCars(new Car("David", "Mercedes"));
		data.addCars(new Car("Federico", "Renault"));
		data.addCars(new Car("Domiciano", "Chevrolet"));
		*/
		//data.saveJSON();
		data.loadJSON();
		data.print();
	}

}
