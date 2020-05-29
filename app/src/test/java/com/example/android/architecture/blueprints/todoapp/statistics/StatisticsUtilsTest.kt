package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.*
import org.junit.Test

class StatisticsUtilsTest {
    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {

        // Create active task
        val tasks = listOf<Task>(Task("title", "desc", isCompleted = false))

        // Call function being tested
        val result = getActiveAndCompletedStats(tasks)

        // Check result
        assertThat(result.completedTasksPercent, `is`(0f))
        assertThat(result.activeTasksPercent, `is`(100f))

    }

    @Test
    fun getActiveAndCompletedStats_noActive_returnsZeroHundred() {

        //Create completed task
        val tasks = listOf<Task>(Task("completed", "desc", isCompleted = true))

        //Call func
        val result = getActiveAndCompletedStats(tasks)

        //Check result
        assertThat(result.completedTasksPercent, `is`(100f))
        assertThat(result.activeTasksPercent, `is`(0f))
    }

    @Test
    fun getActiveAndCompletedStats_twoCompThreeActive_returnsSixtyForty() {

        //Create completed task
        val tasks = listOf<Task>(Task("1", "desc", isCompleted = true), Task("2", "desc", isCompleted = true),
                Task("3", "desc", isCompleted = false), Task("4", "desc", isCompleted = false), Task("5", "desc", isCompleted = false))

        //Call func
        val result = getActiveAndCompletedStats(tasks)

        //Check result
        assertThat(result.completedTasksPercent, `is`(40f))
        assertThat(result.activeTasksPercent, `is`(60f))
    }

    @Test
    fun getActiveAndCompletedStats_emptyList_returnsZeros() {

        val result = getActiveAndCompletedStats(emptyList())
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }

    @Test
    fun getActiveAndCompletedStats_error_returnsZeros() {

        val result = getActiveAndCompletedStats(null)
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }
}