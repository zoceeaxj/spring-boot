package com.rab3tech.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

class Dog{
	private String name;
	private int price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Dog [name=" + name + ", price=" + price + "]";
	}
	
}
//we are not returning string; were going to return object

@RestController
@RequestMapping("/api") 
public class ProfileJSONController {
	
	@GetMapping("/cool")
	public String magic(){
		return "Hello Cool!";
	}
	
	@PostMapping("/dogs")  //were sending redirect			
	public AppResponse findDog(@RequestBody Dog dog) { //Requestbody will read JSON data and convert it into Java obj.
		System.out.println(dog);
		AppResponse appResponse = new AppResponse();
		appResponse.setCode(121);
		appResponse.setMessage("Hey dog is uploaded successfully");
		return appResponse;
	} 
	
	@GetMapping("/dog")  			//findDog is resource, which gives the data of the dog
	public Dog findDog() {
		Dog dog = new Dog();
		dog.setName("Tom");
		dog.setPrice(111);
		return dog;
	} 
	
	@GetMapping("/dogs")  			
	public List<Dog> findDogs() {
		List list = new ArrayList<>();
		Dog dog1 = new Dog();
		dog1.setName("Tom");
		dog1.setPrice(111);
		list.add(dog1);
		
		Dog dog2 = new Dog();
		dog2.setName("Tommy");
		dog2.setPrice(145);
		list.add(dog2);
		return list;

	}
}