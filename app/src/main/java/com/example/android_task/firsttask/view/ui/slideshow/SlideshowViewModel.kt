package com.example.android_task.firsttask.view.ui.slideshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SlideshowViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is third fragment with Recycler view"
    }
    val text: LiveData<String> = _text
}
