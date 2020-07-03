package com.example.loginassessment.login.presenter

interface ILoginPresenter {
    fun doClear()
    fun doLogin(username: String, password: String)
    fun setProgressBarVisibility(isVisible: Int)
}