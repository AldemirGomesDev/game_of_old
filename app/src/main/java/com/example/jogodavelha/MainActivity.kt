package com.example.jogodavelha

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var btSelected: Button
    lateinit var bt1: Button
    lateinit var bt2: Button
    lateinit var bt3: Button
    lateinit var bt4: Button
    lateinit var bt5: Button
    lateinit var bt6: Button
    lateinit var bt7: Button
    lateinit var bt8: Button
    lateinit var bt9: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bt1 = findViewById(R.id.bt1)
        bt2 = findViewById(R.id.bt2)
        bt3 = findViewById(R.id.bt3)
        bt4 = findViewById(R.id.bt4)
        bt5 = findViewById(R.id.bt5)
        bt6 = findViewById(R.id.bt6)
        bt7 = findViewById(R.id.bt7)
        bt8 = findViewById(R.id.bt8)
        bt9 = findViewById(R.id.bt9)

        newGamer.setOnClickListener {
            clean()
        }

        clean()
    }


    fun btClick(view: View) {
        btSelected = view as Button
        var cellID = 0
        when (btSelected.id) {
            R.id.bt1 -> cellID = 1
            R.id.bt2 -> cellID = 2
            R.id.bt3 -> cellID = 3
            R.id.bt4 -> cellID = 4
            R.id.bt5 -> cellID = 5
            R.id.bt6 -> cellID = 6
            R.id.bt7 -> cellID = 7
            R.id.bt8 -> cellID = 8
            R.id.bt9 -> cellID = 9
        }
        playerGamer(cellID, btSelected)

    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1

    fun playerGamer(cellID: Int, btSelected: Button) {
        if (activePlayer == 1) {
            btSelected.text = "X"
            btSelected.setBackgroundColor(Color.GREEN)
            player1.add(cellID)
            activePlayer = 2
        } else {
            btSelected.text = "O"
            btSelected.setBackgroundColor(Color.RED)
            player2.add(cellID)
            activePlayer = 1
        }

        btSelected.isEnabled = false
        checkWiner()
    }

    fun checkWiner() {
        var winer = -1

        for (item in player1) {
            Log.e("playererror", "player 1 $item")
        }

        for (item in player2) {
            Log.e("playererror", "player 2 $item")
        }

        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winer = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winer = 2
        }
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winer = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winer = 2
        }
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winer = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winer = 2
        }
        //==================colunas======================
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winer = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winer = 2
        }
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winer = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winer = 2
        }
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winer = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winer = 2
        }
        //=======================diagonal===========================
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winer = 1
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winer = 2
        }
        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winer = 1
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winer = 2
        }

        if (winer != -1) {
            if (winer == 1) {
                blockKeyboard()
                textView.text = "Jogador 1 venceu!!"
                textView.setTextColor(Color.GREEN)
            }
            if (winer == 2) {
                blockKeyboard() 
                textView.text = "Jogador 2 venceu!!"
                textView.setTextColor(Color.RED)
            }
        }

    }

    fun blockKeyboard() {
        bt1.isEnabled = false
        bt2.isEnabled = false
        bt3.isEnabled = false
        bt4.isEnabled = false
        bt5.isEnabled = false
        bt6.isEnabled = false
        bt7.isEnabled = false
        bt8.isEnabled = false
        bt9.isEnabled = false
    }

    fun clean() {

        activePlayer = 1
        textView.text = ""

        player1.clear()
        player2.clear()

        bt1.setBackgroundColor(Color.GRAY)
        bt2.setBackgroundColor(Color.GRAY)
        bt3.setBackgroundColor(Color.GRAY)
        bt4.setBackgroundColor(Color.GRAY)
        bt5.setBackgroundColor(Color.GRAY)
        bt6.setBackgroundColor(Color.GRAY)
        bt7.setBackgroundColor(Color.GRAY)
        bt8.setBackgroundColor(Color.GRAY)
        bt9.setBackgroundColor(Color.GRAY)

        bt1.isEnabled = true
        bt2.isEnabled = true
        bt3.isEnabled = true
        bt4.isEnabled = true
        bt5.isEnabled = true
        bt6.isEnabled = true
        bt7.isEnabled = true
        bt8.isEnabled = true
        bt9.isEnabled = true

        bt1.text = ""
        bt2.text = ""
        bt3.text = ""
        bt4.text = ""
        bt5.text = ""
        bt6.text = ""
        bt7.text = ""
        bt8.text = ""
        bt9.text = ""
    }
}
