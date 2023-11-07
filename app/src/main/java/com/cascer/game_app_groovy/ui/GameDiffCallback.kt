package com.cascer.game_app_groovy.ui

import androidx.recyclerview.widget.DiffUtil
import com.cascer.game_app_groovy.domain.model.Game

class GameDiffCallback(
    private val oldList: List<Game>,
    private val newList: List<Game>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }
}