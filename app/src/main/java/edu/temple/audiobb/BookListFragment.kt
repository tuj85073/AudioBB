package edu.temple.audiobb

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import edu.temple.audiobb.MainActivity
import edu.temple.audiobb.R
import edu.temple.audiobb.CommentAdapter
import edu.temple.audiobb.Book
import kotlinx.android.synthetic.main.activity_item1.view.*
import kotlinx.android.synthetic.main.activity_list1.view.*


class BookListFragment: Fragment() {
    val userInfoList: MutableList<Book> = ArrayList<Book>() ;
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view:View =inflater.inflate(R.layout.activity_list1, container, false);
        inintView(view);

        return view
    }

    private fun inintView(view: View) {
//        val userInfoList: MutableList<Book> = ArrayList<Book>() ;

        for (index in 1..10){
            var book:Book=Book();
            book.bookTitle= "Book$index";
            book.bookName= "Author$index";
            book.bookDesc= "Description$index";
            userInfoList.add(book)
        }



        view.rv.setLayoutManager(LinearLayoutManager(activity))

        view.rv.adapter = CommentAdapter.Builder()
            .setDatas(userInfoList)
            .setLayoutId(R.layout.activity_item1)
            .bindView(object : CommentAdapter.BindView{
                override fun onBindView(viewHolder: CommentAdapter.MyViewHolder, data: Any?) {
                    val myData: Book = data as Book
                    viewHolder.itemView.tv_1.text = myData.bookTitle
                    viewHolder.itemView.tv_2.text = myData.bookName
                    viewHolder.itemView.llyt_item.setOnClickListener {
                        val activity1: MainActivity =  activity as MainActivity

                        activity1.setData(myData.bookTitle,myData.bookName,myData.bookDesc);

                    }
                }
            })
            .create()


    }
}