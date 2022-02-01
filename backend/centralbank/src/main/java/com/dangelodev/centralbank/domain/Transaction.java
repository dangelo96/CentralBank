package com.dangelodev.centralbank.domain;

import lombok.*;
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
@Table(name = "bank_transaction")
public class Transaction {

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
    @JoinColumn(name = "source_account_id")
    private Account sourceAccount;

    @ManyToOne
    @JoinColumn(name = "destination_account_id")
    private Account destinationAccount;

    @CreatedDate
    @Column(name = "date_of_transaction", updatable = false)
    private Timestamp dateOfTransaction;

    @Column(name = "transaction_type")
    private TransactionType transactionType;

    private BigDecimal amount;
}
