package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@Table(name = "company") // 테이블 엔티티 관리한데
@AllArgsConstructor//확인하기
@NoArgsConstructor

public class Company {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String companyname;
    private String companyurl;
    private String companylogo_url;
    private String companyphone;
    private String companybusiness_number;
    private String companyemail;
    private String companypassword;
    private String companyceo_name;
    private String companycreate_at;
    private String companydescription;
    private String companybusiness_license;

}
