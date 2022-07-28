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

class EnglishLectureFragment : Fragment() {
    var backfromenglishlectures: ImageButton? = null
    var storage: FirebaseStorage? = null
    var storageReference: StorageReference? = null
    var mDataReference: DatabaseReference? = null
    var al: ArrayList<String?>? = ArrayList()
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
        val view =
            inflater.inflate(R.layout.fragment_srila_prabhupada_english_lectures, container, false)
        MainActivity.screen = "spel"
        jcPlayerViewspel = view.findViewById(R.id.jcplayerspel)
        player = MediaPlayer()
        storage = FirebaseStorage.getInstance()
        storageReference = storage!!.reference
        songsList = view.findViewById(R.id.songsList)
        mDataReference = FirebaseDatabase.getInstance().getReference("englishlectures")
        mDataReference!!.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                al = collectnms(dataSnapshot.value as Map<String, Any>?)
                al2 = collecturls(dataSnapshot.value as Map<String, Any>?)
                val audio = dataSnapshot.getValue(
                    AudioModel::class.java
                ) ?: return
                alname.add(audio.name)
                al2urls.add(audio.url)
                if (al == null) return
                for (i in al!!.indices) {
                    jcAudios.add(JcAudio.createFromURL(al!![i]!!, al2[i]!!))
                }
                if (jcAudios.size != 0){
                    jcPlayerViewspel?.initPlaylist(jcAudios, null)
                    songsList?.visibility = View.VISIBLE
                    songsList
                    if (context != null) songsList?.adapter = ArrayAdapter(
                        context!!,
                        android.R.layout.simple_list_item_1,
                        al!!
                    )
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })
        songsList?.onItemClickListener =
            OnItemClickListener { parent: AdapterView<*>?, view1: View?, position: Int, id: Long ->
                Toast.makeText(
                    context, "Playing wait seconds ...", Toast.LENGTH_LONG
                ).show()
                jcPlayerViewspel?.playAudio(jcAudios[position])
                jcPlayerViewspel?.visibility = View.VISIBLE
                KirtanFragment.jcPlayerViewk?.createNotification()
            }
        backfromenglishlectures?.setOnClickListener(View.OnClickListener setOnClickListener@{ v: View? ->
            if (parentFragmentManager == null) return@setOnClickListener
            val fragmentTransaction = parentFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.main_frame, AudioFragment())
            fragmentTransaction.commit()
        })
        return view
    }

    private fun collecturls(value: Map<String, Any>?): ArrayList<String?> {
        val urls = ArrayList<String?>()
        try {
            for ((_, value1) in value!!) {
                val singleUser = value1 as Map<*, *>
                urls.add(singleUser["url"] as String?)
            }
        } catch (e: NullPointerException) {
            print("NullPointerException Caught")
        }
        return urls
    }

    private fun collectnms(value: Map<String, Any>?): ArrayList<String?> {
        val nms = ArrayList<String?>()
        try {
            for ((_, value1) in value!!) {
                val singleUser = value1 as Map<*, *>
                nms.add(singleUser["name"] as String?)
            }
        } catch (e: NullPointerException) {
            print("NullPointerException Caught")
        }
        return nms
    }

    companion object {
        var jcPlayerViewspel: JcPlayerView? = null
        var deeee2 = 0
        fun recivecallsstate(x: Int, context: Context?) {
            if (x == 1) {
                if (jcPlayerViewspel!!.isPlaying) {
                    Toast.makeText(context, "music paused", Toast.LENGTH_SHORT).show()
                    jcPlayerViewspel!!.pause()
                    deeee2 = 1112
                }
            }
            if (x == 2) {
                if (jcPlayerViewspel!!.isPaused) {
                    if (deeee2 == 1112) {
                        Toast.makeText(context, "music played", Toast.LENGTH_SHORT).show()
                        Objects.requireNonNull(jcPlayerViewspel?.currentAudio)?.let {
                            jcPlayerViewspel?.playAudio(it)
                        }
                        deeee2 = 0
                    }
                }
            }
        }
    }

    init {
        KirtanFragment.palydet = 3
    }
}