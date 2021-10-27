package edu.temple.audiobb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CommentAdapter private constructor(): RecyclerView.Adapter<CommentAdapter.MyViewHolder>() {

    private var mDatalist: List<*>? = null
    private var mLayoutId:Int? = null
    private var mBindView: BindView? = null

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(mLayoutId!!,p0,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mDatalist!!.size
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        mBindView?.onBindView(p0, mDatalist?.get(p1))
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    /**

     */
    interface BindView{
        fun onBindView(viewHolder: MyViewHolder, data: Any?)
    }

    /**
     */
    class Builder{

        private var commentAdapter: CommentAdapter = CommentAdapter()


        fun setDatas(lists: List<*>): Builder {
            commentAdapter.mDatalist = lists
            return this
        }

        fun setLayoutId(layoutId:Int): Builder {
            commentAdapter.mLayoutId = layoutId
            return this
        }

        fun bindView(bindView: BindView): Builder {
            commentAdapter.mBindView = bindView
            return this
        }

        fun create(): CommentAdapter {
            return commentAdapter
        }
    }

}