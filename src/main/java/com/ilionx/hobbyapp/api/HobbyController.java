package com.ilionx.hobbyapp.api;

import com.ilionx.hobbyapp.model.Musician;
import com.ilionx.hobbyapp.service.HobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("api/hobbies")
public class HobbyController {

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
            return null;
        }
    }

    @PostMapping
    public ResponseEntity<Musician> create(@RequestBody Musician musician) {
        return ResponseEntity.ok(this.hobbyService.save(musician));
    }

    @PutMapping("{id}")
    public ResponseEntity<Musician> updateById(@PathVariable long id, @RequestBody Musician source) {
        return ResponseEntity.ok(hobbyService.updateByID(id, source));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        this.hobbyService.deleteByID(id);
        return ResponseEntity.noContent().build();
    }
}
