package com.tranphuc.home_page

import com.tranphuc.home_page.utils.ModuleUtils
import org.junit.Test
import org.junit.Assert.assertEquals

class UtilsTest {
    @Test
    fun test_convert_milisecond_to_format_date() {
        assertEquals("21:48 22/10/2020",ModuleUtils.formatMilisecondToDate(1603378119))
    }
}