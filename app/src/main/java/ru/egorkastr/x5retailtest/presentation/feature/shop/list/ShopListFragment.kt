package ru.egorkastr.x5retailtest.presentation.feature.shop.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_shop_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import ru.egorkastr.x5retailtest.R
import ru.egorkastr.x5retailtest.presentation.common.BaseFragment
import ru.egorkastr.x5retailtest.presentation.feature.shop.ShopListViewModel

/**
 * Fragment for show the list of shops
 */
class ShopListFragment : BaseFragment() {

    private val viewModel: ShopListViewModel by viewModel { parametersOf(this.activity) }

    private val adapter: ShopListAdapter by lazy {
        ShopListAdapter(onShopClick())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(
        R.layout.fragment_shop_list, container, false
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        shop_list_container.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            )
        )
        shop_list_container.setHasFixedSize(true)
        shop_list_container.adapter = adapter

        subscribeToShopList()
        subscribeToSpinner()
        subscripeToSnackbar()
    }

    private fun onShopClick() = { shopId: Int -> viewModel.showShopDetail(shopId) }

    private fun subscribeToShopList() {
        viewModel.shopList
            .observe(this, Observer { shopList ->
                    adapter.submitList(shopList)
            })
    }

    /**
     * Show the spinner when [ShopListViewModel.spinner] is true
     */
    private fun subscribeToSpinner() {
        viewModel.spinner.observe(this, Observer { value ->
            value.let { show ->
                spinner.visibility = if (show) View.VISIBLE else View.GONE
            }
        })
    }

    /**
     * Show a snackbar whenever the [ShopListViewModel.snackbar] is updated a non-null value
     */
    private fun subscripeToSnackbar() {
        viewModel.snackbar.observe(this, Observer { text ->
            text?.let {
                Snackbar.make(fragment_shop_list, text, Snackbar.LENGTH_SHORT).show()
                viewModel.onSnackbarShown()
            }
        })
    }

}