package com.app.repository;

import com.app.entity.Cliente;
import com.app.util.JpaUtil;

public class ClienteDao extends GenericDAOImpl<Cliente, Long> {

    public ClienteDao() {
        super(JpaUtil.getEM(), Cliente.class);
    }

}
