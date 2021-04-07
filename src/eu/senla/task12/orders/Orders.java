package eu.senla.task12.orders;

import eu.senla.task12.goods.Goods;

import java.time.LocalDate;
import java.util.List;
/*
1/01-06-2020/1;3;4
2/12-12-2020/1;5;6
3/25-12-2025/3;6
 */
public class Orders {
    private int orderId;
    private LocalDate dateOfOrder;
    private List<Goods> goodsOrdered;

    @Override
    public String toString() {
        return "Заказ " +
                "№" + orderId +
                ", дата заказа " + dateOfOrder +
                ", заказанные позиции:" +"\n"
                + goodsOrdered;
    }

    public Orders(int orderId, LocalDate dateOfOrder, List<Goods> goodsArrayList) {
        this.orderId = orderId;
        this.dateOfOrder = dateOfOrder;
        this.goodsOrdered = goodsArrayList;
    }

    public int getOrderId() {
        return orderId;
    }

    public LocalDate getDateOfOrder() {
        return dateOfOrder;
    }

    public List<Goods> getGoodsOrdered() {
        return goodsOrdered;
    }
}
