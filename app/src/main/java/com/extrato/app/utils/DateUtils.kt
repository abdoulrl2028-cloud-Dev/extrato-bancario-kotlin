package com.extrato.app.utils

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {
    private val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
    private val out = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

    fun format(dateIso: String): String = try {
        val d = parser.parse(dateIso)
        out.format(d ?: Date())
    } catch (e: Exception) { dateIso }
}
