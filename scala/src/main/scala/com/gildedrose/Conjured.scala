package com.gildedrose

class Conjured(val it: Item)  extends BaseItem(it) {
  override def update: Unit = {
    it.sellIn -= 1
    if(it.quality == 0) return
    it.quality -= 2
    if(it.sellIn < 0) it.quality -= 2
    if(it.quality < 0) it.quality = 0
  }
}
