package com.example.weatherapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.R
import com.example.weatherapp.databinding.MainFragmentBinding
import com.example.weatherapp.model.CityInfo
import com.example.weatherapp.viewmodel.AppCondition
import com.example.weatherapp.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar

class MainFragment : Fragment() {

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel:MainViewModel
    private val adapter = MainFragmentAdapter(object : OnItemViewClickListener {
        override fun onItemClick(weather: CityInfo) {
            val manager = activity?.supportFragmentManager
            if (manager != null) {
                val bundle = Bundle()
                bundle.putParcelable(DetailsFragment.BUNDLE_EXTRA, weather)
                manager.beginTransaction()
                    .replace(R.id.container, DetailsFragment.newInstance(bundle))
                    .addToBackStack("")
                    .commit()
            }
        }
    })

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mainRecyclerView.adapter = adapter
        binding.mainFloatingButton.setOnClickListener { changeWeatherData() }
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getLiveData().observe(viewLifecycleOwner, Observer { getData(it) })
        viewModel.getWeatherFromLocalRus()
    }

    private var isDataSetRus: Boolean = true

    private fun changeWeatherData() {
        if (isDataSetRus) {
            viewModel.getWeatherFromLocalWorld()
        } else {
            viewModel.getWeatherFromLocalRus()
        }
        isDataSetRus = !isDataSetRus
    }

    private fun getData(state: AppCondition) {
        when(state) {
            is AppCondition.Success -> {
                binding.loadingView.visibility = View.GONE
                binding.mainRecyclerView.isVisible = true
                adapter.setWeather(state.weatherData)
            }
            is AppCondition.Loading -> {
                binding.loadingView.visibility = View.VISIBLE
                binding.mainRecyclerView.isVisible = false
            }
            is AppCondition.Error -> {
                Snackbar
                    .make(binding.mainFloatingButton, "Error", Snackbar.LENGTH_SHORT)
                    .setAction("Reload") {viewModel.getWeatherFromLocalRus()}
                    .show()
            }
        }
    }

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onDestroy() {
        adapter.removeListener()
        super.onDestroy()
    }
}

interface OnItemViewClickListener {
    fun onItemClick(weather: CityInfo)
}