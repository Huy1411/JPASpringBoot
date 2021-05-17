//package com.example.enterprise_application.service;
//
//
//
//import com.example.enterprise_application.jpa.Customer;
//import com.example.enterprise_application.jpa.VerificationToken;
//import com.example.enterprise_application.repository.CustomerRepository;
//import com.example.enterprise_application.repository.VerificationTokenRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Service
//public class VerificationTokenService {
//    private CustomerRepository customerRepository;
//    private VerificationTokenRepository verificationTokenRepository;
//    private SendingMailService sendingMailService;
//    @Autowired
//    public VerificationTokenService(CustomerRepository customerRepository,
//                                    VerificationTokenRepository verificationTokenRepository,
//                                    SendingMailService sendingMailService){
//        this.customerRepository = customerRepository;
//        this.verificationTokenRepository = verificationTokenRepository;
//        this.sendingMailService = sendingMailService;
//    }
//    public void createVerification(String email){
//        List<Customer> customers = customerRepository.findByEmail(email);
//        Customer customer;
//        if (customers.isEmpty()) {
//            customer = new Customer();
//            customer.setEmail(email);
//            customerRepository.save(customer);
//        } else {
//            customer = customers.get(0);
//        }
//        List<VerificationToken> verificationTokens =
//            verificationTokenRepository.findByCustomerEmail(email);
//        VerificationToken verificationToken;
//        if (verificationTokens.isEmpty()) {
//            verificationToken = new VerificationToken();
//            verificationToken.setCustomer(customer);
//            verificationTokenRepository.save(verificationToken);
//        } else {
//            verificationToken = verificationTokens.get(0);
//        }
//        sendingMailService.sendVerificationMail(email, verificationToken.getToken());
//    }
//    public ResponseEntity<String> verifyEmail(String token){
//        List<VerificationToken> verificationTokens = verificationTokenRepository.findByToken(token);
//        if (verificationTokens.isEmpty()) {
//            return ResponseEntity.badRequest().body("Invalid token."); }
//        VerificationToken verificationToken = verificationTokens.get(0);
//        if (verificationToken.getExpiredDateTime().isBefore(LocalDateTime.now())) {
//            return ResponseEntity.unprocessableEntity().body("Expired token."); }
//
//        verificationToken.setConfirmedDateTime(LocalDateTime.now());
//        verificationToken.setStatus(VerificationToken.STATUS_VERIFIED);
//        verificationToken.getCustomer().setIsActive(true);
//        verificationTokenRepository.save(verificationToken);
//        return ResponseEntity.ok("You have successfully verified your email address.");
//    }
//}
