package com.ikaragil.baksos.service;

import com.ikaragil.baksos.domain.Search;
import com.ikaragil.baksos.domain.User;

import java.util.Map;

public interface UserService extends BaseService<User> {

    Map findByNama(Search search);
}
