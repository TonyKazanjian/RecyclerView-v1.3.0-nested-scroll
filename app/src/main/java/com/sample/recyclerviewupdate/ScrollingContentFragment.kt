package com.sample.recyclerviewupdate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.sample.recyclerviewupdate.databinding.FragmentScrollingContentBinding

class ScrollingContentFragment: Fragment() {

    private lateinit var binding: FragmentScrollingContentBinding
    private val adapter = ContentAdapter()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScrollingContentBinding.inflate(inflater)
        binding.recyclerView?.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerView?.adapter = adapter

        return binding.root
    }
}

