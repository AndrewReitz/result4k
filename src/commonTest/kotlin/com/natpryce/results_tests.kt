package com.natpryce

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ResultsFromTest {
  @Test
  fun `should return a failure when there is an exception`() {
    val expected = Exception("Oh No!")

    val result = resultFrom {
      throw expected
    }

    assertTrue(result is Failure)
    assertEquals(expected, result.reason)
  }

  @Test
  fun `should return success when no exception`() {
    val expected = "Yay!"
    val result = resultFrom { expected }

    assertTrue(result is Success)
    assertEquals(expected, result.value)
  }
}