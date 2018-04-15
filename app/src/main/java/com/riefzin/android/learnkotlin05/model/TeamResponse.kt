package com.riefzin.android.learnkotlin05.model

import com.riefzin.android.learnkotlin05.model.Team

// 8.Create Parent Data Class (POJO)
data class TeamResponse(
        val teams: List<Team>
)