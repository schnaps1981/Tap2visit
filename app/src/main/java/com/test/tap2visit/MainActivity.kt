package com.test.tap2visit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.test.tap2visit.app.App
import com.test.tap2visit.ui.fragments.NewsDetailFragment
import com.test.tap2visit.ui.navigation.Screens
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject lateinit var navigatorHolder: NavigatorHolder
    @Inject lateinit var router: Router
    private val navigator: Navigator = SupportAppNavigator(this, supportFragmentManager, R.id.fl_mainframe)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        App.instance.inject(this)

        router.replaceScreen(Screens.NewsListNav())
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {

        val currentFragment = supportFragmentManager.findFragmentById(R.id.fl_mainframe)
        if (currentFragment is NewsDetailFragment) {
            router.backTo(Screens.NewsListNav())
        } else super.onBackPressed()

    }
}