package com.gildedrose;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.getItems()[0].name);
    }
    @Test
    void testConjuredItemDegrades() {
        Item[] items = new Item[] { new Item("Conjured Mana Strudel", 3, 6) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.getItems()[0].quality);
        assertEquals(2, app.getItems()[0].sellIn);
    }

    @Test
    void testConjuredItemAfterSellDate() {
        Item[] items = new Item[] { new Item("Conjured Mana Buns", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(6, app.getItems()[0].quality);
        assertEquals(-1, app.getItems()[0].sellIn);
    }

    @Test
    void testConjuredQualityNotNegative() {
        Item[] items = new Item[] { new Item("Conjured Mana Biscuits", 5, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.getItems()[0].quality);
    }


}
