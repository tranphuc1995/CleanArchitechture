package com.tranphuc.home_page

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tranphuc.home_page.ui.list_user.ListUserFragment

class HomePageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        addFragment()
    }

    private fun addFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frContainer, ListUserFragment())
        transaction.commit()
    }

}