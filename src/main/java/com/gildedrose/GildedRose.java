package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

                switch(items[i].name){
                    case "Aged Brie":{
                        upgradeQuality(items[i]);
                        downgradeSellin(items[i]);
                        if(items[i].sellIn<=0){
                            upgradeQuality(items[i]);
                        }
                        break;
                    }
                    case "Sulfuras, Hand of Ragnaros":{
                        check(items[i]);
                        break;
                    }
                    case "Backstage passes":{
                        if(items[i].sellIn>10) {
                            upgradeQuality(items[i]);
                            downgradeSellin(items[i]);
                        }
                        else if (items[i].sellIn>5){
                            upgradeQuality(items[i]);
                            upgradeQuality(items[i]);
                            downgradeSellin(items[i]);
                        }
                        else if (items[i].sellIn>0){
                            upgradeQuality(items[i]);
                            upgradeQuality(items[i]);
                            upgradeQuality(items[i]);
                            downgradeSellin(items[i]);
                        }
                        else{
                            items[i].quality =0;
                            downgradeSellin(items[i]);
                        }
                        break;
                    }
                    case "Conjured Mana Cake": {
                        conjuredItem(items[i]);
                        break;

                    }
                    default: {
                        downgradeQuality(items[i]);
                        downgradeSellin(items[i]);
                        break;
                    }

                }

            }
        }
        public int downgradeQuality(Item item){
            if(item.quality>0) {
                item.quality = item.quality - 1;
                return item.quality;
            }
            else return 0;
         }

    public int downgradeSellin(Item item){
            if(item.sellIn>0) {
                item.sellIn = item.sellIn - 1;
                return item.sellIn;
            }
            else{
                downgradeQuality(item);
                item.sellIn = item.sellIn - 1;
                return item.sellIn;
            }

    }
    public int upgradeQuality(Item item){
        if(item.quality<50) {
            item.quality = item.quality + 1;
            return item.quality;
        }
        else return 50;
    }
    public void check(Item item){
        if(item.quality>50){
            item.quality = 50;
        }
        if(item.quality<0){
            item.quality = 0;
        }
    }
    public void conjuredItem(Item item){
        item.sellIn = item.sellIn - 1;
        downgradeQuality(item);
        downgradeQuality(item);
        if(item.sellIn<=0){
            downgradeQuality(item);
            downgradeQuality(item);
        }
    }
    }


