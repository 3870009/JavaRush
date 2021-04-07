package eu.senla.task12.goods;

import java.time.LocalDate;
/*
1/сыр/20-02-2021
3/молоко/15-03-2021
4/творог/10-01-2021
5/хлеб/11-02-2021
6/батон/01-03-2021
7/яблоки/12-02-2021
8/бананы/14-04-2021
 */
public class Goods {
    private int id;
    private String goodsTitle;
    private LocalDate date;

    public Goods(int id, String goodsTitle, LocalDate date) {
        this.id = id;
        this.goodsTitle = goodsTitle;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getGoodsTitle() {
        return goodsTitle;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        String s;
       if(date == null) {
           s = "<<Товар " +
                   "№ " + id +
                   ", " + goodsTitle +
                   ">>";
       }
       else s = "Товар " +
               "№ " + id +
               ", <<" + goodsTitle +
               ">>, дата производства " + date;


        return s;
    }
}
