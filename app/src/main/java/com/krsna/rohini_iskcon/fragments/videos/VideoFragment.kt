package com.krsna.rohini_iskcon.fragments.videos

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.krsna.rohini_iskcon.R
import com.krsna.rohini_iskcon.fragments.videos.youtube.YoutubeAdapter
import com.krsna.rohini_iskcon.fragments.videos.youtube.YoutubeModel
import org.json.JSONException
import org.json.JSONObject
import java.util.ArrayList

class VideoFragment : Fragment() {
    var recyclerView: RecyclerView? = null
    var youtubeAdapter: YoutubeAdapter? = null
    var list: ArrayList<YoutubeModel> = ArrayList<YoutubeModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_video, container, false)
        com.krsna.rohini_iskcon.MainActivity.screen = "video"
        recyclerView = view.findViewById<RecyclerView>(R.id.recyclerviewyt)
        youtubeAdapter = YoutubeAdapter(context, list)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.adapter = youtubeAdapter

        if(list.isNotEmpty()){
            list.clear()
        }
        fetchData()


        return view;
    }

    private fun fetchData() {
        val requestQueue = Volley.newRequestQueue(context)
        val stringRequest = StringRequest(
            Request.Method.GET, "https://www.googleapis.com/youtube/v3/search?key=AIzaSyCUokgggw5kvdJHpnNxXWJO0cUyjdcoMGA&channelId=UCzePpph-Ae0wYhtGonYm8GQ&part=snippet,id&order=date&maxResults=50",
            { response ->
                try {
                    val jsonObject = JSONObject(response)
                    val jsonArray = jsonObject.getJSONArray("items")
                    Log.e("msg", "len " + jsonArray.length())
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject1 = jsonArray.getJSONObject(i)
                        val jsonvideoid = jsonObject1.getJSONObject("id")
                        val jsonsnippet = jsonObject1.getJSONObject("snippet")
                        val jsonthumbnail = jsonsnippet.getJSONObject("thumbnails").getJSONObject("medium")
                        val md = YoutubeModel()
                        md.videoId = jsonvideoid.getString("videoId")
                        Log.e("msg", "Id " + jsonvideoid.getString("videoId"))
                        md.title = jsonsnippet.getString("title")
                        md.url = jsonthumbnail.getString("url")
                        md.description= jsonsnippet.getString("description")
                        list.add(md)
                        youtubeAdapter!!.notifyDataSetChanged()
                    }
                    if (list.size > 0) {
                        Log.e("LListSize", list.size.toString())
                        youtubeAdapter!!.notifyDataSetChanged()
                    }
                } catch (e: JSONException) {
                    Log.e("error in exception ", list.size.toString())
                    Log.e("error in exception ", e.toString())
                    e.printStackTrace()
                }
            }) { Toast.makeText(context, "Error!!", Toast.LENGTH_LONG).show() }
        requestQueue.add(stringRequest)
    }


}