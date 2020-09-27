package com.ch8n.sample

import android.view.View
import kotlinx.android.synthetic.main.dialog_exit.view.*


class ExitDialog : BaseDialogFragment() {

    override val contentLayoutId: Int
        get() = R.layout.dialog_exit

    override fun setup(view: View) = with(view) {
        viewModel.dialogTitle.observe(this@ExitDialog, { title ->
            toolbar_dialog_title.title = title
        })

        viewModel.dialogDescription.observe(this@ExitDialog, { desc ->
            text_dialog_description.text = desc
        })

        button_dialog_confirm.setOnClickListener {
            viewModel.confirmClickListener.invoke()
        }

        button_dialog_cancel.setOnClickListener {
            viewModel.cancelClickListener.invoke()
        }

        toolbar_dialog_title.setNavigationOnClickListener {
            viewModel.dismissClickListener.invoke()
        }

    }


}

