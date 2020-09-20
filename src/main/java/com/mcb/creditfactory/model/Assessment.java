package com.mcb.creditfactory.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "ASSESSMENT")
@ToString

public class Assessment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "assessment_date")
    private LocalDate localDate = LocalDate.now();

    @Column(name = "assessed_value")
    private BigDecimal assessedValue;

    public Assessment(BigDecimal assessedValue) {
        this.assessedValue = assessedValue;
    }
}
