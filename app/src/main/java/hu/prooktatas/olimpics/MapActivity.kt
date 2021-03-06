package hu.prooktatas.olimpics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMapClickListener {

    private lateinit var googleMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        this.googleMap = googleMap
        googleMap.setOnMapClickListener(this)

        //displayTestData()
    }

    fun displayTestData() {
        // Add initial markers
        googleMap.addMarker(MarkerOptions().position(LatLng(51.4984, -0.136083)).title("London"))
        googleMap.addMarker(MarkerOptions().position(LatLng(48.854209, 2.349594)).title("Paris"))
        googleMap.addMarker(MarkerOptions().position(LatLng(37.550952, 126.995717)).title("Seoul"))
        googleMap.addMarker(MarkerOptions().position(LatLng(55.754712, 37.618264)).title("Moscow"))
        googleMap.addMarker(
            MarkerOptions().position(LatLng(34.044429, -118.252161)).title("Los Angeles")
        )

    }

    override fun onMapClick(position: LatLng?) {
        Log.d(TAG, "mapclicked!!")

//        val latitude = position?.latitude
//        val longitude = position?.longitude

        displayDialog(position!!)

    }

    private fun displayDialog(pos: LatLng) {
        val dialog = AlertDialog.Builder(this).create()
        dialog.setTitle("Add New Game")

        val rootView = LayoutInflater.from(this).inflate(R.layout.add_game_request_layout, null)

        val tvLatitude = rootView.findViewById<TextView>(R.id.tvLatitude)
        val tvLongitude = rootView.findViewById<TextView>(R.id.tvLongitude)
        val etCity = rootView.findViewById<EditText>(R.id.etCity)
        val etCountry = rootView.findViewById<EditText>(R.id.etCountry)
        val etYear = rootView.findViewById<EditText>(R.id.etYear)
        val btnOk = rootView.findViewById<Button>(R.id.btnOk)

        tvLatitude.text = pos.latitude.toString()
        tvLongitude.text = pos.longitude.toString()

        btnOk.setOnClickListener {
            dialog.dismiss()
        }

        dialog.setView(rootView)
        dialog.show()
    }

}
