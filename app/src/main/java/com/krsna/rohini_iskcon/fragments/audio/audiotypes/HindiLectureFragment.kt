package com.krsna.rohini_iskcon.fragments.audio.audiotypes

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import com.example.jean.jcplayer.model.JcAudio
import com.example.jean.jcplayer.view.JcPlayerView
import com.krsna.rohini_iskcon.MainActivity
import com.krsna.rohini_iskcon.R
import com.krsna.rohini_iskcon.fragments.audio.AudioModel
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.util.*

class HindiLectureFragment : Fragment() {
    var storage: FirebaseStorage? = null
    var storageReference: StorageReference? = null
    var mDataReference: DatabaseReference? = null
    var al = ArrayList<String?>()
    var al2 = ArrayList<String?>()
    var songsList: ListView? = null
    private var player: MediaPlayer? = null
    var jcAudios = ArrayList<JcAudio>()
    var alname = ArrayList<String?>()
    var al2urls = ArrayList<String?>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_srila_prabhupada_hindi_lectures, container, false)
        com.krsna.rohini_iskcon.MainActivity.screen = "sphl"
        jcPlayerViewsphl = view.findViewById(R.id.jcplayersphl)
        player = MediaPlayer()
        storage = FirebaseStorage.getInstance()
        storageReference = storage?.reference
        songsList = view.findViewById<View>(R.id.songsList) as ListView
        mDataReference = FirebaseDatabase.getInstance().getReference("HindhiLectures")
        mDataReference?.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                al = collectnms(dataSnapshot.value as Map<String, Any>?)
                al2 = collectUrls(dataSnapshot.value as Map<String, Any>?)
                val audio = dataSnapshot.getValue(
                    AudioModel::class.java
                )
                alname.add(audio?.name)
                al2urls.add(audio?.url)
                for (i in al.indices) {
                    jcAudios.add(JcAudio.createFromURL(al[i]!!, al2[i]!!))
                }
                if (jcAudios.size != 0) {
                    jcPlayerViewsphl?.initPlaylist(jcAudios, null)
                    songsList!!.visibility = View.VISIBLE
                    if (context != null) songsList!!.adapter =
                        ArrayAdapter(context!!, android.R.layout.simple_list_item_1, al)
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })
        songsList?.onItemClickListener =
            OnItemClickListener { parent: AdapterView<*>?, view: View?, position: Int, id: Long ->
                Toast.makeText(context, "Playing wait seconds ...", Toast.LENGTH_SHORT).show()
                jcPlayerViewsphl?.playAudio(jcAudios[position])
                jcPlayerViewsphl?.visibility = View.VISIBLE
                KirtanFragment.jcPlayerViewk?.createNotification()
            }
        return view
    }

    private fun collectUrls(value: Map<String, Any>?): ArrayList<String?> {
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
        var jcPlayerViewsphl: JcPlayerView? = null
        var deeee3 = 0
        fun recivecallsstate(x: Int, context: Context?) {
            if (x == 1) {
                if (jcPlayerViewsphl!!.isPlaying) {
                    Toast.makeText(context, "music paused", Toast.LENGTH_SHORT).show()
                    jcPlayerViewsphl!!.pause()
                    deeee3 = 1113
                }
            }
            if (x == 2) {
                if (jcPlayerViewsphl!!.isPaused) {
                    if (deeee3 == 1113) {
                        Toast.makeText(context, "music played", Toast.LENGTH_SHORT).show()
                        Objects.requireNonNull(jcPlayerViewsphl?.currentAudio)?.let {
                            jcPlayerViewsphl!!.playAudio(
                                it
                            )
                        }
                        deeee3 = 0
                    }
                }
            }
        }
    }

    init {
        KirtanFragment.palydet = 4
    }
}