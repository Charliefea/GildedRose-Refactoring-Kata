package com.gildedrose

class Conjured(val it: Item)  extends BaseItemBehaviour(it) {
  override def update: Unit = {
    it.sellIn -= 1
    it.quality -= 2
    if(it.sellIn < 0) it.quality -= 2
    if(it.quality < 0) it.quality = 0
  }
}
