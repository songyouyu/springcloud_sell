package com.imooc.order.repository;

import com.imooc.order.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author youyusong
 * @date 2018/10/18
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {



}
