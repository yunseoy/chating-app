package com.example.aa

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val context: Context, private val userList: ArrayList<User>):
    RecyclerView.Adapter<UserAdapter.userViewHolder>(){

    /*
    화면설정
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): userViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.user_layout, parent, false)

        return userViewHolder(view)
    }

    /*
    데이터설정
     */
    override fun onBindViewHolder(holder: userViewHolder, position: Int) {

        //데이터 담기
        val currentUser = userList[position]

        //화면에 데이터 보여주기
        holder.nameText.text = currentUser.name

        //아이템 클릭 이벤트
        holder.itemView.setOnClickListener{
            val intent = Intent(context, ChatActivity2::class.java)

            //넘길 데이터
            intent.putExtra("name", currentUser.name)
            intent.putExtra("uId", currentUser.uId)

            context.startActivity(intent)
        }
    }

    /*
    데이터 갯수 가져오기
     */
    override fun getItemCount(): Int {
        return userList.size
    }


    class userViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val nameText: TextView =itemView.findViewById(R.id.name_text)
    }
}