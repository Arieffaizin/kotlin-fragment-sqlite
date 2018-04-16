package com.riefzin.android.learnkotlin05.detail

import com.google.gson.Gson
import com.riefzin.android.learnkotlin05.api.ApiRepository
import com.riefzin.android.learnkotlin05.api.TheSportDBApi
import com.riefzin.android.learnkotlin05.model.TeamResponse
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

class TeamDetailPresenter(private val view: TeamDetailView,
                          private val apiRepository: ApiRepository,
                          private val gson: Gson) {

    fun getTeamDetail(teamId: String) {
        view.showLoading()

        // Added Anko Coroutines
        async(UI){
            val data = bg{
                gson.fromJson(apiRepository
                        .doRequest(TheSportDBApi.getTeamDetail(teamId)),
                        TeamResponse::class.java)
            }
            view.showTeamDetail(data.await().teams)
            view.hideLoading()
        }
//        doAsync{
//            val data = gson.fromJson(apiRepository
//                    .doRequest(TheSportDBApi.getTeamDetail(teamId)),
//                    TeamResponse::class.java
//            )
//
//            uiThread {
//                view.hideLoading()
//                view.showTeamDetail(data.teams)
//            }
//        }
    }
}