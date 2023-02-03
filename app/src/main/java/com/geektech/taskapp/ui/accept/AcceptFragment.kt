package com.geektech.taskapp.ui.accept

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.geektech.taskapp.R
import com.geektech.taskapp.databinding.FragmentAcceptBinding
import com.geektech.taskapp.databinding.FragmentAuthBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider


class AcceptFragment : Fragment() {
    private lateinit var binding: FragmentAcceptBinding
    private lateinit var args: AcceptFragmentArgs
    private  var auth=FirebaseAuth.getInstance()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentAcceptBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        args= arguments?.let { AcceptFragmentArgs.fromBundle(it) }!!
        binding.btnSend.setOnClickListener {
            val credential = PhoneAuthProvider.getCredential(args.verId!!, binding.etCode.text.toString())
            }
        signInWithPhoneAuthCredential(credential)
        }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    findNavController().navigate(R.id.navigation_home)
                    val user = task.result?.user
                } else {
                    // Sign in failed, display a message and update the UI
                    Log.w("kani", "signInWithCredential:failure", task.exception)
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        // The verification code entered was invalid
                    }
                    // Update UI
                }
            }
    }




}