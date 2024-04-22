package com.example.myapplication

import java.text.SimpleDateFormat
import java.util.Date

data class Data(
    val createdAt: String,
    val name: String,
    val avatar: String,
    val id: String
) {
    private fun getDate() : Date? {
        return SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse(createdAt)
    }

    fun getFormattedTime(pattern: String) : String {
        val date = getDate()
        return if (date != null) SimpleDateFormat(pattern).format(date) else ""
    }
}
