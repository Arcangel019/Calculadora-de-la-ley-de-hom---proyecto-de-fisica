package com.example.ohm_law_calculator.model.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ohm_law_calculator.model.OhmLawCalculation;

@Repository
public interface OhmLawRepository extends JpaRepository<OhmLawCalculation, Long> {
    // Aquí puedes agregar métodos personalizados de consulta si los necesitas
}
