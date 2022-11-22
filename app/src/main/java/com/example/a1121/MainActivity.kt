package com.example.a1121

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var score1: TextView
    private lateinit var score2: TextView
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button

    private lateinit var resetuna: Button

    var activePlayer = 1

    var firstScore = 0
    var secondScore = 0

    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init(){
        score1 = findViewById(R.id.score1)
        score2 = findViewById(R.id.score2)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)

        resetuna = findViewById(R.id.resetuna)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)

        resetuna.setOnClickListener {
            button1.text = ""
            button2.text = ""
            button3.text = ""
            button4.text = ""
            button5.text = ""
            button6.text = ""
            button7.text = ""
            button8.text = ""
            button9.text = ""

            firstPlayer.clear()
            secondPlayer.clear()

            activePlayer = 1

            disableButtons(true)
        }
    }
    private fun disableButtons(isEnabled: Boolean) {
        button1.isEnabled = isEnabled
        button2.isEnabled = isEnabled
        button3.isEnabled = isEnabled
        button4.isEnabled = isEnabled
        button5.isEnabled = isEnabled
        button6.isEnabled = isEnabled
        button7.isEnabled = isEnabled
        button8.isEnabled = isEnabled
        button9.isEnabled = isEnabled

    }
    override fun onClick(clickedView: View?) {

        var buttonNumber = 0

        if (clickedView is Button) {

            when (clickedView.id) {
                R.id.button1 -> buttonNumber = 1
                R.id.button2 -> buttonNumber = 2
                R.id.button3 -> buttonNumber = 3
                R.id.button4 -> buttonNumber = 4
                R.id.button5 -> buttonNumber = 5
                R.id.button6 -> buttonNumber = 6
                R.id.button7 -> buttonNumber = 7
                R.id.button8 -> buttonNumber = 8
                R.id.button9 -> buttonNumber = 9
            }
        }

        if (buttonNumber != 0) {
            playGame(buttonNumber, clickedView as Button)
        }

    }
    private fun playGame(buttonNumber: Int, clickedView: Button) {

        if (activePlayer == 1){
            clickedView.text = "X"
            clickedView.setTextColor(Color.WHITE)
            activePlayer = 2
            firstPlayer.add(buttonNumber)
        }else if (activePlayer == 2){
            clickedView.text = "0"
            clickedView.setTextColor(Color.RED)
            activePlayer = 1
            secondPlayer.add(buttonNumber)
        }
        clickedView.isEnabled = false
        check()
    }
    private fun check() {
        var winnerPlayer = 0
        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)) {
            winnerPlayer = 1
            firstScore += 1
            score1.text = firstScore.toString()
            button4.isEnabled = false
            button5.isEnabled = false
            button6.isEnabled = false
            button7.isEnabled = false
            button8.isEnabled = false
            button9.isEnabled = false
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)) {
            winnerPlayer = 2
            secondScore += 1
            score2.text = secondScore.toString()
            button4.isEnabled = false
            button5.isEnabled = false
            button6.isEnabled = false
            button7.isEnabled = false
            button8.isEnabled = false
            button9.isEnabled = false
        }
        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)) {
            winnerPlayer = 1
            firstScore += 1
            score1.text = firstScore.toString()
            button1.isEnabled = false
            button2.isEnabled = false
            button3.isEnabled = false
            button7.isEnabled = false
            button8.isEnabled = false
            button9.isEnabled = false
        }
        if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)) {
            winnerPlayer = 2
            secondScore += 1
            score2.text = secondScore.toString()
            button1.isEnabled = false
            button2.isEnabled = false
            button3.isEnabled = false
            button7.isEnabled = false
            button8.isEnabled = false
            button9.isEnabled = false
        }
        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)) {
            winnerPlayer = 1
            firstScore += 1
            score1.text = firstScore.toString()
            button1.isEnabled = false
            button2.isEnabled = false
            button3.isEnabled = false
            button4.isEnabled = false
            button5.isEnabled = false
            button6.isEnabled = false
        }
        if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)) {
            winnerPlayer = 2
            secondScore += 1
            score2.text = secondScore.toString()
            button1.isEnabled = false
            button2.isEnabled = false
            button3.isEnabled = false
            button4.isEnabled = false
            button5.isEnabled = false
            button6.isEnabled = false
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)) {
            winnerPlayer = 1
            firstScore += 1
            score1.text = firstScore.toString()
            button2.isEnabled = false
            button3.isEnabled = false
            button5.isEnabled = false
            button6.isEnabled = false
            button8.isEnabled = false
            button9.isEnabled = false
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)) {
            winnerPlayer = 2
            secondScore += 1
            score2.text = secondScore.toString()
            button2.isEnabled = false
            button3.isEnabled = false
            button5.isEnabled = false
            button6.isEnabled = false
            button8.isEnabled = false
            button9.isEnabled = false
        }
        if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)) {
            winnerPlayer = 1
            firstScore += 1
            score1.text = firstScore.toString()
            button1.isEnabled = false
            button3.isEnabled = false
            button4.isEnabled = false
            button6.isEnabled = false
            button7.isEnabled = false
            button8.isEnabled = false
        }
        if (secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)) {
            winnerPlayer = 2
            secondScore += 1
            score2.text = secondScore.toString()
            button1.isEnabled = false
            button3.isEnabled = false
            button4.isEnabled = false
            button6.isEnabled = false
            button7.isEnabled = false
            button8.isEnabled = false
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)) {
            winnerPlayer = 1
            firstScore += 1
            score1.text = firstScore.toString()
            button1.isEnabled = false
            button2.isEnabled = false
            button4.isEnabled = false
            button5.isEnabled = false
            button7.isEnabled = false
            button8.isEnabled = false
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)) {
            winnerPlayer = 2
            secondScore += 1
            score2.text = secondScore.toString()
            button1.isEnabled = false
            button2.isEnabled = false
            button4.isEnabled = false
            button5.isEnabled = false
            button7.isEnabled = false
            button8.isEnabled = false
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)) {
            winnerPlayer = 1
            firstScore += 1
            score1.text = firstScore.toString()
            button2.isEnabled = false
            button3.isEnabled = false
            button4.isEnabled = false
            button6.isEnabled = false
            button7.isEnabled = false
            button8.isEnabled = false
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)) {
            winnerPlayer = 2
            secondScore += 1
            score2.text = secondScore.toString()
            button2.isEnabled = false
            button3.isEnabled = false
            button4.isEnabled = false
            button6.isEnabled = false
            button7.isEnabled = false
            button8.isEnabled = false
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)) {
            winnerPlayer = 1
            firstScore += 1
            score1.text = firstScore.toString()
            button1.isEnabled = false
            button2.isEnabled = false
            button4.isEnabled = false
            button6.isEnabled = false
            button8.isEnabled = false
            button9.isEnabled = false
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)) {
            winnerPlayer = 2
            secondScore += 1
            score2.text = secondScore.toString()
            button1.isEnabled = false
            button2.isEnabled = false
            button4.isEnabled = false
            button6.isEnabled = false
            button8.isEnabled = false
            button9.isEnabled = false
        }
        if (winnerPlayer == 1){
            Toast.makeText(applicationContext, "X won", Toast.LENGTH_SHORT).show()
        }else if (winnerPlayer == 2){
            Toast.makeText(applicationContext, "0 won", Toast.LENGTH_SHORT).show()

        }
        else if (
            button1.text.isNotEmpty() &&
            button2.text.isNotEmpty() &&
            button3.text.isNotEmpty() &&
            button4.text.isNotEmpty() &&
            button5.text.isNotEmpty() &&
            button6.text.isNotEmpty() &&
            button7.text.isNotEmpty() &&
            button8.text.isNotEmpty() &&
            button9.text.isNotEmpty() ){
            Toast.makeText(this, "It's a Draw", Toast.LENGTH_LONG).show()
            disableButtons(false)
        }
    }
}



