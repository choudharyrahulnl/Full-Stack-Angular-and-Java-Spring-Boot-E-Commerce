package com.ecom.api.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "address")
@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString(of = {"id","city","country","state","street","zipCode"})
@EqualsAndHashCode(of = {"id", "zipCode"})
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 255)
    @Column(name = "city")
    private String city;

    @Size(max = 255)
    @Column(name = "country")
    private String country;

    @Size(max = 255)
    @Column(name = "state")
    private String state;

    @Size(max = 255)
    @Column(name = "street")
    private String street;

    @Size(max = 255)
    @Column(name = "zip_code")
    private String zipCode;

    @OneToOne(orphanRemoval = true)
    @PrimaryKeyJoinColumn
    private Order order;

}