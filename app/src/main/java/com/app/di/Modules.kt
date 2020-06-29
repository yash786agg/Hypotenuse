package com.app.di

import com.app.domain.repository.HypotenuseRepository
import com.app.ui.HypotenuseVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

fun injectFeature() = loadFeature

private val loadFeature by lazy {
    loadKoinModules(
        listOf(viewModelModule,
            repositoryModule)
    )
}

val viewModelModule = module {
    viewModel { HypotenuseVM(hypotenuseRepository = get()) }
}

val repositoryModule = module {
    single { HypotenuseRepository() }
}