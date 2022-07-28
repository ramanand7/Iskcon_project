package com.krsna.rohini_iskcon.fragments.audio.audiotypes

import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import androidx.fragment.app.Fragment
import com.example.jean.jcplayer.model.JcAudio
import com.example.jean.jcplayer.view.JcPlayerView
import com.krsna.rohini_iskcon.MainActivity
import com.krsna.rohini_iskcon.R
import com.krsna.rohini_iskcon.fragments.audio.AudioModel
import com.krsna.rohini_iskcon.fragments.audio.AudioFragment
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.util.*

class KirtanFragment : Fragment() {
    private var storage: FirebaseStorage? = null
    var storageReference: StorageReference? = null
    var mDataReference: DatabaseReference? = null
    var al = ArrayList<String?>()
    var al2 = ArrayList<String?>()
    var songsList: ListView? = null
    var player: MediaPlayer? = null
    var jcAudios = ArrayList<JcAudio>()
    var alname = ArrayList<String?>()
    var al2urls = ArrayList<String?>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_kirtans, container, false)
        com.krsna.rohini_iskcon.MainActivity.screen = "kirtan"
        jcPlayerViewk = view.findViewById(R.id.jcplayerk)
        player = MediaPlayer()
        storage = FirebaseStorage.getInstance()
        storageReference = storage!!.reference
        songsList = view.findViewById<View>(R.id.songsList) as ListView
        mDataReference = FirebaseDatabase.getInstance().getReference("kirtans")
        mDataReference?.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                al = collectnms(dataSnapshot.value as Map<String, Any>?)
                al2 = collecturls(dataSnapshot.value as Map<String, Any>?)
                val audio = dataSnapshot.getValue(
                    AudioModel::class.java
                )
                alname.add(audio?.name)
                al2urls.add(audio?.url)
                for (i in al.indices) {
                    jcAudios.add(JcAudio.createFromURL(al[i]!!, al2[i]!!))
                }
                if (jcAudios.size != 0) {
                    jcPlayerViewk?.initPlaylist(jcAudios, null)
                    songsList!!.visibility = View.VISIBLE
                    if (context != null) songsList!!.adapter =
                        ArrayAdapter(context!!, android.R.layout.simple_list_item_1, al)
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })
        songsList?.onItemClickListener =
            OnItemClickListener { _: AdapterView<*>?, view: View?, position: Int, _: Long ->
                Toast.makeText(context, "Playing wait seconds ...", Toast.LENGTH_LONG).show()
                jcPlayerViewk?.playAudio(jcAudios[position])
                jcPlayerViewk?.visibility = View.VISIBLE
                jcPlayerViewk?.createNotification()
            }

        return view
    }

    private fun collecturls(value: Map<String, Any>?): ArrayList<String?> {
        val urls = ArrayList<String?>()
        var i = 0
        try {
            for ((_, value1) in value!!) {

                //Get user map
                val singleUser = value1 as Map<*, *>
                urls.add(singleUser["url"] as String?)
                //Toast.makeText(MapsActivity.this, lats.get(i) +"|"+lngs.get(i), Toast.LENGTH_SHORT).show();
                i++
            }
        } catch (e: NullPointerException) {
            print("NullPointerException Caught")
        }
        return urls
    }

    private fun collectnms(value: Map<String, Any>?): ArrayList<String?> {
        val nms = ArrayList<String?>()
        var i = 0
        try {
            for ((_, value1) in value!!) {

                //Get user map
                val singleUser = value1 as Map<*, *>
                nms.add(singleUser["name"] as String?)
                //Toast.makeText(MapsActivity.this, lats.get(i) +"|"+lngs.get(i), Toast.LENGTH_SHORT).show();
                i++
            }
        } catch (e: NullPointerException) {
            print("NullPointerException Caught")
        }
        return nms
    }


    companion object {
        var jcPlayerViewk: JcPlayerView? = null
        var palydet = 0
        var deeee = 0
        fun recivecallsstate(x: Int, context: Context?) {
            if (x == 1) {
                if (jcPlayerViewk!!.isPlaying) {
                    Toast.makeText(context, "music paused", Toast.LENGTH_SHORT).show()
                    jcPlayerViewk!!.pause()
                    deeee = 111
                }
            }
            if (x == 2) {
                if (jcPlayerViewk!!.isPaused) {
                    if (deeee == 111) {
                        Toast.makeText(context, "music played", Toast.LENGTH_SHORT).show()
                        jcPlayerViewk!!.playAudio(jcPlayerViewk!!.currentAudio!!)
                        deeee = 0
                    }
                }
            }
        }
    }

    init {
        palydet = 1
    }
}