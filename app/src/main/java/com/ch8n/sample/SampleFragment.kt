package com.ch8n.sample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_sample.view.*

class SampleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sample, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup(view)
    }

    private fun setup(view: View) = with(view) {

        val dialogVM = ViewModelProvider(this@SampleFragment).get(DialogViewModel::class.java)

        with(dialogVM) {
            dialogTitle.value = "Fragment Test title"
            dialogDescription.value = "some random text yada yada yada...set by the fragment"
            confirmClickListener = {
                Toast.makeText(requireContext(), "confirm clicked", Toast.LENGTH_SHORT).show()
            }
            cancelClickListener = {
                Toast.makeText(requireContext(), "cancel clicked", Toast.LENGTH_SHORT).show()
            }
            dismissClickListener = {
                Toast.makeText(requireContext(), "dismissed clicked", Toast.LENGTH_SHORT).show()
            }
        }


        button_show_dialog.setOnClickListener {
            if (childFragmentManager.findFragmentByTag(ExitDialog.TAG) == null) {
                ExitDialog.newInstance()
                    .show(childFragmentManager, ExitDialog.TAG)
            }
        }

        button_remove_fragment.setOnClickListener {
            requireFragmentManager().beginTransaction()
                .remove(this@SampleFragment)
                .commit()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = SampleFragment()
        const val TAG = "SampleFragment"
    }
}