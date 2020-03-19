package ru.egorkastr.x5retailtest.presentation.common

import androidx.appcompat.app.AppCompatActivity

/**
 * Base class for Activity
 */
abstract class BaseActivity : AppCompatActivity() {

    /**
     * Return id of the NavController
     */
    abstract fun getNavControllerId(): Int

}