package com.deflatedpickle.owlgotrhythm.api

interface LineGotRhythm : OwlGotRhythm {
    fun <T, K> process(
        x0: Int,
        y0: Int,
        x1: Int = -1,
        y1: Int = -1,
        plot: (cache: MutableMap<T, K>, x: Int, y: Int) -> Unit
    ): MutableMap<T, K>
}