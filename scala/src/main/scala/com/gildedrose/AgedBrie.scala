package com.gildedrose

class AgedBrie(val it: Item) extends BaseItem(it) {
  override def update: Unit = {
    it.sellIn -= 1
    it.quality += 1
    if (it.sellIn < 0) it.quality += 1
  }
}
