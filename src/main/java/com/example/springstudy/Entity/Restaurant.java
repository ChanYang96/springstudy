package com.example.springstudy.Entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
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
public class Restaurant{
    @Id //음식점 아이디
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restaurantId;

    @Column //음식점 이름
    @NotBlank(message = "음식점의 이름을 입력해 주세요")
    private String RestaurantName;

    @Column //미리보기 이미지
    private String previewImage;

    @Temporal(TemporalType.TIME)//시간 타입 0908
    @Column //오픈시간
    @NotBlank(message = "영업 시작 시간을 입력해 주세요.")
    private java.util.Date openTime;

    @Temporal(TemporalType.TIME)//시간 타입 0908
    @Column //마감시간
    @NotBlank(message = "마감 시간을 입력해 주세요.")
    private java.util.Date closeTime;

    @Column //음식점 주소(도로명) <-위도 경도 통합 주소 0908
    @NotBlank(message = "음식점의 위치를 입력하시오.")
    private String address;

    @Column //별점
    private String starRating;

    @Column //숨겨진 푸드
    @NotBlank(message = "숨겨진 푸드에 선점 되었나요?")
    private String hiddenFood;
}
