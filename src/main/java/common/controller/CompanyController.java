package common.controller;

import common.domain.Company;
import common.service.CompanyService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@SessionAttributes("loginCompanyId")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }
    //users에서 회원가입 진행(검사)
    @PostMapping("/users")
    public ResponseEntity<?> signup(@RequestBody Map<String, String> request) {
        try {
            String email = request.get("email");
            String password = request.get("password");
            String userName = request.get("userName");
            String name = request.get("name");

            Company company = companyService.register(email, password, name, userName);
            return ResponseEntity.ok(company);

        } catch (Exception e) {
            e.printStackTrace(); // 로깅 용
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("회원가입 실패: " + e.getMessage());
        }
    }
    //로그인
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request, HttpSession session) {
        Optional<Company> company = companyService.login(
                request.get("email"),
                request.get("password")
        );

        if (company.isPresent()) {
            session.setAttribute("loginCompanyId", company.get().getEmail()); // ✅ 변경된 부분
            return ResponseEntity.ok("로그인 성공");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 실패");
        }
    }
    //로그아웃
    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok("로그아웃 완료");
    }
    //기업들 조회
    @GetMapping(value = "/companies", params = "!sort")
    public ResponseEntity<?> getAllCompanies() {
        List<Company> companies = companyService.findAll();
        return ResponseEntity.ok(companies);
    }
    //좋아요 수 대로 정렬
    @GetMapping(value = "/companies", params = "sort")
    public ResponseEntity<?> getCompanies(@RequestParam("sort") String sort) {
        List<Company> companies = companyService.findAllOrderByLikes();
        return ResponseEntity.ok(companies);
    }
    //기업 상세 조회
    @GetMapping("/companies/{email}")
    public ResponseEntity<?> getCompanyDetail(@PathVariable("email") String email) {
        Company company = companyService.findById(email); // ✅ email 기반으로 수정
        return ResponseEntity.ok(company);
    }
    //내 기업 정보 조회
    @GetMapping("/me")
    public ResponseEntity<?> getLoginCompany(HttpSession session) {
        String loginEmail = (String) session.getAttribute("loginCompanyId");
        if (loginEmail == null) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 필요");

        Company company = companyService.findById(loginEmail);
        return ResponseEntity.ok(company);
    }
    //내 정보 조회
    @GetMapping("/users/me")
    public ResponseEntity<?> getMyInfo(HttpSession session) {
        String email = (String) session.getAttribute("loginCompanyId");
        if (email == null) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 필요");

        Company company = companyService.findById(email);
        return ResponseEntity.ok(company);
    }
    //내 정보 업데이트
    @PatchMapping("/users/me")
    public ResponseEntity<?> updateMyInfo(HttpSession session, @RequestBody Map<String, String> request) {
        String email = (String) session.getAttribute("loginCompanyId");
        if (email == null) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 필요");

        Company updated = companyService.updateInfo(email, request);
        return ResponseEntity.ok(updated);
    }
}
