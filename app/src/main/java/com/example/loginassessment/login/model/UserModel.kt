package com.example.loginassessment.login.model

import android.text.TextUtils
import android.text.TextUtils.*

data class UserModel(
    private var userName: String,
    private var password: String
): IUser {
    override fun getUserName(): String {
        return userName
    }

    override fun getPassword(): String {
        return password
    }

    override fun checkUserValidity(username: String, password: String): Int {
        return  if(isEmpty(username)){
            -1
            //mView.showError("Please enter username");
        }else if(username.length < 5){
            -1
            //mView.showError("Username must contains 6 letters");
        }else if(isEmpty(password)){
            -1
            //mView.showError("Please enter password");
        }else if(password.length < 5){
            -1
            //mView.showError("Password must contains 6 letters");
        }else {
            0
           /* mDatabase.setUserLogin(true);
            mView.showMainActivity();*/
        }
    }

}