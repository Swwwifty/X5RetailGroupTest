package ru.egorkastr.x5retailtest.presentation

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import ru.egorkastr.x5retailtest.R
import ru.egorkastr.x5retailtest.presentation.common.BaseActivity

/**
 * Main Activity class for the application
 */
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupActionBarWithNavController(findNavController(R.id.nav_host_fragment))
    }

}
