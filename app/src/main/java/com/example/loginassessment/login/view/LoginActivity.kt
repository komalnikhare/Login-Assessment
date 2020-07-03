package com.example.loginassessment.login.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.loginassessment.R
import com.example.loginassessment.dashboard.MainActivity
import com.example.loginassessment.login.presenter.ILoginPresenter
import com.example.loginassessment.login.presenter.LoginPresenterCompl
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), ILoginView{

    lateinit var loginPresenter: ILoginPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginPresenter = LoginPresenterCompl(this)
        loginPresenter.setProgressBarVisibility(View.INVISIBLE)

        btnLogin.setOnClickListener {
            loginPresenter.setProgressBarVisibility(View.VISIBLE)
            btnLogin.isEnabled = false
            btnClear.isEnabled = false
            loginPresenter.doLogin(edUserName.text.toString(), edPassword.text.toString())
        }
        btnClear.setOnClickListener {
            loginPresenter.doClear()
        }

    }

    override fun onClearField() {
        edUserName.setText("")
        edPassword.setText("")
    }

    override fun onLoginResult(result: Boolean, resultCode: Int) {
        loginPresenter.setProgressBarVisibility(View.INVISIBLE)
        btnLogin.isEnabled = true
        btnClear.isEnabled = true
        if (result){
            //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, MainActivity::class.java).apply {
                putExtra("statusCode", resultCode)
                putExtra("userName", edUserName.text.toString())
            })
        }else{
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_LONG).show()

        }
    }

    override fun onSetProgressBarVisibility(isVisible: Int) {
        progressBar.visibility = isVisible
    }
}