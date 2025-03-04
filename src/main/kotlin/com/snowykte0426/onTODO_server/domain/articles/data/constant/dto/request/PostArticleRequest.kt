package com.snowykte0426.onTODO_server.domain.articles.data.constant.dto.request

import com.snowykte0426.onTODO_server.domain.articles.data.constant.ArticleLevel
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class PostArticleRequest(
    @Size(min = 1, max = 255)
    @NotNull
    val content: String,
    @NotNull
    val level: ArticleLevel
)