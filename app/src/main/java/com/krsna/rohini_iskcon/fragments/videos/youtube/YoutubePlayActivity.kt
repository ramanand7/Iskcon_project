package com.krsna.rohini_iskcon.fragments.videos.youtube

import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView
import android.os.Bundle
import android.widget.GridLayout
import android.widget.TextView
import android.widget.Toast
import com.krsna.rohini_iskcon.R
import com.krsna.rohini_iskcon.fragments.audio.audiotypes.EnglishLectureFragment
import com.krsna.rohini_iskcon.fragments.audio.audiotypes.HindiLectureFragment
import com.krsna.rohini_iskcon.fragments.audio.audiotypes.KirtanFragment
import com.krsna.rohini_iskcon.fragments.audio.audiotypes.SpecialLectureFragment
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer.*

class YoutubePlayActivity :  YouTubeBaseActivity(), OnInitializedListener,
    PlayerStateChangeListener, PlaybackEventListener {

    private var videoId: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.youtube_play_item)

        HindiLectureFragment.jcPlayerViewsphl?.pause()
        SpecialLectureFragment.jcPlayerViewsl?.pause()
        EnglishLectureFragment.jcPlayerViewspel?.pause()
        KirtanFragment.jcPlayerViewk?.pause()

        val tvDescription: TextView = findViewById(R.id.tv_description)
        videoId = intent.getStringExtra("videoid")
        tvDescription.text = intent.getStringExtra("description")
        val youTubePlayerView: YouTubePlayerView = findViewById(R.id.player)
        youTubePlayerView.initialize("AIzaSyANVa1zQsriz7v5h6g40X0qEaSi0XKVWdg", this)
    }

    override fun onInitializationSuccess(
        provider: Provider,
        youTubePlayer: YouTubePlayer,
        b: Boolean
    ) {
        youTubePlayer.setPlayerStateChangeListener(this)
        youTubePlayer.setPlaybackEventListener(this)
        if (!b) {
            youTubePlayer.cueVideo(videoId)
        }
    }

    override fun onInitializationFailure(
        provider: Provider,
        youTubeInitializationResult: YouTubeInitializationResult
    ) {
        Toast.makeText(this, "Failed to Play video!", Toast.LENGTH_SHORT).show()
    }

    override fun onPlaying() {}
    override fun onPaused() {}
    override fun onStopped() {}
    override fun onBuffering(b: Boolean) {}
    override fun onSeekTo(i: Int) {}
    override fun onLoading() {}
    override fun onLoaded(s: String) {}
    override fun onAdStarted() {}
    override fun onVideoStarted() {}
    override fun onVideoEnded() {}
    override fun onError(errorReason: ErrorReason) {}
}