package com.mcb.creditfactory.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Access(AccessType.FIELD)
@MappedSuperclass
@AllArgsConstructor
public class AbstractObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;

    @Column(name = "year_of_issue")
    private Short year;

    public AbstractObject (Long id, String brand, String model, Short year) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractObject that = (AbstractObject) o;
        return id.equals(that.id) &&
                Objects.equals(brand, that.brand) &&
                Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, model);
    }

}
