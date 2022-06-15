package jd.sistemas.android.genericrecycleradapter.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

class GenericRecyclerAdapter<T : Any>(
    private val dataSet: List<T>,
    @LayoutRes val layoutID: Int,
    private val bindingInterface: GenericRecyclerAdapterInterface<T>
) : RecyclerView.Adapter<GenericRecyclerAdapter.ViewHolder>() {

    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun <T : Any> bind(
            item: T,
            bindingInterface: GenericRecyclerAdapterInterface<T>
        ) = bindingInterface.bindData(item, view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(layoutID, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataSet[position]
        holder.bind(item, bindingInterface)
    }

    override fun getItemCount(): Int = dataSet.size
}

interface GenericRecyclerAdapterInterface<T : Any> {
    fun bindData(item: T, view: View)
}