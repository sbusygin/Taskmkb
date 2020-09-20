package com.mcb.creditfactory.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "AIRPLANE")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Airplane extends AbstractObject {

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "fuel_capacity")
    private Integer fuelCapacity;

    @Column(name = "seats")
    private Integer seats;

    public Airplane (Long id, String brand, String model, short year, String manucaturer, Integer fuelCapacity, Integer seats) {
        super(id, brand, model, year);
        this.manufacturer = manucaturer;
        this.fuelCapacity = fuelCapacity;
        this.seats = seats;
    }

}
