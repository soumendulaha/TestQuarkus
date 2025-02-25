package org.acme.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table(name = "users", schema = "jpa")
@SequenceGenerator(
        name = "userSeq",
        sequenceName = "users_SEQ",
        schema = "jpa", // Specify schema for the sequence
        allocationSize = 50
)
public class UserEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSeq")
    public Long id;

    @Column(nullable = false)
    public String name;

    @Column(nullable = false, unique = true)
    public String email;
}