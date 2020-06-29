package com.app.domain.repository

import com.app.domain.entities.HypotenuseData
import kotlin.math.acos
import kotlin.math.pow
import kotlin.math.sqrt

class HypotenuseRepository {

    // Right Triangle Calculator
    fun rightTriangleCalcAsync(firstCoordinate: Double, secondCoordinate: Double): HypotenuseData {

        val length = sqrt(firstCoordinate.pow(2.0) + secondCoordinate.pow(2.0))

        val areaMM = firstCoordinate * secondCoordinate / 2

        val inchMultiplier = 0.0393701
        val areaSqInch = areaMM * inchMultiplier

        val angleFirst = Math.toDegrees(acos(firstCoordinate / length))

        val angleSecond = 90 - angleFirst

        return HypotenuseData(length = length,areaMM = areaMM,areaSqInch = areaSqInch,angleFirst = angleFirst,angleSecond = angleSecond)
    }
}