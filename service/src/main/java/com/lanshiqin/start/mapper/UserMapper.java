package com.lanshiqin.start.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lanshiqin.start.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
}
