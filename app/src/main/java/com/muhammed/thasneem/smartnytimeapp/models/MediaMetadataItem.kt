package com.muhammed.thasneem.smartnytimeapp.models


import com.google.gson.annotations.SerializedName
data class MediaMetadataItem(

	@field:SerializedName("format")
	val format: String? = null,

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("height")
	val height: Int? = null
)