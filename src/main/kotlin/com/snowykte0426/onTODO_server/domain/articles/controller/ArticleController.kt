package com.snowykte0426.onTODO_server.domain.articles.controller

import com.snowykte0426.onTODO_server.domain.articles.data.constant.ArticleLevel
import com.snowykte0426.onTODO_server.domain.articles.data.constant.dto.request.PatchArticleRequest
import com.snowykte0426.onTODO_server.domain.articles.data.constant.dto.request.PostArticleRequest
import com.snowykte0426.onTODO_server.domain.articles.service.ArticleService
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
@RequestMapping("/api/v1/articles")
class ArticleController(private val articleService: ArticleService) {

    @GetMapping
    fun getArticles() = articleService.findAll()

    @GetMapping("/{articleId}")
    fun getArticle(@PathVariable articleId: Long) = articleService.findById(articleId)

    @GetMapping("/search")
    fun searchArticles(
        @RequestParam(required = false) keyword: String?,
        @RequestParam(required = false) isCompleted: Boolean?,
        @RequestParam(required = false) date: LocalDate?,
        @RequestParam(required = false) level: ArticleLevel?,
        @RequestParam(required = false) offset: Int?,
        @RequestParam(required = false) limit: Int?
    ) = articleService.searchArticleJpaEntities(keyword, isCompleted, date, level, Pageable.ofSize(limit ?: 10).withPage(offset ?: 0))

    @PostMapping
    fun createArticle(@RequestBody request: PostArticleRequest) = articleService.create(request.content, request.level)

    @PutMapping("/{articleId}")
    fun updateArticle(
        @PathVariable articleId: Long,
        @RequestBody request: PatchArticleRequest
    ) = articleService.update(articleId, request.content, request.level, request.isCompleted)

    @DeleteMapping("/{articleId}")
    fun deleteArticle(@PathVariable articleId: Long) = articleService.delete(articleId)
}