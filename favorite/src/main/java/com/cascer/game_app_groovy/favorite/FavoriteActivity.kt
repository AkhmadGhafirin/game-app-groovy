package com.cascer.game_app_groovy.favorite

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.cascer.game_app_groovy.core.domain.model.Game
import com.cascer.game_app_groovy.core.ui.GameAdapter
import com.cascer.game_app_groovy.core.utils.gone
import com.cascer.game_app_groovy.core.utils.visible
import com.cascer.game_app_groovy.detail.DetailActivity
import com.cascer.game_app_groovy.di.FavoriteModuleDependencies
import com.cascer.game_app_groovy.favorite.databinding.ActivityFavoriteBinding
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class FavoriteActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelFactory

    private lateinit var binding: ActivityFavoriteBinding
    private val viewModel: FavoriteViewModel by viewModels { factory }
    private val gameAdapter by lazy { GameAdapter { toDetail(it) } }

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerFavoriteComponent.builder()
            .context(this)
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    applicationContext, FavoriteModuleDependencies::class.java
                )
            ).build()
            .inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
    }

    override fun onResume() {
        super.onResume()
        setupViewModel()
    }

    private fun setupView() {
        with(binding) {
            rvList.apply {
                layoutManager =
                    LinearLayoutManager(this@FavoriteActivity, LinearLayoutManager.VERTICAL, false)
                adapter = gameAdapter
            }
        }
    }

    private fun toDetail(game: Game) {
        startActivity(Intent(this, DetailActivity::class.java).apply {
            putExtra(DetailActivity.EXTRA_DATA, game)
        })
    }

    private fun setupViewModel() {
        with(viewModel) {
            favoriteGames.observe(this@FavoriteActivity) {
                if (it.isEmpty()) {
                    binding.tvEmpty.visible()
                    binding.rvList.gone()
                } else {
                    binding.tvEmpty.gone()
                    binding.rvList.visible()
                    gameAdapter.sendData(it)
                }
            }
        }
    }
}