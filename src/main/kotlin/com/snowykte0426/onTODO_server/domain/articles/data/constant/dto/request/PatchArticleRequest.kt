package com.snowykte0426.onTODO_server.domain.articles.data.constant.dto.request

import com.snowykte0426.onTODO_server.domain.articles.data.constant.ArticleLevel
import jakarta.validation.constraints.Size

class PatchArticleRequest {
    @Size(min = 1, max = 255)
    var content: String? = null
    var level: ArticleLevel? = null
    var isCompleted: Boolean? = null
}