package com.workintech.s18d1.controller;

import com.workintech.s18d1.dao.BurgerDao;
import com.workintech.s18d1.dao.BurgerDaoImpl;
import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/burger")
public class BurgerController {
    private BurgerDao burgerDao;
    @Autowired
    public BurgerController(BurgerDao burgerDao){
        this.burgerDao = burgerDao;
    }

    @GetMapping()
    public List<Burger> allBurgers(){
        return burgerDao.findAll();
    }

    @GetMapping("/{id}")
    public Burger getBurger(@PathVariable long id){
        return burgerDao.findById(id);
    }

    @PostMapping
    public Burger save(@RequestBody Burger burger){
        return burgerDao.save(burger);
    }

    @PutMapping
    public Burger update( @RequestBody Burger burger){
        return burgerDao.update(burger);
    }

    @DeleteMapping("/{id}")
    public Burger delete(@PathVariable long id){
        return burgerDao.remove(id);
    }

    @GetMapping("/findByPrice")
    public List<Burger> findByPrice(@RequestBody int price){
        return burgerDao.findByPrice(price);
    }

    @GetMapping("/price/{price}")
    public List<Burger> findByPrice(@PathVariable double price){
        return burgerDao.findByPrice(price);
    }

    @GetMapping("/breadType/{breadType}")
    public List<Burger> findByBreadType(@PathVariable BreadType breadType){
        return burgerDao.findByBreadType(breadType);
    }

    @GetMapping("/content/{content}")
    public List<Burger> findByContent(@PathVariable String content){
        return burgerDao.findByContent(content);
    }
}
