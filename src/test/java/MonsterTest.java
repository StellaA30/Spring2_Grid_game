import org.example.Monster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MonsterTest {

    private Monster monster;

    @BeforeEach
    public void setUp(){
        monster = new Monster('V', "venom says psst...", "Venom");
    }

    @Test
    public void getSymbol(){
        assertEquals('V', monster.getSymbol());
    }

    @Test
    public void setSymbol(){
        monster.setSymbol('D');
        assertEquals('D', monster.getSymbol());
    }

    @Test
    public void getGreeting() {
        String expectedGreeting = "venom says psst...";
        String actualGreeting = monster.getGreeting();
        assertEquals(expectedGreeting, actualGreeting);
    }

    @Test
    public void getName() {
        assertEquals("Venom", monster.getName());
    }

    @Test
    public void setName(){
        monster.setName("Demon");
        assertEquals("Demon", monster.getName());
    }



}
