//package com.sample.samplelogin.Account;
//
//import lombok.Getter;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Getter
//public class UserAccount extends User {
//
//    private Account account;
//
//    public UserAccount(Account account) {
//        super(account.getNickname(), account.getPassword(), makeAuthority());
//        this.account = account;
//    }
//
//    public static List<SimpleGrantedAuthority> makeAuthority() {
//        List<SimpleGrantedAuthority> list = new ArrayList<>();
//        list.add(new SimpleGrantedAuthority("ROLE_USER"));
//        return list;
//    }
//
//}
