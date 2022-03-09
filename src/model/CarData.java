package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import com.google.gson.Gson;

public class CarData implements Serializable {

	private ArrayList<Car> cars;

	public CarData() {
		cars = new ArrayList<>();
	}

	public void addCars(Car car) {
		cars.add(car);

	}

	// guarda los objetos en el storage
	public void save() {
		// requerimiento: las clases deben ser serializables

		try {
			File file = new File("data.temp");
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutput oos = new ObjectOutputStream(fos);
			oos.writeObject(this);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void load() {

		try {
			File file = new File("data.temp");
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object object = ois.readObject();
			CarData data = (CarData) object;
			this.cars = data.cars;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void print() {
		for (Car c : cars) {
			System.out.println(c.getCarModel());
		}
	}

	public void saveJSON() {
		try {
			Gson gson = new Gson();
			String json = gson.toJson(this);
			System.out.println(json);
			File file = new File("data.json");
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(json.getBytes());

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void loadJSON() {

		try {
			FileInputStream fis = new FileInputStream(new File("data.json"));
			BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
			String line;
			String json = "";
			while ((line = reader.readLine()) != null) {
				json += line;
				System.out.println(json);
			}
			// String -> obj
			Gson gson = new Gson();
			Car[] data = gson.fromJson(json, Car[].class);
			cars = new ArrayList<>();
			for (Car c : data) {
				cars.add(c);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
