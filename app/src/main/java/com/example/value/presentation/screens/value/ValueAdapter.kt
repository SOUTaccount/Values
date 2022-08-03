package com.example.value.presentation.screens.value

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.example.value.R
import com.example.value.databinding.RecyclerviewFailBinding
import com.example.value.databinding.RecyclerviewProgressBinding
import com.example.value.databinding.RecyclerviewValuesBinding
import com.example.value.presentation.model.ValueUi

/**
 * Created by Vladimir Stebakov on 02.08.2022
 */
class ValueAdapter(
    private val onFavoriteClick: (value: ValueUi) -> Unit,
) : RecyclerView.Adapter<ValueAdapter.ValueViewHolder>() {

    private val listValues = arrayListOf<ValueUi>()

    fun updateAdapter(values: List<ValueUi>) {
        listValues.clear()
        listValues.addAll(values)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int) = when (listValues[position]) {
        is ValueUi.Base -> 1
        is ValueUi.Fail -> 2
        is ValueUi.Progress -> 3
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ValueViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            1 -> ValueViewHolder.Base(
                RecyclerviewValuesBinding.inflate(
                    layoutInflater,
                    parent,
                    false
                ), onFavoriteClick
            )
            2 -> ValueViewHolder.Fail(
                RecyclerviewFailBinding.inflate(
                    layoutInflater,
                    parent,
                    false
                )
            )
            else -> ValueViewHolder.FullScreenProgress(
                RecyclerviewProgressBinding.inflate(
                    layoutInflater,
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: ValueViewHolder, position: Int) {
        holder.bind(listValues[position])
    }

    override fun getItemCount() = listValues.size

    abstract class ValueViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(item: ValueUi)

        class Base(
            private val binding: RecyclerviewValuesBinding,
            private val onFavoriteClick: (value: ValueUi) -> Unit
        ) :
            ValueViewHolder(binding.root) {
            override fun bind(item: ValueUi) {
                item as ValueUi.Base
                with(binding) {
                    tvValueName.text = item.mapTitle()
                    tvValuePrice.text = item.mapValue()

                    ivFavoriteStar.setImageDrawable(
                        AppCompatResources.getDrawable(
                            itemView.context,
                            if (item.isFavorite()) R.drawable.icon_favorite else R.drawable.icon_not_favorite
                        )
                    )
                    ivFavoriteStar.setOnClickListener {
                        onFavoriteClick(item)
                    }
                }
            }
        }

        class Fail(private val binding: RecyclerviewFailBinding) : ValueViewHolder(binding.root) {
            override fun bind(item: ValueUi) {
                binding.tvFailText.text = item.mapTitle()
            }
        }

        class FullScreenProgress(private val binding: RecyclerviewProgressBinding) :
            ValueViewHolder(binding.root) {
            override fun bind(item: ValueUi) = Unit
        }
    }
}