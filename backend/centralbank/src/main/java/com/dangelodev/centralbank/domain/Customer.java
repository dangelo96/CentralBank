package com.dangelodev.centralbank.domain;

import lombok.*;
import java.util.List;
import java.util.UUID;
import java.sql.Timestamp;
import javax.persistence.*;
import java.time.OffsetDateTime;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
public class Customer {

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

    @OneToOne(mappedBy = "customer")
    private Address address;

    @OneToMany(mappedBy = "customer")
    private List<Account> accounts;

    @Column(nullable = false)
    private String name;

    @Column(name = "real_id", nullable = false)
    private String realID;

    @Column(name = "date_of_birthday")
    private OffsetDateTime dateOfBirthday;

    @CreatedDate
    @Column(updatable = false)
    private Timestamp createdDate;

    private String email;
    private String password;
    private String phoneNumber;
}
