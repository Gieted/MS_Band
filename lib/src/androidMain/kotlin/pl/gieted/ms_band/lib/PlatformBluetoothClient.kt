package pl.gieted.ms_band.lib

import android.bluetooth.BluetoothAdapter

actual class PlatformBluetoothClient(private val bluetoothAdapter: BluetoothAdapter): BluetoothClient {
    override val pairedDevices: Set<BluetoothDevice>
        get() = bluetoothAdapter.bondedDevices.map { BluetoothDeviceImpl(it.name, it.address) }.toSet()
}
