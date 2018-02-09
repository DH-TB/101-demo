package com.example.controller;

import com.example.entity.Item;
import com.example.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;

    @PostMapping("")
    public ResponseEntity postItem(@RequestBody Item item) {
        itemRepository.save(item);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity getAll() {
        List<Item> items = itemRepository.findAll();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity getItem(@PathVariable Long id) {
        Item item = itemRepository.findOne(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity putItem(@PathVariable Long id, @RequestBody Item item) {
        Item oldItem = itemRepository.findOne(id);
        oldItem.setName(item.getName());
        oldItem.setPrice(item.getPrice());
        itemRepository.save(oldItem);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteItem(@PathVariable Long id) {
        itemRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
