package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "company")
public class Company {

    @Id
    private String email; // PK

    private String password;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_phone")
    private String userPhone;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "business_number")
    private String businessNumber;

    @Column(name = "business_license")
    private String businessLicense;

    @Column(name = "homepage_url")
    private String homepageUrl;

    private String category;

    @Column(name = "interest_topic")
    private String interestTopic;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    private int likes;
}
