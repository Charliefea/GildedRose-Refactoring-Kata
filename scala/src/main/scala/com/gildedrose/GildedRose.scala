package com.gildedrose

class GildedRose(val items: Array[Item]) {

  def updateQuality() = items.map(itemBehaviourFactory(_).update)


  def itemBehaviourFactory(item: Item): BaseItemBehaviour = {
    item.name match {
      case "Backstage passes to a TAFKAL80ETC concert" => new BackstagePass(item)
      case "Aged Brie" => new AgedBrie(item)
      case "Sulfuras, Hand of Ragnaros" => new BaseItemBehaviour(item)
      case "Conjured" => new Conjured(item)
      case _ => new Normal(item)
    }
  }
}



