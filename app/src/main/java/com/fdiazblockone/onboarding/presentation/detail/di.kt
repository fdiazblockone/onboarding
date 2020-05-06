package com.fdiazblockone.onboarding.presentation.detail

import com.fdiazblockone.onboarding.data.repositories.ListRepository
import com.fdiazblockone.onboarding.interactors.GetBlockById
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Module
class DetailFragmentModule(private val blockId: String) {

    @Provides
    fun detailViewModelProvider(getBlockById: GetBlockById): DetailViewModel {
        return DetailViewModel(blockId, getBlockById)
    }

    @Provides
    fun getBlockByIdProvider(listRepository: ListRepository) = GetBlockById(listRepository)

}

@Subcomponent(modules = [(DetailFragmentModule::class)])
interface DetailFragmentComponent {
    val detailViewModel: DetailViewModel
}