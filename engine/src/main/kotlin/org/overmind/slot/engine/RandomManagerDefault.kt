package org.overmind.slot.engine

import java.util.Random

class RandomManagerDefault(private val random: Random) : RandomManager {

    override fun randomInt(bound: Int): Int {
        return random.nextInt(bound)
    }
}