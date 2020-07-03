package com.example.loginassessment.login.model

interface IUser {
    fun getUserName(): String
    fun getPassword(): String
    fun checkUserValidity(userName: String, password: String): Int
}