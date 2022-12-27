package com.ecom.api.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "state")
@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString(of = {"id","name"})
@EqualsAndHashCode(of = {"id", "name"})
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "SMALLINT UNSIGNED not null")
    private Integer id;

    @Size(max = 255)
    @Column(name = "name")
    private String name;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

}