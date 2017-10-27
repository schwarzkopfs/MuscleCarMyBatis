package com.bluebik.car.musclecar.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.bluebik.car.musclecar.MuscleCar;
public interface MuscleCarRepository {
	
	static final String SQL_SELECT_ALL_CAR = "SELECT * FROM [MUSCLE_CAR]";
	
	static final String SQL_SELECT_CAR_BY_ID = "SELECT * FROM [MUSCLE_CAR] WHERE ID = #{id}";
	
	static final String SQL_DELETE_CAR_BY_ID = "DELETE FROM [MUSCLE_CAR] WHERE ID = #{id}";
	
	static final String SQL_INSERT_CAR = "INSERT INTO [MUSCLE_CAR] ([CAR_BRAND],[CAR_MODEL]"
			+ ",[HORSEPOWER],[CAR_ENGINE])"
			+ " VALUES"
			+ " (#{carBrand}"
			+ " ,#{carModel}"
			+ " ,#{horsepower}"
			+ " ,#{carEngine})";
	
	static final String SQL_UPDATE_CAR_BY_ID = "UPDATE [MUSCLE_CAR] SET CAR_BRAND = #{carBrand}"
			+ ",CAR_MODEL = #{carModel}"
			+ ",HORSEPOWER = #{horsepower}"
			+ ",CAR_ENGINE = #{carEngine}"
			+ " WHERE ID = #{id}";
	
	@Select(SQL_SELECT_CAR_BY_ID)
	public MuscleCar getCarFromList(@Param("id") int id) throws RuntimeException;
	
	@Delete(SQL_DELETE_CAR_BY_ID)
	public int removeCarFromList(@Param("id") int id) throws RuntimeException;
	
	@Insert(SQL_INSERT_CAR)
	public int addCarToList(MuscleCar muscleCar) throws RuntimeException;

	@Update(SQL_UPDATE_CAR_BY_ID)
	public int updateCarFromList(@Param("id") int id,MuscleCar muscleCar) throws RuntimeException;
	
	@Select(SQL_SELECT_ALL_CAR)
	public List<MuscleCar> listAllCars() throws RuntimeException;
	
}
