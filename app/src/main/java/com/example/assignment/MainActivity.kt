package com.example.assignment

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var height: EditText = findViewById(R.id.height)
        var weight: EditText = findViewById(R.id.weigh)
        var age: EditText = findViewById(R.id.age)
        var result:TextView=findViewById(R.id.mytex)
        var button:Button=findViewById(R.id.button)
        //Create a spinner Items(Options)
        var flag: Double = 0.0
        var options = arrayOf(1.2,1.3,1.5, 1.7,1.9,2.0)
        var py:Double= 0.0
        var SpinnerVal: Spinner = findViewById(R.id.spinner2)
        SpinnerVal.adapter = ArrayAdapter<Double>(this, android.R.layout.simple_list_item_1, options)

        SpinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2) //p2 is the index of selected item

            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        button.setOnClickListener{
        var weight:Int=weight.text.toString().toInt()
        var height:Int=height.text.toString().toInt()
        var _py:Double=flag
        var age:Int=age.text.toString().toInt()
        result.text= calculate(_py,weight,height,age).toString()
    }
}
    }
public fun calculate(py:Double,weight:Int,height:Int,years:Int):Double{
return ((10 * weight) + (6.25 * height )- (5 * years)+5) * py
}