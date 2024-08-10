package com.mvparchitecture.di

import com.mvparchitecture.presenter.UserContract
import com.mvparchitecture.view.MainActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped


@Module
@InstallIn(ActivityComponent::class)
object ContractViewModule {

    @Provides
    @ActivityScoped
    fun provideUserView(mainActivity: MainActivity): UserContract.View {
        return mainActivity
    }

}