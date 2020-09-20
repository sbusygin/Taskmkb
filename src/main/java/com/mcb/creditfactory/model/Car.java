package com.mcb.creditfactory.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "CAR")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Car extends AbstractObject {
    @Column(name = "power")
    private Double power;

    public Car (Long id, String brand, String model, short year, Double power) {
        super(id, brand, model, year);
        this.power = power;
    }
}
