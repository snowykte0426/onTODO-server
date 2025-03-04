package com.snowykte0426.onTODO_server.domain.articles.repository

import com.snowykte0426.onTODO_server.domain.articles.data.constant.ArticleLevel
import com.snowykte0426.onTODO_server.domain.articles.entity.ArticleJpaEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface ArticleJpaRepository : JpaRepository<ArticleJpaEntity, Long> {

    @Query("""
    SELECT a 
    FROM ArticleJpaEntity a 
    WHERE (:keyword IS NULL OR a.content LIKE CONCAT('%', :keyword, '%'))
      AND (:isCompleted IS NULL OR a.isCompleted = :isCompleted)
      AND (:date IS NULL OR a.date = :date)
      AND (:level IS NULL OR a.level = :level)
""")
    fun searchArticleJpaEntities(
        @Param("keyword") keyword: String?,
        @Param("isCompleted") isCompleted: Boolean?,
        @Param("date") date: LocalDate?,
        @Param("level") level: ArticleLevel?,
        pageable: Pageable
    ): Page<ArticleJpaEntity>
}