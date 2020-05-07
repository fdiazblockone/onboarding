package com.fdiazblockone.onboarding.presentation.list

import com.fdiazblockone.onboarding.data.repositories.ListRepository
import com.fdiazblockone.onboarding.interactors.GetBlocks
import com.fdiazblockone.onboarding.interactors.GetInfo
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Module
class ListFragmentModule {

    @Provides
    fun listViewModelProvider(getInfo: GetInfo, getBlocks: GetBlocks) =
        ListViewModel(getInfo, getBlocks)

    @Provides
    fun getInfoProvider(listRepository: ListRepository) = GetInfo(listRepository)

    @Provides
    fun getBlocksProvider(listRepository: ListRepository) = GetBlocks(listRepository)
}

@Subcomponent(modules = [(ListFragmentModule::class)])
interface ListFragmentComponent {
    val listViewModel: ListViewModel
}