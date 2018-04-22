package org.overmind.slot.engine

interface ReelSpiner {
    fun spin(reel: SymbolStrip, dimension: ColumnDimension): SpinReelResult
}