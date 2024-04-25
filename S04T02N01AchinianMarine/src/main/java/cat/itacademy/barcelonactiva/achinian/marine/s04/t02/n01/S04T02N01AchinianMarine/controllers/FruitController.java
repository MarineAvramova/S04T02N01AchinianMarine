package cat.itacademy.barcelonactiva.achinian.marine.s04.t02.n01.S04T02N01AchinianMarine.controllers;

import cat.itacademy.barcelonactiva.achinian.marine.s04.t02.n01.S04T02N01AchinianMarine.model.domain.Fruit;
import cat.itacademy.barcelonactiva.achinian.marine.s04.t02.n01.S04T02N01AchinianMarine.model.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/fruits")
public class FruitController {

    @Autowired
    // FruitRepository repository;
    FruitRepository repository;

//    //@GetMapping("/fruit")
//    public FruitController(FruitRepository repository) {
//        this.repository = repository;
//    }
//    @GetMapping
//    public Iterable<Fruit> findAll(){
//        return repository.findAll();
//    }

    //getAll
    @GetMapping
    public ResponseEntity<List<Fruit>> getAll() {
        try {
            List<Fruit> fruits = new ArrayList<Fruit>();
            repository.findAll().forEach(fruits::add);
            if (fruits.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else
                return new ResponseEntity<>(fruits, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //getOne
    @GetMapping("/fruit/{id}")
    public ResponseEntity<Fruit> getFruitByID(@PathVariable("id") Long id) {
        Optional<Fruit> fruitData = repository.findById(id);

        if (fruitData.isPresent()) {
            return new ResponseEntity<>(fruitData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/fruits")
    public ResponseEntity<Fruit> createFruit(@RequestBody Fruit fruit) {
        try {
            Fruit _fruit = repository
                    .save(new Fruit(fruit.getName(), fruit.getQuantity()));
            return new ResponseEntity<>(_fruit, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/fruits/{id}")
    public ResponseEntity<Fruit> updateFruit(@PathVariable("id") Long id, @RequestBody Fruit fruit) {
        Optional<Fruit> fruitData = repository.findById(id);

        if (fruitData.isPresent()) {
            Fruit _fruit = fruitData.get();
            _fruit.setName(fruit.getName());
            _fruit.setQuantity(fruit.getQuantity());
            return new ResponseEntity<>(repository.save(_fruit), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/fruit/{id}")
    public ResponseEntity<HttpStatus> deleteFruit(@PathVariable("id") long id) {

        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/fruit")
    public ResponseEntity<HttpStatus> deleteAllFruit() {
        try {
            repository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

