package pl.gieted.ms_band.lib

interface BluetoothClient {
    val pairedDevices: Set<BluetoothDevice>
}
