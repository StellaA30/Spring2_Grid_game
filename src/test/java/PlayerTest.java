import org.example.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    private Player player;
    @BeforeEach
    public void setUp(){
        player = new Player(3, 5);
    }

    @Test
    public void ableToMove(){
        player.move(4,6);
        int newRow = player.getRow();
        int newCol = player.getColumn();
        assertEquals(4, newRow);
        assertEquals(6, newCol);
    }




}
