package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            doUpdateQuality(items[i]);
        }
    }

    private void doUpdateQuality(Item item) {
        switch (item.name) {
            case "Aged Brie":
                updateAgedBrie(item);
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                updateBackstagePasses(item);
                break;
            case "Sulfuras, Hand of Ragnaros":
                break;
            case "Conjured":
                updateConjured(item);
                break;
            default:
                updateDefault(item);
                break;
        }
    }

    private void updateDefault(Item item) {
        if (item.quality > 0) {
            decrementQuality(item);
        }

        decrementSellIn(item);

        if (item.sellIn < 0) {
            if (item.quality > 0) {
                decrementQuality(item);
            }
        }
    }



    private void updateConjured(Item item) {
        if (item.quality > 0) {
            decrementQualityBy2(item);
        }

        decrementSellIn(item);

        if (item.sellIn < 0) {
            if (item.quality > 0) {
                decrementQualityBy2(item);
            }
        }
        if(item.quality<0){
            item.quality = 0;
        }
    }


    private void updateBackstagePasses(Item item) {
        if (item.quality < 50) {
            incrementQuality(item);

            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    incrementQuality(item);
                }
            }

            if (item.sellIn < 6) {
                if (item.quality < 50) {
                    incrementQuality(item);
                }
            }
        }

        decrementSellIn(item);

        if (item.sellIn < 0) {
            item.quality = 0;
        }
        return;
    }



    private void updateAgedBrie(Item item) {
        if (item.quality < 50) {
            incrementQuality(item);

        }

        decrementSellIn(item);

        if (item.sellIn < 0) {
            if (item.quality < 50) {
                incrementQuality(item);
            }
        }
        return;
    }

    private void decrementSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void decrementQuality(Item item) {
        item.quality = item.quality - 1;
    }
    private void incrementQuality(Item item) {
        item.quality = item.quality + 1;
    }
    private void decrementQualityBy2(Item item) {
        item.quality = item.quality - 2;
    }

}