package com.example.assignment2;

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

import com.example.assignment2.R.*

class Calculator : AppCompatActivity() {
    private var operator = ""
    private var input1 = 0.0
    private var input2 = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        val primaryToolbar = findViewById<Toolbar>(R.id.primary_toolbar)
        setSupportActionBar(primaryToolbar)
        supportActionBar?.title = "Calculator Layout"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setListeners()
    }

     private fun setListeners() {
        val num0 = findViewById<Button>(R.id.num_0)
        val num1 = findViewById<Button>(R.id.num_1)
        val num2 = findViewById<Button>(R.id.num_2)
        val num3 = findViewById<Button>(R.id.num_3)
        val num4 = findViewById<Button>(R.id.num_4)
        val num5 = findViewById<Button>(R.id.num_5)
        val num6 = findViewById<Button>(R.id.num_6)
        val num7 = findViewById<Button>(R.id.num_7)
        val num8 = findViewById<Button>(R.id.num_8)
        val num9 = findViewById<Button>(R.id.num_9)
        val deci = findViewById<Button>(R.id.decimal)

        val add = findViewById<Button>(R.id.add)
        val minus = findViewById<Button>(R.id.minus)
        val multiply = findViewById<Button>(R.id.multiply)
        val divide = findViewById<Button>(R.id.divide)
        val equal = findViewById<Button>(R.id.equal)

         val clear = findViewById<Button>(R.id.clear)
         val reset = findViewById<Button>(R.id.clear_everything)


        val numViews:List<View> = listOf(num0,num1,num2,num3,num4,
                                            num5,num6,num7,num8,num9,deci,
                                            add,minus,multiply,divide,equal,
                                            clear,reset)

         for (item in numViews){
             item.setOnClickListener{
                 setValue(item)
             }
         }
    }

    @SuppressLint("SetTextI18n")
    private fun setValue(item:View) {
        val inputField = findViewById<TextView>(R.id.input)
        val outField = findViewById<TextView>(R.id.output)
        outField.text = ""

            when(item.id){
                R.id.num_0 -> inputField.text = inputField.text.toString() + "0"
                R.id.num_1 -> inputField.text = inputField.text.toString() + "1"
                R.id.num_2 -> inputField.text = inputField.text.toString() + "2"
                R.id.num_3 -> inputField.text = inputField.text.toString() + "3"
                R.id.num_4 -> inputField.text = inputField.text.toString() + "4"
                R.id.num_5 -> inputField.text = inputField.text.toString() + "5"
                R.id.num_6 -> inputField.text = inputField.text.toString() + "6"
                R.id.num_7 -> inputField.text = inputField.text.toString() + "7"
                R.id.num_8 -> inputField.text = inputField.text.toString() + "8"
                R.id.num_9 -> inputField.text = inputField.text.toString() + "9"
                R.id.decimal -> inputField.text = inputField.text.toString() + "."

                R.id.add -> {
                    operator = "add"
                    input1 = inputField.text.toString().toFloat().toDouble()
                    inputField.text = ""
                }

                R.id.minus -> {
                    operator = "minus"
                    input1 = inputField.text.toString().toFloat().toDouble()
                    inputField.text = ""
                }

                R.id.multiply -> {
                    operator = "multiply"
                    input1 = inputField.text.toString().toFloat().toDouble()
                    inputField.text = ""
                }

                R.id.divide -> {
                    operator = "divide"
                    input1 = inputField.text.toString().toFloat().toDouble()
                    inputField.text = ""
                }

                R.id.equal ->{
                    when(operator){
                        "add"->{
                            input2 = if(inputField.text.toString() == ""){
                                0.0
                            } else{
                                inputField.text.toString().toFloat().toDouble()
                            }
                            inputField.text = ""
                            val answer = input1 + input2
                            outField.text = answer.toString()
                        }
                        "minus"->{
                            input2 = if(inputField.text.toString() == ""){
                                0.0
                            } else{
                                inputField.text.toString().toFloat().toDouble()
                            }
                            inputField.text = ""
                            val answer = input1 - input2
                            outField.text = answer.toString()
                        }
                        "multiply"->{
                            input2 = if(inputField.text.toString() == ""){
                                1.0
                            } else{
                                inputField.text.toString().toFloat().toDouble()
                            }
                            inputField.text = ""
                            val answer = input1 * input2
                            outField.text = answer.toString()
                        }
                        "divide"->{
                            input2 = if(inputField.text.toString() == ""){
                                1.0
                            } else{
                                inputField.text.toString().toFloat().toDouble()
                            }
                            inputField.text = ""
                            if(input2 != 0.0) {
                                val answer = input1 / input2
                                outField.text = answer.toString()
                            }
                            else{
                                outField.text ="INVALID INPUT"
                            }
                        }
                    }
                }

                R.id.clear->{
                    inputField.text = ""
                    if(operator == ""){ input1 = 0.0 }
                    else{ input2 = 0.0}
                }

                R.id.clear_everything ->{
                     inputField.text=""
                     outField.text = ""
                     operator = ""
                     input1 = 0.0
                     input2 = 0.0
                }
            }
    }
}