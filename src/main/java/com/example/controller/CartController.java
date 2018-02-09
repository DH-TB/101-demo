package com.example.controller;

import com.example.entity.Cart;
import com.example.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {
    @Autowired
    private CartRepository CartRepository;

    @PostMapping("")
    public ResponseEntity postCart(@RequestBody Cart cart){
        CartRepository.save(cart);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity getAll(){
        List<Cart> cart = CartRepository.findAll();
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity getCart(@PathVariable Long id){
        Cart cart = CartRepository.findOne(id);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity putCart(@PathVariable Long id,@RequestBody Cart cart){
        Cart oldCart = CartRepository.findOne(id);
        oldCart.setName(cart.getName());
        CartRepository.save(oldCart);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCart(@PathVariable Long id){
        CartRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
