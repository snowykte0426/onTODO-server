package com.snowykte0426.onTODO_server.domain.articles.service

import com.snowykte0426.onTODO_server.domain.articles.data.constant.ArticleLevel
import com.snowykte0426.onTODO_server.domain.articles.data.constant.dto.response.GetArticleResponse
import com.snowykte0426.onTODO_server.domain.articles.entity.ArticleJpaEntity
import com.snowykte0426.onTODO_server.domain.articles.repository.ArticleJpaRepository
import jakarta.persistence.EntityNotFoundException
import jakarta.transaction.Transactional
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class ArticleService(private val articleJpaRepository: ArticleJpaRepository) {

    fun findAll(): ResponseEntity<List<ArticleJpaEntity>> {
        return ResponseEntity.status(HttpStatus.OK).body(articleJpaRepository.findAll())
    }

    fun findById(articleId: Long): ResponseEntity<ArticleJpaEntity> {
        return ResponseEntity.status(HttpStatus.OK).body(articleJpaRepository.findById(articleId).orElseThrow {
            EntityNotFoundException("Article not found")
        })
    }

    fun searchArticleJpaEntities(
        keyword: String?,
        isCompleted: Boolean?,
        date: LocalDate?,
        level: ArticleLevel?,
        pageable: Pageable
    ): ResponseEntity<GetArticleResponse> {
        val articleJpaEntities =
            articleJpaRepository.searchArticleJpaEntities(keyword, isCompleted, date, level, pageable)
        return ResponseEntity.status(HttpStatus.OK).body(
            GetArticleResponse(
                articleJpaEntities.totalPages,
                articleJpaEntities.totalElements,
                articleJpaEntities.content
            )
        )
    }

    @Transactional
    fun create(content: String, level: ArticleLevel) {
        val articleJpaEntity = ArticleJpaEntity().apply {
            this.date = LocalDate.now()
            this.content = content
            this.level = level
        }
        articleJpaRepository.save(articleJpaEntity)
    }

    @Transactional
    fun update(articleId: Long, content: String?, level: ArticleLevel?, isCompleted: Boolean?) {
        val articleJpaEntity = articleJpaRepository.findById(articleId).orElseThrow {
            EntityNotFoundException("Article not found")
        }
        content?.let { articleJpaEntity.updateContent(it) }
        level?.let { articleJpaEntity.updateLevel(it) }
        isCompleted?.let { articleJpaEntity.updateIsCompleted(it) }
        articleJpaRepository.save(articleJpaEntity)
    }

    @Transactional
    fun delete(articleId: Long) = articleJpaRepository.deleteById(articleId)
}