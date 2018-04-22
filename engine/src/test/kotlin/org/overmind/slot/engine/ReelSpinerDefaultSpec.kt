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

    given("a ReelSpinerDefault") {
        val randomManager = mockk<RandomManager>()
        val reelSpinerDefault = ReelSpinerDefault(randomManager)

        on("spin") {
            val stopPosition = 0
            val reel = SymbolStrip((0..5).toList())

            every {
                randomManager.randomInt(reel.length)
            } returns stopPosition

            val spinReelResult = reelSpinerDefault.spin(reel, dimension)

            it("should something") {
                assert(spinReelResult)
                        .isEqualTo(
                                SpinReelResult(
                                        stopPosition,
                                        SymbolStrip(listOf(0, 1, 2))
                                )
                        )
            }

            verifyAll {
                randomManager.randomInt(reel.length)
            }
        }
    }
})