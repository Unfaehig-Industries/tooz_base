package com.example.araction

// tooz imports
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
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
        //Log.d("AR Action", "Button pressed: ".plus(button.toString()))
        //initUi()
        //A1_S is the only button which works while this toozer-app is running!!!
        //if (button == Button.A_1S) {
            //
        //}
    }
    //---

    //--- RegistrationListener (toozifier)
    override fun onDeregisterFailure(errorCause: ErrorCause) {
        Log.d("AR Action", "Deregister failure")
        Log.d("AR Action", errorCause.code.toString().plus(errorCause.description))
    }

    override fun onDeregisterSuccess() {
        Log.d("AR Action", "Deregister success")
    }

    override fun onRegisterFailure(errorCause: ErrorCause) {
        Log.d("AR Action", "Register failure")
        Log.d("AR Action", errorCause.code.toString().plus(errorCause.description))
    }

    override fun onRegisterSuccess() {
        Log.d("AR Action", "Register success")
    }
    //---

    private fun initUi() {
        setContentView(R.layout.activity_main2)
    }
}