package com.snowykte0426.onTODO_server.domain.articles.data.constant.dto.response

import com.snowykte0426.onTODO_server.domain.articles.entity.ArticleJpaEntity

data class GetArticleResponse(
    val totalPage: Int,
    val totalElements: Long,
    val articles: List<ArticleJpaEntity>
)