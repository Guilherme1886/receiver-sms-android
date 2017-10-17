package com.guilherme.antonio.listenersms

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import java.util.ArrayList

/**
 * Created by Bimore on 17/10/2017.
 */

class ListViewAdapter(context: Context?, val smsList: ArrayList<SMSModel>) : ArrayAdapter<SMSModel>(context, R.layout.item_msg, smsList) {

    private class ViewHolder {
        internal var textView_numero: TextView? = null
        internal var textView_mensagem: TextView? = null
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {

        var convertView = convertView

        val smsList = smsList[position]
        val viewHolder: ViewHolder

        if (convertView == null) {

            viewHolder = ViewHolder()
            val inflater = LayoutInflater.from(context)
            convertView = inflater.inflate(R.layout.item_msg, parent, false)

            viewHolder.textView_numero = convertView.findViewById<TextView>(R.id.number)
            viewHolder.textView_mensagem = convertView.findViewById<TextView>(R.id.message)


            convertView.tag = viewHolder
        } else {
            viewHolder = convertView.tag as ViewHolder
        }

        viewHolder.textView_numero?.text = smsList.numero
        viewHolder.textView_mensagem?.text = smsList.mensagem



        return convertView

    }
}