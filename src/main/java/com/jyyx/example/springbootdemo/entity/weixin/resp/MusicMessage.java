package com.jyyx.example.springbootdemo.entity.weixin.resp;

/**
 * 音乐消息
 */
public class MusicMessage extends RespMessage{
    //音乐
    private Music music;

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }
}
