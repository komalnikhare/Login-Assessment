package com.example.loginassessment.login.presenter

import android.os.Handler
import android.os.Looper
import com.example.loginassessment.login.model.IUser
import com.example.loginassessment.login.model.UserModel
import com.example.loginassessment.login.view.ILoginView

class LoginPresenterCompl(val iLoginView: ILoginView) : ILoginPresenter {
    private val user: IUser = UserModel("user1", "user1")
    private val handler: Handler = Handler(Looper.getMainLooper())

    override fun doClear() {
        iLoginView.onClearField()
    }

    override fun doLogin(username: String, password: String) {
        var isLoginSuccess = true
        var code = user.checkUserValidity(username, password)
        if (code < 0) isLoginSuccess = false
        else if (username == user.getUserName() && password == user.getPassword())
            code = 0
        else
            code = 1

        handler.postDelayed({
            iLoginView.onLoginResult(isLoginSuccess, code)
        }, 2000)
    }

    override fun setProgressBarVisibility(isVisible: Int) {
        iLoginView.onSetProgressBarVisibility(isVisible)
    }
}