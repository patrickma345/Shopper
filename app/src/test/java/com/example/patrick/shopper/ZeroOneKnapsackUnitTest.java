package com.example.patrick.shopper;

import com.example.patrick.shopper.Utility.ZeroOneKnapsack;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by patrick on 18/01/18.
 */

public class ZeroOneKnapsackUnitTest {

    private final Double BUDGET = 5.00;
    private ZeroOneKnapsack knapsack;
    private double  DEFAULT_VALUE = 1.0;


    @Before
    public void setUp() {
        knapsack = new ZeroOneKnapsack(BUDGET);
        knapsack.initKnapsack();
    }

    /**
     * Test the boundary if we get the expected result when we enter a budget of 0.
     */
    @Test
    public void calcUnitsZeroTestHighAccuracy() {
        double amount = 0.0;

        knapsack.setUnitAccuracy(ZeroOneKnapsack.HIGH_ACCURACY_UNIT); //1 cent accuracy
        assertEquals(0, knapsack.calcUnits(amount, true));
        assertEquals(0, knapsack.calcUnits(amount, false));
    }

    /**
     * Test the boundary if we get the expected result when we enter a budget of 0.
     */
    @Test
    public void calcUnitsZeroTestMediumAccuracy() {
        double amount = 0.0;

        knapsack.setUnitAccuracy(ZeroOneKnapsack.MEDIUM_ACCURACY_UNIT); //10 cent accuracy
        assertEquals(0, knapsack.calcUnits(amount, true));
        assertEquals(0, knapsack.calcUnits(amount, false));
    }
    /**
     * Test the boundary if we get the expected result when we enter a budget of 0.
     */
    @Test
    public void calcUnitsZeroTestLowAccuracy() {
        double amount = 0.0;

        knapsack.setUnitAccuracy(ZeroOneKnapsack.LOW_ACCURACY_UNIT); //100 cent accuracy
        assertEquals(0, knapsack.calcUnits(amount, true));
        assertEquals(0, knapsack.calcUnits(amount, false));
    }


    /**
     * Test if we get the correct result if we enter an amount that does not need rounding.
     */
    @Test
    public void calcUnitsNormalTestHighAccuracy() {
        knapsack.setUnitAccuracy(ZeroOneKnapsack.HIGH_ACCURACY_UNIT); //1 cent accuracy

        double amount = 5.50;
        assertEquals(550, knapsack.calcUnits(amount, true));
        assertEquals(550, knapsack.calcUnits(amount, false));

        double amount2 = 5.00;
        assertEquals(500, knapsack.calcUnits(amount2, true));
        assertEquals(500, knapsack.calcUnits(amount2, false));

        double amount3 = 5.40;
        assertEquals(540, knapsack.calcUnits(amount3, true));
        assertEquals(540, knapsack.calcUnits(amount3, false));
    }

    /**
     * Test if we get the correct result if we enter an amount that does not need rounding.
     */
    @Test
    public void calcUnitsNormalTestMediumAccuracy() {
        knapsack.setUnitAccuracy(ZeroOneKnapsack.MEDIUM_ACCURACY_UNIT); //10 cent accuracy

        double amount = 5.50;
        assertEquals(55, knapsack.calcUnits(amount, true));
        assertEquals(55, knapsack.calcUnits(amount, false));

        double amount2 = 5.00;
        assertEquals(50, knapsack.calcUnits(amount2, true));
        assertEquals(50, knapsack.calcUnits(amount2, false));

        double amount3 = 5.40;
        assertEquals(54, knapsack.calcUnits(amount3, true));
        assertEquals(54, knapsack.calcUnits(amount3, false));
    }

    /**
     * Test if we get the correct result if we enter an amount that does not need rounding.
     */
    @Test
    public void calcUnitsNormalTestLowAccuracy() {
        knapsack.setUnitAccuracy(ZeroOneKnapsack.LOW_ACCURACY_UNIT); //100 cent accuracy

        double amount = 5.50;
        assertEquals(6, knapsack.calcUnits(amount, true));
        assertEquals(5, knapsack.calcUnits(amount, false));

        double amount2 = 5.00;
        assertEquals(5, knapsack.calcUnits(amount2, true));
        assertEquals(5, knapsack.calcUnits(amount2, false));

        double amount3 = 5.40;
        assertEquals(6, knapsack.calcUnits(amount3, true));
        assertEquals(5, knapsack.calcUnits(amount3, false));
    }

