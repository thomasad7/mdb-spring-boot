package com.example.mdbspringboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.mdbspringboot.model.GroceryItem;
import com.example.mdbspringboot.repository.ItemRepository;

@RestController
public class GroceryItemController2 {

	@Autowired
	ItemRepository productRepo;
	
   //private static Map<String, GroceryItem> productRepo = new HashMap<>();
   /*
   static {
      GroceryItem honey = new GroceryItem();
      honey.setId("1");
      honey.setName("Honey");
      productRepo.put(honey.getId(), honey);
      
      GroceryItem almond = new GroceryItem();
      almond.setId("2");
      almond.setName("Almond");
      productRepo.put(almond.getId(), almond);
   }
   */

   @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
   public ResponseEntity<Object> delete(@PathVariable("id") String id) { 
      productRepo.deleteById(id);
      return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
   }

   @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
   public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody GroceryItem product) { 
      productRepo.deleteById(id);
      product.setId(id);
      productRepo.save(product);
      return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
   }
	
   @RequestMapping(value = "/products", method = RequestMethod.POST)
   public ResponseEntity<Object> createProduct(@RequestBody GroceryItem product) {
      productRepo.save(product);
      return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
   }
	
   @RequestMapping(value = "/products")
   public ResponseEntity<Object> getProduct() {
      return new ResponseEntity<>(productRepo.findAll(), HttpStatus.OK);
   }
}
