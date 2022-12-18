package com.pujaar.challengebinar

import android.content.ContentValues.TAG
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.pujaar.challengebinar.databinding.DialogGameBinding
import com.pujaar.challengebinar.databinding.VersusComActivityBinding
import kotlinx.android.synthetic.main.versus_player_activity.*

class VersusComActivity : AppCompatActivity() {
    lateinit var binding: VersusComActivityBinding
    private var namePlayer: String = "-"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = VersusComActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnAct() // memanggil fungsi logic game
        supportActionBar?.hide()
        setView()
    }

    fun setView() {
        binding.apply {
            namePlayer = intent.getStringExtra("name").toString()
            tvPlyr.setText("$namePlayer")
            Glide.with(this@VersusComActivity)
                .load("https://i.ibb.co/HC5ZPgD/splash-screen1.png")
                .into(ivGametitle)
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
                    tvVs.setText("$namePlayer\nMenang")
                    tvVs.setTextSize(20F)
                    tvVs.textAlignment = View.TEXT_ALIGNMENT_CENTER
                    tvVs.setTextColor(Color.WHITE)
                    tvVs.setPadding(80, 10, 80, 50)
                    setDialogWin()
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
                    setDialogDraw()
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
                val intent = Intent(this@VersusComActivity, GameSelection::class.java)
                intent.putExtra("name", namePlayer)
                finish()
                startActivity(intent)

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
            tvVs.setText("VS")
            tvVs.setTextSize(50f)
            tvVs.setBackgroundResource(0)
            tvVs.setTextColor(Color.parseColor("#F00000"))
        }
    }
//dialog game ketika menang
    private fun setDialogWin() {
        val bindingDialog = DialogGameBinding.inflate(layoutInflater)
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setView(bindingDialog.root)
        val dialog = dialogBuilder.create()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        bindingDialog.apply {
            tvHasiltwo.setText("$namePlayer\nMENANG!")
            tvHasiltwo.textAlignment=View.TEXT_ALIGNMENT_CENTER
            btnPlayagain.setOnClickListener() {
                resetGame()
                Toast.makeText(this@VersusComActivity, "Main Lagiiiii", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            btnBackmenu.setOnClickListener() {
                val intentmenu = Intent(this@VersusComActivity, GameSelection::class.java)
                intentmenu.putExtra("name", namePlayer)
                startActivity(intentmenu)
                finish()
            }
            dialog.show()
        }
    }

    //diaog game ketika hasil seri
    private fun setDialogDraw() {
        val bindingDialog = DialogGameBinding.inflate(layoutInflater)
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setView(bindingDialog.root)
        val dialog = dialogBuilder.create()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        bindingDialog.apply {
            tvHasiltwo.setText(R.string.imbang)
            tvHasiltwo.textAlignment=View.TEXT_ALIGNMENT_CENTER
            btnPlayagain.setOnClickListener() {
                resetGame()
                Toast.makeText(this@VersusComActivity, "MAINNN LAGI", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            btnBackmenu.setOnClickListener() {
                val intentmenu = Intent(this@VersusComActivity, GameSelection::class.java)
                intentmenu.putExtra("name", namePlayer)
                startActivity(intentmenu)
                finish()
            }
            dialog.show()
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