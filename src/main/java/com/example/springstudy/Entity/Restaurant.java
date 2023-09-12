package com.example.springstudy.Entity;

import lombok.*;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
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
    private LocalTime openTime;

    @Temporal(TemporalType.TIME)//시간 타입 0908
    @Column //마감시간
    @NotBlank(message = "마감 시간을 입력해 주세요.")
    private LocalTime closeTime;

    @Column //음식점 주소(도로명) <-위도 경도 통합 주소 0908
    @NotBlank(message = "음식점의 위치를 입력하시오.")
    private String address;

    @ColumnDefault("0.0") //별점 0912 : 디폴트 0.0으로 잡아야 한다.
    private float starRating; //0912 피드백 소수점 1자리 까지

    //@NotBlank(message = "숨겨진 푸드에 선점 되었나요?") 0912 직접 입력이 아님
    @ColumnDefault("false")//숨겨진 푸드
    private Boolean hiddenFood;
}
