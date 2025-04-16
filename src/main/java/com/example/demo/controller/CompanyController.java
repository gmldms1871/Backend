package com.example.demo.controller;

import com.example.demo.domain.Company;
import com.example.demo.dto.CompanyDto;
import com.example.demo.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // API리턴해서 이거 이용한데용
@RequiredArgsConstructor //의존성 주입 final으로 선언만 해줘도 사용할 수 있다?
@RequestMapping(value={"company/"})
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping("list")
    public ResponseDto list() throws IOExeption {
        List<Company> list = companyService.findAll();
        List<CompanyDto> collect = list.stream()
                .map(m -> new CompnayDto(m))
                .collect(Collectors.toList());
//        List<CompnayDto> collect = list.stream()
//                .map(CompanyDto::new)
//                .collect(Collectors.toList());
        // 한번 더 줄일수 있는 예시가 주석처리 된거랍니다.
        return new ResponseDto(HttpStatus.OK,"company ");
    }
}
