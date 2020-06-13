package com.test.tap2visit.app.di.modules

import com.test.tap2visit.mvp.models.NetworkClient
import com.test.tap2visit.network.api.ApiInterface
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkClientModule {

    @Singleton
    @Provides
    fun provideNetworkClient(apiInterface: ApiInterface) = NetworkClient(api = apiInterface)
}