package com.example.gferreir.multimidia;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends Activity implements MediaPlayer.OnPreparedListener {

    private MediaPlayer player;
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView = (VideoView) findViewById(R.id.videoView);
    }

    public void executarVideo(View v) {
        Uri uri = Uri.parse("android.resource://"+ getPackageName() +
                "/" + R.raw.sample);

        videoView.setVideoURI(uri);
        MediaController mc = new MediaController(this);
        videoView.setMediaController(mc);
        videoView.start();
    }

    public void executarMusicaArquivo(View v) {
        player = MediaPlayer.create(this, R.raw.kalimba);
        player.start();
    }

    public void parar(View v) {
        if(player.isPlaying()){
            player.stop();
        }
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        player.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        liberarPlayer();
    }

    private void liberarPlayer() {
        if(player != null){
            player.release();
        }
    }

}
