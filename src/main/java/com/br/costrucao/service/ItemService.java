package com.br.costrucao.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
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
				() -> new EntityNotFoundException("There is no item registred with that id"));
		repository.deleteById(item.getId());
	}
	
	public Item update(Long id, Optional<Item> item) {
		
		Item salvo = repository.findById(id).orElseThrow(
				() -> new EntityNotFoundException("There is no item registred with that id"));
		
		BeanUtils.copyProperties(item.get(), salvo, "id");
		return repository.save(salvo);
		
	}
	
}
