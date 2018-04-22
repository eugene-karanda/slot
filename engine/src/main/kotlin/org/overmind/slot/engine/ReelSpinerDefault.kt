package org.overmind.slot.engine

class ReelSpinerDefault(private val randomManager: RandomManager) : ReelSpiner {

    override fun spin(reel: SymbolStrip, dimension: ColumnDimension): SpinReelResult {
        val symbols = reel.symbols
        val stopPosition = randomManager.randomInt(reel.length)

        val column = symbols.circular()
                .subList(stopPosition, stopPosition + dimension.height)
                .let(::SymbolStrip)

        return SpinReelResult(stopPosition, column)
    }
}