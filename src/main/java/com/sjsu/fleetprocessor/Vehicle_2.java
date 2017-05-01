package com.sjsu.fleetprocessor;

import java.io.Serializable;
import java.sql.Timestamp;

public class Vehicle_2  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getVehicle_log_id() {
		return vehicle_log_id;
	}

	public void setVehicle_log_id(String vehicle_log_id) {
		this.vehicle_log_id = vehicle_log_id;
	}

	public String getVehicle_log_engine_coolant_temp() {
		return vehicle_log_engine_coolant_temp;
	}

	public void setVehicle_log_engine_coolant_temp(String vehicle_log_engine_coolant_temp) {
		this.vehicle_log_engine_coolant_temp = vehicle_log_engine_coolant_temp;
	}

	public String getVehicle_log_fuel_level() {
		return vehicle_log_fuel_level;
	}

	public void setVehicle_log_fuel_level(String vehicle_log_fuel_level) {
		this.vehicle_log_fuel_level = vehicle_log_fuel_level;
	}

	public String getVehicle_log_latitude() {
		return vehicle_log_latitude;
	}

	public void setVehicle_log_latitude(String vehicle_log_latitude) {
		this.vehicle_log_latitude = vehicle_log_latitude;
	}

	public String getVehicle_log_longitude() {
		return vehicle_log_longitude;
	}

	public void setVehicle_log_longitude(String vehicle_log_longitude) {
		this.vehicle_log_longitude = vehicle_log_longitude;
	}

	public String getVehicle_log_mileage() {
		return vehicle_log_mileage;
	}

	public void setVehicle_log_mileage(String vehicle_log_mileage) {
		this.vehicle_log_mileage = vehicle_log_mileage;
	}

	public String getVehicle_log_miles() {
		return vehicle_log_miles;
	}

	public void setVehicle_log_miles(String vehicle_log_miles) {
		this.vehicle_log_miles = vehicle_log_miles;
	}

	public String getVehicle_log_oil_level() {
		return vehicle_log_oil_level;
	}

	public void setVehicle_log_oil_level(String vehicle_log_oil_level) {
		this.vehicle_log_oil_level = vehicle_log_oil_level;
	}

	public String getVehicle_log_rpm() {
		return vehicle_log_rpm;
	}

	public void setVehicle_log_rpm(String vehicle_log_rpm) {
		this.vehicle_log_rpm = vehicle_log_rpm;
	}

	public String getVehicle_log_speed() {
		return vehicle_log_speed;
	}

	public void setVehicle_log_speed(String vehicle_log_speed) {
		this.vehicle_log_speed = vehicle_log_speed;
	}

	public String getVehicle_log_temperature() {
		return vehicle_log_temperature;
	}

	public void setVehicle_log_temperature(String vehicle_log_temperature) {
		this.vehicle_log_temperature = vehicle_log_temperature;
	}

	public Timestamp getVehicle_log_time() {
		return vehicle_log_time;
	}

	public void setVehicle_log_time(Timestamp vehicle_log_time) {
		this.vehicle_log_time = vehicle_log_time;
	}

	public String getVehicle_log_vehicle_id() {
		return vehicle_log_vehicle_id;
	}

	public void setVehicle_log_vehicle_id(String vehicle_log_vehicle_id) {
		this.vehicle_log_vehicle_id = vehicle_log_vehicle_id;
	}

	public Vehicle_2(String vehicle_log_id, String vehicle_log_engine_coolant_temp, String vehicle_log_fuel_level,
			String vehicle_log_latitude, String vehicle_log_longitude, String vehicle_log_mileage,
			String vehicle_log_miles, String vehicle_log_oil_level, String vehicle_log_rpm, String vehicle_log_speed,
			String vehicle_log_temperature, Timestamp vehicle_log_time, String vehicle_log_vehicle_id) {
		super();
		this.vehicle_log_id = vehicle_log_id;
		this.vehicle_log_engine_coolant_temp = vehicle_log_engine_coolant_temp;
		this.vehicle_log_fuel_level = vehicle_log_fuel_level;
		this.vehicle_log_latitude = vehicle_log_latitude;
		this.vehicle_log_longitude = vehicle_log_longitude;
		this.vehicle_log_mileage = vehicle_log_mileage;
		this.vehicle_log_miles = vehicle_log_miles;
		this.vehicle_log_oil_level = vehicle_log_oil_level;
		this.vehicle_log_rpm = vehicle_log_rpm;
		this.vehicle_log_speed = vehicle_log_speed;
		this.vehicle_log_temperature = vehicle_log_temperature;
		this.vehicle_log_time = vehicle_log_time;
		this.vehicle_log_vehicle_id = vehicle_log_vehicle_id;
	}
	
	public Vehicle_2(){
		super();
	}

	private String vehicle_log_id, vehicle_log_engine_coolant_temp, vehicle_log_fuel_level, vehicle_log_latitude, vehicle_log_longitude, vehicle_log_mileage, vehicle_log_miles, vehicle_log_oil_level, vehicle_log_rpm, vehicle_log_speed, vehicle_log_temperature, vehicle_log_vehicle_id;
	private Timestamp vehicle_log_time;
}
