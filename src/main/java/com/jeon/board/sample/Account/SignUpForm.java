package com.sample.samplelogin.Account;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
public class SignUpForm {

    @NotBlank
    @Length(min = 2, max = 20)
    private String nickname;

    @NotBlank
    @Length(min = 3, max = 20)
    private String password;

}
