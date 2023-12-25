package com.project.movievault.utils

import android.util.Log

object DataBindingUtils {

    @JvmStatic
    fun removeTags(summary: String?): String {
        val list = summary?.split("<p>","</p>","<b>","</b>")
        var returnString = ""
        if (list != null) {
            for(s: String in list) {

                returnString += s
            }
        }

        return returnString
    }

    @JvmStatic
    fun listToStr(genres: List<String>?): String {
        var returnString = ""
        if (genres != null) {
            for(s: String in genres) {
                returnString += ("$s ")
            }
        }

        return "Genres: $returnString"
    }
}