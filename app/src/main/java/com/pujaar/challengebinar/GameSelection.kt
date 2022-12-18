package com.pujaar.challengebinar

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
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
    //function untuk menampilkan tampilan serta menerima value dari activity sebelumnya
    private fun setView() {
        namePlayer = intent.getStringExtra("name").toString()
        binding.apply {
            tvVsplayer.setText("$namePlayer VS Player")
            tvVscom.setText("$namePlayer VS COM")
        }
        onSnackBar()

    }

    //function untuk menampilkan snakback
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
    //function untuk memilih game
    private fun setOnAction() {
        binding.apply {
            imgVsplayer.setOnClickListener { //melawan player
                val intent = Intent(this@GameSelection, VersusPlayerActivity::class.java) //membuat intent untuk pindah activity
                imgVsplayer.setBackgroundResource(R.drawable.bg_selector)
                imgVscom.setBackgroundResource(0)
                intent.putExtra("name", namePlayer) //menyimpan nilai dari masukan
                startActivity(intent)
                finish()
            }
            imgVscom.setOnClickListener { //melawan computer
                val intentTwo = Intent(this@GameSelection, VersusComActivity::class.java)
                imgVsplayer.setBackgroundResource(0)
                imgVscom.setBackgroundResource(R.drawable.bg_selector)
                intentTwo.putExtra("name", namePlayer) //menyimpan nilai
                startActivity(intentTwo)
                finish()
            }
        }
    }
}
