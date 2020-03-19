package ru.egorkastr.x5retailtest.presentation.common

import androidx.fragment.app.Fragment

/**
 * Base class for fragments
 */
abstract class BaseFragment : Fragment() {

    /**
     * show loader while data is loading
     */
    protected fun showLoading() = {}

    /**
     * hide loader
     */
    protected fun hideLoading() = {}

}