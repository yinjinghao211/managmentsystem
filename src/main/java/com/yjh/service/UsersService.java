package com.yjh.service;

import com.yjh.entity.Users;
import com.yjh.resource.request.UsersTemplateRequest;

public interface UsersService {
    /**
     * 添加用户
     * @param usersTemplateRequest
     * @return
     */
    int addUsers(UsersTemplateRequest usersTemplateRequest);

    /**
     * 删除用户
     * @param id
     */
    void deleteUser(String id);

    /**
     * 更新用户
     * @param id
     * @param usersTemplateRequest
     * @return
     */
    int updateUser(String id, UsersTemplateRequest usersTemplateRequest);

    /**
     * 查询用户
     * @param id
     * @return
     */
    Users queryUser(String id);

    /**
     * 查询用户身份
     * @param id
     * @return
     */
    String queryUserIdentity(String id);
}
