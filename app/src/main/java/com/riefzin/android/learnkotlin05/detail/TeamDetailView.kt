package com.riefzin.android.learnkotlin05.detail

import com.riefzin.android.learnkotlin05.model.Team

interface TeamDetailView {
    fun showLoading()
    fun hideLoading()
    fun showTeamDetail(data: List<Team>)
}