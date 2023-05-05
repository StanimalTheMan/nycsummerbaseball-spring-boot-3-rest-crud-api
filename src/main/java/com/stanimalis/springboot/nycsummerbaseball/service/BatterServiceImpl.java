package com.stanimalis.springboot.nycsummerbaseball.service;

import com.stanimalis.springboot.nycsummerbaseball.dao.BatterRepository;
import com.stanimalis.springboot.nycsummerbaseball.entity.Batter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BatterServiceImpl implements BatterService {

    private BatterRepository batterRepository;

    @Autowired
    public BatterServiceImpl(BatterRepository theBatterRepository) { batterRepository = theBatterRepository; }

    @Override
    public List<Batter> findAll() {
        return batterRepository.findAll();
    }

    @Override
    public Batter findById(int theId) {
        Optional<Batter> result = batterRepository.findById(theId);

        Batter theBatter = null;

        if (result.isPresent()) {
            theBatter = result.get();
        }
        else {
            // batter was not found, probs should handle better
            throw new RuntimeException("Did not find batter id - " + theId);
        }

        return theBatter;
    }

    @Override
    public Batter save(Batter theBatter) {
        return batterRepository.save(theBatter);
    }

    @Override
    public void deleteById(int theId) {
        batterRepository.deleteById(theId);
    }
}
