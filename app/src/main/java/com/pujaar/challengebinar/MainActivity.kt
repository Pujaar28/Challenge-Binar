package com.pujaar.challengebinar

import android.content.ContentValues.TAG
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView

class MainActivity : AppCompatActivity() {
    lateinit var plyrRock: AppCompatImageView
    lateinit var plyrScr: AppCompatImageView
    lateinit var plyrPpr: AppCompatImageView
    lateinit var compRock: AppCompatImageView
    lateinit var compScr: AppCompatImageView
    lateinit var compPpr: AppCompatImageView
    lateinit var refreshImg: AppCompatImageView
    lateinit var tvVs: AppCompatTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setObject() // memanggil fungsi
        setOnAct() // memanggil fungsi logic game
        supportActionBar?.hide()

    }

    //membuat fungsi memanggil view di layout
    fun setObject() {
        plyrRock = findViewById(R.id.plyr_rck)
        plyrScr = findViewById(R.id.plyr_scr)
        plyrPpr = findViewById(R.id.plyr_ppr)
        compRock = findViewById(R.id.comp_rck)
        compScr = findViewById(R.id.comp_scr)
        compPpr = findViewById(R.id.comp_ppr)
        refreshImg = findViewById(R.id.img_refresh)
        tvVs = findViewById(R.id.tv_vs)

    }

    //membuat kondisi pilihan untuk player ketika memilih batu,kertas atau gunting
    private fun selectionPlyr(typeSelection: String) {
        when (typeSelection) {
            ROCK -> {
                plyrRock.setBackgroundResource(R.drawable.bg_selector)
                plyrPpr.setBackgroundResource(0)
                plyrScr.setBackgroundResource(0)

            }
            PAPER -> {
                plyrRock.setBackgroundResource(0)
                plyrPpr.setBackgroundResource(R.drawable.bg_selector)
                plyrScr.setBackgroundResource(0)

            }
            SCISSOR -> {
                plyrPpr.setBackgroundResource(0)
                plyrRock.setBackgroundResource(0)
                plyrScr.setBackgroundResource(R.drawable.bg_selector)
            }
        }
    }

    //membuat kondisi pilihan untuk computer ketika memilih batu,kertas atau gunting
    private fun selectionCmptr(typeSelection: String) {
        when (typeSelection) {
            ROCK -> {
                compRock.setBackgroundResource(R.drawable.bg_selector)
                compPpr.setBackgroundResource(0)
                compScr.setBackgroundResource(0)
            }
            PAPER -> {
                compPpr.setBackgroundResource(R.drawable.bg_selector)
                compScr.setBackgroundResource(0)
                compRock.setBackgroundResource(0)
            }
            SCISSOR -> {
                compScr.setBackgroundResource(R.drawable.bg_selector)
                compRock.setBackgroundResource(0)
                compPpr.setBackgroundResource(0)
            }
        }
    }

    //membuat fungsi kondisi ketika game menang, kalah dan imbang
    private fun gameCondition(typeSelection: String) {
        when (typeSelection) {
            WIN -> {
                tvVs.setBackgroundResource(R.drawable.bg_win)
                tvVs.setText(R.string.menang)
                tvVs.setTextSize(20F)
                tvVs.textAlignment = View.TEXT_ALIGNMENT_CENTER
                tvVs.setTextColor(Color.WHITE)
                tvVs.setPadding(80, 10, 80, 50)
            }
            LOSE -> {
                tvVs.setBackgroundResource(R.drawable.bg_win)
                tvVs.setText(R.string.kalah)
                tvVs.setTextSize(20F)
                tvVs.textAlignment = View.TEXT_ALIGNMENT_CENTER
                tvVs.setTextColor(Color.WHITE)
                tvVs.setPadding(80, 10, 80, 50)
            }
            DRAW -> {
                tvVs.setBackgroundResource(R.drawable.bg_draw)
                tvVs.setText("DRAW")
                tvVs.textAlignment = View.TEXT_ALIGNMENT_CENTER
                tvVs.setTextColor(Color.WHITE)
                tvVs.setTextSize(20F)
                tvVs.setPadding(80, 10, 80, 30)
            }
        }
    }

    //logic game
    private fun setOnAct() {
        //ketika player memilih rock
        plyrRock.setOnClickListener() {
            Log.d(TAG, "Player Choose Rock")
            val computerSelect = (1..3).random()
            selectionPlyr(ROCK)
            if (computerSelect == 1) {
                Log.d(TAG, "COM Choose Rock")
                selectionCmptr(ROCK)
                gameCondition(DRAW)
                Toast.makeText(this, "Hasil Seri", Toast.LENGTH_SHORT).show()
            } else if (computerSelect == 2) {
                Log.d(TAG, "COM Choose Paper")
                selectionCmptr(PAPER)
                gameCondition(WIN)
                Toast.makeText(this, "Pemain 1 MENANG!", Toast.LENGTH_SHORT).show()
            } else {
                Log.d(TAG, "COM Choose Scissor")
                selectionCmptr(SCISSOR)
                gameCondition(LOSE)
                Toast.makeText(this, "Computer MENANG!", Toast.LENGTH_SHORT).show()
            }
        }
        //ketika player memilih paper
        plyrPpr.setOnClickListener() {
            Log.d(TAG, "Player Choose Paper")
            var computerSelect = (1..3).random()
            selectionPlyr(PAPER)
            if (computerSelect == 1) {
                Log.d(TAG, "COM Choose Paper")
                selectionCmptr(PAPER)
                gameCondition(DRAW)
                Toast.makeText(this, "Hasil Seri", Toast.LENGTH_SHORT).show()
            } else if (computerSelect == 2) {
                Log.d(TAG, "COM Choose Scissor")
                selectionCmptr(SCISSOR)
                gameCondition(LOSE)
                Toast.makeText(this, "COM MENANG!", Toast.LENGTH_SHORT).show()
            } else {
                Log.d(TAG, "COM Choose Rock")
                selectionCmptr(ROCK)
                gameCondition(WIN)
                Toast.makeText(this, "Player Menang!", Toast.LENGTH_SHORT).show()
            }
        }
        //ketika player memilih scissor
        plyrScr.setOnClickListener() {
            Log.d(TAG, "Player Choose Scissor")
            var computerSelect = (1..3).random()
            selectionPlyr(SCISSOR)
            if (computerSelect == 1) {
                Log.d(TAG, "COM Choose Paper")
                selectionCmptr(PAPER)
                gameCondition(WIN)
                Toast.makeText(this, "Player MENANG!", Toast.LENGTH_SHORT).show()
            } else if (computerSelect == 2) {
                Log.d(TAG, "COM Choose Scissor")
                selectionCmptr(SCISSOR)
                gameCondition(DRAW)
                Toast.makeText(this, "Hasil Seri", Toast.LENGTH_SHORT).show()
            } else {
                Log.d(TAG, "COM Choose Rock")
                selectionCmptr(ROCK)
                gameCondition(LOSE)
                Toast.makeText(this, "Com MENANG!", Toast.LENGTH_SHORT).show()
            }

        }
        Log.d(TAG, "Player reset the game")
        refreshImg.setOnClickListener() {
            resetGame()
        }

    }

    //fungsi untuk reset game
    private fun resetGame() {
        plyrPpr.setBackgroundResource(0)
        plyrScr.setBackgroundResource(0)
        plyrRock.setBackgroundResource(0)
        compRock.setBackgroundResource(0)
        compScr.setBackgroundResource(0)
        compPpr.setBackgroundResource(0)
        tvVs.setBackgroundResource(0)
    }

    //membuat companion object
    companion object {
        const val ROCK = "STONE"
        const val PAPER = "PAPER"
        const val SCISSOR = "SCISSOR"
        const val WIN = "MENANG"
        const val LOSE = "KALAH"
        const val DRAW = "IMBANG"
    }

}