package com.geektech.taskapp.ui.profile

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.fragment.findNavController
import com.geektech.taskapp.R
import com.geektech.taskapp.databinding.FragmentProfileBinding
import com.geektech.taskapp.data.Pref
import com.geektech.taskapp.utils.loadImage
import com.google.firebase.auth.FirebaseAuth


class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding
    lateinit var pref: Pref
    private lateinit var image: String
    private lateinit var auth: FirebaseAuth
    private val getContent = registerForActivityResult(ActivityResultContracts.GetContent()){
            uri: Uri? ->
        image = uri.toString()
        binding.imgProfile.loadImage(image)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref=Pref(requireContext())
        binding.apply {
            etProfile.setText(pref.getName())
            etAge.setText((pref.getAge()))
            imgProfile.loadImage(pref.getImage())


        }
        binding.btnSave.setOnClickListener {
            pref.saveName(binding.etProfile.text.toString())
            pref.saveAge(binding.etAge.text.toString())
            pref.saveImage(image)
        }

        binding.imgProfile.setOnClickListener{
            getContent.launch("image/*")
        }

        auth = FirebaseAuth.getInstance()
        binding.btnSignOut.setOnClickListener {    auth.signOut()
            findNavController().navigate(R.id.authFragment)

        }
    }





}