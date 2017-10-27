package com.bluebik.car.musclecar;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bluebik.car.musclecar.MuscleCar;
import com.bluebik.car.musclecar.MuscleCarServiceImpl;

/**
 * Copyright © 2016 Bluebik Group.
 * Created by khakhanat on 24/10/2017 AD.
 */
@RestController
@RequestMapping(value = "/api/cars")
public class MuscleCarResource {

    private MuscleCarServiceImpl muscleCarService;

    @Autowired
    public MuscleCarResource(MuscleCarServiceImpl muscleCarService) {
        this.muscleCarService = muscleCarService;
    }

    @RequestMapping(value = "/get-car/{id}", method = RequestMethod.GET)
    public ResponseEntity<MuscleCar> getMuscleCar(@PathVariable("id") int id) {

        try {
            MuscleCar muscleCar = muscleCarService.getCar(id);
            if (muscleCar != null) {
                return ResponseEntity.status(HttpStatus.OK).body(muscleCar);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @RequestMapping(value = "/delete-car/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteMuscleCar(@PathVariable("id") int id) {

        try {
            muscleCarService.removeCarFromList(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @RequestMapping(value = "/add-car", method = RequestMethod.POST)
    public ResponseEntity<Void> addCarToList(@RequestBody MuscleCar muscleCar) {

        try {
            muscleCarService.addCarToList(muscleCar);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public ResponseEntity<List<MuscleCar>> listAllCars() {

        try {
        	List<MuscleCar> result = muscleCarService.listAllCars();
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @RequestMapping(value = "/update-car/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateCar(@PathVariable("id") int id, @RequestBody MuscleCar muscleCar) {

        try {
            muscleCarService.updateCarFromList(id, muscleCar);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
