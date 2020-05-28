package com.dongtech.dao;


import com.dongtech.vo.*;

import java.util.List;

public interface CarGoodsDao {
    List<CarGoods> queryList(CarGoods carGoods) ;

    List<CarOrders> queryOrders();

    List<CarOrderDetails> queryOrdersDetails(Integer id);

    void saveOrdersDetails(String goods_name,int num,String produce ,int price,int order_id);

    void saveCarOrders(CarOrders carOrders);

    void saveTearDownDetails(TearDownDetails t);

    List<TearDownDetails> queryOrdersTearDownDetails(CarOrderDetails c);
}
