package com.example.springstudy.Entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class Member implements UserDetails {
    @Id //회원 아이디
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column //회원 이름
    @NotBlank(message = "이름을 입력해 주세요")
    private String userName;

    @Column //회원 비밀번호
    @NotBlank(message = "비밀번호를 입력해 주세요")
    @Pattern(regexp="^(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$", message = "특수문자 포함한 8글자 이상의 비밀번호를 입력해 주세요(사용가능 특수문자 : !@#$%^&*=")
    private String password;

    @Column //회원 이메일
    @NotBlank(message = "이메일을 입력해 주세요")
    @Email(message = "이메일 형식을 맞춰 주세요.")
    private String email;

    @Column //회원 전화번호
    private String contact;

    @Column //회원 프로필 사진
    private String profile;

    @Temporal(TemporalType.DATE)//날짜 타입 0908
    @Column //생성일자
    private LocalDate createDate = LocalDate.now(); //0912 피드백 현재 날짜 자동 입력

    @Temporal(TemporalType.DATE)//날짜 타입 0908
    @Column //수정일자
    private LocalDate updateDate;
    //private String updateDate;

    @Column //위치정보동의
    @NotBlank
    private String locationInformationConsent;


    @Column
    private String verification_code;//인증코드

    @Column
    private boolean certified;//인증됨

    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}