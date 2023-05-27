package com.tucanoo.crm.data.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name="user")
public class Customer {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String fullName;
//    @Column
//    @NotBlank
//    String firstName;
//    @Column
//    @NotBlank
//    String lastName;
    @Column
    String emailAddress;
    @Column
    String address;
    @Column
    String city;
    @Column
    String country;
    @Column
    String phoneNumber;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    List<Request> requests = new ArrayList<>();
}
