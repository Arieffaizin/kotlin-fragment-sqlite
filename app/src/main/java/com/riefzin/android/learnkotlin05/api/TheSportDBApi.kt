package com.riefzin.android.learnkotlin05.api

import com.riefzin.android.learnkotlin05.BuildConfig

// 5.Create API Access Route
object TheSportDBApi {
    fun getTeams(league: String?) : String {
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/search_all_teams.php?l=" + league
    }

    fun getTeamDetail(teamId: String?): String{
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/lookupteam.php?id=" + teamId
    }
}