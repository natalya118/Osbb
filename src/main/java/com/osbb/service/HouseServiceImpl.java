package com.osbb.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.osbb.dao.HouseDao;
import com.osbb.dao.UserDao;
import com.osbb.model.House;
import com.osbb.model.User;


@Service("houseService")
@Transactional
public class HouseServiceImpl implements HouseService{
	@Autowired
	private HouseDao dao;
	
	@Autowired
	private UserDao userDao;

	@Override
	public House getHouseById(int id) {
		return dao.findById(id);
	}

	@Override
	public void saveHouse(House house) {
		dao.save(house);
		
	}

	@Override
	public void updateHouse(House house) {
		House entity = dao.findById(house.getHouseId());
		if(entity!=null){
			entity.setStreet(house.getStreet());
			entity.setNumber(house.getNumber());
		}
		
	}

	@Override
	public void deleteHouse(int id) {
		dao.deleteById(id);
		
	}

	@Override
	public List<House> getAllHouses(int osbbId) {

		return dao.findAllHousesByOsbbId(osbbId);
	}

	@Override
	public void generateUsersCredentials(List<Integer> flats,int houseId) {
		for(int i = 0; i< flats.size();i++){
			String login = houseId+flats.get(i).toString();
			RandomString rs = new RandomString(10);
			String password = rs.nextString();
			User user = new User();
			user.setSsoId(login);
			user.setOsbbId(dao.getOsbbId(dao.findById(houseId)));
			user.setPassword(password);
			userDao.save(user);
		}
		
	}
}

class RandomString {

	  private static final char[] symbols;

	  static {
	    StringBuilder tmp = new StringBuilder();
	    for (char ch = '0'; ch <= '9'; ++ch)
	      tmp.append(ch);
	    for (char ch = 'a'; ch <= 'z'; ++ch)
	      tmp.append(ch);
	    symbols = tmp.toString().toCharArray();
	  }   

	  private final Random random = new Random();

	  private final char[] buf;

	  public RandomString(int length) {
	    if (length < 1)
	      throw new IllegalArgumentException("length < 1: " + length);
	    buf = new char[length];
	  }

	  public String nextString() {
	    for (int idx = 0; idx < buf.length; ++idx) 
	      buf[idx] = symbols[random.nextInt(symbols.length)];
	    return new String(buf);
	  }
	}
