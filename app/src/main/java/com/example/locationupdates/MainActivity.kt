package com.example.locationupdates

import android.annotation.SuppressLint
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.FusedLocationProviderClient

class MainActivity : AppCompatActivity() {
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
    }

    companion object {
        var TAG = MainActivity::class.java.simpleName
    }

    @SuppressLint("MissingPermission")
    fun getLocation(view: View) {
        fusedLocationClient.lastLocation  //location service hosted in google play
            .addOnSuccessListener { location : Location? ->
                Log.i(TAG,"latitude="+location?.latitude+"--longitude="+location?.longitude)

            }
    }
}