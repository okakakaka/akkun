package com.example.seiya.myapplication

import android.content.Context
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import android.os.Build

/**
 * 効果音の再生
 * http://hakoniwadesign.com/
 * 配布・再配布もご自由にどうぞ、無償、有償問いません。
 * ただし、一切の保証はありません。
 * あくまでも学習用のソースです。
 * Ver 2017/03/02
 */

class MySound {

    private var soundPool: SoundPool? = null    // 効果音を鳴らす本体（コンポ）
    private var mp3s: IntArray? = null

    ///////////////////////////////////////////////////
    fun onCreate(context: Context, mp3s: IntArray) {
        // ② 初期化（電源を入れる・コピペOK）
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            soundPool = SoundPool(5, AudioManager.STREAM_MUSIC, 0)
        } else {
            val attr = AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build()
            soundPool = SoundPool.Builder()
                    .setAudioAttributes(attr)
                    .setMaxStreams(5)
                    .build()
        }

        // ③ 読込処理(CDを入れる)
        this.mp3s = IntArray(mp3s.size)
        for (i in mp3s.indices) {
            this.mp3s!![i] = this.soundPool!!.load(context, mp3s[i], 1)
        }
    }

    // ④ 再生処理(再生ボタン)    //////////////////////////
    fun onPlay(number: Int) {
        this.soundPool!!.play(this.mp3s!![number], 1f, 1f, 0, 0, 1f)
    }

    // ⑤ 終了処理(電源のOFF)    //////////////////////////
    fun onDestroy() {
        this.soundPool!!.release()
    }
}
