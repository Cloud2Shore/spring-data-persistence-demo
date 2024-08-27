package org.example.repository;

import jakarta.transaction.Transactional;
import org.example.entities.Income;
import org.example.entities.IncomeSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.util.AssertionErrors;

import java.math.BigDecimal;
import java.util.Optional;

@DataJpaTest
@Transactional
class IncomeRepositoryTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private IncomeRepository incomeRepository;

    @Test
    void save() {
        Income income = new Income(IncomeSource.SALARY, new BigDecimal(100));
        income = incomeRepository.save(income);
        Assertions.assertNotNull(income.getId());
//        AssertionErrors.assertEquals(IncomeSource.SALARY,income.getIncomeSource());
    }

    @Test
    void findOne() {
        jdbcTemplate.query("select id from income", (rs, num) -> rs.getInt("id"))
                .forEach(id -> {
                    Optional<Income> income = incomeRepository.findById(id);
                    AssertionErrors.assertTrue("", income.isPresent());
                    Assertions.assertEquals(id, income.get().getId());
                });
    }

}