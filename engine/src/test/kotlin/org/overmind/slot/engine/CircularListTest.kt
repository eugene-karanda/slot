package org.overmind.slot.engine

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import assertk.assert
import assertk.assertions.*

object CircularListTest : Spek({
    given("a CircularList") {
        val circularList = listOf(0, 1, 2).circular()

        on("get") {
            it("should return element") {
                assert(circularList[3])
                        .isEqualTo(0)
            }
        }

        on("subList") {
            it("should return element") {
                assert(circularList.subList(2, 5))
                        .isEqualTo(listOf(2, 0, 1))
            }
        }
    }
})

