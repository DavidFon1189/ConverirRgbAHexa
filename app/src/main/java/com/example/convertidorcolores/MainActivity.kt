package com.example.convertidorcolores

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var edtConvertirR: EditText
    lateinit var edtConvertirG: EditText
    lateinit var edtConvertirB: EditText
    lateinit var tvHexa: TextView
    lateinit var btnConvertir : Button
    lateinit var lLRoot : LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        edtConvertirR = findViewById(R.id.edt_codigo_r)
        edtConvertirG = findViewById(R.id.edt_codigo_g)
        edtConvertirB = findViewById(R.id.edt_codigo_b)
        tvHexa = findViewById(R.id.tv_hexadecimal)
        btnConvertir = findViewById(R.id.btn_convertir)
        btnConvertir.setOnClickListener(this)
        lLRoot = findViewById(R.id.root_color)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_convertir -> {
                val rValor = edtConvertirR.text.toString()
                val gValor = edtConvertirG.text.toString()
                val bValor = edtConvertirB.text.toString()

                val hex = String.format("#%02X%02X%02X", rValor.toInt(), gValor.toInt(), bValor.toInt())
                tvHexa.text = hex
                lLRoot.setBackgroundColor(Color.parseColor(hex))
            }
        }
    }
}