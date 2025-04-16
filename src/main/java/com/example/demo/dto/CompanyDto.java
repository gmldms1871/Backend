package com.example.demo.dto;

import com.example.demo.domain.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class CompanyDto {
    private Integer id;
    private String companyname;
    private String companyurl;
    private String companylogo_url;
    private String companyphone;
    private String companybusiness_number;
    private String companyemail;
    private String companypassword;
    private String companyceo_name;
    private String companycreated_at;
    private String companydescription;
    private String companybusiness_license;

    public CompanyDto(Company entity) {
        id = entity.getId();
        companyname = entity.getcompanyname();
        companyurl = entity.getcompanyurl();
        companylogo_url = entity.companylogo_url();
        companyphone = entity.companyphone();
        companybusiness_number = entity.companybusiness_number();
        companyemail = entity.companyemail();
        companypassword = entity.companypassword();
        companyceo_name = entity.companyceo_name();
        companycreated_at = entity.companycreated_at();
        companydescription = entity.companydescription();
        companybusiness_license = entity.companybusiness_license();
    }

    @Getter
    public static class CompanyAddDto{
        @NotBlank
        private String companyid;
        private String companyurl;
        private String companylogo_url;
        private String companyphone;
        private String companybusiness_number;
        private String companyemail;
        private String companypassword;
        private String companyceo_name;
        private String companycreated_at;
        private String companydescription;
        private String companybusiness_license;
    }

}
