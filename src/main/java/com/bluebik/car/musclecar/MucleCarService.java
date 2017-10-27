package com.bluebik.car.musclecar;

import java.util.List;

public interface MucleCarService {

	public MuscleCar getCar(int id) throws RuntimeException;

	public void removeCarFromList(int id) throws RuntimeException;

	public List<MuscleCar> listAllCars() throws RuntimeException;

	public void addCarToList(MuscleCar muscleCar) throws RuntimeException;

	public void updateCarFromList(int id, MuscleCar muscleCar) throws RuntimeException;

}
