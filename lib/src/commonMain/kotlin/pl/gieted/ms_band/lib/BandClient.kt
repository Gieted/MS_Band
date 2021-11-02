package pl.gieted.ms_band.lib

class BandClient(
    var autoScan: Boolean = true,
    var autoConnect: Boolean = true,
    private val bluetoothClient: BluetoothClient
) {
    private val mutableAvailableBands = mutableSetOf<Band>()

    var started = false
        private set

    val availableBands: Set<Band>
        get() = mutableAvailableBands

    fun scanForBands() {
        println("scanning!")
        bluetoothClient.pairedDevices.forEach {
            println(it.name)
        }
    }

    fun start() {
        started = true
        scanForBands()
    }

    fun stop() {
        started = false
    }
}
