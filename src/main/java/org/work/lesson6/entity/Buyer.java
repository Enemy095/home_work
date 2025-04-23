package org.work.lesson6.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Buyer {

    @Id
    @SequenceGenerator(name = "buyer_seq",
            sequenceName = "buyer_sequence",
            allocationSize = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "buyer_seq")
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "purchase", nullable = false)
    @OneToOne(mappedBy = "buyer", cascade = javax.persistence.CascadeType.ALL, orphanRemoval = true)
    private Product purchase;
}

//Скрипт создания таблицы buyer и general_sequence
//
//CREATE SEQUENCE general_sequence
//START WITH 1
//CACHE 10;
//
//CREATE TABLE buyer (
//        id BIGINT NOT NULL UNIQUE PRIMARY KEY,
//        name VARCHAR(128) NOT NULL
//);

