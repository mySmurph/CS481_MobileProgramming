package com.hw1_sirenamurphree

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class btn_Back : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater!!.inflate(R.layout.fragment_btn__back, container, false);
        val goTo_Main: Button = view.findViewById(R.id.btn_toMain);
        goTo_Main.setOnClickListener(this);
        return view;
    }

    companion object {
        fun newInstance(): btn_Back {
            return btn_Back();
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_toMain -> {
                val go = Intent(v.context, MainActivity::class.java);
                startActivity(go);
                getActivity()?.finish();

            }
            else -> { }
        }
    }
}