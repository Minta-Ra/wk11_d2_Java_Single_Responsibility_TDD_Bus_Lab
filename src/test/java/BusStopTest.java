import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusStopTest {

    private Person person;
    private BusStop busStop;

    @Before
    public void before(){
        person = new Person();
        busStop = new BusStop("Argyle street");
    }

    @Test
    public void canAddPersonToQueue(){
        busStop.addToQueue(person);
        assertEquals(1, busStop.queueCout());
    }

    @Test
    public void canRemovePersonFromQueue(){
        busStop.addToQueue(person);
        busStop.addToQueue(person);
        busStop.removeFromQueue();
        assertEquals(1, busStop.queueCout());
    }




}
