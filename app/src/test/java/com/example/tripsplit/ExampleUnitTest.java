package com.example.tripsplit;

import com.example.tripsplit.Model.ItemModel;
import com.example.tripsplit.Model.PersonModel;
import com.example.tripsplit.Model.TripModel;
import com.example.tripsplit.Model.UserOpModel;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    ItemModel multi = new ItemModel("A","B","C","D");

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
    /*
    ItemModel
     */
    @Test
    public void constructor_model(){
        ItemModel test = new ItemModel("A","B","C","D");
        assertNotNull(test);
    }
    @Test
    public void get_trip_name(){
        assertEquals("A",multi.getTripName());
    }
    @Test
    public void get_trip_desc(){
        assertEquals("B",multi.getTripDescription());
    }
    @Test
    public void get_trip_total(){
        assertEquals("C",multi.getUserTotal());
    }
    @Test
    public void get_trip_code(){
        assertEquals("D",multi.getTripCode());
    }
    /*
    PersonModel
     */
    PersonModel m = new PersonModel("x","y");
    @Test
    public void constructor_personmodel(){
        PersonModel n = new PersonModel("l","p");
        assertNotNull(n);
    }
    @Test
    public void get_first(){
        assertEquals("x",m.getFirstname());
    }
    @Test
    public void get_last(){
        assertEquals("y",m.getLastname());
    }
    /*
    UserOpModel
     */
    UserOpModel h = new UserOpModel("x","y","z");
    @Test
    public void constructor_userop(){
        UserOpModel k = new UserOpModel("f","g","s");
        assertNotNull(k);
    }
    @Test
    public void get_sender(){
        assertEquals("x",h.getSender());
    }
    @Test
    public void get_operation(){
        assertEquals("y",h.getOperationMSG());
    }
    @Test
    public void get_recipent(){
        assertEquals("z",h.getRecipent());
    }
    /*
    TripModel
     */
    TripModel v = new TripModel("x","y","z");
    @Test
    public void get_trip_m_name(){
        assertEquals("x",v.getTripName());
    }
    @Test
    public void constructor_tripModel(){
        TripModel d = new TripModel("g","s","d");
        assertNotNull(d);
    }
    @Test
    public void get_trip_m_desc(){
        assertEquals("y",v.getTripDesc());
    }
    @Test
    public void get_trip_m_num(){
        assertEquals("z",v.getTripNum());
    }
}