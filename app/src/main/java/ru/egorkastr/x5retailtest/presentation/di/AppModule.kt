package ru.egorkastr.x5retailtest.presentation.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module
import ru.egorkastr.x5retailtest.data.repository.ShopRepositoryImpl
import ru.egorkastr.x5retailtest.domain.repository.ShopRepository
import ru.egorkastr.x5retailtest.domain.usecase.ShopListInteractor
import ru.egorkastr.x5retailtest.domain.usecase.ShopListInteractorImpl
import ru.egorkastr.x5retailtest.presentation.common.BaseActivity
import ru.egorkastr.x5retailtest.presentation.feature.shop.ShopListViewModel
import ru.egorkastr.x5retailtest.presentation.feature.shop.ShopRouter
import ru.egorkastr.x5retailtest.presentation.feature.shop.ShopRouterImpl

/**
 * Module for DI in shop feature
 */
val shopModule = module {

    factory<ShopRouter> { (view: BaseActivity) -> ShopRouterImpl(view) }

    viewModel { (view: BaseActivity) -> ShopListViewModel(get(), get { parametersOf(view) }) }

    factory<ShopListInteractor> { ShopListInteractorImpl(get()) }

}

val shopDataModule = module {

    single<ShopRepository> { ShopRepositoryImpl() }

}