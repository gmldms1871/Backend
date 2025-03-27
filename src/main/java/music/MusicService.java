package music;

import org.springframework.stereotype.Service;

@Service
public class MusicService {

    //장르에 따라서 어쩌고잉~
    public String recommendPlaylist(String genre){
        //하드코딩~
        String playlist = switch (genre){
            case "hiphop" -> "2025년 최고의 힙합";
            case "classic" -> "한국인이 좋아하는 클래식";
            default -> "봄에 어울리는 K-pop";
        };
        return genre + "장르의 playlist = " + playlist;
    }

    public String playMusic(String song){

        return "";
    }
}
