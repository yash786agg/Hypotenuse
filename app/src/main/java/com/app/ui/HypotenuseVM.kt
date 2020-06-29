package com.app.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.domain.entities.HypotenuseData
import com.app.domain.repository.HypotenuseRepository

class HypotenuseVM(private val hypotenuseRepository: HypotenuseRepository) : ViewModel() {

    // FOR DATA --
    private lateinit var resultantData: MutableLiveData<HypotenuseData>

    fun rightTriangleCalculator(
        firstCoordinate: Double,
        secondCoordinate: Double
    ): LiveData<HypotenuseData> {
        resultantData = MutableLiveData()

        resultantData.postValue(
            hypotenuseRepository.rightTriangleCalcAsync(
                firstCoordinate,
                secondCoordinate
            )
        )

        return resultantData
    }
}