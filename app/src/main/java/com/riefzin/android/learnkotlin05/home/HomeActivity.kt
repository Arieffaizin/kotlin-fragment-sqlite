package com.riefzin.android.learnkotlin05.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.riefzin.android.learnkotlin05.R
import com.riefzin.android.learnkotlin05.R.id.favorites
import com.riefzin.android.learnkotlin05.R.id.teams
import com.riefzin.android.learnkotlin05.teams.TeamsFragment
import com.riefzin.android.learnkotlin05.favorites.FavoriteTeamsFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // 23.Implement Bottom Nav View
        bottom_navigation.setOnNavigationItemSelectedListener({ item ->
            when (item.itemId){
                teams -> {
                    loadTeamsFragment(savedInstanceState)
                }
                favorites -> {
                    loadFavoritesFragment(savedInstanceState)
                }
            }
            true
        })
        bottom_navigation.selectedItemId = teams
    }

    // 26.Implement Fragment
    private fun loadTeamsFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_container, TeamsFragment(), TeamsFragment::class.simpleName)
                    .commit()
        }
    }

    private fun loadFavoritesFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_container, FavoriteTeamsFragment(), FavoriteTeamsFragment::class.simpleName)
                    .commit()
        }
    }
}
