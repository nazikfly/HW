package com.geektech.lesson42.data

import android.app.backup.SharedPreferencesBackupHelper
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

class Preference(private val context: Context) {
    private lateinit var preference: SharedPreferences

    init {
        preference=context.getSharedPreferences("simple_data", MODE_PRIVATE)
    }

    fun getIsShowBoarding():Boolean{
        return preference.getBoolean("is_show",false)
    }
    fun showBoarding(isShow:Boolean){
        preference.edit().putBoolean("is_show",isShow).apply()
    }
   fun setProfileImage(url:String){
       preference.edit().putString("profile_image","").apply()
   }
    fun getProfileImage():String=preference.getString("profile_image","").toString()
}


