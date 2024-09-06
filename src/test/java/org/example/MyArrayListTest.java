package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    private MyArrayList<Integer> myArrayList;
    MyArrayList<Car> cars = new MyArrayList<>();

    @BeforeEach
    void setUp() {
        myArrayList = new MyArrayList<>();
        myArrayList.add(43);
        myArrayList.add(10);
        myArrayList.add(20);

        Car ferrari = new Car(1990, "Ferrari 360 Spider", 310);
        Car lambo = new Car(2012, "Lamborghini Gallardo", 290);
        Car bugatti = new Car(2010, "Bugatti Veyron", 350);

        cars.add(ferrari);
        cars.add(lambo);
        cars.add(bugatti);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testAdd() {
        assertTrue(myArrayList.add(45));
        assertEquals(4, myArrayList.size());
        assertEquals(10, myArrayList.length());
        assertEquals(45, myArrayList.get(3));
    }

    @Test
    void testAddWithIndex() {
        assertTrue(myArrayList.add(1,1));
        assertTrue(myArrayList.add(1,99));
        assertEquals(5, myArrayList.size());
        assertEquals(10, myArrayList.length());
        assertEquals(43, myArrayList.get(0));
        assertEquals(99, myArrayList.get(1));
        assertEquals(1, myArrayList.get(2));
    }

    @Test
    void testGet() {
        assertEquals(20,myArrayList.get(2));
    }

    @Test
    void testRemove() {
        assertTrue(myArrayList.remove(1));
        assertEquals(2, myArrayList.size());
        assertEquals(10, myArrayList.length());
        assertEquals(43, myArrayList.get(0));
        assertEquals(20, myArrayList.get(1));
    }

    @Test
    void testClear() {
        assertTrue(myArrayList.clear());
        assertEquals(0, myArrayList.size());
        assertEquals(10, myArrayList.length());
    }

    @Test
    void testIntegerSort() {
        myArrayList.sort();
        assertEquals(10, myArrayList.get(0));
        assertEquals(20, myArrayList.get(1));
        assertEquals(43, myArrayList.get(2));
    }

    @Test
    void testCarCompareTo() {
        assertTrue((cars.get(0).compareTo(cars.get(1)))<0);
    }

    @Test
    void testCarManufactureYearSort() {
        cars.sort();
        assertEquals(1990, cars.get(0).getManufactureYear());
        assertEquals(2010, cars.get(1).getManufactureYear());
        assertEquals(2012, cars.get(2).getManufactureYear());
    }

    @Test
    void testSortWithComparator() {
        MaxSpeedComparator mySpeedComparator = new MaxSpeedComparator();
        cars.sort(mySpeedComparator);
        assertEquals(290, cars.get(0).getMaxSpeed());
        assertEquals(310, cars.get(1).getMaxSpeed());
        assertEquals(350, cars.get(2).getMaxSpeed());
    }

    @Test
    void testSet() {
        assertTrue(myArrayList.set(1,666));
        assertEquals(3, myArrayList.size());
        assertEquals(10, myArrayList.length());
        assertEquals(43, myArrayList.get(0));
        assertEquals(666, myArrayList.get(1));
        assertEquals(20, myArrayList.get(2));
    }

    @Test
    void testSize() {
        assertEquals(3, myArrayList.size());
    }

    @Test
    void TestLength() {
        assertEquals(10, myArrayList.length());
    }

    @Test
    void TestIsEmpty() {
        assertFalse(myArrayList.isEmpty());
        myArrayList.clear();
        assertTrue(myArrayList.isEmpty());
    }

    @Test
    void testResize() {
        myArrayList.clear();
        assertEquals(0, myArrayList.size());
        assertEquals(10, myArrayList.length());
        for (int i = 0; i < 1000; i++) {
            myArrayList.add(i);
        }
        assertEquals(1000, myArrayList.size());
        assertEquals(1280, myArrayList.length());

        for(int i =myArrayList.size()-1; i>=600; i-- ){
            myArrayList.remove(i);
        }
        assertEquals(600, myArrayList.size());
        assertEquals(640, myArrayList.length());
    }

    @Test
    void testIterator() {
        Iterator<Integer> integerIterator = myArrayList.iterator();
        if(integerIterator.hasNext()){
            assertEquals(43, integerIterator.next());
        }
        if(integerIterator.hasNext()){
            assertEquals(10, integerIterator.next());
        }
        if(integerIterator.hasNext()){
            assertEquals(20, integerIterator.next());
        }
    }


    @Test
    void testConstructor(){
        MyArrayList<Double> doubles = new MyArrayList<>();
        assertEquals(10, doubles.length());
    }

    @Test
    void testConstructorWithZeroCapacity(){
        MyArrayList<Double> doubles = new MyArrayList<>(0);
        assertEquals(10, doubles.length());
    }

    @Test
    void testConstructorWithCapacity(){
        MyArrayList<Double> doubles = new MyArrayList<>(30);
        assertEquals(30, doubles.length());
    }

    @Test
    void testCarConstructor(){
        Car ferrari = new Car(1990, "Ferrari 360 Spider", 310);
        assertEquals(1990, ferrari.getManufactureYear());
        assertEquals("Ferrari 360 Spider", ferrari.getModel());
        assertEquals(310, ferrari.getMaxSpeed());
    }

}