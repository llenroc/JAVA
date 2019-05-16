package mymockito;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CityTest {

    @Mock
    private Street street;

    @InjectMocks
    private City city;

    private String actualBuilding ="Museum";
    @Test
    public void displayBuildingTest() throws Exception {
        Mockito.when(city.displayBuilding()).thenReturn("Museum");

        assertEquals("City has the building: "+actualBuilding, city.displayBuilding());
    }

}
