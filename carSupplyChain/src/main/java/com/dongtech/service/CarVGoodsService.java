package com.dongtech.service;

import com.dongtech.vo.*;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service
public interface CarVGoodsService {

    List<CarGoods> queryList(CarGoods carGoods) throws SQLException;



    List<CarOrders> queryOrders();

    List<CarOrderDetails> queryOrdersDetails(Integer id);


    void saveOrders(List<Cart> cartInCookie);

    void saveTearDownDetails(TearDownDetails t);

    List<TearDownDetails> queryOrdersTearDownDetails(CarOrderDetails c);
}
