package com.app.domain.entities

object HypotenuseDataGenerator {

    fun getHypotenuseData(): HypotenuseData {
        return HypotenuseData(
            length = 5.0,
            areaMM = 6.0,
            areaSqInch = 0.2362206,
            angleFirst = 53.13010235415598,
            angleSecond = 36.86989764584402
        )
    }

    fun getEmptyHypotenuseData(): HypotenuseData {
        return HypotenuseData(
            length = 0.0,
            areaMM = 0.0,
            areaSqInch = 0.0,
            angleFirst = 0.0,
            angleSecond = 0.0
        )
    }
}