package com.pujaar.challengebinar

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.pujaar.challengebinar.databinding.DialogGameBinding
import com.pujaar.challengebinar.databinding.VersusPlayerActivityBinding


class VersusPlayerActivity : AppCompatActivity() {
    lateinit var binding: VersusPlayerActivityBinding
    private var namePlayer: String = "-"
    var pOne: String = " "
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = VersusPlayerActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setView() // function set tampilan

        playerOneAction() // function player 1
        playerTwoAction() // function player 2
    }
    // function memanggil string pada activity sebelum nyta kemuda diset pada textview
    // dan menampilan gambar dari internet untuk image view
    private fun setView() {
        namePlayer = intent.getStringExtra("name").toString()
        binding.apply {
            tvPlayerone.text = "$namePlayer "
            Glide.with(this@VersusPlayerActivity)
                .load("https://i.ibb.co/HC5ZPgD/splash-screen1.png")
                .into(imagTitle)
        }
    }
    // function untuk player 1 apabila telah melakukan 1 click
    fun disableOnClick() {
        binding.apply {
            ivPlayerOneRock.isClickable = false
            ivPlayerOneScissor.isClickable = false
            ivPlayerOnePaper.isClickable = false
        }
    }
    // function untuk restart game
    private fun resetGame() {
        binding.apply {
            ivPlayerOneRock.setBackgroundResource(0)
            ivPlayerOnePaper.setBackgroundResource(0)
            ivPlayerOneScissor.setBackgroundResource(0)
            ivPlayerTwoRock.setBackgroundResource(0)
            ivPlayerTwoPaper.setBackgroundResource(0)
            ivPlayerTwoScissor.setBackgroundResource(0)
            tvResult.setText("VS")
            tvResult.setTextSize(50f)
            tvResult.setTextColor(Color.parseColor("#F00000"))
            tvResult.setBackgroundResource(0)
            ivPlayerOneRock.isClickable = true
            ivPlayerOneScissor.isClickable = true
            ivPlayerOnePaper.isClickable = true
        }

    }

    // function kondisi ketika player 1 melakukan click
    private fun playerOne(selectionPlayerOne: String) {
        binding.apply {
            when (selectionPlayerOne) {
                ROCK -> {
                    ivPlayerOneRock.setBackgroundResource(R.drawable.bg_selector)
                    ivPlayerOnePaper.setBackgroundResource(0)
                    ivPlayerOneScissor.setBackgroundResource(0)
                }
                PAPER -> {
                    ivPlayerOnePaper.setBackgroundResource(R.drawable.bg_selector)
                    ivPlayerOneRock.setBackgroundResource(0)
                    ivPlayerOneScissor.setBackgroundResource(0)
                }
                SCISSOR -> {
                    ivPlayerOneScissor.setBackgroundResource(R.drawable.bg_selector)
                    ivPlayerOnePaper.setBackgroundResource(0)
                    ivPlayerOneRock.setBackgroundResource(0)
                }
            }
        }
    }
    // function kondisi ketika player 2 melakukan click
    private fun playerTwo(selectionPlayerTwo: String) {
        binding.apply {
            when (selectionPlayerTwo) {
                ROCK -> {
                    ivPlayerTwoRock.setBackgroundResource(R.drawable.bg_selector)
                    ivPlayerTwoPaper.setBackgroundResource(0)
                    ivPlayerTwoScissor.setBackgroundResource(0)

                }
                PAPER -> {
                    ivPlayerTwoPaper.setBackgroundResource(R.drawable.bg_selector)
                    ivPlayerTwoRock.setBackgroundResource(0)
                    ivPlayerTwoScissor.setBackgroundResource(0)
                }
                SCISSOR -> {
                    ivPlayerTwoScissor.setBackgroundResource(R.drawable.bg_selector)
                    ivPlayerTwoPaper.setBackgroundResource(0)
                    ivPlayerTwoRock.setBackgroundResource(0)
                }
            }
        }
    }
    // function untuk membuat kondisi game ketika menang, kalah dan seri
    private fun gameCondition(selectionCondition: String) {
        binding.apply {
            when (selectionCondition) {
                WIN -> {
                    tvResult.setBackgroundResource(R.drawable.bg_win)
                    tvResult.text = "$namePlayer \nMenang"
                    tvResult.textSize = 20F
                    tvResult.textAlignment = View.TEXT_ALIGNMENT_CENTER
                    tvResult.setTextColor(Color.WHITE)
                    tvResult.setPadding(80, 10, 80, 50)
                }
                DRAW -> {
                    tvResult.setBackgroundResource(R.drawable.bg_draw)
                    tvResult.setText(R.string.imbang)
                    tvResult.textAlignment = View.TEXT_ALIGNMENT_CENTER
                    tvResult.setTextColor(Color.WHITE)
                    tvResult.textSize = 20F
                    tvResult.setPadding(80, 10, 80, 30)
                }
                LOSE -> {
                    tvResult.setBackgroundResource(R.drawable.bg_win)
                    tvResult.setText(R.string.playertwowin)
                    tvResult.textSize = 20F
                    tvResult.textAlignment = View.TEXT_ALIGNMENT_CENTER
                    tvResult.setTextColor(Color.WHITE)
                    tvResult.setPadding(80, 10, 80, 50)
                }
            }
        }
    }
