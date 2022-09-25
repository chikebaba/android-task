package com.example.android_task.ui.gallery

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.android_task.databinding.FragmentGalleryBinding
import kotlinx.android.synthetic.main.fragment_gallery.*


class GalleryFragment : Fragment() {

private var _binding: FragmentGalleryBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

    _binding = FragmentGalleryBinding.inflate(inflater, container, false)
    val root: View = binding.root

    val textView: TextView = binding.textGallery
    galleryViewModel.text.observe(viewLifecycleOwner) {
      textView.text = it
    }
    return root
  }


    override fun onStart() {
        super.onStart()
        // Toast.makeText(activity, "fragments onStart method", Toast.LENGTH_LONG).show()

        /*val handler = Handler()
        val runnable = Runnable {
            Toast.makeText(context, "Woop Woop", Toast.LENGTH_LONG).show()
        }

        watchedText.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable, 5000)
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

        })*/


        watchedText.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                // textView4.setText("Text in EditText : "+s)
            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                Toast.makeText(context, s , Toast.LENGTH_SHORT).show()

                // tvSample.setText("Text in EditText : "+s)
                // textView4.setText("Text in EditText : "+s)

            }
        })



    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}