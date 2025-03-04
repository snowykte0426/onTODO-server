package com.snowykte0426.onTODO_server.domain.articles.entity

import com.snowykte0426.onTODO_server.domain.articles.data.constant.ArticleLevel
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "articles")
class ArticleJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id", nullable = false, updatable = false, unique = true, columnDefinition = "BIGINT")
    var articleId: Long? = null

    @Column(name = "content", nullable = false, columnDefinition = "TEXT", length = 255)
    var content: String? = null

    @Column(name = "date", nullable = false, columnDefinition = "DATE")
    var date: LocalDate? = LocalDate.now()

    @Column(name = "is_completed", nullable = false, columnDefinition = "BOOLEAN")
    var isCompleted: Boolean? = false

    @Enumerated(EnumType.STRING)
    @Column(name = "level", nullable = false, columnDefinition = "VARCHAR(255)")
    var level: ArticleLevel? = null

    fun updateContent(content: String) {
        this.content = content
    }

    fun updateLevel(level: ArticleLevel) {
        this.level = level
    }

    fun updateIsCompleted(isCompleted: Boolean) {
        this.isCompleted = isCompleted
    }
}