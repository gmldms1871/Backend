package music;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/music")
public class MusicController {
    private final MusicService musicService;
    //생성자입니다. (단일생성자일때 사용 하는방법이랍니다.)
    public MusicController(MusicService musicService){
        this.musicService = musicService;
    }
    //장르 요청받아 플레이리스트 추천
    @GetMapping("/recommend") //4061/user?id:1234 중요한 정보가 아닐때 보안성 약함.
    //걍 대충 GetMapping, RequestParam이랑 세트라 생각하셈;
    public String getRecommend(@RequestParam("genre") String genre){
        //String playList = musicService.recommendPlaylist(genre); 줄여서 리턴에 입력.
        return musicService.recommendPlaylist(genre);
    }
    //재생 음악을 요청받아 음악 재생
    @PostMapping("/play") // 4061/user
    public String playSong(String song){

        return "";
    }
}
