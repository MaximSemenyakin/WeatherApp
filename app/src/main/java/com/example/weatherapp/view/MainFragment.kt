package com.example.weatherapp.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.weatherapp.R
import com.example.weatherapp.databinding.MainFragmentBinding
import com.example.weatherapp.viewmodel.AppCondition
import com.example.weatherapp.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private var _binding:MainFragmentBinding? = null

    private val binding get() = _binding!!

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        val observer = Observer<AppCondition> { state ->
            getData(state)
        }
        viewModel.getLiveData().observe(viewLifecycleOwner, observer)
        viewModel.getWeather()
    }

    private fun getData(state: AppCondition) {
        when(state) {
            is AppCondition.Success -> {
                binding.mainView.isVisible = true
                binding.loadingView.visibility = View.GONE
                binding.cityWeather.text = state.weatherData.name
                binding.temperatureWeather.text = state.weatherData.temperature.toString()
            }
            is AppCondition.Loading -> {
                binding.loadingView.isVisible = true
                binding.mainView.isVisible = false
            }
            is AppCondition.Error -> {
                Snackbar
                    .make(binding.root, "Error", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Refresh") {viewModel.getWeather()}
                    .show()
            }
        }
    }

}