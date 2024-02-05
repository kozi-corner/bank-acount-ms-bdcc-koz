package net.kozi.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import net.kozi.accountservice.enums.AccountType;
import net.kozi.accountservice.model.Customer;
import java.time.LocalDate;


@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString @Builder
@Entity
public class BankAccount {

    @Id
    private String accountId;
    private double balance;
    @Temporal(TemporalType.DATE)
    private LocalDate createdAt;
    private String currency;
    @Enumerated(EnumType.ORDINAL)
    private AccountType type;
    @Transient
    private Customer customer;
    private Long customerId;
}
