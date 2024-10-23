package com.example.ohm_law_calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.ohm_law_calculator.model.OhmLawCalculation;
import com.example.ohm_law_calculator.model.Service.OhmLawService;

@Controller
public class OhmLawController {

    @Autowired
    private OhmLawService ohmLawService;

    @GetMapping("/")
    public String calculatorForm(Model model) {
        model.addAttribute("calculation", new OhmLawCalculation());
        model.addAttribute("history", ohmLawService.getAllCalculations());
        return "calculator";
    }

    @PostMapping("/calculate")
    public String calculate(@ModelAttribute OhmLawCalculation calculation, Model model) {
        OhmLawCalculation result = ohmLawService.calculate(calculation);
        model.addAttribute("calculation", result);
        model.addAttribute("history", ohmLawService.getAllCalculations());
        return "calculator";
    }


    @PostMapping("/delete/{id}")
    public String deleteCalculation(@PathVariable Long id) {
        ohmLawService.deleteCalculation(id);
        return "redirect:/";
    }
}
