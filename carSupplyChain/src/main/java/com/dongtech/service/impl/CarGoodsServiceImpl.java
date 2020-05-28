package com.dongtech.service.impl;


import com.dongtech.dao.CarGoodsDao;
import com.dongtech.dao.impl.CarGoodsDaoImpl;
import com.dongtech.service.CarVGoodsService;
import com.dongtech.vo.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

@Service
public class CarGoodsServiceImpl implements CarVGoodsService {
    CarGoodsDao dao = new CarGoodsDaoImpl();


    @Override
    public List<CarGoods> queryList(CarGoods carGoods) throws SQLException {
        return dao.queryList(carGoods);
    }

    @Override
    public List<CarOrders> queryOrders() {
        return dao.queryOrders();
    }

    @Override
    public List<CarOrderDetails> queryOrdersDetails(Integer id) {
        return dao.queryOrdersDetails(id);
    }

    @Override
    @Transactional
    public void saveOrders(List<Cart> cartInCookie) {
        List<CarOrders> carOrdersList= queryOrders();
        int size = carOrdersList.size();
        long i=size+1;
        CarOrders carOrders = new CarOrders();
        int totalPrice=0;
        if(cartInCookie.size()>0){
            for (Cart cart:cartInCookie){
                totalPrice+= cart.getPrice() * cart.getNum().intValue();
            }
            carOrders.setId(i);
            carOrders.setPrice(new BigDecimal(totalPrice));
            carOrders.setNumber("ORD_0000000"+i);

            dao.saveCarOrders(carOrders);

            for (Cart cart:cartInCookie){
                dao.saveOrdersDetails(cart.getName(),cart.getNum(),cart.getProduce(),cart.getPrice(),carOrders.getId().intValue());
            }

        }


    }

    @Override
    public void saveTearDownDetails(TearDownDetails t) {
       dao.saveTearDownDetails(t);
    }

    @Override
    public List<TearDownDetails> queryOrdersTearDownDetails(CarOrderDetails c) {
        List<TearDownDetails> tearDownDetails= dao.queryOrdersTearDownDetails(c);
        return tearDownDetails;
    }


}
