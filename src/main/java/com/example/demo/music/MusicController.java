package com.example.demo.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/music")

public class MusicController {
    private final MusicService musicService;

    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }
    //장르를 요청받아 플레이리스트 추천
    @GetMapping("/recommend")
    public String getRecommend(@RequestParam("genre") String genre) {
        return musicService.recommendPlaylist(genre);
    }

    //재생 음악을 요청받아 음악 재생
    @PostMapping("/play")
    public String playSong (String song) {
        return "";
    }

}