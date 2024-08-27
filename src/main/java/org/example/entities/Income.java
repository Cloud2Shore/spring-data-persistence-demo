package org.example.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private IncomeSource incomeSource;

    private BigDecimal amount;

    public Income() {
    }

    public Income(Integer id, IncomeSource incomeSource, BigDecimal amount) {
        this.id = id;
        this.incomeSource = incomeSource;
        this.amount = amount;
    }

    public Income(IncomeSource incomeSource, BigDecimal amount) {
        this.incomeSource = incomeSource;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public IncomeSource getIncomeSource() {
        return incomeSource;
    }

    public void setIncomeSource(IncomeSource incomeSource) {
        this.incomeSource = incomeSource;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Income income = (Income) o;
        return Objects.equals(id, income.id) && incomeSource == income.incomeSource && Objects.equals(amount, income.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, incomeSource, amount);
    }

    @Override
    public String toString() {
        return "Income{" +
                "id=" + id +
                ", incomeSource=" + incomeSource +
                ", amount=" + amount +
                '}';
    }
}
