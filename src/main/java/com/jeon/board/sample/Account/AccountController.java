//package com.sample.samplelogin.Account;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.Errors;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.validation.Valid;
//
//@Controller
//@RequiredArgsConstructor
//public class AccountController {
//
//    private final AccountService accountService;
//    private final AccountRepository accountRepository;
//
//
//    @GetMapping("/")
//    public String home(){
//        String name = SecurityContextHolder.getContext().getAuthentication().getName();
//        System.out.println(name);
//        return "index";
//    }
//    @GetMapping("/login")
//    public String login(){
//        return "login";
//    }
//    @GetMapping("/signUp")
//    public String signUpForm(Model model) {
//        model.addAttribute(new SignUpForm());
//        return "signup";
//    }
//    @PostMapping("/signUp")
//    public String signUpSubmit(@Valid SignUpForm signUpForm, Errors errors) {
//        System.out.println("post요청");
//        if (errors.hasErrors()) {
//            return "signUp";
//        }
//        System.out.println("에러없음");
//        Account account = accountService.signUp(signUpForm);
//        System.out.println(account.getNickname());
//        accountService.login(account);
//        return "redirect:/";
//    }
//    @GetMapping("/user")
//    @ResponseBody
//    public String user(){
//        Account yang = accountRepository.findByNickname("yang");
//        System.out.println(yang.getNickname());
//        return "hi";
//    }
//}
