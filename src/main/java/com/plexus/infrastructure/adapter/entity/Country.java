package com.plexus.infrastructure.adapter.entity;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name="country")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Serdeable

public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

}
