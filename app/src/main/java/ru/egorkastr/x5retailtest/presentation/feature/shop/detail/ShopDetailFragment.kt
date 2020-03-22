package ru.egorkastr.x5retailtest.presentation.feature.shop.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_shop_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import ru.egorkastr.x5retailtest.R
import ru.egorkastr.x5retailtest.databinding.FragmentShopDetailBinding
import ru.egorkastr.x5retailtest.presentation.common.BaseFragment

/**
 * Fragment for show detail info for the shop
 */
class ShopDetailFragment : BaseFragment() {

    private val viewModel: ShopDetailViewModel by viewModel { parametersOf(args.shopId) }

    private val args: ShopDetailFragmentArgs by navArgs()

    private lateinit var binding: FragmentShopDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shop_detail, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        subscribeToShopDetail()
        subscribeToSpinner()
        subscripeToSnackbar()
    }

    private fun subscribeToShopDetail() {
        viewModel.shopDetail
            .observe(this, Observer { shopDetail ->
                binding.shopDetailEntity = shopDetail
            })
    }

    /**
     * Show the spinner when [ShopDetailViewModel.spinner] is true
     */
    private fun subscribeToSpinner() {
        viewModel.spinner.observe(this, Observer { value ->
            value.let { show ->
                spinner.visibility = if (show) View.VISIBLE else View.GONE
            }
        })
    }

    /**
     * Show a snackbar whenever the [ShopDetailViewModel.snackbar] is updated a non-null value
     */
    private fun subscripeToSnackbar() {
        viewModel.snackbar.observe(this, Observer { text ->
            text?.let {
                Snackbar.make(fragment_shop_detail, text, Snackbar.LENGTH_SHORT).show()
                viewModel.onSnackbarShown()
            }
        })
    }

}