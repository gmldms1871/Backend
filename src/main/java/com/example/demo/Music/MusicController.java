package com.example.demo.Music;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Music")
public class MusicController {
    private final MusicService musicService;
    //생성자 주입 함수(단일 생성자일 때만)
    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }

    //장르를 요청받아 플레이리스트 추천
    @GetMapping("/recommend")
    public String getRecommend(@RequestParam("genre") String genre) {
        //playlist = musicService.recommendPlaylist(genre);
        return musicService.recommendPlaylist(genre);
    }
    //재생 음악을 요청받아 음악 재생
    @PostMapping("/play")
    public String playSong(String song) {
        return "";
    }
}
