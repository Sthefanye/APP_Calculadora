package com.example.calculadorafeitaporsthe

import android.os.Bundle
import android.os.strictmode.WebViewMethodCalledOnWrongThreadViolation
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private var txt_valor_1: EditText? = null
    private var txt_valor_2: EditText? = null
    private var txt_resultado: TextView? = null
    private var rb1: RadioButton? = null
    private var rb2: RadioButton? = null
    private var rb3: RadioButton? = null
    private var rb4: RadioButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txt_valor_1 = findViewById<View>(R.id.valor1) as EditText
        txt_valor_2 = findViewById<View>(R.id.valor2) as EditText
        txt_resultado = findViewById<View>(R.id.resultado) as TextView
        rb1 = findViewById<View>(R.id.soma) as RadioButton
        rb2 = findViewById<View>(R.id.sub) as RadioButton
        rb3 = findViewById<View>(R.id.mult) as RadioButton
        rb4 = findViewById<View>(R.id.div) as RadioButton
    }
    fun calcular(view: View?) {
        val valor_1: Int
        val valor_2: Int
        var resultado: Double

        valor_1 = txt_valor_1!!.text.toString().toInt()
        valor_2 = txt_valor_2!!.text.toString().toInt()

        if (rb1!!.isChecked) {
            resultado = valor_1 + valor_2.toDouble()
            txt_resultado!!.text = java.lang.Double.toString(resultado)
        }
        if (rb2!!.isChecked) {
            resultado = valor_1 - valor_2.toDouble()
            txt_resultado!!.text = java.lang.Double.toString(resultado)
        }
        if (rb3!!.isChecked) {
            resultado = valor_1 * valor_2.toDouble()
            txt_resultado!!.text = java.lang.Double.toString(resultado)
        }
        if (rb4!!.isChecked) {
            if (valor_2 != 0) {
                resultado = valor_1 / (valor_2 * 1.0)
                txt_resultado!!.text = java.lang.Double.toString(resultado)
            }
            else {
                Toast.makeText(this, "Divisão não permitida", Toast.LENGTH_SHORT).show()
            }
        }
    }
}