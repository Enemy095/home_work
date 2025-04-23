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
public class Product {

    @Id
    @SequenceGenerator(name = "product_seq",
            sequenceName = "product_sequence",
            allocationSize = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private String price;

    @OneToOne
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;
}

//Скрипт создания таблицы product
//
//CREATE TABLE product (
//        id BIGINT NOT NULL UNIQUE PRIMARY KEY,
//        name VARCHAR(64) NOT NULL,
//price NUMERIC NOT NULL,
//buyer_id BIGINT UNIQUE NOT NULL,
//FOREIGN KEY (buyer_id) REFERENCES buyer(id)
//        );

