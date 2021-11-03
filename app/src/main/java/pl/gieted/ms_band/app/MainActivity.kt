package pl.gieted.ms_band.app

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.companion.AssociationRequest
import android.companion.BluetoothDeviceFilter
import android.companion.CompanionDeviceManager
import android.content.Intent
import android.content.IntentSender
import android.os.Bundle
import android.os.ParcelUuid
import androidx.activity.result.contract.ActivityResultContracts.RequestPermission
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bluetoothManager = getSystemService(BLUETOOTH_SERVICE) as BluetoothManager
        val bluetoothAdapter = bluetoothManager.adapter

        val requestPermissionLauncher =
            registerForActivityResult(
                RequestPermission()
            ) { isGranted: Boolean ->

            }

        requestPermissionLauncher.launch(Manifest.permission.BLUETOOTH_CONNECT)

        if (bluetoothAdapter?.isEnabled == false) {
            val enableBtIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            startActivityForResult(enableBtIntent, 1)
        }


        val deviceManager = getSystemService(COMPANION_DEVICE_SERVICE) as CompanionDeviceManager

        val deviceFilter: BluetoothDeviceFilter = BluetoothDeviceFilter.Builder()
            .setNamePattern(Pattern.compile("""^MSFT Band \w\w:\w\w$"""))
            .addServiceUuid(ParcelUuid(UUID.fromString("a502ca97-2ba5-413c-a4e0-13804e47b38f")), null)
            .addServiceUuid(ParcelUuid(UUID.fromString("a502ca99-2ba5-413c-a4e0-13804e47b38f")), null)
            .build()


        val pairingRequest = AssociationRequest.Builder()
            // Find only devices that match this request filter.
//            .addDeviceFilter(deviceFilter)
            // Stop scanning as soon as one device matching the filter is found.
            .build()


        deviceManager.associate(
            pairingRequest,
            object : CompanionDeviceManager.Callback() {
                override fun onDeviceFound(chooserLauncher: IntentSender) {
                    startIntentSenderForResult(
                        chooserLauncher,
                        2, null, 0, 0, 0
                    )
                }

                override fun onFailure(error: CharSequence) {
                    println(error)
                }
            }, null
        )
    }
}
