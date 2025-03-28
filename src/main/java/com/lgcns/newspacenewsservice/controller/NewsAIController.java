package com.lgcns.newspacenewsservice.controller;

import com.lgcns.newspacenewsservice.dto.NewsResponseDto;
import com.lgcns.newspacenewsservice.service.NewsAIService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/news")
@RequiredArgsConstructor
@Slf4j
public class NewsAIController {
    private final NewsAIService newsAIService;

    /**
     * Groq AI를 이용하여 오늘 날짜의 과거 핫한 뉴스를 가져옵니다!
     * @param keyword 카테고리명이나 키워드명을 입력하면 프롬프트 파라미터로 활용합니다.
     * @return List<NewsResponseDto> 뉴스 10개
     */
    @GetMapping
    public ResponseEntity<List<NewsResponseDto>> getNews(@RequestParam String keyword) {
        log.info("[GET] /api/news 요청 - category: {}", keyword); // 요청 로그

        try {
            List<NewsResponseDto> newsList = newsAIService.getPastNews(keyword);

            if (newsList.isEmpty()) {
                log.warn("뉴스 데이터 없음 - category: {}", keyword);
                return ResponseEntity.status(500).build(); // 실패 시 500 에러 반환
            }

            log.info("뉴스 데이터 응답 성공 - category: {}, 개수: {}", keyword, newsList.size());
            return ResponseEntity.ok(newsList);

        } catch (Exception e) {
            log.error("뉴스 데이터 조회 중 예외 발생 - category: {}", keyword, e);
            return ResponseEntity.status(500).body(null);
        }
    }

}