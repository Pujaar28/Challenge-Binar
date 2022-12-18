package com.pujaar.challengebinar

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.pujaar.challengebinar.databinding.ActivityGameSelectionBinding

class GameSelection : AppCompatActivity() {
    lateinit var binding: ActivityGameSelectionBinding
    private var namePlayer: String = " "

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameSelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setView()
        setOnAction()

    }

    //untuk mengset value yang diterima dari layout sebelumnya
    private fun setView() {
        namePlayer = intent.getStringExtra("name").toString()
        binding.apply {
            tvVsplayer.setText("$namePlayer VS Player")
            tvVscom.setText("$namePlayer VS COM")
        }
        onSnackBar() // memanggil snackbar


    }

    // membuat snack bar
    private fun onSnackBar() {
        binding.apply {
            val snackBar = Snackbar.make(
                binding.actyGameSelect,
                "Selamat Datang $namePlayer",
                Snackbar.LENGTH_INDEFINITE
            )
            snackBar.setAction("Tutup") {
                snackBar.dismiss()
            }
            snackBar.show()
        }
    }

    //function ketika gambar diklik
    private fun setOnAction() {
        val intent = Intent(this@GameSelection, VersusPlayerActivity::class.java) //pindah layout ke player vs player
        val intentTwo = Intent(this@GameSelection, VersusComActivity::class.java) //pindah layout ke player vs com
        binding.apply {
            imgVsplayer.setOnClickListener {
                imgVsplayer.setBackgroundResource(R.drawable.bg_selector)
                imgVscom.setBackgroundResource(0)
                intent.putExtra("name", namePlayer)
                startActivity(intent)
                finish()
            }
            imgVscom.setOnClickListener {
                imgVsplayer.setBackgroundResource(0)
                imgVscom.setBackgroundResource(R.drawable.bg_selector)
                intentTwo.putExtra("name", namePlayer)
                startActivity(intentTwo)
                finish()
            }
        }
    }
}
