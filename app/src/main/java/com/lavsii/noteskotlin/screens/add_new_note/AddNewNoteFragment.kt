package com.lavsii.noteskotlin.screens.add_new_note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.lavsii.noteskotlin.R
import com.lavsii.noteskotlin.databinding.FragmentAddNewNoteBinding
import com.lavsii.noteskotlin.models.AppNote
import com.lavsii.noteskotlin.utilits.APP_ACTIVITY
import com.lavsii.noteskotlin.utilits.showToast

class AddNewNoteFragment : Fragment() {

    private var _binding: FragmentAddNewNoteBinding? = null
    private val binding get() = _binding!!
    private lateinit var mViewModel: AddNewNoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddNewNoteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        mViewModel = ViewModelProvider(this).get(AddNewNoteViewModel::class.java)
        binding.btnAddNote.setOnClickListener {
            val name = binding.inputNameNote.text.toString()
            val text = binding.inputTextNote.text.toString()
            if (text.isEmpty()) {
                showToast(getString(R.string.toast_text_note_isEmpty))
            } else mViewModel.insert(AppNote(name = name, text = text)) {
                APP_ACTIVITY.navController.navigate(R.id.action_addNewNoteFragment_to_mainFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
