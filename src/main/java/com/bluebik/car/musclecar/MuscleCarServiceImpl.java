package com.bluebik.car.musclecar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluebik.car.musclecar.repository.MuscleCarRepository;

/**
 * Copyright © 2016 Bluebik Group. Created by khakhanat on 24/10/2017 AD.
 */

@Service
public class MuscleCarServiceImpl implements MucleCarService{
	
	@Autowired 
	MuscleCarRepository muscleCarRepository;

	public MuscleCar getCar(int id) {
		if (id <= 0) {
			throw new IllegalArgumentException("ID can not be 0 or <0");
		}
		return muscleCarRepository.getCarFromList(id);
	}

	public void removeCarFromList(int id) {
		if (id <= 0) {
			throw new IllegalArgumentException("ID can not be 0 or <0 or this id do not exist");
		}
		muscleCarRepository.removeCarFromList(id);
	}

	public List<MuscleCar> listAllCars() {
		List<MuscleCar> result = muscleCarRepository.listAllCars();
		if (result.size() > 0) {
			return result;
		} else {
			return null;
		}
	}

	public void addCarToList(MuscleCar muscleCar) {
		if (muscleCar == null) {
			throw new IllegalArgumentException("The passed object cna not be null.");
		}
		muscleCarRepository.addCarToList(muscleCar);
	}

	public void updateCarFromList(int id, MuscleCar muscleCar) {
		if (id <= 0 && muscleCar == null) {
			throw new IllegalArgumentException("The passed object cna not be null.");
		}
		muscleCarRepository.updateCarFromList(id, muscleCar);
	}

}
