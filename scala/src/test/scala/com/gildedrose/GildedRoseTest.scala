package com.gildedrose

import org.scalatest._

class GildedRoseTest  extends FlatSpec with Matchers {
      it should "reduce sell by date by 1 and quality by one for a normal item " in {
        val items = Array[Item](new Item("Normal", 1, 1))
        val app = new GildedRose(items)
        app.updateQuality()
        (app.items(0).name) should equal ("Normal")
        (app.items(0).sellIn) should equal (0)
        (app.items(0).quality) should equal (0)
      }

      it should "reduce quality by 2 after sell by date is passed " in {
        val items = Array[Item](new Item("Normal", 0, 10))
        val app = new GildedRose(items)
        app.updateQuality()
        (app.items(0).name) should equal ("Normal")
        (app.items(0).sellIn) should equal (-1)
        (app.items(0).quality) should equal (8)
      }

      it should "never let quality become negative" in {
        val items = Array[Item](new Item("Normal", 0, 0))
        val app = new GildedRose(items)
        app.updateQuality()
        (app.items(0).name) should equal ("Normal")
        (app.items(0).sellIn) should equal (-1)
        (app.items(0).quality) should equal (0)
      }
      it should "never let quality become negative if after sell by date" in {
        val items = Array[Item](new Item("Normal", -1, 1))
        val app = new GildedRose(items)
        app.updateQuality()
        (app.items(0).name) should equal ("Normal")
        (app.items(0).sellIn) should equal (-2)
        (app.items(0).quality) should equal (0)
      }
      it should "increase the quality if not already above 50 if it is less than 5 days to concert" in {
        val items = Array[Item](new Item("Backstage passes to a TAFKAL80ETC concert", 1, 49))
        val app = new GildedRose(items)
        app.updateQuality()
        (app.items(0).name) should equal ("Backstage passes to a TAFKAL80ETC concert")
        (app.items(0).sellIn) should equal (0)
        (app.items(0).quality) should equal (50)
      }
      it should "increase the quality if not already above 50 if it is less than 10 days to concert" in {
        val items = Array[Item](new Item("Backstage passes to a TAFKAL80ETC concert", 8, 49))
        val app = new GildedRose(items)
        app.updateQuality()
        (app.items(0).name) should equal ("Backstage passes to a TAFKAL80ETC concert")
        (app.items(0).sellIn) should equal (7)
        (app.items(0).quality) should equal (50)
      }

      it should "increase the quality of Aged Brie every day" in {
        val items = Array[Item](new Item("Aged Brie", 1, 1))
        val app = new GildedRose(items)
        app.updateQuality()
        (app.items(0).name) should equal ("Aged Brie")
        (app.items(0).sellIn) should equal (0)
        (app.items(0).quality) should equal (2)
      }

      it should "increase in quality of Aged Brie by 2 past if passed its sell by date" in {
        val items = Array[Item](new Item("Aged Brie", 0, 1))
        val app = new GildedRose(items)
        app.updateQuality()
        (app.items(0).name) should equal ("Aged Brie")
        (app.items(0).sellIn) should equal (-1)
        (app.items(0).quality) should equal (3)
      }

      it should "increase the quality of Backstage passes to a TAFKAL80ETC concert by 3 if less than 5 days from concert " in {
        val items = Array[Item](new Item("Backstage passes to a TAFKAL80ETC concert",1 , 1))
        val app = new GildedRose(items)
        app.updateQuality()
        (app.items(0).name) should equal ("Backstage passes to a TAFKAL80ETC concert")
        (app.items(0).sellIn) should equal (0)
        (app.items(0).quality) should equal (4)
      }

      it should "increase the quality of Backstage passes to a TAFKAL80ETC concert by 2 if between 6 and 10 days from concert " in {
        val items = Array[Item](new Item("Backstage passes to a TAFKAL80ETC concert", 8, 1))
        val app = new GildedRose(items)
        app.updateQuality()
        (app.items(0).name) should equal ("Backstage passes to a TAFKAL80ETC concert")
        (app.items(0).sellIn) should equal (7)
        (app.items(0).quality) should equal (3)
      }

      it should "increase the quality of Backstage passes to a TAFKAL80ETC concert by 1 if more than 20 days away " in {
        val items = Array[Item](new Item("Backstage passes to a TAFKAL80ETC concert",20, 1))
        val app = new GildedRose(items)
        app.updateQuality()
        (app.items(0).name) should equal ("Backstage passes to a TAFKAL80ETC concert")
        (app.items(0).sellIn) should equal (19)
        (app.items(0).quality) should equal (2)
      }

      it should "reduce the quality to 0 of Backstage passes to a TAFKAL80ETC concert after concert " in {
        val items = Array[Item](new Item("Backstage passes to a TAFKAL80ETC concert", 0 ,-1 ))
        val app = new GildedRose(items)
        app.updateQuality()
        (app.items(0).name) should equal ("Backstage passes to a TAFKAL80ETC concert")
        (app.items(0).sellIn) should equal (-1)
        (app.items(0).quality) should equal (0)
      }

      it should "never decrease in quality or changes sell by date of Sulfuras, Hand of Ragnaros" in {
        val items = Array[Item](new Item("Sulfuras, Hand of Ragnaros", 1, 80))
        val app = new GildedRose(items)
        app.updateQuality()
        (app.items(0).name) should equal ("Sulfuras, Hand of Ragnaros")
        (app.items(0).sellIn) should equal (1)
        (app.items(0).quality) should equal (80)
      }
      it should "reduce sell by date by 2 and quality by one for a conjured item " in {
        val items = Array[Item](new Item("Conjured", 1, 2))
        val app = new GildedRose(items)
        app.updateQuality()
        (app.items(0).name) should equal ("Conjured")
        (app.items(0).sellIn) should equal (0)
        (app.items(0).quality) should equal (0)
      }

      it should "reduce quality by 4 after sell by date is passed for conjured items " in {
        val items = Array[Item](new Item("Conjured", 0, 10))
        val app = new GildedRose(items)
        app.updateQuality()
        (app.items(0).name) should equal ("Conjured")
        (app.items(0).sellIn) should equal (-1)
        (app.items(0).quality) should equal (6)
      }
      it should "never reduce quaility to below 0 for conjured items " in {
        val items = Array[Item](new Item("Conjured", 0, 0))
        val app = new GildedRose(items)
        app.updateQuality()
        (app.items(0).name) should equal ("Conjured")
        (app.items(0).sellIn) should equal (-1)
        (app.items(0).quality) should equal (0)
      }
}