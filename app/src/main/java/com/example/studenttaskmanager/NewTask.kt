package com.example.studenttaskmanager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.studenttaskmanager.databinding.FragmentNewTaskBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

//This will set this fragment to be a bottom sheet
class NewTask : BottomSheetDialogFragment() {

    //This will create a binding object for this fragment
    private lateinit var binding: FragmentNewTaskBinding
    private lateinit var viewTaskModel: ViewTaskModel

    //This will create the view for the fragment
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireActivity()
        viewTaskModel = ViewModelProvider(activity).get(ViewTaskModel::class.java)
        binding.saveButton.setOnClickListener {
            saveAction()
        }
    }
    //This will inflate the layout for this fragment
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentNewTaskBinding.inflate(inflater,container,false)
        return binding.root
    }
    //This will save the task name and description
    private fun saveAction() {
        viewTaskModel.name.value = binding.name.text.toString()
        viewTaskModel.description.value = binding.desc.text.toString()
        //This will close the bottom sheet
        dismiss()
    }
}