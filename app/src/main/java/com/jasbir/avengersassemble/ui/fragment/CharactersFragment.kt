package com.jasbir.avengersassemble.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.navGraphViewModels
import androidx.paging.map
import androidx.recyclerview.widget.GridLayoutManager
import com.jasbir.avengersassemble.R
import com.jasbir.avengersassemble.databinding.FragmentCharactersBinding
import com.jasbir.avengersassemble.ui.MarvelViewModel
import com.jasbir.avengersassemble.ui.adapter.CharacterAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharactersFragment : Fragment() {
    private val viewModel by hiltNavGraphViewModels<MarvelViewModel>(R.id.my_nav)
    lateinit var binding : FragmentCharactersBinding
    lateinit var characterAdapter : CharacterAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment\\
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_characters, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initEssentials()
        setRecyclerView()
        fetchCharactersLiveData()

    }

    private fun fetchCharactersLiveData() {
        lifecycleScope.launch {
            viewModel.fetchCharactersLiveData().collectLatest {
                characterAdapter.submitData(it)
            }
        }
    }

    /*private fun fetchCharactersLiveData() {
        viewModel.fetchCharactersLiveData().observe(viewLifecycleOwner, Observer {data ->
            lifecycleScope.launch {
                data.map {
                    it
                }
                characterAdapter.submitData(data)
            }
        })
    } */
    /*private fun fetchCharactersLiveData() {
        viewModel.fetchCharactersLiveData().observe(viewLifecycleOwner, Observer {data ->
            lifecycleScope.launch {
                data.map {
                    it
                }
                characterAdapter.submitData(data)
            }
        })
    }*/

    private fun setRecyclerView() {
        binding.rvCharacters.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvCharacters.adapter = characterAdapter
    }

    private fun initEssentials(){
        characterAdapter = CharacterAdapter()
    }

}