package com.snowykte0426.onTODO_server.domain.articles.repository

import com.snowykte0426.onTODO_server.domain.articles.data.constant.ArticleLevel
import com.snowykte0426.onTODO_server.domain.articles.entity.ArticleJpaEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface ArticleJpaRepository : JpaRepository<ArticleJpaEntity, Long> {

    @Query(
        "SELECT a FROM ArticleJpaEntity a WHERE a.content LIKE %:keyword% AND a.isCompleted = :isCompleted AND a.date = :date AND a.level = :level"
    )
    fun searchArticleJpaEntities(
        keyword: String?,
        isCompleted: Boolean?,
        date: LocalDate?,
        level: ArticleLevel?,
        pageable: Pageable
    ): Page<ArticleJpaEntity>
}