package com.fdiazblockone.onboarding.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.fdiazblockone.onboarding.databinding.BlockListItemBinding
import com.fdiazblockone.onboarding.domain.Block

class BlockListAdapter(private val clickListener: BlockListListener) :
    ListAdapter<Block, BlockListAdapter.ViewHolder>(BlockDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), clickListener)
    }

    class ViewHolder private constructor(private val binding: BlockListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            item: Block,
            clickListener: BlockListListener
        ) {
            binding.block = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = BlockListItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class BlockDiffCallback : DiffUtil.ItemCallback<Block>() {
    override fun areItemsTheSame(oldItem: Block, newItem: Block): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Block, newItem: Block): Boolean {
        return oldItem == newItem
    }
}

class BlockListListener(val clickListener: (id: String) -> Unit) {
    fun onClick(block: Block) = clickListener(block.id)
}
