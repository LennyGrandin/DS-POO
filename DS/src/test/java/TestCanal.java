import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCanal
{

    @Test
    public void compareToEntreCanaux() throws ActionNonAutoriseeException
    {
        Canal c1 = new Canal();
        c1.setOrdre(2);
        Canal c2 = new Canal();
        c2.setOrdre(0);	
        
        Assert.assertTrue(c1.compareTo(c2) > 0);
    }
}
