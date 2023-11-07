package com.cascer.game_app_groovy.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.cascer.game_app_groovy.core.data.Resource
import com.cascer.game_app_groovy.core.domain.model.Game
import com.cascer.game_app_groovy.core.ui.GameAdapter
import com.cascer.game_app_groovy.core.utils.gone
import com.cascer.game_app_groovy.core.utils.visible
import com.cascer.game_app_groovy.databinding.FragmentHomeBinding
import com.cascer.game_app_groovy.detail.DetailActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private val gameAdapter by lazy { GameAdapter { toDetail(it) } }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                adapter = gameAdapter
            }
        }
    }

    private fun toDetail(game: Game) {
        startActivity(Intent(requireContext(), DetailActivity::class.java).apply {
            putExtra(DetailActivity.EXTRA_DATA, game)
        })
    }

    private fun setupViewModel() {
        with(viewModel) {
            games.observe(viewLifecycleOwner) {
                if (it != null) {
                    when (it) {
                        is Resource.Success -> {
                            binding.progressbar.gone()
                            it.data?.let { data ->
                                if (data.isEmpty()) {
                                    binding.emptyView.root.visible()
                                    binding.rvList.gone()
                                } else {
                                    binding.emptyView.root.gone()
                                    binding.rvList.visible()
                                    gameAdapter.sendData(data)
                                }
                            }
                        }

                        is Resource.Error -> {
                            binding.progressbar.gone()
                            Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
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