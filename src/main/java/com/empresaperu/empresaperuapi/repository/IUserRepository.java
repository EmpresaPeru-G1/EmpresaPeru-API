package com.empresaperu.empresaperuapi.repository;

import com.empresaperu.empresaperuapi.model.*;
import java.util.List;

public interface IUserRepository {
	public List<User>findAll();
	public int save(User user);
	public int update(User user);
	public int remove(int id);
}
