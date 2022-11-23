package com.lavsii.noteskotlin.screens.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.lavsii.noteskotlin.R
import com.lavsii.noteskotlin.databinding.FragmentMainBinding
import com.lavsii.noteskotlin.databinding.FragmentNoteBinding
import com.lavsii.noteskotlin.models.AppNote
import com.lavsii.noteskotlin.models.MainFragmentViewModel
import com.lavsii.noteskotlin.screens.main.MainAdapter
import com.lavsii.noteskotlin.utilits.APP_ACTIVITY
import java.io.Serializable

class NoteFragment : Fragment() {

    private var _binding: FragmentNoteBinding? = null
    private val binding get() = _binding!!
    private lateinit var mViewModel: NoteFragmentViewModel
    private lateinit var mCurrentNote: AppNote

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNoteBinding.inflate(layoutInflater, container, false)
        mCurrentNote = arguments?.getSerializable("note") as AppNote
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        setHasOptionsMenu(true)
        binding.noteName.text = mCurrentNote.name
        binding.noteText.text = mCurrentNote.text
        mViewModel = ViewModelProvider(this).get(NoteFragmentViewModel::class.java)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}