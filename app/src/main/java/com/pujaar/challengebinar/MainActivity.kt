package com.pujaar.challengebinar

import android.content.ContentValues.TAG
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.pujaar.challengebinar.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var namePlayer: String = "-"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        namePlayer = intent.getStringExtra("name").toString()
        setOnAct() // memanggil fungsi logic game
        supportActionBar?.hide()
        setView()
    }

    fun setView() {
        binding.apply {
            binding.tvPlyr.text = namePlayer

        }
    }


    //membuat kondisi pilihan untuk player ketika memilih batu,kertas atau gunting
    private fun selectionPlyr(typeSelection: String) {
        binding.apply {
            when (typeSelection) {
                ROCK -> {
                    plyrRck.setBackgroundResource(R.drawable.bg_selector)
                    plyrPpr.setBackgroundResource(0)
                    plyrScr.setBackgroundResource(0)

                }
                PAPER -> {
                    plyrRck.setBackgroundResource(0)
                    plyrPpr.setBackgroundResource(R.drawable.bg_selector)
                    plyrScr.setBackgroundResource(0)

                }
                SCISSOR -> {
                    plyrPpr.setBackgroundResource(0)
                    plyrRck.setBackgroundResource(0)
                    plyrScr.setBackgroundResource(R.drawable.bg_selector)
                }
            }
        }
    }

    //membuat kondisi pilihan untuk computer ketika memilih batu,kertas atau gunting
    private fun selectionCmptr(typeSelection: String) {
        binding.apply {
            when (typeSelection) {
                ROCK -> {
                    compRck.setBackgroundResource(R.drawable.bg_selector)
                    compPpr.setBackgroundResource(0)
                    compScr.setBackgroundResource(0)
                }
                PAPER -> {
                    compPpr.setBackgroundResource(R.drawable.bg_selector)
                    compScr.setBackgroundResource(0)
                    compRck.setBackgroundResource(0)
                }
                SCISSOR -> {
                    compScr.setBackgroundResource(R.drawable.bg_selector)
                    compRck.setBackgroundResource(0)
                    compPpr.setBackgroundResource(0)
                }
            }
        }
    }

    //membuat fungsi kondisi ketika game menang, kalah dan imbang
    private fun gameCondition(typeSelection: String) {
        binding.apply {
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
    }

    //logic game
    private fun setOnAct() {
        binding.apply {
            //ketika player memilih rock
            plyrRck.setOnClickListener() {
                Log.d(TAG, "Player Choose Rock")
                val computerSelect = (1..3).random()
                selectionPlyr(ROCK)
                if (computerSelect == 1) {
                    Log.d(TAG, "COM Choose Rock")
                    selectionCmptr(ROCK)
                    gameCondition(DRAW)
                } else if (computerSelect == 2) {
                    Log.d(TAG, "COM Choose Paper")
                    selectionCmptr(PAPER)
                    gameCondition(WIN)
                } else {
                    Log.d(TAG, "COM Choose Scissor")
                    selectionCmptr(SCISSOR)
                    gameCondition(LOSE)
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
                } else if (computerSelect == 2) {
                    Log.d(TAG, "COM Choose Scissor")
                    selectionCmptr(SCISSOR)
                    gameCondition(LOSE)
                } else {
                    Log.d(TAG, "COM Choose Rock")
                    selectionCmptr(ROCK)
                    gameCondition(WIN)
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
                } else if (computerSelect == 2) {
                    Log.d(TAG, "COM Choose Scissor")
                    selectionCmptr(SCISSOR)
                    gameCondition(DRAW)
                } else {
                    Log.d(TAG, "COM Choose Rock")
                    selectionCmptr(ROCK)
                    gameCondition(LOSE)
                }

            }
            Log.d(TAG, "Player reset the game")
            imgRefresh.setOnClickListener() {
                resetGame()
            }
            ivClose.setOnClickListener {
                val intent = Intent(this@MainActivity, GameSelection::class.java)
                intent.putExtra("name",namePlayer)
                startActivity(intent)
                finish()
            }
        }
    }

    //fungsi untuk reset game
    private fun resetGame() {
        binding.apply {
            plyrPpr.setBackgroundResource(0)
            plyrScr.setBackgroundResource(0)
            plyrRck.setBackgroundResource(0)
            compRck.setBackgroundResource(0)
            compScr.setBackgroundResource(0)
            compPpr.setBackgroundResource(0)
            tvVs.setBackgroundResource(0)
        }
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