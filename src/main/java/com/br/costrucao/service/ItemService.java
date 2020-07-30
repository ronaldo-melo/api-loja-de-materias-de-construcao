package com.br.costrucao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.costrucao.exceptions.EntityNotFoundException;
import com.br.costrucao.model.Item;
import com.br.costrucao.repository.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository repository;
	
	public Item save(Item entity) {
		return repository.save(entity);
	}
	
	public void deleteById(Long id) {
		Item item = repository.findById(id).orElseThrow(
				() -> new EntityNotFoundException("There is no item registred with that name"));
		repository.deleteById(item.getId());
	}
	
}
