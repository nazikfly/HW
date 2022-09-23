package com.geektech.lesson42

import android.widget.ImageView
import androidx.appcompat.view.menu.MenuView
import com.bumptech.glide.Glide

fun ImageView.loadImage(url:String){
    Glide.with(this).load(url).into(this)
}