package org.work.lesson8.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@Scope("prototype")
public class Product {
    private int id;
    private String title;
    private int cost;


    public Product(String title, int cost) {
        this.title = title;
        this.cost = cost;
    }

    public String toString() {
        return title + " " + cost;
    }
}
