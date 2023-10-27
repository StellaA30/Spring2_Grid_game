import org.example.Grid;
import org.example.Monster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class GridTest {

    private Grid grid;

    @Mock
    private Monster monster1;

    @Mock
    private Monster monster2;

    @Mock
    private Monster monster3;

    @BeforeEach
    public void setUp(){
        grid = new Grid(6, 6);

    }




}


