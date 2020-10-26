//package com.sample.samplelogin.Account;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.util.List;
//import java.util.Objects;
//
//import static com.sample.samplelogin.Account.UserAccount.makeAuthority;
//
//@Service
//@Transactional
//@RequiredArgsConstructor
//public class AccountService implements UserDetailsService {
//
//    private final AccountRepository accountRepository;
//
//    private final PasswordEncoder passwordEncoder;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Account account = accountRepository.findByNickname(username);
//        if(Objects.isNull(account))
//            throw new UsernameNotFoundException(username);
//
//        return new UserAccount(account);
//    }
//
//    public Account signUp(SignUpForm signUpForm) {
//        signUpForm.setPassword(passwordEncoder.encode(signUpForm.getPassword()));
//        Account account = new Account();
//        account.setNickname(signUpForm.getNickname());
//        account.setPassword(signUpForm.getPassword());
//        return accountRepository.save(account);
//    }
//    public void login(Account account) {
//        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
//                new UserAccount(account),
//                account.getPassword(),
//                makeAuthority());
//        SecurityContextHolder.getContext().setAuthentication(token);
//    }
//}
