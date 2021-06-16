package com.mt.IMS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mt.IMS.Entities.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long>{

}
