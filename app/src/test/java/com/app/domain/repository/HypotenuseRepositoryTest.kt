package com.app.domain.repository

import com.app.common.ConstantTest.Companion.ANGLE_FIRST
import com.app.common.ConstantTest.Companion.ANGLE_SECOND
import com.app.common.ConstantTest.Companion.AREA_MM
import com.app.common.ConstantTest.Companion.AREA_SQ_INCH
import com.app.common.ConstantTest.Companion.LENGTH
import com.app.domain.entities.HypotenuseDataGenerator.getEmptyHypotenuseData
import com.app.domain.entities.HypotenuseDataGenerator.getHypotenuseData
import com.nhaarman.mockitokotlin2.mock
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito
import org.junit.Assert.*

@RunWith(JUnit4::class)
class HypotenuseRepositoryTest {
    private val hypotenuseRepository: HypotenuseRepository = mock()

    @Test
    fun `calculate right Triangle coordinates and succeed`() {

        val hypotenuseData = getHypotenuseData()

        Mockito.`when`(hypotenuseRepository.rightTriangleCalcAsync(3.0,4.0)).thenReturn(
            hypotenuseData
        )

        assertEquals(LENGTH, hypotenuseData.length)
        assertTrue(hypotenuseData.areaMM == AREA_MM)
        assertTrue(hypotenuseData.areaSqInch == AREA_SQ_INCH)
        assertTrue(hypotenuseData.angleFirst == ANGLE_FIRST)
        assertFalse(hypotenuseData.angleSecond == 0.0)
        assertFalse(hypotenuseData.length == 9.0)
        assertFalse(hypotenuseData.areaMM == 9.0)
        assertNotNull(hypotenuseData.angleSecond)
        assertNotNull(ANGLE_SECOND)
    }

    @Test
    fun `get empty right Triangle coordinates`() {

        val hypotenuseData = getEmptyHypotenuseData()

        Mockito.`when`(hypotenuseRepository.rightTriangleCalcAsync(3.0,4.0)).thenReturn(
            hypotenuseData
        )

        assertEquals(0.0, hypotenuseData.length)
        assertTrue(hypotenuseData.areaMM == 0.0)
        assertTrue(hypotenuseData.areaSqInch == 0.0)
        assertTrue(hypotenuseData.angleFirst == 0.0)
        assertFalse(hypotenuseData.angleSecond == 7.0)
        assertFalse(hypotenuseData.length == 9.0)
        assertFalse(hypotenuseData.areaMM == 9.0)
        assertNotNull(hypotenuseData.angleSecond)
    }
}