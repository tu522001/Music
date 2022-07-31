package com.example.music.adapter

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.example.music.data.Music
import com.example.music.databinding.FragmentAllSongsBinding


//class CustomAdapter(private val mList: List<ItemsViewModel>) : RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {
class CustomAdapter : RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {
//    private var mp: MediaPlayer? = null
//    private var currentSong = mutableListOf(R.raw.batcoccontim, R.raw.anhdanhroiemmay)

    private var oldData = emptyList<Music>()
    class MyViewHolder(val binding: FragmentAllSongsBinding) : RecyclerView.ViewHolder(binding.root)

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.fragment_all_songs, parent, false)
//
//        return ViewHolder(view)
        return MyViewHolder(
            FragmentAllSongsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

//        val ItemsViewModel = mList[position]
//
//        // sets the image to the imageview from our itemHolder class
//        holder.imageButton.setImageResource(ItemsViewModel.image)
//
//        // sets the text to the textview from our itemHolder class
//        holder.textView.text = ItemsViewModel.text

        holder.binding.STT.text = oldData[position].sTT.toString()
        holder.binding.Name.text = oldData[position].nameMusic
        holder.binding.Time.text = oldData[position].time

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
//        return mList.size
        return oldData.size
    }

    fun setData(newData: List<Music>){
        oldData = newData
        notifyDataSetChanged()
    }

//    // Holds the views for adding it to image and text
//    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
//        val imageButton: ImageButton
//        val textView: TextView
//
//        val mp: MediaPlayer? = null
//        val currentSong = mutableListOf(R.raw.batcoccontim)
//
//        init {
//            imageButton = ItemView.findViewById(R.id.tool)
//            textView = ItemView.findViewById(R.id.STT)
//
//
//            ItemView.setOnClickListener {
//                val position: Int = adapterPosition+1
//
//                Toast.makeText(
//                    itemView.context,
//                    "Bạn đã chọn $position",
//                    Toast.LENGTH_LONG
//                ).show()
//
////                if (mp == null) {
////                    mp = MediaPlayer.create(, R.raw.batcoccontim)
////                    //  initialiseSeekBar()
////                }
////                mp?.start()
//            }
//
//
//        }
//
//
//    }





}
