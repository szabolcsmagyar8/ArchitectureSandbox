package com.unidevoes.szabisandbox.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.unidevoes.szabisandbox.viewmodel.HomeViewModel
import com.unidevoes.szabisandbox.adapter.QuoteAdapter
import com.unidevoes.szabisandbox.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val viewModel: HomeViewModel by viewModels()

    private val binding get() = _binding!!
    private lateinit var adapter: QuoteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        initView()
        initViewModel()

        return binding.root
    }

    private fun initView() {
        adapter = QuoteAdapter()
        val mLayoutManager = LinearLayoutManager(context)
        binding.quotesRecycler.layoutManager = mLayoutManager
        binding.quotesRecycler.adapter = adapter

        adapter.notifyItemChanged(0)

        binding.button.setOnClickListener {
            viewModel.getEmployees()
        }
    }

    private fun initViewModel() {
        viewModel.employees.observe(viewLifecycleOwner) {
            binding.textView.text = getRandomString(30).uppercase()
        }
        viewModel.quotes.observe(viewLifecycleOwner) {
            adapter.submitList(it.toList())
        }
    }

    private fun getRandomString(length: Int) : String {
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        return (1..length)
            .map { allowedChars.random() }
            .joinToString("")
    }
}