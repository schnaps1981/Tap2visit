package com.test.tap2visit.global

import com.test.tap2visit.network.entity.Categories
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun String.toHumanTime() : String {
    val input = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale(Locale.getDefault().toString()))
    val output = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale(Locale.getDefault().toString()))

    var d: Date? = null
    try {
        d = input.parse(this)
    } catch (e: ParseException) {
        e.printStackTrace()
    }
    return output.format(d)
}

/** * Returns an enum entry with the specified name or `null` if no such entry was found. */
inline fun <reified T : Enum<T>> enumValueOfOrNull(name: String): T? {
    return enumValues<T>().find { it.name == name }
}