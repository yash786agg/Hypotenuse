package com.app.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.app.common.Constant.Companion.SAMPLE_FIRST_COORDINATES
import com.app.common.Constant.Companion.SAMPLE_SECOND_COORDINATES
import com.app.common.afterTextChanged
import com.app.common.hideKeyboard
import com.app.hypotenuse.BuildConfig
import com.app.hypotenuse.R
import com.app.hypotenuse.databinding.ActivityHypotenuseBinding
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class HypotenuseActivity : AppCompatActivity() {

    // ViewModel ---
    private val hypotenuseVM: HypotenuseVM by viewModel()

    /*View Binding*/
    private lateinit var activityHypotenuseBinding: ActivityHypotenuseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityHypotenuseBinding =
            ActivityHypotenuseBinding.inflate(layoutInflater) // activity_hypotenuse.xml
        setContentView(activityHypotenuseBinding.root)

        activityHypotenuseBinding.edtTextFirstCoordinates.afterTextChanged { enableLoginButton() }

        activityHypotenuseBinding.edtTextSecondCoordinates.afterTextChanged { enableLoginButton() }

        if (BuildConfig.DEBUG) {
            activityHypotenuseBinding.edtTextFirstCoordinates.setText(SAMPLE_FIRST_COORDINATES)
            activityHypotenuseBinding.edtTextSecondCoordinates.setText(SAMPLE_SECOND_COORDINATES)
        }

        activityHypotenuseBinding.buttonCalculate.setOnClickListener {
            if (activityHypotenuseBinding.buttonCalculate.isEnabled) {
                hideKeyboard()
                configureObservable()
            }
        }
    }

    // View Model Observable ----
    private fun configureObservable() {
        hypotenuseVM.rightTriangleCalculator(
            activityHypotenuseBinding.edtTextFirstCoordinates.text.toString().toDouble(),
            activityHypotenuseBinding.edtTextSecondCoordinates.text.toString().toDouble()
        ).observe(this, Observer {
            it?.also {
                activityHypotenuseBinding.lengthText.text = it.length.toString()
                activityHypotenuseBinding.areaMmText.text = it.areaMM.toString()
                activityHypotenuseBinding.areaSqInchesText.text = it.areaSqInch.toString()
                activityHypotenuseBinding.angleFirstText.text = it.angleFirst.toString()
                activityHypotenuseBinding.angleSecondText.text = it.angleSecond.toString()

                showSnackBar(
                    activityHypotenuseBinding.rootView,
                    this.resources.getString(R.string.success_value_calculated)
                )
            } ?: run {
                showSnackBar(
                    activityHypotenuseBinding.rootView,
                    this.resources.getString(R.string.error_something_went_wrong)
                )
            }
        })
    }

    private fun enableLoginButton() {
        activityHypotenuseBinding.edtTextFirstCoordinates.text?.also { first ->
            activityHypotenuseBinding.edtTextSecondCoordinates.text?.also { second ->
                activityHypotenuseBinding.buttonCalculate.isEnabled =
                    first.isNotEmpty() && second.isNotEmpty()
            }
        }
    }

    private fun showSnackBar(view: View, content: String) =
        Snackbar.make(view, content, Snackbar.LENGTH_LONG).setDuration(3000).show()
}