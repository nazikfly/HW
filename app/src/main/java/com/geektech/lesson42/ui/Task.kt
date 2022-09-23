package com.geektech.lesson42.ui

import android.accounts.AuthenticatorDescription
import java.io.Serializable

data class Task(
    var title:String,
    var description:String
    ):Serializable
