package com.gildedrose

class BackstagePass(val it: Item)  extends BaseItem(it) {
  override def update: Unit = {
    it.sellIn -= 1
    it.quality += 1
    if (it.sellIn < 11) it.quality += 1
    if (it.sellIn < 5) it.quality += 1
    if (it.quality > 50) it.quality = 50
    if (it.sellIn < 0) it.quality = 0
  }
}
