package com.cascer.game_app_groovy.home

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.cascer.game_app_groovy.R
import com.cascer.game_app_groovy.core.data.Resource
import com.cascer.game_app_groovy.core.domain.model.Game
import com.cascer.game_app_groovy.core.ui.GameAdapter
import com.cascer.game_app_groovy.core.utils.gone
import com.cascer.game_app_groovy.core.utils.visible
import com.cascer.game_app_groovy.databinding.ActivityHomeBinding
import com.cascer.game_app_groovy.detail.DetailActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private val gameAdapter by lazy { GameAdapter { toDetail(it) } }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
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
                    LinearLayoutManager(this@HomeActivity, LinearLayoutManager.VERTICAL, false)
                adapter = gameAdapter
            }

            toolbar.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.favorites -> {
                        startActivity(
                            Intent(
                                this@HomeActivity,
                                Class.forName("com.cascer.game_app_groovy.favorite.FavoriteActivity")
                            )
                        )
                        true
                    }

                    else -> {
                        false
                    }
                }
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
            games.observe(this@HomeActivity) {
                if (it != null) {
                    when (it) {
                        is Resource.Success -> {
                            binding.progressbar.gone()
                            it.data?.let { data ->
                                if (data.isEmpty()) {
                                    binding.tvEmpty.visible()
                                    binding.rvList.gone()
                                } else {
                                    binding.tvEmpty.gone()
                                    binding.rvList.visible()
                                    gameAdapter.sendData(data)
                                }
                            }
                        }

                        is Resource.Error -> {
                            binding.progressbar.gone()
                            android.widget.Toast.makeText(
                                this@HomeActivity,
                                it.message,
                                android.widget.Toast.LENGTH_SHORT
                            ).show()
                        }

                        is Resource.Loading -> {
                            binding.progressbar.visible()
                        }
                    }
                }
            }
        }
    }
}