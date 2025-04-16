package com.example.demo.service;

import com.example.demo.domain.Company;
import com.example.demo.repository.CompanyRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor

public class CompanyService {
    private final CompanyRepository companyRepository;

    public List<Compnay> findAll(){
        return companyRepository.findAll();
    }

    public Company findOne(Integer id){
        return companyRepository.findById(id).or
    }

//    @Transactionalpublic Int

}
