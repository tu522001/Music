package com.example.music.back

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.music.R
import com.example.music.databinding.FragmentMediaPlaybackBinding

class MediaPlaybackFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding : FragmentMediaPlaybackBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_media_playback,container,false)
        return binding.root
    }
}