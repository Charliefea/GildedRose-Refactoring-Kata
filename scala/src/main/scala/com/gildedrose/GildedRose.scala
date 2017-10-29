package com.gildedrose

class GildedRose(val items: Array[Item]) {

  def updateQuality() {
    for (i <- 0 until items.length) {
      if (items(i).name.equals("Backstage passes to a TAFKAL80ETC concert")) new BackstagePass(items(i)).updateQuality
      else if (items(i).name.equals("Sulfuras, Hand of Ragnaros")) new Sulfuras(items(i)).updateQuality
      else if (items(i).name.equals("Aged Brie")) new AgedBrie(items(i)).updateQuality
      else new Normal(items(i)).updateQuality
    }
  }
}


class ItemFactory(val item: Item) {
  def updateQuality: Unit = {
  }
}

class Normal(val item: Item)  {
  def updateQuality: Unit = {
    item.sellIn -= 1
    if(item.quality == 0) return
    item.quality -= 1
    if(item.sellIn < 0) item.quality -= 1
    if(item.quality < 0) item.quality = 0
  }
}

class Sulfuras(val item: Item) {

  def updateQuality: Unit = {
  }
}

class AgedBrie(val item: Item) {
  def updateQuality: Unit = {
    item.sellIn -= 1
    item.quality += 1
    if (item.sellIn < 0) item.quality += 1
  }
}

class BackstagePass(val item: Item) {
  def updateQuality: Unit = {
    item.sellIn -= 1
    item.quality += 1
    if (item.sellIn < 11) item.quality += 1
    if (item.sellIn < 5) item.quality += 1
    if (item.quality > 50) item.quality = 50
    if (item.sellIn < 0) item.quality = 0
  }
}