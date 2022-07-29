package com.example.araction

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber
import timber.log.Timber.DebugTree
import tooz.bto.toozifier.Toozifier
import tooz.bto.toozifier.ToozifierFactory
import tooz.bto.toozifier.button.Button
import tooz.bto.toozifier.button.ButtonEventListener
import tooz.bto.toozifier.error.ErrorCause
import tooz.bto.toozifier.registration.RegistrationListener


class MainActivity : AppCompatActivity(), ButtonEventListener, RegistrationListener {

    private val toozifier:Toozifier = ToozifierFactory.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }

    override fun onResume() {
        super.onResume()
        tryToRegisterToozifier()
    }

    private fun tryToRegisterToozifier() {
        if (!toozifier.isRegistered) {
            toozifier.register(this, getString(R.string.app_name), this)
        }
    }

    //--- ButtonEventListener (toozifier)
    override fun onButtonEvent(button: Button) {
        Timber.i("Button pressed: ".plus(button.toString()))
        //initUi()
        //A1_S is the only button which works while this toozer-app is running
        //if (button == Button.A_1S) {
        //
        //}
    }
    //---

    //--- RegistrationListener (toozifier)
    override fun onDeregisterFailure(errorCause: ErrorCause) {
        Timber.e("Deregister failure")
        Timber.e(errorCause.code.toString().plus(errorCause.description))
    }

    override fun onDeregisterSuccess() {
        Timber.i("Deregister success")
    }

    override fun onRegisterFailure(errorCause: ErrorCause) {
        Timber.e("Register failure")
        Timber.e(errorCause.code.toString().plus(errorCause.description))
    }

    override fun onRegisterSuccess() {
        Timber.i("Register success")
    }
    //---

    private fun initUi() {
    }
}