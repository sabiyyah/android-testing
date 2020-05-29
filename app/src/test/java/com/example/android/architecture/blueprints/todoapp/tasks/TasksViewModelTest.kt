package com.example.android.architecture.blueprints.todoapp.tasks

import android.app.usage.UsageEvents
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android.architecture.blueprints.todoapp.Event
import org.hamcrest.CoreMatchers.not
import org.hamcrest.CoreMatchers.nullValue
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TasksViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Test
    fun addNewTask_setsNewTaskEvent() {

        // Given a fresh TasksViewModel
        val tasksViewModel = TasksViewModel(ApplicationProvider.getApplicationContext())

        // When adding a new task
        tasksViewModel.addNewTask()

        // Then new task event triggered
        val value = tasksViewModel.newTaskEvent.getOrAwaitValue ()

        assertThat(value.getContentIfNotHandled(), (not(nullValue())))
    }
}