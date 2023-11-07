package com.cascer.game_app_groovy.core.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.cascer.game_app_groovy.core.R
import com.cascer.game_app_groovy.core.databinding.ViewGameBinding
import com.cascer.game_app_groovy.core.domain.model.Game
import com.cascer.game_app_groovy.core.utils.ImageUtils.load

class GameAdapter(
    private val listener: (game: Game) -> Unit
) : RecyclerView.Adapter<GameAdapter.GameViewHolder>() {

    private var listItem = mutableListOf<Game>()

    fun sendData(data: List<Game>) {
        val diffCallback = GameDiffCallback(listItem, data)
        val diffGame = DiffUtil.calculateDiff(diffCallback)
        listItem.clear()
        listItem.addAll(data)
        diffGame.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        return GameViewHolder(
            ViewGameBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int = listItem.size

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        listItem[position].let { holder.bind(it) }
    }

    inner class GameViewHolder(private val binding: ViewGameBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                listener.invoke(listItem[adapterPosition])
            }
        }

        fun bind(item: Game) {
            with(binding) {
                tvTitle.text = item.name
                ivGame.load(binding.root.context, item.backgroundImage)
                tvEsrbRating.text = item.esrbRating.name
                tvRating.text = binding.root.context.getString(
                    R.string.rating_game,
                    "${item.rating}",
                    "${item.ratingsCount}"
                )
            }
        }
    }
}