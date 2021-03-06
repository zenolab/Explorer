package com.online_viewer_mo_apps.zenolab.explorer

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.online_viewer_mo_apps.zenolab.explorer.presentation.file.FileFragment
import com.online_viewer_mo_apps.zenolab.explorer.presentation.group.GroupFragment
import com.online_viewer_mo_apps.zenolab.explorer.presentation.root.RootFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().
               add(R.id.fragment, RootFragment(), "Root").commit()

        }
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
                replaceView(0)
            }
            R.id.nav_gallery -> {
                replaceView(1)
            }
            R.id.nav_slideshow -> {
                replaceView(2)
            }
            R.id.nav_manage -> {
                replaceView(0)
            }
            R.id.nav_share -> {
                replaceView(1)
            }
            R.id.nav_send -> {
                replaceView(2)
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onStart() {
        super.onStart()
        print("onStart")
    }

    override fun onResume() {
        super.onResume()
        print("onResume")
    }

    override fun onPause() {
        super.onPause()
        print("onPause")
    }

    override fun onStop() {
        super.onStop()
        print("onStop")
    }

    override fun onRestart() {
        super.onRestart()
        print("onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        print("onDestroy")
    }

    fun print(msg: String){
        Log.d("Activity State ",msg)
    }

    private fun replaceView(value: Int): Unit {
        if (value == 0) {
            supportFragmentManager.beginTransaction().replace(
                R.id.fragment,
                RootFragment(), "Replace"
            ).commit()
        }
        if (value == 1) {
            supportFragmentManager.beginTransaction().replace(
                R.id.fragment,
                GroupFragment(), "Replace"
            ).commit()

        }
        if (value == 2) {
            supportFragmentManager.beginTransaction().replace(
                R.id.fragment,
                FileFragment(), "Replace"
            ).commit()

        }
    }
}
