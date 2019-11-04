package com.muhammed.thasneem.smartnytimeapp.models

import com.google.gson.annotations.SerializedName

data class ResultsItem(


    @field:SerializedName("column")
    val column: String? = null,

    @field:SerializedName("section")
    val section: String? = null,

    @field:SerializedName("abstract")
    val jsonMemberAbstract: String? = null,

    @field:SerializedName("source")
    val source: String? = null,

    @field:SerializedName("asset_id")
    val assetId: Long? = null,

    @field:SerializedName("media")
    val media: List<MediaItem>? = null,

    @field:SerializedName("type")
    val type: String? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("url")
    val url: String? = null,

    @field:SerializedName("adx_keywords")
    val adxKeywords: String? = null,

    @field:SerializedName("id")
    val id: Long? = null,

    @field:SerializedName("byline")
    val byline: String? = null,

    @field:SerializedName("published_date")
    val publishedDate: String? = null,

    @field:SerializedName("views")
    val views: Int? = null
) {
    fun getImgThumb(): String? {
        return media?.let {
            if (it.isNotEmpty()) {
                it[0].mediaMetadata?.let { imageItem ->
                    return imageItem[0]?.url ?: ""
                }
            }
            ""

        } ?: ""
    }
}