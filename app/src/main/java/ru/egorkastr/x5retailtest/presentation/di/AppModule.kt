package ru.egorkastr.x5retailtest.presentation.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module
import ru.egorkastr.x5retailtest.data.repository.ShopRepositoryImpl
import ru.egorkastr.x5retailtest.domain.repository.ShopRepository
import ru.egorkastr.x5retailtest.domain.usecase.ShopInteractor
import ru.egorkastr.x5retailtest.domain.usecase.ShopInteractorImpl
import ru.egorkastr.x5retailtest.presentation.common.BaseActivity
import ru.egorkastr.x5retailtest.presentation.feature.shop.ShopRouter
import ru.egorkastr.x5retailtest.presentation.feature.shop.ShopRouterImpl
import ru.egorkastr.x5retailtest.presentation.feature.shop.detail.ShopDetailViewModel
import ru.egorkastr.x5retailtest.presentation.feature.shop.list.ShopListViewModel

/**
 * Module for DI in shop feature
 */
val shopModule = module {

    factory<ShopRouter> { (view: BaseActivity) -> ShopRouterImpl(view) }

    viewModel { (view: BaseActivity) ->
        ShopListViewModel(
            get(),
            get { parametersOf(view) })
    }

    viewModel { (shopId: Int) ->
        ShopDetailViewModel(
            get(),
            shopId
        )
    }

    factory<ShopInteractor> { ShopInteractorImpl(get()) }

}

val shopDataModule = module {

    single<ShopRepository> { ShopRepositoryImpl() }

}