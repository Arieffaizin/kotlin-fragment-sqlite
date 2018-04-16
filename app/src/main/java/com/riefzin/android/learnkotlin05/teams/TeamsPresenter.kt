package com.riefzin.android.learnkotlin05.teams

import com.google.gson.Gson
import com.riefzin.android.learnkotlin05.api.ApiRepository
import com.riefzin.android.learnkotlin05.api.TheSportDBApi
import com.riefzin.android.learnkotlin05.model.TeamResponse
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

// 10.Create Presenter MVP
class TeamsPresenter(
        private val view: TeamsView,
        private val apiRepository: ApiRepository,
        private val gson: Gson) {

    fun getTeamList(league: String?) {
        view.showLoading()

        // Added Anko Coroutines
        async(UI){
            val data = bg {
                gson.fromJson(apiRepository
                        .doRequest(TheSportDBApi.getTeams(league)),
                        TeamResponse::class.java)
            }
            view.showTeamList(data.await().teams)
            view.hideLoading()
        }
//        doAsync {
//            val data = gson.fromJson(apiRepository
//                    .doRequest(TheSportDBApi.getTeams(league)),
//                    TeamResponse::class.java
//            )
//
//            uiThread {
//                view.hideLoading()
//                view.showTeamList(data.teams)
//            }
//        }
    }
}