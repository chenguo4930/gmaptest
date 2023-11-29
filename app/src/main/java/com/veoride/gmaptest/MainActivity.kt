package com.veoride.gmaptest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.veoride.gmaptest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var binding: ActivityMainBinding

    private lateinit var mMap: GoogleMap

    private lateinit var viewModel: MapViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initMapFragment()
        initViewModel()
        initListener()
    }

    private fun initListener() {
        binding.btnStart.setOnClickListener {
            Toast.makeText(this, "点击Start", Toast.LENGTH_SHORT).show()
        }

    }

    /**
     * 初始化ViewModeView
     */
    private fun initViewModel() {
        viewModel = ViewModelProvider(this)[MapViewModel::class.java]

        // 监听界面状态以及事件，并做出响应
        viewModel.uiState.observe(this) {
            Log.d("MainActivity", "received response: $it")
        }
    }

    /**
     * 初始化地图fragment
     */
    private fun initMapFragment() {
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * 地图的回掉
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(
            MarkerOptions()
                .position(sydney)
                .title("Marker in Sydney")
        )
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
}