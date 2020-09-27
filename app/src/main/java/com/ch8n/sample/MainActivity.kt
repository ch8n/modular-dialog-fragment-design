package com.ch8n.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dialogVM = ViewModelProvider(this).get(DialogViewModel::class.java)

        with(dialogVM) {
            dialogTitle.value = "Activity Test title"
            dialogDescription.value = "some random text yada yada yada...set by the activity"
            confirmClickListener = {
                Toast.makeText(this@MainActivity, "confirm clicked", Toast.LENGTH_SHORT).show()
            }
            cancelClickListener = {
                Toast.makeText(this@MainActivity, "cancel clicked", Toast.LENGTH_SHORT).show()
            }
            dismissClickListener = {
                Toast.makeText(this@MainActivity, "dismissed clicked", Toast.LENGTH_SHORT).show()
            }
        }


        button_show_dialog.setOnClickListener {
            if (supportFragmentManager.findFragmentByTag(ExitDialog.TAG) == null) {
                ExitDialog.newInstance()
                    .show(supportFragmentManager, ExitDialog.TAG)
            }
        }


        button_show_fragment.setOnClickListener {
            if (supportFragmentManager.findFragmentByTag(SampleFragment.TAG) == null) {
                supportFragmentManager
                    .beginTransaction()
                    .add(root.id, SampleFragment.newInstance(), SampleFragment.TAG)
                    .commit()
            }
        }
    }
}