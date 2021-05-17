//package com.example.enterprise_application.repository;
//
//
//import com.example.enterprise_application.jpa.VerificationToken;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//
//public interface VerificationTokenRepository extends JpaRepository<VerificationToken, String> {
//    List<VerificationToken> findByCustomerEmail(String email);
//    List<VerificationToken> findByToken(String token);
//}
