package com.example.controller;

import com.example.entity.Category;
import com.example.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorys")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping("")
    public ResponseEntity postCategory(@RequestBody Category category){
        categoryRepository.save(category);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("")
    public ResponseEntity getAll(){
        List<Category> categories = categoryRepository.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCategory(@PathVariable Long id){
        Category category = categoryRepository.findOne(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity putCategory(@PathVariable Long id,@RequestBody Category category){
        Category oldCategory = categoryRepository.findOne(id);
        oldCategory.setName(category.getName());
        categoryRepository.save(oldCategory);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCategory(@PathVariable Long id){
        categoryRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
