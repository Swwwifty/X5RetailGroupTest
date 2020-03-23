package ru.egorkastr.x5retailtest.presentation.feature.shop.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.egorkastr.x5retailtest.domain.entity.ShopEntity
import ru.egorkastr.x5retailtest.domain.usecase.ShopInteractor

/**
 * ViewModel for shop list
 */
class ShopListViewModel(
    private val shopInteractor: ShopInteractor
) : ViewModel() {

    private val _shopList: MutableLiveData<List<ShopEntity>> by lazy {
        MutableLiveData<List<ShopEntity>>().also {
            loadShopList()
        }
    }

    private val _spinner = MutableLiveData<Boolean>(false)

    private val _snackBar = MutableLiveData<String?>()

    private fun loadShopList() = launchDataLoad {
        val result = shopInteractor.getShopList()
        if (result.isSuccess) {
            _shopList.value = result.getOrNull() ?: listOf()
        } else {
            _shopList.value = listOf()
            _snackBar.value = "Unable to refresh shop list"
        }
    }

    /**
     * Request list of the shops
     */
    val shopList: LiveData<List<ShopEntity>>
        get() = _shopList

    /**
     * Show a loading spinner if true
     */
    val spinner: LiveData<Boolean>
        get() = _spinner

    /**
     * Request a snackbar to display a string.
     */
    val snackbar: LiveData<String?>
        get() = _snackBar

    /**
     * Called immediately after the UI shows the snackbar.
     */
    fun onSnackbarShown() {
        _snackBar.value = null
    }

    /**
     * Helper function to call a data load function with a loading spinner, errors will trigger a
     * snackbar.
     *
     * @param block lambda to actually load data. It is called in the viewModelScope. Before calling the
     *              lambda the loading spinner will display, after completion or error the loading
     *              spinner will stop
     */
    private fun launchDataLoad(block: suspend () -> Unit) {
        viewModelScope.launch {
            repeat(Int.MAX_VALUE) {
                try {
                    _spinner.value = true
                    block()
                } catch (error: Throwable) {
                    _snackBar.value = error.message
                } finally {
                    _spinner.value = false
                    delay(30000)
                }
            }
        }
    }

}