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

    private fun setView() {
        namePlayer = intent.getStringExtra("name").toString()
        binding.apply {
            tvVsplayer.setText("$namePlayer VS Player")
            tvVscom.setText("$namePlayer VS COM")
        }
        onSnackBar()


    }

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
//            hideNavBar()
        }
    }

    private fun setOnAction() {
        val intent = Intent(this@GameSelection, VersusPlayerActivity::class.java)
        val intentTwo = Intent(this@GameSelection, VersusComActivity::class.java)
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

    fun hideNavBar() {
        binding.apply {
            WindowCompat.setDecorFitsSystemWindows(window, false)
            WindowInsetsControllerCompat(window, window.decorView).let { controller ->
            controller.hide(WindowInsetsCompat.Type.systemBars())

                controller.systemBarsBehavior=WindowInsetsControllerCompat.BEHAVIOR_SHOW_BARS_BY_SWIPE
        }
        }
    }

}
