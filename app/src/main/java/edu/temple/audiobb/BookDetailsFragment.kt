package edu.temple.audiobb

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import edu.temple.audiobb.R
import kotlinx.android.synthetic.main.activity_detail1.view.*

class BookDetailsFragment(name: String?, name1: String?, name2: String?) : Fragment() {

    var bookTitle: String? = name
    var bookName: String? = name1
    var bookDesc: String? = name2

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view: View =inflater.inflate(R.layout.activity_detail1, container, false);
        inintView(view);

        return view
    }

    private fun inintView(view: View) {
        view.tv_1.text=bookTitle
        view.tv_2.text=bookDesc
    }
}