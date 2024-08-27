package org.example.repository;

import org.example.entities.Income;
import org.example.entities.IncomeSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Integer> {
    List<Income> findByIncomeSource(IncomeSource incomeSource);
}
