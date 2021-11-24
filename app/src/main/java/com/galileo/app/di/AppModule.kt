package com.galileo.app.di

import com.galileo.app.repo.CowboyWisdomRepo
import com.galileo.app.repo.CowboyWisdomRepoImpl
import com.galileo.app.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    // single instance of HelloRepository
    single<CowboyWisdomRepo> { CowboyWisdomRepoImpl() }

    // Simple Presenter Factory
    viewModel { MainViewModel(get()) }
}