    /**
     * Test if we get the correct result if we enter an amount that needs rounding.
     */
    @Test
    public void calcUnitsTestHighAccuracy() {
        knapsack.setUnitAccuracy(ZeroOneKnapsack.HIGH_ACCURACY_UNIT); //1 cent accuracy

        double amount = 5.55;
        assertEquals(555, knapsack.calcUnits(amount, true));
        assertEquals(555, knapsack.calcUnits(amount, false));

        double amount2 = 5.54;
        assertEquals(554, knapsack.calcUnits(amount2, true));
        assertEquals(554, knapsack.calcUnits(amount2, false));

        double amount3 = 5.00;
        assertEquals(500, knapsack.calcUnits(amount3, true));
        assertEquals(500, knapsack.calcUnits(amount3, false));
    }

    /**
     * Test if we get the correct result if we enter an amount that needs rounding.
     */
    @Test
    public void calcUnitsTestMediumAccuracy() {
        knapsack.setUnitAccuracy(ZeroOneKnapsack.MEDIUM_ACCURACY_UNIT); //10 cent accuracy

        double amount = 5.55;
        assertEquals(56, knapsack.calcUnits(amount, true));
        assertEquals(55, knapsack.calcUnits(amount, false));

        double amount2 = 5.54;
        assertEquals(56, knapsack.calcUnits(amount2, true));
        assertEquals(55, knapsack.calcUnits(amount2, false));

        double amount3 = 5.00;
        assertEquals(50, knapsack.calcUnits(amount3, true));
        assertEquals(50, knapsack.calcUnits(amount3, false));
    }

    /**
     * Test if we get the correct result if we enter an amount that needs rounding.
     */
    @Test
    public void calcUnitsTestLowAccuracy() {
        knapsack.setUnitAccuracy(ZeroOneKnapsack.LOW_ACCURACY_UNIT); //100 cent accuracy

        double amount = 5.55;
        assertEquals(6, knapsack.calcUnits(amount, true));
        assertEquals(5, knapsack.calcUnits(amount, false));

        double amount2 = 5.54;
        assertEquals(6, knapsack.calcUnits(amount2, true));
        assertEquals(5, knapsack.calcUnits(amount2, false));

        double amount3 = 5.00;
        assertEquals(5, knapsack.calcUnits(amount3, true));
        assertEquals(5, knapsack.calcUnits(amount3, false));
    }

    /**
     * Test if we are able to add items properly.
     */
    @Test
    public void addItemsTest() {
        String info1 = "A";
        String info2 = "B";
        String info3 = "C";

        double cost1 = 1.00;
        double cost2 = 1.10;
        double cost3 = 1.20;

        ZeroOneKnapsack.Item modelItem1 = knapsack.new Item(info1, cost1, knapsack.calcUnits(cost1, true), DEFAULT_VALUE);
        ZeroOneKnapsack.Item modelItem2 = knapsack.new Item(info2, cost2, knapsack.calcUnits(cost2, true), DEFAULT_VALUE);
        ZeroOneKnapsack.Item modelItem3 = knapsack.new Item(info3, cost3, knapsack.calcUnits(cost3, true), DEFAULT_VALUE);

        knapsack.addItem(info1, cost1);
        knapsack.addItem(info2, cost2);
        knapsack.addItem(info3, cost3);

        ArrayList<ZeroOneKnapsack.Item> retrievedItems = knapsack.getItems();

        //At index 0 there is an Item object that is used to represent the situation of
        //no items being added in the algorithm. Indexes > 0 are the actual items.
        assertEquals(modelItem1, retrievedItems.get(1));
        assertEquals(modelItem2, retrievedItems.get(2));
        assertEquals(modelItem3, retrievedItems.get(3));
    }

    /**
     * Test if the correct items can be retrieved.
     */
    @Test
    public void solveTest() {
        knapsack.addItem("A", 1.00);
        knapsack.addItem("B", 1.20);
        knapsack.addItem("C", 5.00);
        knapsack.addItem("D", 2.10);
        knapsack.addItem("E", 0.90);
        knapsack.addItem("F", 0.70);

        //System.out.println(knapsack.getItems());

        String modelSolution = "A\nB\nD\nF";

        String solution = knapsack.solve();

        //knapsack.displayBoard();

        //System.out.println(solution);

        assertTrue(modelSolution.equals(solution));
    }

    /**
     * Test if the algorithm gives the correct result when no items are added.
     */
    @Test
    public void solveTestNone() {
        String modelSolution = "";
        String solution = knapsack.solve();
        assertTrue(modelSolution.equals(solution));
    }

}
