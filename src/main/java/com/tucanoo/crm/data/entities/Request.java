package com.tucanoo.crm.data.entities;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "request")
public class Request {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String name;

    @Column
    String description;

    @Column
    String status;

    @Column
    String fullName;

    @Column
    String emailAddress;

    @Column
    String phoneNumber;

    @Column
    String type;

    @Column
    LocalDateTime startDate;

    @Column
    LocalDateTime endDate;

    @Column
    Integer grade;

    @ManyToOne
    @JoinColumn(name = "id_user")
    Customer customer;

    public void setStartDate(String date) {
        startDate = LocalDateTime.parse(date);
    }
}
