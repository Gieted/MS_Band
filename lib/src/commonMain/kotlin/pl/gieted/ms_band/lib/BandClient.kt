package pl.gieted.ms_band.lib

class BandClient {
    private val mutableConnectedBands = mutableSetOf<Band>()

    var started = false
        private set

    val connectedBands: Set<Band>
        get() = mutableConnectedBands

    fun addConnection(connection: BandConnection) {
        mutableConnectedBands.add(Band(connection))
    }

    fun start() {
        started = true
    }

    fun stop() {
        started = false
    }
}
