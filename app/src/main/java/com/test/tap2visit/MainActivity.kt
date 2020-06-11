package com.test.tap2visit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.test.tap2visit.app.App
import com.test.tap2visit.mvp.models.RecieveNews
import com.test.tap2visit.navigation.Screens
import com.test.tap2visit.network.entity.Categories
import kotlinx.android.synthetic.main.activity_main.*
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private val reciver = RecieveNews()

    @Inject
    lateinit var navigatorHolder: NavigatorHolder
    @Inject
    lateinit var router: Router
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

}