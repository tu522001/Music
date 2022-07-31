package com.example.music.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.music.R
import com.example.music.databinding.FragmentAllSongsBinding


class AllSongsFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentAllSongsBinding>(
            inflater,
            R.layout.fragment_all_songs,
            container,
            false
        )
       binding.tool.setOnClickListener{view : View ->
           Toast.makeText(getActivity(), "AAAAA", Toast.LENGTH_LONG).show();

       }


        return binding.root
    }
}