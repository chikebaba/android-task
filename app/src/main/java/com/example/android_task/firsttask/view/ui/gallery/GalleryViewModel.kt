package com.example.android_task.firsttask.view.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GalleryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is fragment with echo editText"
    }
    val text: LiveData<String> = _text
}
