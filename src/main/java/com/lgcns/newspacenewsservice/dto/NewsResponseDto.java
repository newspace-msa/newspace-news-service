package com.lgcns.newspacenewsservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NewsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String date;
    private String source; // newsCompany
    private String link;
}
