package com.lgcns.newspacenewsservice.repository;

import com.lgcns.newspacenewsservice.entity.NewsCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsCategoryRepository extends JpaRepository<NewsCategory, Long> {

}
