package org.overmind.slot.engine

import io.mockk.every
import io.mockk.mockk
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import assertk.assert
import assertk.assertions.*
import io.mockk.verifyAll

object ReelSpinerDefaultSpec : Spek({
    val dimension = ColumnDimension(3)
    val reel = SymbolStrip((0 until 5).toList())

    given("a ReelSpinerDefault") {
        val randomManager = mockk<RandomManager>()
        val reelSpinerDefault = ReelSpinerDefault(randomManager)

        val testCases = listOf(
                TestCase("column within reel", 0, SymbolStrip(listOf(0, 1, 2))),
                TestCase("column out of reel", 4, SymbolStrip(listOf(4, 0, 1)))
        )

        testCases.forEach { (description, stopPosition, expectedStrip) ->
            on(description) {
                every {
                    randomManager.randomInt(reel.length)
                } returns stopPosition

                val spinReelResult = reelSpinerDefault.spin(reel, dimension)

                it("return column") {
                    assert(spinReelResult)
                            .isEqualTo(
                                    SpinReelResult(stopPosition, expectedStrip)
                            )
                }

                verifyAll {
                    randomManager.randomInt(reel.length)
                }
            }
        }
    }
}) {
    private data class TestCase(
            val description: String,
            val stopPosition: Int,
            val expectedStrip: SymbolStrip
    )
}