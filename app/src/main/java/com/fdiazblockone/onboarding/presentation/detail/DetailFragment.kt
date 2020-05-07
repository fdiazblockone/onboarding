package com.fdiazblockone.onboarding.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.fdiazblockone.onboarding.MyApplication
import com.fdiazblockone.onboarding.R
import com.fdiazblockone.onboarding.databinding.FragmentDetailBinding
import com.fdiazblockone.onboarding.presentation.getViewModel

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    private lateinit var component: DetailFragmentComponent
    private val viewModel by lazy { getViewModel { component.detailViewModel } }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_detail,
            container,
            false
        )

        val blockId = arguments?.let { blockId ->
            DetailFragmentArgs.fromBundle(blockId).id
        }

        val c = activity?.applicationContext as MyApplication
        component = c.component.plus(DetailFragmentModule(blockId!!))

        binding.detailViewModel = viewModel


        return binding.root
    }

}
