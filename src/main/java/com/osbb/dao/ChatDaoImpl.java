package com.osbb.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.osbb.model.User;
import com.osbb.model.chats.Chat;
import com.osbb.model.chats.Message;
@Repository("chatDao")
public class ChatDaoImpl extends AbstractDao<Integer, Chat> implements ChatDao{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Chat findById(Integer id) {
		Chat chat = getByKey(id);
		return chat;
	}

	
	//TODO check once again difference between save and persist
	@Override
	public void save(Chat chat) {
		persist(chat);
		
	}

	@Override
	public void deleteById(int id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		Chat chat = (Chat) crit.uniqueResult();
		delete(chat);
		
	}

	@Override
	public List<Chat> findUserChats(int userid) {
		Session session = sessionFactory.getCurrentSession();
	    String hql = "SELECT chatId from UserChat WHERE userId ="+userid;
	    Query query = session.createQuery(hql);
	    List<Integer> chatsid = (List<Integer>)query.list();
		List<Chat> chats = new ArrayList<Chat>();
		for(Integer id: chatsid){
			chats.add(getByKey(id));
		}
	    return chats;
	}

	public List<Message> getChatMessages(int chatid) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("chatId", chatid));
		List<Message> mess = (List<Message>) crit.list();

//		Session session = sessionFactory.getCurrentSession();
//	    List<Message> mess = (List<Message>) session.createQuery("from Message m where m.chatId = :chat_id").setParameter("chat_id", chatid).list();
	    return mess;
	}

}
