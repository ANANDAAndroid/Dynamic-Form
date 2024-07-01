package com.clone.dynamicform.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clone.dynamicform.databinding.FragmentTabBinding
import com.clone.dynamicform.databinding.TextItemBinding

class TabFragment(private val text: String) : Fragment() {

    private lateinit var binding: FragmentTabBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentTabBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val view2=TextItemBinding.inflate(layoutInflater)
        view2.editText.setText(text)
        binding.linear.addView(view2.root)
    }
}