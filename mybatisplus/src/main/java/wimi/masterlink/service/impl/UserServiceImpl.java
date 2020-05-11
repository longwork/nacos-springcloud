package wimi.masterlink.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import wimi.masterlink.entity.User;
import wimi.masterlink.mapper.UserMapper;
import wimi.masterlink.service.UserService;

/**
 * @author : wenchao.long
 * @date : Created in 2020/04/29 17:30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
