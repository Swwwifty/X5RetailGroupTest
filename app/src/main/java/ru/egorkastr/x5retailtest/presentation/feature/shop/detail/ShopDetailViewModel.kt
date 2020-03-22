package ru.egorkastr.x5retailtest.presentation.feature.shop.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.egorkastr.x5retailtest.domain.entity.ShopDetailEntity
import ru.egorkastr.x5retailtest.domain.usecase.ShopInteractor

/**
 * ViewModel for shop detail info
 */
class ShopDetailViewModel(
    private val shopInteractor: ShopInteractor,
    private val shopId: Int
) : ViewModel() {

    private val _shopDetail: MutableLiveData<ShopDetailEntity> by lazy {
        MutableLiveData<ShopDetailEntity>().also {
            loadShopDetail(shopId)
        }
    }

    private val _spinner = MutableLiveData<Boolean>(false)

    private val _snackBar = MutableLiveData<String?>()

    private fun loadShopDetail(shopId: Int) = launchDataLoad {
        val result = shopInteractor.getShopDetail(shopId)
        if (result.isSuccess) {
            _shopDetail.value = result.getOrNull()
        } else {
            _shopDetail.value = null
            _snackBar.value = "Unable to get detail information for shop with id $shopId"
        }
    }

    /**
     * Request list of the shops
     */
    val shopDetail: LiveData<ShopDetailEntity>
        get() = _shopDetail

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
            try {
                _spinner.value = true
                block()
            } catch (error: Throwable) {
                _snackBar.value = error.message
            } finally {
                _spinner.value = false
            }
        }
    }

}