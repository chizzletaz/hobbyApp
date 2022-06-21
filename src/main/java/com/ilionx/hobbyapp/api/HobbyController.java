package com.ilionx.hobbyapp.api;

import com.ilionx.hobbyapp.model.Musician;
import com.ilionx.hobbyapp.service.HobbyService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Musician> list() {
        return this.hobbyService.findAll();
    }

    @GetMapping("{id}")
    public Musician findById(@PathVariable long id) {
        Optional<Musician> optionalMusician = this.hobbyService.findById(id);
        if (optionalMusician.isPresent()) {
            return optionalMusician.get();
        } else {
            return null;
        }
    }

    @PostMapping
    public Musician create(@RequestBody Musician musician) {
        return this.hobbyService.save(musician);
    }

    @PutMapping("{id}")
    public Musician updateById(@PathVariable long id, @RequestBody Musician source) {
        Optional<Musician> optionalMusician = this.hobbyService.findById(id);
        if (optionalMusician.isPresent()) {
            Musician target = optionalMusician.get();
            target.setName(source.getName());
            target.setAge(source.getAge());
            target.setInstrument(source.getInstrument());

            return this.hobbyService.save(target);
        } else {
            return null;
        }
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable long id) {
        Optional<Musician> optionalMusician = this.hobbyService.findById(id);
        if(optionalMusician.isPresent()) {
            this.hobbyService.deleteById(id);
        }
    }
}
