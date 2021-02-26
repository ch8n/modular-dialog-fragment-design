package com.ch8n.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_fragment_test.*
import kotlinx.android.synthetic.main.activity_main.*

class FragmentTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_test)


    }

    fun clickButton(view: View) {
        supportFragmentManager
            .beginTransaction()
            .add(container.id, SampleFragment.newInstance(), SampleFragment.TAG)
            .commit()
    }
}