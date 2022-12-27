package com.ecom.api.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "country")
@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString(of = {"id","code","name"})
@EqualsAndHashCode(of = {"id", "code"})
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "SMALLINT UNSIGNED not null")
    private Integer id;

    @Size(max = 2)
    @Column(name = "code", length = 2)
    private String code;

    @Size(max = 255)
    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
    private Set<State> states = new LinkedHashSet<>();

}