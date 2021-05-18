import mathDefinitions.model.Def;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeinitionLoadTest {

    @Test

    public void loadTest(){
        Assertions.assertEquals(0, Def.definitions.size());
        Def.load("Test/test.xml");
        Assertions.assertEquals(3, Def.definitions.size());
    }

}
