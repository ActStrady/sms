package com.eos.dao;

import com.eos.entity.Admin;

public interface AdminDao {

    /**
     * 更新管理员
     * @param admin
     * @return
     */
    int updateAdmin(Admin admin);
}
