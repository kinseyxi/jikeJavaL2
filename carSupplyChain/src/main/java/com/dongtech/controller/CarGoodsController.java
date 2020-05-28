package com.dongtech.controller;

import com.dongtech.service.CarVGoodsService;
import com.dongtech.vo.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author gzl
 * @date 2020-04-15
 * @program: springboot-jsp
 * @description: ${description}
 */
@Controller
@RequestMapping("cargoods")
public class CarGoodsController {


    @Resource
    private  CarVGoodsService carVGoodsService;


    /**
     * @Author gzl
     * @Description：查询商品列表
     * @Exception
     */
    @RequestMapping("/queryList")
    public ModelAndView queryList(CarGoods carGoods)  {
        List<CarGoods> list = new ArrayList<>();
        try {
            list = carVGoodsService.queryList(carGoods);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        /**
         * 模型和视图
         * model模型: 模型对象中存放了返回给页面的数据
         * view视图: 视图对象中指定了返回的页面的位置
         */
        ModelAndView modelAndView = new ModelAndView();
        //将返回给页面的数据放入模型和视图对象中
        modelAndView.addObject("list", list);
        //指定返回的页面位置
        modelAndView.setViewName("carGoods/list");
        return modelAndView;
    }


    /**
     * @Author gzl
     * @Description：查询下单列表
     * @Exception
     * @Date： 2020/4/19 11:59 PM
     */
    @RequestMapping("/queryorders")
    public ModelAndView QueryOrders()  {
        List<CarOrders> list =carVGoodsService.queryOrders();
        /**
         * 模型和视图
         * model模型: 模型对象中存放了返回给页面的数据
         * view视图: 视图对象中指定了返回的页面的位置
         */
        ModelAndView modelAndView = new ModelAndView();
        //将返回给页面的数据放入模型和视图对象中
        modelAndView.addObject("list", list);
        //指定返回的页面位置
        modelAndView.setViewName("carGoods/orderlist");
        return modelAndView;
    }

    /**
     * @Author gzl
     * @Description：查询下单详情列表
     * @Exception
     * @Date： 2020/4/19 11:59 PM
     */
    @RequestMapping("/queryordersdetails")
    public ModelAndView QueryOrdersDetails(Integer id)  {
        List<CarOrderDetails> list =carVGoodsService.queryOrdersDetails(id);
        /**
         * 模型和视图
         * model模型: 模型对象中存放了返回给页面的数据
         * view视图: 视图对象中指定了返回的页面的位置
         */
        ModelAndView modelAndView = new ModelAndView();
        //将返回给页面的数据放入模型和视图对象中
        modelAndView.addObject("list", list);
        //指定返回的页面位置
        modelAndView.setViewName("carGoods/orderdetailslist");
        return modelAndView;
    }



    /**
     * 获取cookie中的购物车列表
     *
     * @param response
     * @param request
     * @return 购物车列表
     * @throws UnsupportedEncodingException 抛出异常
     */
    public List<Cart> getCartInCookie(HttpServletResponse response, HttpServletRequest request) throws
            UnsupportedEncodingException {
        // 定义空的购物车列表
        List<Cart> items = new ArrayList<>();
        String value_1st ;
        // 购物cookie
        Cookie cart_cookie = getCookie(request);
        // 判断cookie是否为空
        if (cart_cookie != null) {
            // 获取cookie中String类型的value,从cookie获取购物车
            value_1st = URLDecoder.decode(cart_cookie.getValue(), "utf-8");
            // 判断value是否为空或者""字符串
            if (value_1st != null && !"".equals(value_1st)) {
                // 解析字符串中的数据为对象并封装至list中返回给上一级
                String[] arr_1st = value_1st.split("==");
                for (String value_2st : arr_1st) {
                    String[] arr_2st = value_2st.split("=");
                    Cart item = new Cart();
                    item.setId(Long.parseLong(arr_2st[0])); //商品id
                    item.setType(arr_2st[1]); //商品类型ID
                    item.setName(arr_2st[2]); //商品名
                    item.setProduce(arr_2st[3]);
                    item.setPrice(Integer.parseInt(arr_2st[4])); //商品市场价格
                    item.setDescription(arr_2st[5]);//商品详情
                    item.setNum(Integer.parseInt(arr_2st[6]));//加入购物车数量
                    items.add(item);
                }
            }
        }
        return items;

    }

    /**
     * 获取名为"cart"的cookie
     *
     * @param request
     * @return cookie
     */
    public Cookie getCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        Cookie cart_cookie = null;
        for (Cookie cookie : cookies) {
            //获取购物车cookie
            if ("cart".equals(cookie.getName())) {
                cart_cookie = cookie;
            }
        }
        return cart_cookie;
    }

