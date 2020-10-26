package com.tranphuc.home_page.utils

import java.text.SimpleDateFormat
import java.util.*

object ModuleUtils {
    fun formatMilisecondToDate(time: Long): String {
        val date = Date(time * 1000)
        val df = SimpleDateFormat("HH:mm dd/MM/yyyy")
        return df.format(date)
    }

}