package com.ch8n.sample


import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
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
            dismiss()
            viewModel.confirmClickListener.invoke()
        }

        button_dialog_cancel.setOnClickListener {
            dismiss()
            viewModel.cancelClickListener.invoke()
        }

        toolbar_dialog_title.setNavigationOnClickListener {
            dismiss()
            viewModel.dismissClickListener.invoke()
        }

    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        viewModel.dismissClickListener.invoke()
    }

    companion object {
        const val TAG = "ExitDialog"
        fun newInstance() = ExitDialog()
    }

}

