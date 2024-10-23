package com.example.ohm_law_calculator.model.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ohm_law_calculator.model.OhmLawCalculation;
import com.example.ohm_law_calculator.model.repository.OhmLawRepository;

import java.util.List;

@Service
public class OhmLawService {

    @Autowired
    private OhmLawRepository repository;

    public OhmLawCalculation calculate(OhmLawCalculation input) {
        // Realizar cálculos
        if (input.getVoltage() == null) {
            input.setVoltage(input.getCurrent() * input.getResistance());
        } else if (input.getCurrent() == null) {
            input.setCurrent(input.getVoltage() / input.getResistance());
        } else if (input.getResistance() == null) {
            input.setResistance(input.getVoltage() / input.getCurrent());
        }
        
        // Guardar el cálculo en la base de datos
        return repository.save(input);
    }

    public List<OhmLawCalculation> getAllCalculations() {
        return repository.findAll();
    }

    public void deleteCalculation(Long id) {
        repository.deleteById(id);
    }
}