//function player one ketika melakukan click atau touch
    private fun playerOneAction() {
        binding.apply {
            ivPlayerOneRock.setOnClickListener {
                playerOne(ROCK)
                pOne = "batu"
                disableOnClick()
                Toast.makeText(
                    this@VersusPlayerActivity,
                    "$namePlayer memilih batu",
                    Toast.LENGTH_SHORT
                ).show()
            }
            ivPlayerOneScissor.setOnClickListener {
                playerOne(SCISSOR)
                pOne = "gunting"
                disableOnClick()
                Toast.makeText(
                    this@VersusPlayerActivity,
                    "$namePlayer memilih gunting",
                    Toast.LENGTH_SHORT
                ).show()
            }
            ivPlayerOnePaper.setOnClickListener {
                playerOne(PAPER)
                pOne = "kertas"
                disableOnClick()
                Toast.makeText(
                    this@VersusPlayerActivity,
                    "$namePlayer memilih kertas",
                    Toast.LENGTH_SHORT
                ).show()
            }
            ivReset.setOnClickListener {
                resetGame()
                Toast.makeText(
                    this@VersusPlayerActivity,
                    "$namePlayer memilih reset",
                    Toast.LENGTH_SHORT
                ).show()
            }
            ivClose.setOnClickListener {
                val intent = Intent(this@VersusPlayerActivity, GameSelection::class.java)
                intent.putExtra("name", namePlayer)
                finish()
                startActivity(intent)
            }
        }
    }
    // function apabila player 2 melakukan click
    private fun playerTwoAction() {
        binding.apply {
            ivPlayerTwoRock.setOnClickListener {
                playerTwo(ROCK)
                gamePlay(pOne, "batu")
                Toast.makeText(
                    this@VersusPlayerActivity,
                    "Pemain 2  memilih batu",
                    Toast.LENGTH_SHORT
                ).show()
            }
            ivPlayerTwoScissor.setOnClickListener {
                playerTwo(SCISSOR)
                gamePlay(pOne, "gunting")
                Toast.makeText(
                    this@VersusPlayerActivity,
                    "Pemain 2  memilih gunting",
                    Toast.LENGTH_SHORT
                ).show()
            }
            ivPlayerTwoPaper.setOnClickListener {
                playerTwo(PAPER)
                gamePlay(pOne, "kertas")
                Toast.makeText(
                    this@VersusPlayerActivity,
                    "Pemain 2  memilih kertas",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
//logic game play player vs player
    private fun gamePlay(playerOneChoice: String, playerTwoChoice: String) {
        if (playerOneChoice == playerTwoChoice) {
            gameCondition(DRAW)
            setDialogDraw()
            Toast.makeText(this, "DRAW", Toast.LENGTH_SHORT).show()
        } else if (playerOneChoice == "gunting" && playerTwoChoice == "kertas") {
            gameCondition(WIN)
            setDialogWin()
            Toast.makeText(this, "Pemain 1 Menang", Toast.LENGTH_SHORT).show()
        } else if (playerOneChoice == "batu" && playerTwoChoice == "gunting") {
            gameCondition(WIN)
            setDialogWin()
            Toast.makeText(this, "Pemain 1 Menang", Toast.LENGTH_SHORT).show()
        } else if (playerOneChoice == "kertas" && playerTwoChoice == "batu") {
            gameCondition(WIN)
            setDialogWin()
            Toast.makeText(this, "Pemain 1 Menang", Toast.LENGTH_SHORT).show()
        } else if (playerOneChoice == "kertas" && playerTwoChoice == "gunting") {
            gameCondition(LOSE)
            setDialogLose()
            Toast.makeText(this, "Pemain 2 Menang", Toast.LENGTH_SHORT).show()
        } else if (playerOneChoice == "gunting" && playerTwoChoice == "batu") {
            gameCondition(LOSE)
            setDialogLose()
            Toast.makeText(this, "Pemain 2 Menang", Toast.LENGTH_SHORT).show()
        } else if (playerOneChoice == "batu" && playerTwoChoice == "kertas") {
            gameCondition(LOSE)
            setDialogLose()
            Toast.makeText(this, "Pemain 2 Menang", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Pilih salah satu ", Toast.LENGTH_SHORT).show()
        }
    }
    // function membuat dialog menang
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
                Toast.makeText(this@VersusPlayerActivity, "$namePlayer Menang", Toast.LENGTH_SHORT)
                    .show()
                dialog.dismiss()
            }
            btnBackmenu.setOnClickListener() {
                val intentmenu = Intent(this@VersusPlayerActivity, GameSelection::class.java)
                intentmenu.putExtra("name", namePlayer)
                startActivity(intentmenu)
                finish()
            }
            dialog.show()
        }
    }
    // function membuat dialog kalah
    private fun setDialogLose() {
        val bindingDialog = DialogGameBinding.inflate(layoutInflater)
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setView(bindingDialog.root) // membuat binding layout untuk custom dialog
        val dialog = dialogBuilder.create()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        bindingDialog.apply {
            tvHasiltwo.setText(R.string.playertwowin)
            tvHasiltwo.textAlignment=View.TEXT_ALIGNMENT_CENTER
            btnPlayagain.setOnClickListener() {
                resetGame()
                Toast.makeText(this@VersusPlayerActivity, "PEMAIN 2 Menang", Toast.LENGTH_SHORT)
                    .show()
                dialog.dismiss()
            }
            btnBackmenu.setOnClickListener() {
                val intentmenu = Intent(this@VersusPlayerActivity, GameSelection::class.java)
                intentmenu.putExtra("name", namePlayer)
                startActivity(intentmenu)
                finish()
            }
            dialog.show()
        }
    }
    // function membuat dialog hasil game seri menggunakan custom dialog
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
                Toast.makeText(this@VersusPlayerActivity, "Hasil Game Draw", Toast.LENGTH_SHORT)
                    .show()
                dialog.dismiss()
            }
            btnBackmenu.setOnClickListener() {
                val intentmenu = Intent(this@VersusPlayerActivity, GameSelection::class.java)
                intentmenu.putExtra("name", namePlayer)
                startActivity(intentmenu)
                finish()
            }
            dialog.show()
        }
    }

    companion object {
        const val ROCK = "STONE"
        const val PAPER = "PAPER"
        const val SCISSOR = "SCISSOR"
        const val WIN = "MENANG"
        const val LOSE = "KALAH"
        const val DRAW = "IMBANG"
    }
}
