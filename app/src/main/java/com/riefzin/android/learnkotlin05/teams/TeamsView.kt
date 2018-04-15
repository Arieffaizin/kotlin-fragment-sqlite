package com.riefzin.android.learnkotlin05.teams

import com.riefzin.android.learnkotlin05.model.Team

// 9.Create View MVP
interface TeamsView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
}