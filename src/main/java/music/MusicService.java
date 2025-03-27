package music;

import org.springframework.stereotype.Service;

@Service
public class MusicService {
    public String recommendPlayList(String genre) {
        String playlist = switch (genre) {
            case "hiphop" -> "2025년 최고의 힙합";
            case "classic" -> "한국인이 좋아하는 클래식";
            default -> "봄에 어울리는 k-팝";
        };
    }
}
