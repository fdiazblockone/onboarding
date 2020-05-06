package com.fdiazblockone.onboarding.presentation.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.fdiazblockone.onboarding.MyApplication
import com.fdiazblockone.onboarding.R
import com.fdiazblockone.onboarding.databinding.FragmentListBinding
import com.fdiazblockone.onboarding.presentation.getViewModel

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    private lateinit var component: ListFragmentComponent
    private val viewModel: ListViewModel by lazy { getViewModel { component.listViewModel } }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_list,
            container,
            false
        )

        val c = activity?.applicationContext as MyApplication
        component = c.component.plus(ListFragmentModule())
        binding.listViewModel = viewModel

        val adapter = BlockListAdapter(BlockListListener {
            it?.let {
                this.findNavController().navigate(ListFragmentDirections.actionListToDetail(it))
            }
        })

        binding.recyclerView.adapter = adapter

        viewModel.myString.observe(viewLifecycleOwner, Observer {
            it?.let {
                binding.getInfoButton.isEnabled = true
            }
        })

        viewModel.blockList.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        return binding.root
    }
}
