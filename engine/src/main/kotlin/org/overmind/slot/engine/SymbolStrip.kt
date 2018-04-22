package org.overmind.slot.engine

data class SymbolStrip(
        val symbols: List<Int>
) {
    val length = symbols.size
}