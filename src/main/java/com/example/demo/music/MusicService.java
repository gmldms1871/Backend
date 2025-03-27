package com.example.demo.music;

import org.springframework.stereotype.Service;

@Service
public class MusicService {

    public String recommendPlayList(String genre){
        String playList = switch (genre){
            case "hiphop" -> "2025년 최고의 힙합";
            case "classic" -> "한국인이 좋아하는 클래식";
            default -> "봄이 어울리는 k-팝" ;
        };
        return "";
    }

    public String playMusic(String Song) {
        return "";
    }

}
