package com.ilionx.hobbyapp.api;

import com.ilionx.hobbyapp.model.Musician;
import com.ilionx.hobbyapp.service.HobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(HobbyController.url)
public class HobbyController {

    public static final String url = "/api/hobbies";
    @Autowired
    private HobbyService hobbyService;

    @GetMapping
    public ResponseEntity<Iterable<Musician>> list() {
        return ResponseEntity.ok(hobbyService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Musician> findById(@PathVariable long id) {
        Optional<Musician> optionalMusician = this.hobbyService.findById(id);
        if (optionalMusician.isPresent()) {
            return ResponseEntity.ok(optionalMusician.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Musician> create(@RequestBody Musician musician) {
        return ResponseEntity.ok(this.hobbyService.save(musician));
    }

    @PutMapping("{id}")
    public ResponseEntity<Musician> updateById(@PathVariable long id, @RequestBody Musician source) {
        Optional<Musician> optionalMusician = this.hobbyService.findById(id);
        if(optionalMusician.isPresent()) {
            return ResponseEntity.ok(hobbyService.updateByID(id, source));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        Optional<Musician> optionalMusician = this.hobbyService.findById(id);
        if (optionalMusician.isPresent()) {
            this.hobbyService.deleteByID(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
