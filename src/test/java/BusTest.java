import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class BusTest {

    private Bus bus;
    private Person person1;
    private Person person2;
    private Person person3;
    private Person person4;
    private BusStop busStop;

    @Before
    public void before(){
        bus = new Bus("Glasgow", 3);
        person1 = new Person();
        person2 = new Person();
        person3 = new Person();
        person4 = new Person();
        busStop = new BusStop("Argyle street");
        busStop.addToQueue(person1);
    }

    @Test
    public void startEmpty(){
        assertEquals(0, bus.passengerCount());
    }

    @Test
    public void canAddPassengers(){
        bus.addPassenger(person1);
        bus.addPassenger(person2);
        assertEquals(2, bus.passengerCount());
    }

    @Test
    public void cannotAddPassenger(){
        bus.addPassenger(person1);
        bus.addPassenger(person2);
        bus.addPassenger(person3);
        bus.addPassenger(person4);
        assertEquals(3, bus.passengerCount());
    }

    @Test
    public void canRemovePassenger(){
        bus.addPassenger(person1);
        bus.addPassenger(person2);
        bus.removePassenger(person1);
        assertFalse(bus.getPassengers().contains(person1));
        assertEquals(1, bus.passengerCount());
    }

    @Test
    public void canPickUp(){
        bus.pickUpFromBusStop(busStop);
        assertEquals(1, bus.passengerCount());
        assertEquals(0, busStop.queueCout());
    }

    @Test
    public void cannotRemoveAsBusStopIsEmpty(){
        busStop.removeFromQueue();
        bus.pickUpFromBusStop(busStop);
        assertEquals(0, bus.passengerCount());
    }
    
}
