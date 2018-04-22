package org.overmind.slot.engine

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import assertk.assert
import assertk.assertions.*

object SymbolStripSpec : Spek({
    given("a symbol strip") {
        val symbolStrip = SymbolStrip(listOf(0, 1, 2, 3, 4))

        on("length") {
            val length = symbolStrip.length

            it("should be number of symbols in the strip") {
                assert(length)
                        .isEqualTo(5)
            }
        }
    }
})