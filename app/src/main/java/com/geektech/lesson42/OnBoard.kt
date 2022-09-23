package com.geektech.lesson42

import android.media.Image
import java.io.Serializable

data class OnBoard (
    var image: String?=null,
    var title: String?=null,
    var description:String?=null,
):Serializable