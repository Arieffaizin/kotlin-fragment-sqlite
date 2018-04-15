package com.riefzin.android.learnkotlin05.api

import java.net.URL

// 4.API Repository to read URL
class ApiRepository {

    fun doRequest(url: String): String {
        return URL(url).readText()
    }
}