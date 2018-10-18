package com.imooc.order.repository;

import com.imooc.order.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author youyusong
 * @date 2018/10/18
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {


}
