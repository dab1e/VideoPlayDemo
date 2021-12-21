package com.example.videoplaydemo.ui

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import androidx.core.app.ActivityCompat
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.videoplaydemo.R
import com.example.videoplaydemo.databinding.ActivityMainBinding
import com.example.videoplaydemo.ui.fragment.FragmentMain
import com.example.videoplaydemo.viewmodel.FirstViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private var uri: Uri? = null
    private var mediaControler: MediaController? = null
    private lateinit var viewmodel : FirstViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragManager: FragmentManager = supportFragmentManager
        val fragTran = fragManager.beginTransaction()
        val fragMain = FragmentMain()
        fragTran.add(R.id.frag_con, fragMain).commit()
        binding.fragCon.visibility = View.GONE

        viewmodel =  ViewModelProvider(this).get(FirstViewModel::class.java)

        ActivityCompat.requestPermissions(this,
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE),123)

        binding.chooseVideo.setOnClickListener {
            chooseVideo()

        }

        binding.navigationActivity.setOnClickListener {
            val intent = Intent(this, NavigationActivity::class.java)
            startActivity(intent)
        }

        binding.fragmentNavigation.setOnClickListener {
            if(binding.fragCon.visibility == View.GONE){
                binding.fragCon.visibility = View.VISIBLE
            }else{
                binding.fragCon.visibility = View.GONE
            }
        }

    }

    private fun chooseVideo() {
        val intent = Intent().apply {
            type = "video/*"
            action = Intent.ACTION_GET_CONTENT
        }

        startActivityForResult(Intent.createChooser(intent,"Select video"), 111)
    }

    override fun onBackPressed() {
        if(binding.fragCon.visibility == View.GONE){
            super.onBackPressed()
        }else{
            binding.fragCon.visibility = View.GONE
        }
    }

    private fun playVideo(){
        binding.videoview.stopPlayback()
        if(mediaControler == null){
            mediaControler = MediaController(this)
            mediaControler!!.setAnchorView(binding.videoview)
        }

        binding.videoview.setMediaController(mediaControler)
        binding.videoview.setVideoURI(uri)
        binding.videoview.requestFocus()
        binding.videoview.start()

        binding.videoview.setOnCompletionListener {  }
        binding.videoview.setOnErrorListener { mp, what, extra ->
            false
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode== RESULT_OK){
            if(requestCode ==111){
                uri = data?.data
                Log.e("uri", uri.toString())
                playVideo()
            }
        }
    }
}