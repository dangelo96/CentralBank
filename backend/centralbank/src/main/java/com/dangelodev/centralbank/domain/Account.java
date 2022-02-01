package com.dangelodev.centralbank.domain;

import lombok.*;
import java.util.List;
import java.util.UUID;
import java.sql.Timestamp;
import javax.persistence.*;
import java.math.BigDecimal;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account")
public class Account {

    @Id
    @Column(
            length = 36,
            nullable = false,
            updatable = false,
            columnDefinition = "varchar"
    )
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "sourceAccount")
    private List<Transaction> sourceAccounts;

    @OneToMany(mappedBy = "destinationAccount")
    private List<Transaction> destinationAccount;
    
    @OneToOne(mappedBy = "account")
    private Card card;

    @Column(name = "account_number", nullable = false)
    private String accountNumber;

    @CreatedDate
    @Column(updatable = false)
    private Timestamp createdDate;

    private String agency;
    private BigDecimal balance;
}