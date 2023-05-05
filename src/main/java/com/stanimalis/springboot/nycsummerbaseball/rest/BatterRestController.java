package com.stanimalis.springboot.nycsummerbaseball.rest;

import com.stanimalis.springboot.nycsummerbaseball.entity.Batter;
import com.stanimalis.springboot.nycsummerbaseball.service.BatterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BatterRestController {

    private BatterService batterService;

    public BatterRestController(BatterService theBatterService) {
        batterService = theBatterService;
    }

    // expose /batters and return a list of batters
    @GetMapping("/batters")
    public List<Batter> findAll() { return batterService.findAll(); }

    // add mapping for GET /batters/{batterId}

    @GetMapping("/batters/{batterId}")
    public Batter getBatter(@PathVariable int batterId) {

        Batter theBatter = batterService.findById(batterId);

        if (theBatter == null) {
            throw new RuntimeException("Batter id not found - " + batterId);
        }

        return theBatter;
    }

    // add mapping for POST /batters - add new batter

    @PostMapping("/batters")
    public Batter addBatter(@RequestBody Batter theBatter) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of a new item ... instead of an update

        theBatter.setId(0);

        Batter dbBatter = batterService.save(theBatter);

        return dbBatter;
    }

    // add mapping for PUT /batters - update existing batter

    @PutMapping("/batters")
    public Batter updateBatter(@RequestBody Batter theBatter) {

        Batter dbBatter = batterService.save(theBatter);

        return dbBatter;
    }

    // add mapping for DELETE /batters/{batterId} - delete batter

    @DeleteMapping("/batters/{batterId}")
    public String deleteBatter(@PathVariable int batterId) {

        Batter tempBatter = batterService.findById(batterId);

        // throw exception if null

        if (tempBatter == null) {
            throw new RuntimeException("Batter id not found - " + batterId);
        }

        batterService.deleteById(batterId);

        return "Deleted batter id - " + batterId;
    }
}
