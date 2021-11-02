package pl.gieted.ms_band.app

import android.Manifest
import android.bluetooth.BluetoothManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts.RequestPermission
import pl.gieted.ms_band.lib.BandClient
import pl.gieted.ms_band.lib.PlatformBluetoothClient

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        
        val bluetoothManager = getSystemService(BLUETOOTH_SERVICE) as BluetoothManager
        val bandClient = BandClient(bluetoothClient = PlatformBluetoothClient(bluetoothManager.adapter))
        val requestPermissionLauncher =
            registerForActivityResult(
                RequestPermission()
            ) { isGranted: Boolean ->
                
            }

        if (Build.VERSION.SDK_INT >= 31) {
            requestPermissionLauncher.launch(Manifest.permission.BLUETOOTH_CONNECT)
        } else {
            requestPermissionLauncher.launch(Manifest.permission.BLUETOOTH)
        }

        bandClient.start()
    }
}
