@file:Suppress("NAME_SHADOWING")

package com.deflatedpickle.owlgotrhythm.impl.line

import com.deflatedpickle.owlgotrhythm.api.LineGotRhythm
import com.deflatedpickle.owlgotrhythm.api.OwlGotRhythm
import kotlin.math.abs

// https://en.wikipedia.org/wiki/Bresenham%27s_line_algorithm
object BresenhamLine : LineGotRhythm {
    override fun <T, K> process(
        x0: Int,
        y0: Int,
        x1: Int,
        y1: Int,
        plot: (cache: MutableMap<T, K>, x: Int, y: Int) -> Unit
    ): MutableMap<T, K> {
        var x0 = x0
        var y0 = y0

        val dx = abs(x1 - x0)
        val sx = if (x0 < x1) 1 else -1
        val dy = -abs(y1 - y0)
        val sy = if (y0 < y1) 1 else -1
        var error = dx + dy

        val cache = mutableMapOf<T, K>()

        while (true) {
            plot(cache, x0, y0)

            if (x0 == x1 && y0 == y1) break
            val e2 = 2 * error

            if (e2 >= dy) {
                if (x0 == x1) break
                error += dy
                x0 += sx
            }

            if (e2 <= dx) {
                if (y0 == y1) break
                error += dx
                y0 += sy
            }
        }

        return cache
    }
}