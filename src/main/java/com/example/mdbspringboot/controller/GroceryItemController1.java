package com.example.mdbspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mdbspringboot.repository.ItemRepository;

@Controller
public class GroceryItemController1 {

	@Autowired
	ItemRepository groceryItemRepo;

    public GroceryItemController1(ItemRepository repository) {
        this.groceryItemRepo = repository;
    }

    @GetMapping("/items")
    public String getAllItems(Model model) {
        model.addAttribute("items", groceryItemRepo.findAll());
        return "list-items";
    }
}
