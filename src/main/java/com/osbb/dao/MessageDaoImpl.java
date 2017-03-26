package com.osbb.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import com.osbb.configuration.HibernateConfiguration;
import com.osbb.model.User;
import com.osbb.model.chats.Chat;
import com.osbb.model.chats.Message;

@Repository("messageDao")
public class MessageDaoImpl extends AbstractDao<Integer, Message> implements MessageDao {

	@Autowired
	LocalSessionFactoryBean sessionFactory;

	public Message findById(Integer id) {
		Message mess = getByKey(id);
		return mess;
	}

	// TODO check once again difference between save and persist

	public void save(Message mess) {
		persist(mess);

	}

	public void deleteById(int id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		Message mess = (Message) crit.uniqueResult();
		delete(mess);

	}

	public List<Message> getChatMessages(Chat chat) {
		Criteria crit = createEntityCriteria();

		crit.add(Restrictions.eq("chatId", chat.getId()));
		//crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Message> messages = crit.list();
		return messages;
	}

}
