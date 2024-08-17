package com.example.car;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {
	
	@Autowired
	private CarRepository carRepository;
	
	private List<Car> cars = new ArrayList<>();
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping
	public Car addCar(@RequestBody Car car) {
		return carRepository.save(car);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping
	public List<Car> getAllCars(){
		return carRepository.findAll();
	}
	
	// http://www.abc.com/brand/aaa
	@GetMapping("/{brand}")
	public List<Car> getCarsByBrand(@PathVariable String brand){
		List<Car> carsByBrand = new ArrayList<>();
		
		for(Car car : cars) {
			if(car.getBrand().equalsIgnoreCase(brand)) {
				carsByBrand.add(car);
			}
		}
		return carsByBrand;
	}

	@PutMapping("/{brand}/{model}")
	public Car updateCar(@PathVariable String brand, @PathVariable String model, @RequestBody Car updatedCar) {
		for(Car car: cars) {
			if(car.getBrand().equalsIgnoreCase(brand) && car.getModel().equalsIgnoreCase(model)) {
				car.setBrand(updatedCar.getBrand());
				car.setModel(updatedCar.getModel());
				car.setPrice(updatedCar.getPrice());
				car.setImage(updatedCar.getImage());
				return car;
			}
		}
		
		return null;
	}
	
	@DeleteMapping("/{brand}/{model}")
	public void deleteCar(@PathVariable String brand, @PathVariable String model) {
		Iterator<Car> iterator = cars.iterator();
		
		while(iterator.hasNext()) {
			Car car = iterator.next();
			if(car.getBrand().equalsIgnoreCase(brand) && car.getModel().equalsIgnoreCase(model)) {
				iterator.remove();
			}
		}
	}
}
