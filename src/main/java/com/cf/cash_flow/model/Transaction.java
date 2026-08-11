package com.cf.cash_flow.model;

import com.cf.cash_flow.enums.TransactionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "transactions")
public class Transaction {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "transaction_date",nullable = false)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate transactionDate;

    @Column(name = "description",nullable = false)
    @NotBlank
    @Size(max = 255)
    private String description;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(name = "transaction_type",nullable = false)
    @NotNull
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @Column(name = "amount",nullable = false)
    @Positive
    private BigDecimal amount;
}