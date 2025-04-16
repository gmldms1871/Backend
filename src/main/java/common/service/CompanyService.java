package common.service;

import common.domain.Company;
import common.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;
    //생성자
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
    //회원가입(검사)
    public Company register(String email, String password, String companyName, String userName) {
        System.out.println("email: " + email);
        System.out.println("password: " + password);
        System.out.println("companyName: " + companyName);

        if (companyRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("이미 존재하는 이메일입니다.");
        }

        Company company = new Company();
        company.setEmail(email);
        company.setPassword(password);
        company.setUserName(userName);
        company.setCompanyName(companyName); // 기존 name → companyName

        return companyRepository.save(company);
    }
    //로그인
    public Optional<Company> login(String email, String password) {
        return companyRepository.findByEmailAndPassword(email, password);
    }
    //회원 조회
    public Company findById(String email) {
        return companyRepository.findById(email)
                .orElseThrow(() -> new RuntimeException("회원을 찾을 수 없습니다."));
    }
    //회원 정보 수정
    public Company updateInfo(String email, Map<String, String> request) {
        Company company = companyRepository.findById(email)
                .orElseThrow(() -> new RuntimeException("기업 없음"));

        if (request.containsKey("userName")) company.setUserName(request.get("userName"));
        if (request.containsKey("userPhone")) company.setUserPhone(request.get("userPhone"));
        if (request.containsKey("interestTopic")) company.setInterestTopic(request.get("interestTopic"));

        return companyRepository.save(company);
    }
    //좋아요 수 대로 정렬
    public List<Company> findAllOrderByLikes() {
        return companyRepository.findAllByOrderByLikesDesc();
    }
    //정보 모두 조회
    public List<Company> findAll() {
        return companyRepository.findAll();
    }
}
