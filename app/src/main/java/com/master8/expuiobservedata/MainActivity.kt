package com.master8.expuiobservedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.commit
import androidx.fragment.app.commitNow
import androidx.fragment.app.replace
import com.master8.expuiobservedata.flow.FlowFragment
import com.master8.expuiobservedata.rx.RxFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        //flow sample

        findViewById<Button>(R.id.button_show_fragment).setOnClickListener {
            supportFragmentManager.commitNow {
                replace<FlowFragment>(R.id.container)
                setReorderingAllowed(true)
            }
        }

        findViewById<Button>(R.id.button_show_fragment2).setOnClickListener {
            supportFragmentManager.commitNow {
                replace<FlowFragment>(R.id.container2)
                setReorderingAllowed(true)
            }
        }

        findViewById<Button>(R.id.button_to_stack).setOnClickListener {
            supportFragmentManager.commit {
                replace<EmptyFragment>(R.id.container)
                setReorderingAllowed(true)
                addToBackStack(null)
            }
        }

        //rx sample

//        findViewById<Button>(R.id.button_show_fragment).setOnClickListener {
//            supportFragmentManager.commitNow {
//                replace<RxFragment>(R.id.container)
//                setReorderingAllowed(true)
//            }
//        }
//
//        findViewById<Button>(R.id.button_to_stack).setOnClickListener {
//            supportFragmentManager.commit {
//                replace<EmptyFragment>(R.id.container)
//                setReorderingAllowed(true)
//                addToBackStack(null)
//            }
//        }
    }
}