    /**
     * 制作cookie所需value
     *
     * @param cartVos 购物车列表
     * @return 解析为字符串的购物车列表，属性间使用"="相隔，对象间使用"=="相隔
     */
    public String makeCookieValue(List<Cart> cartVos) {
        StringBuffer buffer_2st = new StringBuffer();
        for (Cart item : cartVos) {
            buffer_2st.append(item.getId() + "=" + item.getType() + "=" + item.getName() + "="
                    + item.getProduce() + "="+ item.getPrice() + "=" + item.getDescription() + "=" + item.getNum() + "==");
        }
        return buffer_2st.toString().substring(0, buffer_2st.toString().length() - 2);
    }
    @RequestMapping("/addGoodsToCart")
    @ResponseBody
    public String addGoodsToCart(Integer goodsId,HttpServletRequest request,HttpServletResponse response)throws
            UnsupportedEncodingException{
        //从cookie中获取购物列表
        List<Cart> cartVos = getCartInCookie(response, request);
        Cookie cookie_2st;
        CarGoods carGoods = new CarGoods();

        try {
            CarGoods carGoods1=new CarGoods();
            carGoods1.setId(Long.parseLong(goodsId+""));
            List<CarGoods> cList = carVGoodsService.queryList(carGoods1);
            carGoods = cList.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //如果购物车列表为空
        if(cartVos.size()<=0) {
            Cart cartVo = new Cart();
            cartVo.setNum(1);
            cartVo.setPrice(carGoods.getPrice().intValue());
            cartVo.setId(carGoods.getId());
            cartVo.setType(carGoods.getType());
            cartVo.setName(carGoods.getName());
            cartVo.setProduce(carGoods.getProduce());
            cartVo.setDescription(carGoods.getDescription());
            //将当前传来的商品添加到购物车列表
            cartVos.add(cartVo);
            if (getCookie(request) == null) {
                //制作购物车cookie数据
                cookie_2st = new Cookie("cart", URLEncoder.encode(makeCookieValue(cartVos), "utf-8"));
                //设置在该目录下都可以访问cookie
                cookie_2st.setPath("/");
                //设置cookie有效时间为30分钟
                cookie_2st.setMaxAge(60 * 30);
                //添加cookie
                response.addCookie(cookie_2st);

            } else {
                cookie_2st = getCookie(request);
                cookie_2st.setPath("/");
                //设置cookie有效时间为30分钟
                cookie_2st.setMaxAge(60 * 30);
                cookie_2st.setValue(URLEncoder.encode(makeCookieValue(cartVos)));
                //添加cookie
                response.addCookie(cookie_2st);
            }
        }
        //当前购物车列表不为空
        else {
            int bj=0;
            for (Cart cart:cartVos){
                //如果购物车中存在该商品数量+1
                if (cart.getId().intValue()==goodsId.intValue()){
                    cart.setNum(cart.getNum()+1);
                    bj=1;
                    break;
                }
            }
            if(bj==0){
                //根据商品ID获取商品信息
                Cart cartVo= new Cart();
                cartVo.setNum(1);
                cartVo.setPrice(carGoods.getPrice().intValue());
                cartVo.setId(carGoods.getId());
                cartVo.setType(carGoods.getType());
                cartVo.setName(carGoods.getName());
                cartVo.setProduce(carGoods.getProduce());
                cartVo.setDescription(carGoods.getDescription());
                //将传进来的商品添加到商品列表
                cartVos.add(cartVo);
            }
            //获取名为"cart"的cookie
            cookie_2st = getCookie(request);
            cookie_2st.setPath("/");
            //设置cookie有效时间为30分钟
            cookie_2st.setMaxAge(60 * 30);
            cookie_2st.setValue(URLEncoder.encode(makeCookieValue(cartVos)));
            //添加cookie
            response.addCookie(cookie_2st);
        }
        return cartVos.toString();
    }

    @RequestMapping("/getCart")
    public ModelAndView getCar(HttpServletRequest request,HttpServletResponse response)throws
            UnsupportedEncodingException{
        List<Cart> cartInCookie = getCartInCookie(response, request);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("list",cartInCookie);
        modelAndView.setViewName("carGoods/carlist");
        return modelAndView;

    }

    @RequestMapping("/addOrders")
    public ModelAndView addOrders(HttpServletRequest request,HttpServletResponse response)throws
            UnsupportedEncodingException{
        List<Cart> cartInCookie = getCartInCookie(response, request);
        carVGoodsService.saveOrders(cartInCookie);
        /**
         * 模型和视图
         * model模型：模型对象中存放返回页面的数据
         * view视图：视图对象中指定返回页面的位置
         */
        ModelAndView modelAndView = new ModelAndView();
        List<CarOrders> carOrders = new ArrayList<>();

        try {
          carOrders = carVGoodsService.queryOrders();

        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.addObject("list",carOrders);
        //指定返回页面的位置
        modelAndView.setViewName("carGoods/orderlist");
        return modelAndView;
    }
    @RequestMapping("/teardowndetails")
    public ModelAndView teardowndetails(HttpServletRequest request,HttpServletResponse response,Integer orderId) throws UnsupportedEncodingException {
        List<Cart> cartInCookie = getCartInCookie(response, request);
        List<CarOrderDetails> list = carVGoodsService.queryOrdersDetails(orderId);
        //根据厂家 筛选出不同的
        TearDownDetails tdd=null;
        for(CarOrderDetails c:list){
            List<TearDownDetails> tdds=carVGoodsService.queryOrdersTearDownDetails(c);
            if(tdds.size()>0) {
              tdd = tdds.get(0);
            }
            if(tdd!=null){
                  tdd.setNum(tdd.getNum()+c.getNum());
              }else {
                  TearDownDetails t=new TearDownDetails();
                  t.setNum(c.getNum());
                  t.setCargoods_name(c.getGoodsname());
                  t.setOrderId(c.getOrderId());
                  t.setProduce(c.getProduce());
                  carVGoodsService.saveTearDownDetails(t);
              }

        }
        CarOrderDetails carOrderDetails = new CarOrderDetails();
        carOrderDetails.setOrderId(orderId);
        List<TearDownDetails> tearDownDetails = carVGoodsService.queryOrdersTearDownDetails(carOrderDetails);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list",tearDownDetails);
        modelAndView.setViewName("carGoods/teardowndetails");
        return modelAndView;
    }

    /**
     * 任务1  清除cookie
     * @param request
     * @param response
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("/deleteAllCookie")
    public ModelAndView clearCoolie(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
        Cookie newCookie=new Cookie("cart",null);// 删除名为cart
        newCookie.setMaxAge(0); //立即删除
        newCookie.setPath("/"); //项目所有目录均有效，这句很关键，否则不敢保证删除
        response.addCookie(newCookie);//重新写入，将之前的覆盖掉
        List<Cart> cartInCookie = getCartInCookie(response, request);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("list",cartInCookie);
        modelAndView.setViewName("carGoods/carlist");
        return modelAndView;
    }

    /**
     *根据id清除cookie
     * @param request
     * @param response
     * @param id
     * @return
     * @throws UnsupportedEncodingException
     */

    @RequestMapping("/clearCookieById")
    public ModelAndView clearCookieById(HttpServletRequest request,HttpServletResponse response,Integer id) throws UnsupportedEncodingException {
        Cookie cookie_del=null;
        List<Cart> cartVos = getCartInCookie(response, request);
        for(Cart cart:cartVos){
            if(cart.getId().intValue()==id){
                cartVos.remove(cart);
                break;
            }
        }
        //获取名为"cart"的cookie
        cookie_del = getCookie(request);
        cookie_del.setPath("/");
        //设置cookie有效时间为30分钟
        cookie_del.setMaxAge(60 * 30);
        cookie_del.setValue(URLEncoder.encode(makeCookieValue(cartVos)));
        //添加cookie
        response.addCookie(cookie_del);
        ModelAndView modelAndView=new ModelAndView();
        List<Cart> cartInCookie = getCartInCookie(response, request);
        modelAndView.addObject("list",cartInCookie);
        modelAndView.setViewName("carGoods/carlist");
        return modelAndView;
    }

    /**
     * 统计下单详情
     * @return
     */
    @RequestMapping("/statisticsOrderdetails")
    @ResponseBody
    public List<CarOrderDetails>  statisticsOrderdetails(){
        int sumNum=0;
        int sumPrice=0;
        List<CarOrderDetails> carOrderDetailsList=new ArrayList<>();
        HashSet<String> goodnameSet = new HashSet<>();
        Integer id=null;
        List<CarOrderDetails> carOrderDetails = carVGoodsService.queryOrdersDetails(id);
        for(CarOrderDetails c:carOrderDetails){
            goodnameSet.add(c.getGoodsname());
        }
        for(String goodName:goodnameSet){
            CarOrderDetails carOrderDetailsObject=new CarOrderDetails();
           for(CarOrderDetails cod:carOrderDetails){
               if(cod.getGoodsname().equalsIgnoreCase(goodName)){
                   carOrderDetailsObject.setGoodsname(goodName);
                   sumNum+=cod.getNum();
                   sumPrice+=cod.getPrice().intValue();
                   carOrderDetailsObject.setNum(sumNum);
                   carOrderDetailsObject.setPrice(new BigDecimal(sumPrice));
               }
           }
            carOrderDetailsList.add(carOrderDetailsObject);
        }
    return carOrderDetailsList;
    }
}
