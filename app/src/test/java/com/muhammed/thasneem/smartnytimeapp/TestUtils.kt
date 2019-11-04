package com.muhammed.thasneem.smartnytimeapp

import org.json.JSONObject
import java.io.File

/**
 * File Description
 * ------------------
 * Author : thasneem
 * Email : thasneem@farabi.ae
 * Date : 9/23/2019
 * Project : NewsFeed
 * Company : Farabi Technology
 */
object TestUtils {

    fun getJsonObject(): String {
        val uri = this.javaClass.classLoader?.getResource("out.json")
        val file = File(uri?.path ?: "")
        return String(file.readBytes())
    }
}