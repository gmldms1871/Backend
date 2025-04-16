package common.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    @Column(name = "interest_topic")
    private String interestTopic;

    private int likes;
}
