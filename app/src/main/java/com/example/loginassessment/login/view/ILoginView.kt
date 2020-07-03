package com.example.loginassessment.login.view

interface ILoginView {
    fun onClearField()
    fun onLoginResult(result: Boolean, resultCode: Int)
    fun onSetProgressBarVisibility(isVisible: Int)
}