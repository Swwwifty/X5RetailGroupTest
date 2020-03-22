package ru.egorkastr.x5retailtest.presentation.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.egorkastr.x5retailtest.data.repository.ShopRepositoryImpl
import ru.egorkastr.x5retailtest.domain.repository.ShopRepository
import ru.egorkastr.x5retailtest.domain.usecase.ShopInteractor
import ru.egorkastr.x5retailtest.domain.usecase.ShopInteractorImpl
import ru.egorkastr.x5retailtest.presentation.feature.shop.detail.ShopDetailViewModel
import ru.egorkastr.x5retailtest.presentation.feature.shop.list.ShopListViewModel

/**
 * Module for DI in shop feature
 */
val shopModule = module {

    viewModel {
        ShopListViewModel(
            get()
        )
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