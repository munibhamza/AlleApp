package com.kodextech.cleaques.utils



import org.ocpsoft.prettytime.PrettyTime
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


private fun String.onUtcToLocal(s: String): String {
    try {
        val utcFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.getDefault())
        utcFormat.timeZone = TimeZone.getTimeZone("UTC")
        val date: Date?
        date = utcFormat.parse(s)
        val localTimeFormate = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        localTimeFormate.timeZone = TimeZone.getDefault()
        localTimeFormate.parse(localTimeFormate.format(date ?: Date()))
        //            prettyTime.
        return localTimeFormate.format(date ?: Date())
    } catch (e: ParseException) {
        try {
            val utcFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
            utcFormat.timeZone = TimeZone.getTimeZone("UTC")
            val date: Date?
            date = utcFormat.parse(s)
            val localTimeFormate = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
            localTimeFormate.timeZone = TimeZone.getDefault()
            localTimeFormate.parse(localTimeFormate.format(date ?: Date()))
            //            prettyTime.
            return localTimeFormate.format(date ?: Date())
        } catch (ex: ParseException) {
            ex.printStackTrace()
        }
        //
    }

    return ""
}

fun Date.getDateCustom(format: String = "yyyy-MM-dd HH:mm:ss"): String {
    val dateFormat = SimpleDateFormat(format, Locale.getDefault())
    return dateFormat.format(this)

}

private fun String.convertToDateObj(date_string: String): Date? {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    try {
        return dateFormat.parse(date_string)
    } catch (e: ParseException) {
        e.printStackTrace()
    }
    return Date()
}

fun String.convertToOutPutFormat(
    inputFormat: String = "yyyy-MM-dd",
    outputFormat: String = "dd MMM"
): String {
    val dateFormatInput = SimpleDateFormat(inputFormat, Locale.getDefault())
    val dateFormatOutput = SimpleDateFormat(outputFormat, Locale.getDefault())
    var date: Date? = Date()
    try {
        date = dateFormatInput.parse(this)
    } catch (e: ParseException) {
        e.printStackTrace()
    }
    return dateFormatOutput.format(date ?: Date())
}

fun String.timeAgo(): String {
    val p = PrettyTime(Locale.getDefault())
    val localDate = onUtcToLocal(this)
    val dtObj = convertToDateObj(localDate)


    return p.format(dtObj)

}

