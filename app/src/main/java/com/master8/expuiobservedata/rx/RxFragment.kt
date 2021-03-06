package com.master8.expuiobservedata.rx

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.master8.expuiobservedata.R

class RxFragment : Fragment() {

    private val viewModel by viewModels<RxViewModel>()

    private lateinit var textView: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        Log.e("mv8", "onCreateView")
        return inflater.inflate(R.layout.main_fragment, container, false)
            .also {
                textView = it.findViewById(R.id.message)
            }
    }

    override fun onStart() {
        Log.e("mv8", "onStart")
        super.onStart()

        viewModel.stableFlowable
            .subscribe(lifecycle) {
                runOnUIThread {
                    textView.text = "n $it"
                    Log.e("mv8", "n ${it}")
                }
            }
    }


    //Logs only

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e("mv8", "onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.e("mv8", "onViewCreated")
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.e("mv8", "onActivityCreated")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onResume() {
        Log.e("mv8", "onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.e("mv8", "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.e("mv8", "onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.e("mv8", "onDestroyView")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.e("mv8", "onDestroy")
        super.onDestroy()
    }
}