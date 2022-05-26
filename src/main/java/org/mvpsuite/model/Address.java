package org.mvpsuite.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(generator = "uuid4")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    private String street;
    private String city;
    private String postalCode;
    private String country;

}
