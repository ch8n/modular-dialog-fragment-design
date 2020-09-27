package com.ch8n.sample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider

abstract class BaseDialogFragment : DialogFragment() {

    private var _viewModel: DialogViewModel? = null
    val viewModel get() = requireNotNull(_viewModel)

    abstract val contentLayoutId: Int

    private fun viewModelOfActivityOrFragment(): DialogViewModel {
        return if (parentFragment != null) {
            ViewModelProvider(requireParentFragment()).get(DialogViewModel::class.java)
        } else {
            ViewModelProvider(requireActivity()).get(DialogViewModel::class.java)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _viewModel = viewModelOfActivityOrFragment()
        val view = inflater.inflate(contentLayoutId, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup(view)
    }

    abstract fun setup(view: View)
}