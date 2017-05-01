package com.sjsu.fleetprocessor;

import static com.datastax.spark.connector.japi.CassandraJavaUtil.mapToRow;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.StorageLevels;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.mqtt.MQTTUtils;

import com.datastax.spark.connector.japi.CassandraStreamingJavaUtil;
import com.google.gson.Gson;

public class IoTProcessor {

	private JavaSparkContext sc;
	private JavaStreamingContext jssc;
	private static String broker = Constants.MQTT_BROKER;
	public static String topic = Constants.MQTT_TOPIC;

	public void initializeSpark(){
		
		SparkConf conf = new SparkConf().setAppName(Constants.SPARK_APP)
				.setMaster("local[3]").set("spark.driver.allowMultipleContexts", "true");
		conf.set("spark.cassandra.connection.host",Constants.CASSANDRA_HOST);
		sc = JavaSparkContext.fromSparkContext(SparkContext.getOrCreate(conf));
		jssc = new JavaStreamingContext(sc, Durations.seconds(10));
		jssc.checkpoint("/tmp/fleet-streaming-data");
	}

	public void processMQTT() throws InterruptedException{
		//List<Vehicle> vehicles = new ArrayList<>();
		
		Map<String, String> columnNameMappings = new HashMap<String, String>();
		columnNameMappings.put("vehicle_log_id","vehicleId");
		columnNameMappings.put("vehicle_log_engine_coolant_temp","engineCoolantTemp");
		columnNameMappings.put("vehicle_log_fuel_level", "fuelLevel");
		columnNameMappings.put("vehicle_log_mileage","mileage");
		columnNameMappings.put("vehicle_log_miles", "miles");
		columnNameMappings.put("vehicle_log_oil_level","oilLevel");
		columnNameMappings.put("vehicle_log_rpm", "rpm");
		columnNameMappings.put("vehicle_log_speed","speed");
		columnNameMappings.put("vehicle_log_temperature", "temperature");
		columnNameMappings.put("vehicle_log_time","timestamp");
		columnNameMappings.put("vehicle_log_latitude", "latitude");
		columnNameMappings.put("vehicle_log_longitude", "longitude");


		JavaReceiverInputDStream<String> stream = MQTTUtils.createStream(jssc, broker, topic, StorageLevels.MEMORY_AND_DISK_SER);
		
		JavaDStream<Vehicle_2> dStream = null;
		dStream =  stream.flatMap((vehicle) -> {
			Gson gson = new Gson();
			List<Vehicle_2> vehicles = new ArrayList<Vehicle_2>();
			Vehicle v = gson.fromJson(vehicle, Vehicle.class);
			Vehicle_2 v2 = new Vehicle_2(UUID.randomUUID().toString(), v.getEngineCoolantTemp(), v.getFuelLevel(), v.getLatitude() + "", v.getLongitude()+ "", v.getMileage(), v.getMiles(), v.getOilLevel(), v.getRpm(), v.getSpeed(), v.getTemperature(), Timestamp.valueOf(v.getTimestamp()), v.getVehicleId());
			vehicles.add(v2);
			return vehicles.iterator();
		});
		
		CassandraStreamingJavaUtil.javaFunctions(dStream).writerBuilder("fleetapp", "fleetapp_vehicle_log", mapToRow(Vehicle_2.class)).saveToCassandra();
		jssc.start();
		jssc.awaitTermination();
	}

	public static void main(String s[]){
		IoTProcessor c = new IoTProcessor();
		System.out.println("Spark started");
		c.initializeSpark();
		try {
			c.processMQTT();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
