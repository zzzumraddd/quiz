package com.example.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var index=0
    var savollar = arrayListOf<Test>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        savollar.add(Test("Cairo is the capital of which country?", "Egypt", "Uzbekistan", "Italy", "Indonesia", "Egypt"))
        savollar.add(Test("In which of these countries can we find Statue of Liberty?", "Canada", "United States", "Great Britain", "Iraq", "United States"))
        savollar.add(Test("How many states are there in the USA?", "50", "60", "20", "40", "50"))
        savollar.add(Test("What is the capital of Uzbekistan", "Samarkand", "Bukhara", "Tashkent", "Ferghana", "Tashkent"))
        questionNumber(savollar.size)
        question(0)
        next.setOnClickListener {
            if(index == 3){
                index = 0
                question(index)
                group.clearCheck()


            }else {
                index++
                question(index)
                group.clearCheck()

            }
        }
    }
    fun question(index:Int){
        var test1=savollar[index]
        question.text=test1.savol
        answer1.text=test1.variant1
        answer2.text=test1.variant2
        answer3.text=test1.variant3
        answer4.text=test1.variant4

    }

    fun questionNumber(n:Int){
        for (i in 1..n){
            var btn = Button(this)
            btn.id = i
            btn.text = "$i"
            btn.tag = "$i"
            btn.setOnClickListener(this)
            q_number.addView(btn)
        }
    }

    override fun onClick(p0: View?) {
        val btn = findViewById<Button>(p0!!.id)
        index = btn.tag.toString().toInt()-1
        question(index)
    }
}