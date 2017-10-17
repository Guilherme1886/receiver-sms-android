package com.guilherme.antonio.listenersms

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    val listMsg = arrayListOf<SMSModel>()
    var adapter: ListViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configSmsReceiver()
    }


    private fun configSmsReceiver() {

        adapter = ListViewAdapter(this@MainActivity, listMsg)
        list_msgs.adapter = adapter

        SMSReceiver.bindListener(object : SmsListener {
            override fun messageReceived(message: String?, number: String?) {

                sms_wait.visibility = View.GONE

                listMsg.add(SMSModel("Número: $number", "Mensagem: $message"))
                adapter?.notifyDataSetChanged()


            }
        })

        list_msgs.onItemClickListener = AdapterView.OnItemClickListener { p0, p1, position, p3 ->

            toast("${listMsg[position].numero} - ${listMsg[position].mensagem}")

        }
    }
}

