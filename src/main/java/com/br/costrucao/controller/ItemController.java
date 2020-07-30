package com.br.costrucao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.costrucao.model.Item;
import com.br.costrucao.repository.ItemRepository;
import com.br.costrucao.service.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {
	
	@Autowired
	private ItemRepository repository;
	
	@Autowired
	private ItemService service;
	
	@GetMapping
	public List<Item> findAll(){
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Item> findById(@PathVariable Long id){
		return ResponseEntity.of(repository.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Item> insert(@RequestBody Item item){
		
		Item save = service.save(item);
		/*200 ok é errado deve ser 201 created*/
		return ResponseEntity.ok(save);
	}
}	
